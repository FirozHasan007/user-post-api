package com.firoz.mobileappws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firoz.mobileappws.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

}
