/**
 * @Copyright:           Copyright© 2009-2016 UXUNCHINA
 * @Company:             深圳市优讯信息技术有限公司
 * @Project:             dorm-sys
 * @see                  com.sys.dorm.dao                              
 */
package com.sys.dorm.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sys.dorm.entity.main.Room;

/**
 * <p><b>Title: </b>RoomDao.java
 * <p><b>Description: </b>TODO
 * @author Xupk
 * @version V1.0
 * <p>
 * 2016年4月7日 Xupk 创建类  <br>
 *
 */
public interface RoomDao extends JpaRepository<Room, Long>{

	/**
	 * <p><b>Description: </b>根据房间名称查找房间（模糊查找）
	 * <p>2016年4月7日 下午3:26:11
	 * @author xupk
	 * @param name
	 * @param createPageable
	 * @return
	 */
	Page<Room> findByNameContaining(String name, Pageable pageable);

	/**
	 * <p><b>Description: </b>根据房间名查找房间（精确查找）
	 * <p>2016年4月7日 下午5:38:28
	 * @author xupk
	 * @param name
	 * @return
	 */
	Room findByName(String name);

	/**
	 * <p><b>Description: </b>根据ID查找
	 * <p>2016年4月23日 上午11:20:29
	 * @author xupk
	 * @param roomId
	 * @return
	 */
	Room findById(long roomId);

}
