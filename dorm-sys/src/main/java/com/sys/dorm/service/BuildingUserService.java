/**
 * @Copyright:           Copyright© 2009-2016 UXUNCHINA
 * @Company:             深圳市优讯信息技术有限公司
 * @Project:             dorm-sys
 * @see                  com.sys.dorm.service                              
 */
package com.sys.dorm.service;

import java.util.List;

import com.sys.dorm.entity.main.BuildingUser;

/**
 * <p><b>Title: </b>BuildingUserService.java
 * <p><b>Description: </b>TODO
 * @author Xupk
 * @version V1.0
 * <p>
 * 2016年3月29日 Xupk 创建类  <br>
 *
 */
public interface BuildingUserService {
	
	/**
	 * 根据buildingId，找到已分配的管理员。
	 * 描述
	 * @param buildingId
	 * @return
	 */
	List<BuildingUser> find(Long buildingId);

	void save(BuildingUser buildingUser);

	void delete(Long buildingUserId);

}
