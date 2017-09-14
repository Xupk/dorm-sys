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

import com.sys.dorm.entity.main.Student;

/**
 * <p><b>Title: </b>StudentDao.java
 * <p><b>Description: </b>TODO
 * @author Xupk
 * @version V1.0
 * <p>
 * 2016年4月8日 Xupk 创建类  <br>
 *
 */
public interface StudentDao extends JpaRepository<Student, Long>{

	/**
	 * <p><b>Description: </b>姓名的模糊查找
	 * <p>2016年4月8日 上午11:19:45
	 * @author xupk
	 * @param name
	 * @param createPageable
	 * @return
	 */
	Page<Student> findByNameContaining(
			String name, Pageable createPageable);


	/**
	 * <p><b>Description: </b>姓名的精确查找
	 * <p>2016年4月8日 下午2:31:39
	 * @author xupk
	 * @param name
	 * @return
	 */
	Student findByName(String name);


	/**
	 * <p><b>Description: </b>学号查找
	 * <p>2016年4月23日 上午11:35:58
	 * @author xupk
	 * @param stuNo
	 * @return
	 */
	Student findByStuNo(String stuNo);


}
