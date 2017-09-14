/**
 * @Copyright:           Copyright© 2009-2016 UXUNCHINA
 * @Company:             深圳市优讯信息技术有限公司
 * @Project:             dorm-sys
 * @see                  com.sys.dorm.dao                              
 */
package com.sys.dorm.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sys.dorm.entity.main.Repair;
import com.sys.dorm.entity.main.Violation;

/**
 * <p><b>Title: </b>ViolationDao.java
 * <p><b>Description: </b>TODO
 * @author Xupk
 * @version V1.0
 * <p>
 * 2016年4月23日 Xupk 创建类  <br>
 *
 */
public interface RepairDao extends JpaRepository<Repair, Long>  {

	/**
	 * <p><b>Description: </b>根据宿舍名称查找
	 * <p>2016年4月23日 下午3:45:46
	 * @author xupk
	 * @param roomName
	 * @param createPageable
	 * @return
	 */
	org.springframework.data.domain.Page<Repair> findByRoomNameContaining(
			String roomName, Pageable createPageable);

}
