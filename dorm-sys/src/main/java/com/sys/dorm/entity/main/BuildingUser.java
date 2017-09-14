/**
 * @Copyright:           Copyright© 2009-2016 UXUNCHINA
 * @Company:             深圳市优讯信息技术有限公司
 * @Project:             dorm-sys
 * @see                  com.sys.dorm.entity.main                              
 */
package com.sys.dorm.entity.main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Range;

import com.sys.dorm.entity.IdEntity;

/**
 * <p><b>Title: </b>BuildingUser.java
 * <p><b>Description: </b>TODO
 * @author Xupk
 * @version V1.0
 * <p>
 * 2016年3月29日 Xupk 创建类  <br>
 *
 */
@Entity
@Table(name="security_building_user")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region="com.sys.dorm.entity.main")
public class BuildingUser extends IdEntity{

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 8478344489080833023L;
	
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userId")
	private User user;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="buildingId")
	private Building building;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}
	
	
}
