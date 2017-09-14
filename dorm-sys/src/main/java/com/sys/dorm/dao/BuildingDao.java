/**
 * @Copyright:           Copyright© 2009-2016 UXUNCHINA
 * @Company:             深圳市优讯信息技术有限公司
 * @Project:             dorm-sys
 * @see                  com.sys.dorm.dao                              
 */
package com.sys.dorm.dao;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.transaction.annotation.Transactional;

import com.sys.dorm.entity.main.Building;

/**
 * <p><b>Title: </b>BuildingDao.java
 * <p><b>Description: </b>TODO
 * @author Xupk
 * @version V1.0
 * <p>
 * 2016年3月10日 Xupk 创建类  <br>
 *
 */
public interface BuildingDao extends JpaRepository<Building, Long>{

	/**
	 * <p><b>Description: 根据名称查找楼宇</b>
	 * <p>2016年3月10日 下午5:37:53
	 * @author xupk
	 * @param name
	 * @return
	 */
	List<Building> findByName(String name);

	/**
	 * <p><b>Description:根据父节点查找 </b>
	 * <p>2016年3月10日 下午6:18:25
	 * @author xupk
	 * @param parentId
	 * @param createPageable
	 * @return
	 */
	Page<Building> findByParentId(Long parentId,
			Pageable pageable);

	/**
	 * <p><b>Description: </b>根据父节点和名称查找
	 * <p>2016年3月10日 下午6:21:57
	 * @author xupk
	 * @param parentId
	 * @param name
	 * @param createPageable
	 * @return
	 */
	Page<Building> findByParentIdAndNameContaining(
			Long parentId, String name, Pageable Pageable);

	/**
	 * <p><b>Description: </b>缓存查找
	 * <p>2016年3月10日 下午6:25:33
	 * @author xupk
	 * @return
	 */
	@QueryHints(value={
			@QueryHint(name="org.hibernate.cacheable",value="true"),
			@QueryHint(name="org.hibernate.cacheRegion",value="com.sys.dorm.entity.main")
		}
	)
	@Query("from Building")
	List<Building> findAllWithCache();

	@Transactional
	@Modifying
	@Query("delete from Building b where b.id = ?1")
	int deleteById(Long id);
	
}
