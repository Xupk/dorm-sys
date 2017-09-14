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

import com.sys.dorm.dao.ViolationDao;
import com.sys.dorm.entity.main.Violation;
import com.sys.dorm.exception.ExistedException;
import com.sys.dorm.exception.ServiceException;
import com.sys.dorm.service.ViolationService;
import com.sys.dorm.util.dwz.Page;
import com.sys.dorm.util.dwz.PageUtils;

/**
 * <p><b>Title: </b>ViolationServiceImpl.java
 * <p><b>Description: </b>TODO
 * @author Xupk
 * @version V1.0
 * <p>
 * 2016年4月23日 Xupk 创建类  <br>
 *
 */

@Service
@Transactional(readOnly = true)
public class ViolationServiceImpl implements ViolationService{
	
	@Autowired
	private ViolationDao violationDao;
	
	/**
	 * 构造函数
	 * 
	 * @param jpaRepository
	 */
	@Autowired
	public ViolationServiceImpl(ViolationDao violationDao) {
		this.violationDao = violationDao;
	}

	@Override
	public Violation get(String roomName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Violation> find(Page page, String roomName) {
		org.springframework.data.domain.Page<Violation> springDataPage = violationDao
				.findByRoomNameContaining(roomName, PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}

	@Override
	@Transactional
	public void update(Violation violation) {
		violationDao.save(violation);
	}

	@Override
	@Transactional
	public void save(Violation violation) throws ExistedException {
		violationDao.save(violation);
	}

	@Override
	public Violation get(Long id) {
		return violationDao.findOne(id);
	}

	@Override
	@Transactional
	public void delete(Long id) throws ServiceException {
		violationDao.delete(id);
	}

	@Override
	public List<Violation> findAll(Page page) {
		org.springframework.data.domain.Page<Violation> springDataPage = violationDao
				.findAll(PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}

}
