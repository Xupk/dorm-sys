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

import com.sys.dorm.dao.RepairDao;
import com.sys.dorm.dao.ViolationDao;
import com.sys.dorm.entity.main.Repair;
import com.sys.dorm.entity.main.Violation;
import com.sys.dorm.exception.ExistedException;
import com.sys.dorm.exception.ServiceException;
import com.sys.dorm.service.RepairService;
import com.sys.dorm.util.dwz.Page;
import com.sys.dorm.util.dwz.PageUtils;

/**
 * <p>
 * <b>Title: </b>ViolationServiceImpl.java
 * <p>
 * <b>Description: </b>TODO
 * 
 * @author Xupk
 * @version V1.0
 *          <p>
 *          2016年4月23日 Xupk 创建类 <br>
 * 
 */

@Service
@Transactional(readOnly = true)
public class RepairServiceImpl implements RepairService {

	@Autowired
	private RepairDao repairDao;

	/**
	 * 构造函数
	 * 
	 * @param jpaRepository
	 */
	@Autowired
	public RepairServiceImpl(RepairDao repairDao) {
		this.repairDao = repairDao;
	}

	@Override
	public Repair get(String roomName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Repair> find(Page page, String roomName) {
		org.springframework.data.domain.Page<Repair> springDataPage = repairDao
				.findByRoomNameContaining(roomName,
						PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}

	@Override
	@Transactional
	public void update(Repair repair) {
		repairDao.save(repair);
	}

	@Override
	@Transactional
	public void save(Repair repair) throws ExistedException {
		repairDao.save(repair);
	}

	@Override
	public Repair get(Long id) {
		return repairDao.findOne(id);
	}

	@Override
	@Transactional
	public void delete(Long id) throws ServiceException {
		repairDao.delete(id);
	}

	@Override
	public List<Repair> findAll(Page page) {
		org.springframework.data.domain.Page<Repair> springDataPage = repairDao
				.findAll(PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}

}
