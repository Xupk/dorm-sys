/**
 * @Copyright:           Copyright© 2009-2016 UXUNCHINA
 * @Company:             深圳市优讯信息技术有限公司
 * @Project:             dorm-sys
 * @see                  com.sys.dorm.service                              
 */
package com.sys.dorm.service;

import java.util.List;

import com.sys.dorm.entity.main.Repair;
import com.sys.dorm.entity.main.Violation;
import com.sys.dorm.exception.ExistedException;
import com.sys.dorm.exception.ServiceException;
import com.sys.dorm.util.dwz.Page;

/**
 * <p><b>Title: </b>ViolationService.java
 * <p><b>Description: </b>TODO
 * @author Xupk
 * @version V1.0
 * <p>
 * 2016年4月23日 Xupk 创建类  <br>
 *
 */
public interface RepairService {
	
	Repair get(String roomName);
	
	List<Repair> find(Page page, String roomName);

	void update(Repair repair);

	void save(Repair repair) throws ExistedException;

	Repair get(Long id);

	void delete(Long id) throws ServiceException;

	List<Repair> findAll(Page page);
	
}
