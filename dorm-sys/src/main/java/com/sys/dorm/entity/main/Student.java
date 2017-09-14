/**
 * @Copyright:           Copyright© 2009-2016 UXUNCHINA
 * @Company:             深圳市优讯信息技术有限公司
 * @Project:             dorm-sys
 * @see                  com.sys.dorm.entity.main                              
 */
package com.sys.dorm.entity.main;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.google.common.collect.Lists;
import com.sys.dorm.entity.IdEntity;

/**
 * <p><b>Title: </b>Student.java
 * <p><b>Description: </b>TODO
 * @author Xupk
 * @version V1.0
 * <p>
 * 2016年4月8日 Xupk 创建类  <br>
 *
 */
@Entity
@Table(name="security_student")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region="com.sys.dorm.entity.main")
public class Student extends IdEntity{

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 4591746854840328719L;
	

	/**
	 * 学号
	 * */
	@NotBlank
	@Length(max=11)
	@Column(nullable=false, length=11)
	private String stuNo;
	
	/**
	 * 姓名
	 * */
	@Length(max=20)
	@Column(length=20)
	private String name;
	
	/**
	 * 性别
	 * */
	@Length(max=20)
	@Column(length=20)
	private String sex;
	
	/**
	 * 年级
	 * */
	@Length(max=20)
	@Column(length=20)
	private String grade;
	
	/**
	 * 联系电话
	 * */
	@Length(max=20)
	@Column(length=20)
	private String phone;
	
	@OneToMany(mappedBy="student", cascade={CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval=true)
	private List<StudentRoom> studentRooms = Lists.newArrayList();
	
	@ManyToOne
	@JoinColumn(name="roomId")
	private Room room;

	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<StudentRoom> getStudentRooms() {
		return studentRooms;
	}

	public void setStudentRooms(List<StudentRoom> studentRooms) {
		this.studentRooms = studentRooms;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
}
