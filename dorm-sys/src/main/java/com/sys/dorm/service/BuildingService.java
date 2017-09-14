/**
 * @Copyright:           Copyright© 2009-2016 UXUNCHINA
 * @Company:             深圳市优讯信息技术有限公司
 * @Project:             dorm-sys
 * @see                  com.sys.dorm.service                              
 */
package com.sys.dorm.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;

import com.sys.dorm.entity.main.Building;
import com.sys.dorm.exception.ExistedException;
import com.sys.dorm.util.dwz.Page;

/**
 * <p><b>Title: </b>BuildingService.java
 * <p><b>Description: </b>TODO
 * @author Xupk
 * @version V1.0
 * <p>
 * 2016年3月10日 Xupk 创建类  <br>
 *
 */
public interface BuildingService {

	/**
	 * <p><b>Description: </b>根据ID获得一个实体
	 * <p>2016年3月10日 下午4:37:09
	 * @author xupk
	 * @param id
	 * @return
	 */
	Building get(Long id);

	/**
	 * <p><b>Description: </b>保存
	 * <p>2016年3月10日 下午4:43:07
	 * @author xupk
	 * @param building
	 */
	void save(Building building) throws ExistedException;

	/**
	 * <p><b>Description: </b>更新
	 * <p>2016年3月10日 下午4:51:58
	 * @author xupk
	 * @param oldBuilding
	 */
	void update(Building Building);

	/**
	 * <p><b>Description: </b>删除
	 * <p>2016年3月10日 下午5:02:57
	 * @author xupk
	 * @param id
	 * @throws com.sys.dorm.exception.ServiceException 
	 */
	void delete(Long id) throws ServiceException, com.sys.dorm.exception.ServiceException;

	/**
	 * <p><b>Description: </b>获取树结构
	 * <p>2016年3月10日 下午5:17:08
	 * @author xupk
	 * @return
	 */
	Building getTree();

	/**
	 * <p><b>Description: </b>根据父节点的ID，名称查找
	 * <p>2016年3月10日 下午5:23:22
	 * @author xupk
	 * @param parentBuildingId
	 * @param keywords
	 * @param page
	 * @return
	 */
	List<Building> find(Long parentId, String name, Page page);

	/**
	 * <p><b>Description: </b>
	 * <p>2016年3月10日 下午5:24:28
	 * @author xupk
	 * @param parentBuildingId
	 * @param page
	 * @return
	 */
	List<Building> find(Long parentId, Page page);

	/**
	 * <p><b>Description: </b>查找所有
	 * <p>2016年3月10日 下午6:24:00
	 * @author xupk
	 * @return
	 */
	List<Building> findAll();

}
