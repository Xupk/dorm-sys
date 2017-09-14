/**
 * @Copyright:           Copyright© 2009-2016 UXUNCHINA
 * @Company:             深圳市优讯信息技术有限公司
 * @Project:             dorm-sys
 * @see                  com.sys.dorm.service                              
 */
package com.sys.dorm.service;

import java.util.List;

import com.sys.dorm.entity.main.Room;
import com.sys.dorm.entity.main.Student;
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
public interface StudentService {

	/**
	 * <p><b>Description: </b>
	 * <p>2016年4月8日 下午1:51:31
	 * @author xupk
	 * @param page
	 * @param keywords
	 * @return
	 */
	List<Student> find(Page page, String keywords);

	/**
	 * <p><b>Description: </b>
	 * <p>2016年4月8日 下午1:51:38
	 * @author xupk
	 * @param page
	 * @return
	 */
	List<Student> findAll(Page page);

	/**
	 * <p><b>Description: </b>
	 * <p>2016年4月8日 下午2:28:52
	 * @author xupk
	 * @param student
	 */
	void save(Student student) throws ExistedException;

	/**
	 * <p><b>Description: </b>
	 * <p>2016年4月23日 下午12:42:21
	 * @author xupk
	 * @param id
	 * @return
	 */
	Student get(Long id);

	/**
	 * <p><b>Description: </b>
	 * <p>2016年4月23日 下午12:54:03
	 * @author xupk
	 * @param student
	 */
	void update(Student student);

	/**
	 * <p><b>Description: </b>
	 * <p>2016年4月23日 下午2:26:40
	 * @author xupk
	 * @param id
	 */
	void delete(Long id);

}
