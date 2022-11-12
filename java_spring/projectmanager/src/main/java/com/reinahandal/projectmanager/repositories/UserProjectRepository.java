package com.reinahandal.projectmanager.repositories;

import org.springframework.data.repository.CrudRepository;

import com.reinahandal.projectmanager.models.UserProject;

public interface UserProjectRepository extends CrudRepository<UserProject, Long> {

}
