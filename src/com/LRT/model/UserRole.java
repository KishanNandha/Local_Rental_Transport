package com.LRT.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user_roles", uniqueConstraints =
@UniqueConstraint(columnNames = { "role", "username" }))
public class UserRole {

 private Integer userRoleId;
 private User user;
 private String role;

 public UserRole() {
 }

 public UserRole(User user, String role) {
 this.user = user;
 this.role = role;
 }

 @Id
 @GenericGenerator(name="native", strategy = "native") 
 @GeneratedValue(generator = "native")
	@Column(name = "user_role_id", unique = true)
 public Integer getUserRoleId() {
 return this.userRoleId;
 }

 public void setUserRoleId(Integer userRoleId) {
 this.userRoleId = userRoleId;
 }

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "username")
 public User getUser() {
 return this.user;
 }

 public void setUser(User user) {
 this.user = user;
 }

	@Column(name = "role", length = 45)
 public String getRole() {
 return this.role;
 }

 public void setRole(String role) {
 this.role = role;
 }
 
}