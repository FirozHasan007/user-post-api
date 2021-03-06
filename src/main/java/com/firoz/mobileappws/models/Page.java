package com.firoz.mobileappws.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "pages")
public class Page {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int pagemembers;
	private String pagename;
	private String pagedescription;
	
	public Page() {
		super();
	}

	public Page(int pagemembers, String pagename, String pagedescription) {
		super();
		this.pagemembers = pagemembers;
		this.pagename = pagename;
		this.pagedescription = pagedescription;
	}


	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<User> users;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPagemembers() {
		return pagemembers;
	}

	public void setPagemembers(int pagemembers) {
		this.pagemembers = pagemembers;
	}

	public String getPagename() {
		return pagename;
	}

	public void setPagename(String pagename) {
		this.pagename = pagename;
	}

	public String getPagedescription() {
		return pagedescription;
	}

	public void setPagedescription(String pagedescription) {
		this.pagedescription = pagedescription;
	}

	@JsonBackReference
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}



	




}
