/**
 * @Copyright:           Copyright© 2009-2016 UXUNCHINA
 * @Company:             深圳市优讯信息技术有限公司
 * @Project:             dorm-sys
 * @see                  com.sys.dorm.dao                              
 */
package com.sys.dorm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sys.dorm.entity.main.BuildingUser;
import com.sys.dorm.entity.main.BuildingUser;

/**
 * <p><b>Title: </b>BuildingUserDao.java
 * <p><b>Description: </b>
 * @author Xupk
 * @version V1.0
 * <p>
 * 2016年3月29日 Xupk 创建类  <br>
 *
 */
public interface BuildingUserDao extends JpaRepository<BuildingUser, Long>{
	
	List<BuildingUser> findByUserId(Long userId);
	
	List<BuildingUser> findByBuildingId(Long buildingId);

}
