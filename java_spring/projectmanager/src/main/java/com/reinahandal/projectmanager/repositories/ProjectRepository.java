package com.reinahandal.projectmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reinahandal.projectmanager.models.Project;
import com.reinahandal.projectmanager.models.User;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
	List<Project> findAll();
    List<Project> findAllByTeamMembersNotContains(User user);
    List<Project> findAllByTeamMembersContains(User user);
    List<Project> findAllByTeamLead(User user);
}
