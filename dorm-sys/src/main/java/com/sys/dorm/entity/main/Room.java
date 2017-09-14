/**
 * @Copyright:           Copyright© 2009-2016 UXUNCHINA
 * @Company:             深圳市优讯信息技术有限公司
 * @Project:             dorm-sys
 * @see                  com.sys.dorm.entity.main                              
 */
package com.sys.dorm.entity.main;

import java.util.ArrayList;
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

import com.sys.dorm.entity.IdEntity;

/**
 * <p><b>Title: </b>Room.java
 * <p><b>Description: </b>TODO
 * @author Xupk
 * @version V1.0
 * <p>
 * 2016年4月7日 Xupk 创建类  <br>
 *
 */
@Entity
@Table(name="security_room")
//默认的缓存策略.
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region="com.sys.dorm.entity.main")
public class Room extends IdEntity{

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 9110647844332437431L;

	/**
	 * 完整的宿舍名称，如：25#330
	 * */
	@Length(max=20)
	@Column(length=20)
	private String name;
	
	/**
	 * 宿舍可住人数
	 * */
	@Length(max=11)
	@Column(length=11)
	private String contain;
	
	/**
	 * 宿舍现有人数
	 * */
	@Length(max=11)
	@Column(length=11)
	private String used;
	
	/**
	 * 宿舍的联系电话
	 * */
	@Length(max=20)
	@Column(length=20)
	private String phone;
	
	@ManyToOne
	@JoinColumn(name="buildingId")
	private Building building;
	
	@OneToMany(mappedBy="room", cascade={CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval=true)
	private List<StudentRoom> studentRooms = new ArrayList<StudentRoom>(0);


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContain() {
		return contain;
	}

	public void setContain(String contain) {
		this.contain = contain;
	}

	public String getUsed() {
		return used;
	}

	public void setUsed(String used) {
		this.used = used;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public List<StudentRoom> getStudentRooms() {
		return studentRooms;
	}

	public void setStudentRooms(List<StudentRoom> studentRooms) {
		this.studentRooms = studentRooms;
	}
}
