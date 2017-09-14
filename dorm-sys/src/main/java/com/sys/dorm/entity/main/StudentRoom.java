/**
 * @Copyright:           Copyright© 2009-2016 UXUNCHINA
 * @Company:             深圳市优讯信息技术有限公司
 * @Project:             dorm-sys
 * @see                  com.sys.dorm.entity.main                              
 */
package com.sys.dorm.entity.main;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.sys.dorm.entity.IdEntity;

/**
 * <p>
 * <b>Title: </b>StudentRoom.java
 * <p>
 * <b>Description: </b>TODO
 * 
 * @author Xupk
 * @version V1.0
 *          <p>
 *          2016年4月8日 Xupk 创建类 <br>
 * 
 */
@Entity
@Table(name = "security_student_room")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "com.sys.dorm.entity.main")
public class StudentRoom extends IdEntity {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 2771802938148522816L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "studentId")
	private Student student;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roomId")
	private Room room;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

}
