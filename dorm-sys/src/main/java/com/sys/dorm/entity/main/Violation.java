/**
 * @Copyright:           Copyright© 2009-2016 UXUNCHINA
 * @Company:             深圳市优讯信息技术有限公司
 * @Project:             dorm-sys
 * @see                  com.sys.dorm.entity.main                              
 */
package com.sys.dorm.entity.main;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.sys.dorm.entity.IdEntity;

/**
 * <p><b>Title: </b>Violation.java
 * <p><b>Description: </b>TODO
 * @author Xupk
 * @version V1.0
 * <p>
 * 2016年4月23日 Xupk 创建类  <br>
 *
 */

@Entity
@Table(name="security_violation")
//默认的缓存策略.
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region="com.sys.dorm.entity.main")
public class Violation extends IdEntity {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -752671508829341966L;
	
	/**
	 * 完整的宿舍名称，如：25#330
	 * */
	@Length(max=20)
	@Column(length=20)
	private String roomName;
	
	/**
	 * 违规信息
	 * */
	@Length(max=255)
	@Column(length=255)
	private String message;
	
	/**
	 * 日期
	 * */
	@Column(updatable=true)
	private String date;
	
	/**
	 * 违规学生
	 * */
	@Length(max=255)
	@Column(length=255)
	private String student;
	
	/**
	 * 状态disabled，enabled
	 */
	@NotBlank
	@Length(max=20)
	@Column(length=20)
	private String status = "enabled";
	
	/**
	 * 处理人
	 * */
	@Length(max=20)
	@Column(length=20)
	private String manager;

	
//---------------------------getter,setter-----------------------------------------//
	
	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

}
