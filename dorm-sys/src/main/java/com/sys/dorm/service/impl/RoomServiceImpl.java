/**
 * @Copyright:           Copyright© 2009-2016 UXUNCHINA
 * @Company:             深圳市优讯信息技术有限公司
 * @Project:             dorm-sys
 * @see                  com.sys.dorm.service.impl                              
 */
package com.sys.dorm.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sys.dorm.dao.RoomDao;
import com.sys.dorm.entity.main.Room;
import com.sys.dorm.entity.main.User;
import com.sys.dorm.exception.ExistedException;
import com.sys.dorm.exception.ServiceException;
import com.sys.dorm.service.RoomService;
import com.sys.dorm.shiro.ShiroDbRealm.HashPassword;
import com.sys.dorm.util.dwz.Page;
import com.sys.dorm.util.dwz.PageUtils;

/**
 * <p>
 * <b>Title: </b>RoomServiceImpl.java
 * <p>
 * <b>Description: </b>TODO
 * 
 * @author Xupk
 * @version V1.0
 *          <p>
 *          2016年4月7日 Xupk 创建类 <br>
 * 
 */
@Service
@Transactional(readOnly = true)
public class RoomServiceImpl implements RoomService {

	private RoomDao roomDao;
	
	/**
	 * 构造函数
	 * 
	 * @param jpaRepository
	 */
	@Autowired
	public RoomServiceImpl(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

	@Override
	public List<Room> find(Page page, String name) {
		org.springframework.data.domain.Page<Room> springDataPage = roomDao
				.findByNameContaining(name, PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}

	@Override
	public List<Room> findAll(Page page) {
		org.springframework.data.domain.Page<Room> springDataPage = roomDao
				.findAll(PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}
	
	@Transactional
	public void save(Room room) throws ExistedException {
		if (roomDao.findByName(room.getName()) != null) {
			throw new ExistedException("房间添加失败，房间名：" + room.getName()
					+ "已存在。");
		}

		roomDao.save(room);
	}
	
	@Override
	public Room get(Long id) {
		return roomDao.findOne(id);
	}
	
	@Transactional
	public void update(Room room) {
		roomDao.save(room);
	}
	
	@Transactional
	public void delete(Long id) throws ServiceException {
		roomDao.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.sys.dorm.service.RoomService#findAll()
	 */
	@Override
	public List<Room> findAll() {
		List<Room> rooms = roomDao.findAll();
		return rooms;
	}

}
