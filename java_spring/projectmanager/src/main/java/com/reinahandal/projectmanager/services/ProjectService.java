package com.reinahandal.projectmanager.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reinahandal.projectmanager.models.Project;
import com.reinahandal.projectmanager.models.Task;
import com.reinahandal.projectmanager.models.User;
import com.reinahandal.projectmanager.models.UserProject;
import com.reinahandal.projectmanager.repositories.ProjectRepository;
import com.reinahandal.projectmanager.repositories.TaskRepository;
import com.reinahandal.projectmanager.repositories.UserProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	ProjectRepository projectRepo;
	
	@Autowired
	UserProjectRepository userProjRepo;
	
	@Autowired
	TaskRepository taskRepo;
	

	public Project createProject(Project p) {
		return projectRepo.save(p);
	}
	
	public Project updateProject(Project p) {
		return projectRepo.save(p);
	}
	
	public void deleteProject(Long id) {
		projectRepo.deleteById(id);
	}
	
    // retrieves a project
    public Project findProject(Long id) {
        Optional<Project> optionalProject = projectRepo.findById(id);
        if(optionalProject.isPresent()) {
            return optionalProject.get();
        } else {
            return null;
        }
    }
    
    // retrieves projects this user is not a member of
    public List<Project> findOtherProjects(User user){
    	return projectRepo.findAllByTeamMembersNotContains(user);
    }
    
    // retrieves projects this user is a member of or leads
    public List<Project> findMyProjects(User user){
    	List<Project> myProjects = new ArrayList<Project>();
    	myProjects.addAll(projectRepo.findAllByTeamLead(user));
    	myProjects.addAll(projectRepo.findAllByTeamMembersContains(user));
    	return myProjects;
    } 
    
    // adds user to project as team member
    public UserProject joinProject(UserProject up) {
    	return userProjRepo.save(up);
    }
 
    // removes user from project as team member
    public UserProject leaveProject(UserProject up) {
    	up.setProject(null);
    	up.setTeamMember(null);
    	return userProjRepo.save(up);
    }
    
    // creates new task
    public Task createTask(Task task) {
    	return taskRepo.save(task);
    }
}
