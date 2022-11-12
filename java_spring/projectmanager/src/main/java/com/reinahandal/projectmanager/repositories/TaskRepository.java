package com.reinahandal.projectmanager.repositories;

import org.springframework.data.repository.CrudRepository;

import com.reinahandal.projectmanager.models.Task;

public interface TaskRepository extends CrudRepository<Task, Long>{
	
}
