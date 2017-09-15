/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.sys.dorm.security.entity.authenticate.User.java
 * Class:			User
 * Date:			2015-8-2
 * Author:			<a href="mailto:211450675@qq.com">xupk</a>
 * Version          1.1.0
 * Description:		
 *
 * </pre>
 **/
 
package com.sys.dorm.entity.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.google.common.collect.Lists;
import com.sys.dorm.entity.IdEntity;

/** 
 * 	
 * @author 	<a href="mailto:211450675@qq.com">xupk</a>
 * Version  1.1.0
 * @since   2015-8-2 下午2:44:58 
 */
@Entity
@Table(name="security_user")
//默认的缓存策略.
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region="com.sys.dorm.entity.main")
public class User extends IdEntity {

	/** 描述  */
	private static final long serialVersionUID = -4277639149589431277L;
	
	/**
	 * 真实姓名
	 * */
	@NotBlank
	@Length(min=1, max=32)
	@Column(nullable=false, length=32, updatable=false)
	private String realname;

	/**
	 * 登录名称
	 * */
	@NotBlank
	@Length(min=1, max=32)
	@Column(nullable=false, length=32, unique=true, updatable=false)
	private String username;
	
	/**
	 * 密码
	 * */
	@Column(nullable=false, length=64)
	private String password;
	
	@Transient
	private String plainPassword;
	
	/**
	 * 验证密码需要用到
	 * */
	@Column(nullable=false, length=32)
	private String salt;
	
	/**
	 * 联系电话
	 * */
	@Length(max=32)
	@Column(length=32)
	private String phone;
	
	/**
	 * 电子邮箱
	 * */
	@Email
	@Length(max=128)
	@Column(length=128)
	private String email;
	
	/**
	 * 帐号创建时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable=false)
	private Date createTime;
	
	/**
	 * 使用状态disabled，enabled
	 */
	@NotBlank
	@Length(max=16)
	@Column(nullable=false, length=16)
	private String status = "enabled";
	
	@OneToMany(mappedBy="user", cascade={CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval=true)
	@OrderBy("priority ASC")
	private List<UserRole> userRoles = Lists.newArrayList();
	
	@OneToMany(mappedBy="user", cascade={CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval=true)
	private List<BuildingUser> buildingUsers = new ArrayList<BuildingUser>(0);
	
	@ManyToOne
	@JoinColumn(name="orgId")
	private Organization organization;
	
	/**  
	 * 返回 realname 的值   
	 * @return realname  
	 */
	public String getRealname() {
		return realname;
	}

	/**  
	 * 设置 realname 的值  
	 * @param realname
	 */
	public void setRealname(String realname) {
		this.realname = realname;
	}

	/**  
	 * 返回 username 的值   
	 * @return username  
	 */
	public String getUsername() {
		return username;
	}

	/**  
	 * 设置 username 的值  
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**  
	 * 返回 password 的值   
	 * @return password  
	 */
	public String getPassword() {
		return password;
	}

	/**  
	 * 设置 password 的值  
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**  
	 * 返回 createTime 的值   
	 * @return createTime  
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**  
	 * 设置 createTime 的值  
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/**  
	 * 返回 status 的值   
	 * @return status  
	 */
	public String getStatus() {
		return status;
	}

	/**  
	 * 设置 status 的值  
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**  
	 * 返回 plainPassword 的值   
	 * @return plainPassword  
	 */
	public String getPlainPassword() {
		return plainPassword;
	}

	/**  
	 * 设置 plainPassword 的值  
	 * @param plainPassword
	 */
	public void setPlainPassword(String plainPassword) {
		this.plainPassword = plainPassword;
	}

	/**  
	 * 返回 salt 的值   
	 * @return salt  
	 */
	public String getSalt() {
		return salt;
	}

	/**  
	 * 设置 salt 的值  
	 * @param salt
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	/**  
	 * 返回 email 的值   
	 * @return email  
	 */
	public String getEmail() {
		return email;
	}

	/**  
	 * 设置 email 的值  
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**  
	 * 返回 userRoles 的值   
	 * @return userRoles  
	 */
	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	/**  
	 * 设置 userRoles 的值  
	 * @param userRoles
	 */
	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	
	public List<BuildingUser> getBuildingUsers() {
		return buildingUsers;
	}

	public void setBuildingUsers(List<BuildingUser> buildingUsers) {
		this.buildingUsers = buildingUsers;
	}

	/**  
	 * 返回 phone 的值   
	 * @return phone  
	 */
	public String getPhone() {
		return phone;
	}

	/**  
	 * 设置 phone 的值  
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**  
	 * 返回 organization 的值   
	 * @return organization  
	 */
	public Organization getOrganization() {
		return organization;
	}

	/**  
	 * 设置 organization 的值  
	 * @param organization
	 */
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
// 在做debug测试时，可能hibernate默认会调用toString方法，该方法包装了集合的样式，在未打开sessionInView时会造成延迟加载错误，
//	@Override
//	public String toString() {
//		return ToStringBuilder.reflectionToString(this);
//	}
}
