/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fees_management.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class TTsign_up {
    private int id;
    private String firstname, lastname, username, password, con_pass, contact_no;
    private Date dob;

	public TTsign_up(int id, String firstname, String lastname, String username, String password,Date dob, String con_pass, String contact_no) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.con_pass = con_pass;
		this.contact_no = contact_no;
		this.dob = dob;
		
	}

	public TTsign_up() {
	}

	public int getId() throws Exception {
		String sql = "select max(id) from signup";
		ResultSet rs =null;
		try (
			Connection con = databaseHelper.openConnection();
			Statement stmt = con.createStatement();
			){
			
			rs= stmt.executeQuery(sql);
			while(rs.next()){
				id = rs.getInt(1);
				id++;	
				
			}
		}
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCon_pass() {
		return con_pass;
	}

	public void setCon_pass(String con_pass) {
		this.con_pass = con_pass;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
    
}