/**
 * @Copyright:           Copyright© 2009-2016 UXUNCHINA
 * @Company:             深圳市优讯信息技术有限公司
 * @Project:             dorm-sys
 * @see                  com.sys.dorm.service.impl                              
 */
package com.sys.dorm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sys.dorm.dao.RoomDao;
import com.sys.dorm.dao.StudentDao;
import com.sys.dorm.entity.main.Room;
import com.sys.dorm.entity.main.Student;
import com.sys.dorm.exception.ExistedException;
import com.sys.dorm.exception.ServiceException;
import com.sys.dorm.service.StudentService;
import com.sys.dorm.util.dwz.Page;
import com.sys.dorm.util.dwz.PageUtils;

/**
 * <p>
 * <b>Title: </b>StudentServiceImpl.java
 * <p>
 * <b>Description: </b>TODO
 * 
 * @author Xupk
 * @version V1.0
 *          <p>
 *          2016年4月8日 Xupk 创建类 <br>
 * 
 */
@Service
@Transactional(readOnly = true)
public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;

	@Autowired
	private RoomDao roomDao;

	/**
	 * 构造函数
	 * 
	 * @param jpaRepository
	 */
	@Autowired
	public StudentServiceImpl(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public List<Student> find(Page page, String name) {
		org.springframework.data.domain.Page<Student> springDataPage = studentDao
				.findByNameContaining(name, PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}

	@Override
	public List<Student> findAll(Page page) {
		org.springframework.data.domain.Page<Student> springDataPage = studentDao
				.findAll(PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}

	@Transactional
	public void save(Student student) throws ExistedException {
		long roomId = student.getRoom().getId();
		Room room = roomDao.findById(roomId);
		int roomContain = Integer.parseInt(room.getContain());
		int roomUsed = Integer.parseInt(room.getUsed());
		int buildingContain = Integer.parseInt(room.getBuilding().getContain());
		int buildingUsed = Integer.parseInt(room.getBuilding()
				.getUsedBed());
		if (studentDao.findByStuNo(student.getStuNo()) != null) {
			throw new ExistedException("入住失败，已经存在学号为：" + student.getStuNo()
					+ "的学生。");
		}
		if (roomUsed >= roomContain) {
			throw new ExistedException("入住失败，已超过宿舍可住人数(" + room.getContain()
					+ "人)");
		}
		if (buildingUsed >= buildingContain) {
			throw new ExistedException("入住失败，已超过该楼栋可住人数("
					+ room.getBuilding().getContain() + ")");
		}
		roomUsed = roomUsed + 1;
		buildingUsed = buildingUsed + 1;
		room.getBuilding().setUsedBed(buildingUsed + "");
		room.setUsed(roomUsed + "");

		roomDao.save(room);
		studentDao.save(student);
	}

	@Override
	public Student get(Long id) {
		return studentDao.findOne(id);
	}

	@Override
	@Transactional
	public void update(Student student){
		studentDao.save(student);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		//根据学生id查找一个学生实体
		Student student = studentDao.findOne(id);
		long roomId = student.getRoom().getId();
		Room room = roomDao.findById(roomId);
		int roomContain = Integer.parseInt(room.getContain());
		int roomUsed = Integer.parseInt(room.getUsed());
		int buildingContain = Integer.parseInt(room.getBuilding().getContain());
		int buildingUsed = Integer.parseInt(room.getBuilding()
				.getUsedBed());
		//退宿时，给房间和楼栋的已住人数减1
		roomUsed = roomUsed - 1;
		buildingUsed = buildingUsed - 1;
		room.getBuilding().setUsedBed(buildingUsed + "");
		room.setUsed(roomUsed + "");

		roomDao.save(room);
		studentDao.delete(id);
	}

}
