/**
 * @Copyright:           Copyright© 2009-2016 UXUNCHINA
 * @Company:             深圳市优讯信息技术有限公司
 * @Project:             dorm-sys
 * @see                  com.sys.dorm.service.impl                              
 */
package com.sys.dorm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sys.dorm.dao.BuildingDao;
import com.sys.dorm.entity.main.Building;
import com.sys.dorm.exception.ExistedException;
import com.sys.dorm.exception.ServiceException;
import com.sys.dorm.service.BuildingService;
import com.sys.dorm.util.dwz.Page;
import com.sys.dorm.util.dwz.PageUtils;

/**
 * <p>
 * <b>Title: </b>BuildingServiceImpl.java
 * <p>
 * <b>Description: </b>TODO
 * 
 * @author Xupk
 * @version V1.0
 *          <p>
 *          2016年3月10日 Xupk 创建类 <br>
 * 
 */
@Service
@Transactional(readOnly = true)
public class BuildingServiceImpl implements BuildingService {

	@Autowired
	private BuildingDao buildingDao;

	@Transactional
	@Override
	public void save(Building building) throws ExistedException {
		if (buildingDao.findByName(building.getName()).size() > 0) {
			throw new ExistedException("已存在名称是:" + building.getName() + "的楼宇");
		}
		buildingDao.save(building);
	}

	@Override
	public Building get(Long id) {
		return buildingDao.findOne(id);
	}

	@Transactional
	@Override
	public void update(Building building) {
		buildingDao.save(building);
	}

	@Transactional
	public void delete(Long id) throws ServiceException {
		if (isRoot(id)) {
			throw new ServiceException("不允许删除根目录");
		}

		Building building = this.get(id);

		// 先判断是否存在子目录，如果存在，则不允许删除
		if (building.getChildren().size() > 0) {
			throw new ServiceException(building.getName() + "目录下存在子目录，不允许删除！");
		}

		buildingDao.deleteById(id);
	}

	/**
	 * 判断是否是根模块.
	 */
	private boolean isRoot(Long id) {
		return id == 1;
	}

	public List<Building> find(Long parentId, Page page) {
		org.springframework.data.domain.Page<Building> springDataPage = buildingDao
				.findByParentId(parentId, PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}

	public List<Building> find(Long parentId, String name, Page page) {
		org.springframework.data.domain.Page<Building> springDataPage = buildingDao
				.findByParentIdAndNameContaining(parentId, name,
						PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}

	@Override
	public List<Building> findAll() {
		return buildingDao.findAll();
	}

	public Building getTree() {

		List<Building> list = buildingDao.findAllWithCache();

		List<Building> rootList = makeTree(list);

		return rootList.get(0);
	}

	private List<Building> makeTree(List<Building> list) {
		List<Building> parent = new ArrayList<Building>();
		// get parentId = null;
		for (Building e : list) {
			if (e.getParent() == null) {
				e.setChildren(new ArrayList<Building>(0));
				parent.add(e);
			}
		}
		// 删除parentId = null;
		list.removeAll(parent);

		makeChildren(parent, list);

		return parent;
	}

	private void makeChildren(List<Building> parent, List<Building> children) {
		if (children.isEmpty()) {
			return;
		}

		List<Building> tmp = new ArrayList<Building>();
		for (Building c1 : parent) {
			for (Building c2 : children) {
				c2.setChildren(new ArrayList<Building>(0));
				if (c1.getId().equals(c2.getParent().getId())) {
					c1.getChildren().add(c2);
					tmp.add(c2);
				}
			}
		}

		children.removeAll(tmp);

		makeChildren(tmp, children);
	}

}
