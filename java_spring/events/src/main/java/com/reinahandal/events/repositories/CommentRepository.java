package com.reinahandal.events.repositories;

import org.springframework.data.repository.CrudRepository;

import com.reinahandal.events.models.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}
