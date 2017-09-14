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

import com.sys.dorm.dao.BuildingUserDao;
import com.sys.dorm.entity.main.BuildingUser;
import com.sys.dorm.entity.main.BuildingUser;
import com.sys.dorm.service.BuildingUserService;

/**
 * <p><b>Title: </b>BuildingUserServiceImpl.java
 * <p><b>Description: </b>TODO
 * @author Xupk
 * @version V1.0
 * <p>
 * 2016年3月29日 Xupk 创建类  <br>
 *
 */

@Service
@Transactional(readOnly=true)
public class BuildingUserServiceImpl implements BuildingUserService{
	
private BuildingUserDao buildingUserDao;
	
	/**  
	 * 构造函数
	 * @param jpaRepository  
	 */ 
	@Autowired
	public BuildingUserServiceImpl(BuildingUserDao buildingUserDao) {
		this.buildingUserDao = buildingUserDao;
	}

	@Transactional
	@Override
	public void save(BuildingUser buildingUser) {
		buildingUserDao.save(buildingUser);
	}

	@Transactional
	@Override
	public void delete(Long buildingUserId) {
		buildingUserDao.delete(buildingUserId);
	}

	/**   
	 * @param userId
	 * @return  
	 * @see com.sys.dorm.service.BuildingUserService#find(Long)  
	 */
	public List<BuildingUser> find(Long buildingId) {
		return buildingUserDao.findByBuildingId(buildingId);
	}

}
