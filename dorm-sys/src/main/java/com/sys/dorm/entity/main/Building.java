/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.sys.dorm.entity.main.Building.java
 * Class:			Building
 * Date:			2015-8-2
 * Author:			<a href="mailto:211450675@qq.com">xupk</a>
 * Version          1.1.0
 * Description:		
 *
 * </pre>
 **/
 
package com.sys.dorm.entity.main;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.sys.dorm.entity.IdEntity;

/** 
 * 	
 * @author 	<a href="mailto:211450675@qq.com">xupk</a>
 * Version  1.1.0
 * @since   2015-8-2 下午5:36:39 
 */
@Entity
@Table(name="security_building")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region="com.sys.dorm.entity.main")
public class Building extends IdEntity implements Comparable<Building> {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -3631757524848413584L;

	/**
	 * 名称
	 * */
	@NotBlank
	@Length(max=20)
	@Column(nullable=false, length=20)
	private String name;
	
	/**
	 * 性别
	 * */
	@Length(max=20)
	@Column(length=20)
	private String sex;
	
	/**
	 * 高度
	 * */
	@Length(max=20)
	@Column(length=20)
	private String height;
	
	/**
	 * 每层楼的房间数量
	 * */
	@Length(max=20)
	@Column(length=20)
	private String layerPRoom;
	
	/**
	 * 每个房间的床位数量
	 * */
	@Length(max=20)
	@Column(length=20)
	private String roomPBed;
	
	/**
	 * 楼宇容纳的学生人数
	 * */
	@Length(max=20)
	@Column(length=20)
	private String contain;
	
	/**
	 * 楼宇现有学生人数
	 * */
	@Length(max=20)
	@Column(length=20)
	private String usedBed;
	
	@ManyToOne
	@JoinColumn(name="parentId")
	private Building parent;
	
	@OneToMany(cascade=CascadeType.PERSIST, mappedBy="parent")
	@OrderBy("name ASC")
	private List<Building> children = Lists.newArrayList();
	
	@OneToMany(mappedBy="building", cascade={CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval=true)
	private List<BuildingUser> buildingUsers = Lists.newArrayList();
	
//	/**
//	 *	因为hibernate更新使用的是merge方法，会自动新增关联的瞬时对象，如果再次配置CascadeType.MERGE，会插入两条数据。<br/>
//	 *  详见我的博客：<a href="ketayao.com">ketayao.com</a> 
//	 */
//	@OneToMany(mappedBy="building", cascade={CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval=true)
//	private List<Permission> permissions = Lists.newArrayList();

	/**  
	 * 返回 name 的值   
	 * @return name  
	 */
	public String getName() {
		return name;
	}

	/**  
	 * 设置 name 的值  
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getLayerPRoom() {
		return layerPRoom;
	}

	public void setLayerPRoom(String layerPRoom) {
		this.layerPRoom = layerPRoom;
	}

	public String getRoomPBed() {
		return roomPBed;
	}

	public void setRoomPBed(String roomPBed) {
		this.roomPBed = roomPBed;
	}

	public String getContain() {
		return contain;
	}

	public void setContain(String contain) {
		this.contain = contain;
	}

	public String getUsedBed() {
		return usedBed;
	}

	public void setUsedBed(String usedBed) {
		this.usedBed = usedBed;
	}



	/**  
	 * 返回 parent 的值   
	 * @return parent  
	 */
	public Building getParent() {
		return parent;
	}

	/**  
	 * 设置 parent 的值  
	 * @param parent
	 */
	public void setParent(Building parent) {
		this.parent = parent;
	}

	/**  
	 * 返回 children 的值   
	 * @return children  
	 */
	public List<Building> getChildren() {
		return children;
	}

	/**  
	 * 设置 children 的值  
	 * @param children
	 */
	public void setChildren(List<Building> children) {
		this.children = children;
	}

	public List<BuildingUser> getBuildingUsers() {
		return buildingUsers;
	}

	public void setBuildingUsers(List<BuildingUser> buildingUsers) {
		this.buildingUsers = buildingUsers;
	}

	@Override
	public int compareTo(Building m) {
//		if (m == null) {
//			return -1;
//		} else if (m == this) {
//			return 0;
//		} else if (this.priority < m.getPriority()) {
//			return -1;
//		} else if (this.priority > m.getPriority()) {
//			return 1;
//		}

		return 0;	
	}
	
	@Override
	public String toString() {
		return Objects.toStringHelper(this)
				.addValue(id)
				.addValue(name)
				.addValue(parent == null ? null:parent.getName())
				.addValue(children.size())
				.toString();
	}
}
