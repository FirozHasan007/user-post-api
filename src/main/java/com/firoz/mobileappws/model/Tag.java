package com.firoz.mobileappws.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tags")
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String tagname;
	
	public Tag() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTagname() {
		return tagname;
	}

	public void setTagname(String tagname) {
		this.tagname = tagname;
	}

	
	/*
	 * This annotation basically says that posts will not be part of the JSON
	 * returned for tag (but each post will contain list of its tags in the
	 * response). If the post was a part of the list then the program would fetch
	 * the post's tags, which would then make the program fetch the post again
	 * and again until we’d get a StackOverflowException.
	 */
	
	@JsonBackReference
	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	@ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
	private Set<Post> posts;

	public Tag(String tagname, Set<Post> posts) {
		super();
		this.tagname = tagname;
		this.posts = posts;
	}

	public Tag(String tagname) {
		super();
		this.tagname = tagname;
	}
	
}
