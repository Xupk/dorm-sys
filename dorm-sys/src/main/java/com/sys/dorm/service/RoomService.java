/**
 * @Copyright:           Copyright© 2009-2016 UXUNCHINA
 * @Company:             深圳市优讯信息技术有限公司
 * @Project:             dorm-sys
 * @see                  com.sys.dorm.service                              
 */
package com.sys.dorm.service;

import java.util.List;

import com.sys.dorm.entity.main.Room;
import com.sys.dorm.entity.main.User;
import com.sys.dorm.exception.ExistedException;
import com.sys.dorm.exception.ServiceException;
import com.sys.dorm.util.dwz.Page;

/**
 * <p><b>Title: </b>RoomService.java
 * <p><b>Description: </b>TODO
 * @author Xupk
 * @version V1.0
 * <p>
 * 2016年4月7日 Xupk 创建类  <br>
 *
 */
public interface RoomService {

	/**
	 * <p><b>Description: </b>关键词查找
	 * <p>2016年4月7日 下午3:04:32
	 * @author xupk
	 * @param page
	 * @param keywords
	 * @return
	 */
	List<Room> find(Page page, String keywords);

	/**
	 * <p><b>Description: </b>
	 * <p>2016年4月7日 下午3:04:39
	 * @author xupk
	 * @param page
	 * @return
	 */
	List<Room> findAll(Page page);

	/**
	 * <p><b>Description: </b>
	 * <p>2016年4月7日 下午5:33:19
	 * @author xupk
	 * @param room
	 */
	void save(Room room) throws ExistedException;

	/**
	 * <p><b>Description: </b>
	 * <p>2016年4月7日 下午9:09:03
	 * @author xupk
	 * @param id
	 * @return
	 */
	Room get(Long id);

	/**
	 * <p><b>Description: </b>
	 * <p>2016年4月7日 下午9:11:02
	 * @author xupk
	 * @param room
	 * 
	 */
	void update(Room room);

	/**
	 * <p><b>Description: </b>
	 * <p>2016年4月7日 下午10:20:48
	 * @author xupk
	 * @param id
	 */
	void delete(Long id) throws ServiceException;

	/**
	 * <p><b>Description: </b>
	 * <p>2016年4月8日 下午3:09:48
	 * @author xupk
	 * @return
	 */
	List<Room> findAll();

}
