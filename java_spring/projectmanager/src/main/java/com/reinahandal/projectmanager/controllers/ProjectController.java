package com.reinahandal.projectmanager.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.reinahandal.projectmanager.models.Project;
import com.reinahandal.projectmanager.models.Task;
import com.reinahandal.projectmanager.models.User;
import com.reinahandal.projectmanager.models.UserProject;
import com.reinahandal.projectmanager.services.ProjectService;
import com.reinahandal.projectmanager.services.UserService;

@Controller
public class ProjectController {
	
	@Autowired
	ProjectService projectService;

	@Autowired
	UserService userService;
	
	// renders dashboard
	@GetMapping("/dashboard")
	public String index(HttpSession session, 
			Model model, 
			@ModelAttribute("userProject") UserProject userProject) {
		if(session.getAttribute("thisUser") != null) {
			model.addAttribute("allProjects", projectService.findOtherProjects((User) session.getAttribute("thisUser")));
			model.addAttribute("myProjects", projectService.findMyProjects((User) session.getAttribute("thisUser")));
			return "index.jsp";		
		} else {
			return "redirect:/";
		}
	}
	
	// adds user to project as team member
	@PostMapping("/join")
	public String joinProject(@ModelAttribute("userProject") UserProject userProject) {
		projectService.joinProject(userProject);
		return "redirect:/dashboard";
	}
	
	// removes user from project as team member
	@PostMapping("/leave")
	public String leaveProject(
			@RequestParam("teamMember") Long memberId,
			@RequestParam("project") Long projectId) {
		User member = userService.findUserById(memberId);
		Project project = projectService.findProject(projectId);
		List<User> projectMembers = project.getTeamMembers();
		projectMembers.remove(member);
		project.setTeamMembers(projectMembers);
		projectService.updateProject(project);
		return "redirect:/dashboard";
	}
	
	// renders form for creating new project
	@GetMapping("/projects/new")
	public String newProject(HttpSession session, @ModelAttribute("project") Project project) {
		if(session.getAttribute("userId") != null) {
			return "newProject.jsp";
		} else {
			return "redirect:/";
		}
	}
	
	// processes form to create new project
	@PostMapping("/projects/new")
	public String createProject(@Valid @ModelAttribute("project") Project project, BindingResult result) {
		if(result.hasErrors()) {
			return "newProject.jsp";
		} else {
			projectService.createProject(project);
			return "redirect:/dashboard";
		}
	}
	
	// renders form for editing project 
	@GetMapping("/projects/edit/{id}")
	public String editProject(HttpSession session, @PathVariable("id") Long projectId, Model model) {
		if(session.getAttribute("userId") != null) {
			if((Long) session.getAttribute("userId") == projectService.findProject(projectId).getTeamLead().getId()) {
				model.addAttribute("project", projectService.findProject(projectId));
				return "editProject.jsp";
			} else {
				return "redirect:/dashboard";
			}
		} else {
			return "redirect:/";
		}
	}
	
	// processes form that edits project
	@PutMapping("/project/edit/{id}")
	public String updateProject(@Valid @ModelAttribute("project") Project project, 
			BindingResult result, 
			@PathVariable("id") Long projectId, 
			HttpSession session) {
		if(session.getAttribute("userId") != null) {
			if((Long) session.getAttribute("userId") == projectService.findProject(projectId).getTeamLead().getId()) {
				if (result.hasErrors()) {
					return "editProject.jsp";
				} else {
					Project thisProject = projectService.findProject(projectId);
					project.setTeamMembers(thisProject.getTeamMembers());
					projectService.updateProject(project);
					return "redirect:/projects/"+projectId; 				}
			} else {
				return "redirect:/dashboard";
			}
		} else {
			return "redirect:/";
		}
		
	}
	
	// renders page with project details
	@GetMapping("/projects/{id}")
	public String showProject(
			@PathVariable("id") Long projectId, 
			Model model,
			HttpSession session) {
		if(session.getAttribute("userId") != null) {
			model.addAttribute("project", projectService.findProject(projectId));
			Project thisProject = projectService.findProject(projectId);
			User thisUser = userService.findUserById((Long) session.getAttribute("userId"));
			model.addAttribute("isMember",thisProject.getTeamMembers().contains(thisUser));
			return "showProject.jsp";
		} else {
			return "redirect:/";
		}
	}
	
	// deletes project
	@DeleteMapping("/projects/{id}")
	public String destroy(@PathVariable("id") Long projectId, HttpSession session) {
		if((Long) session.getAttribute("userId") == projectService.findProject(projectId).getTeamLead().getId()) {
			projectService.deleteProject(projectId);
			return "redirect:/dashboard"; 		
		} else {
			return "redirect:/projects/"+projectId;
		}
	}

	// renders page that shows all project tasks and contains form for adding a new task
	@GetMapping("/projects/{projectId}/tasks")
	public String showTasks(
			@PathVariable("projectId") Long projectId, 
			Model model,
			HttpSession session,
			@ModelAttribute("task") Task task) {
		if(session.getAttribute("userId") != null) {
			Project thisProject = projectService.findProject(projectId);
			User thisUser = userService.findUserById((Long) session.getAttribute("userId"));
			if(session.getAttribute("userId") == thisProject.getTeamLead().getId() || thisProject.getTeamMembers().contains(thisUser)) {
				model.addAttribute("project", thisProject);
				return "task.jsp";
			} else {
				return "redirect:/dashboard";
			}
		} else {
			return "redirect:/";
		}
	}
	
	// creates new project task
	@PostMapping("/projects/{projectId}/tasks")
	public String newTask(
			@PathVariable("projectId") Long projectId,
			@Valid @ModelAttribute("task") Task task,
			BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			Project thisProject = projectService.findProject(projectId);
			model.addAttribute("project", thisProject);
			return "task.jsp";
		} else {
			projectService.createTask(task);
			return "redirect:/projects/"+projectId+"/tasks";
		}
	}
}
