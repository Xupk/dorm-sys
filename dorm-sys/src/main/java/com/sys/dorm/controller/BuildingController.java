/**
 * @Copyright:           Copyright© 2009-2016 UXUNCHINA
 * @Company:             深圳市优讯信息技术有限公司
 * @Project:             dorm-sys
 * @see                  com.sys.dorm.controller                              
 */
package com.sys.dorm.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Validator;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.beanvalidator.BeanValidators;

import com.google.common.collect.Lists;
import com.sys.dorm.constants.Constants;
import com.sys.dorm.entity.main.Building;
import com.sys.dorm.entity.main.BuildingUser;
import com.sys.dorm.entity.main.User;
import com.sys.dorm.exception.ExistedException;
import com.sys.dorm.service.BuildingService;
import com.sys.dorm.service.BuildingUserService;
import com.sys.dorm.service.UserService;
import com.sys.dorm.util.dwz.AjaxObject;
import com.sys.dorm.util.dwz.Page;

/**
 * <p>
 * <b>Title: </b>BuildingController.java
 * <p>
 * <b>Description: </b>TODO
 * 
 * @author Xupk
 * @version V1.0
 *          <p>
 *          2016年3月10日 Xupk 创建类 <br>
 * 
 */

@Controller
@RequestMapping("/management/security/building/")
public class BuildingController {
	@Autowired
	private BuildingService buildingService;
	
	@Autowired
	private BuildingUserService buildingUserService;
	
	@Autowired
	private UserService userService;

	@Autowired
	private Validator validator;

	private static final String CREATE = "management/security/building/create";
	private static final String UPDATE = "management/security/building/update";
	private static final String LIST = "management/security/building/list";
	private static final String TREE = "management/security/building/tree";
	private static final String VIEW = "management/security/building/view";
	private static final String ASSIGN_MANAGER = "management/security/building/assign_building_manager";
	private static final String DELETE_MANAGER = "management/security/building/delete_building_manager";

	@RequiresPermissions("Building:save")
	@RequestMapping(value = "/create/{parentBuildingId}", method = RequestMethod.GET)
	public String preCreate(Map<String, Object> map,
			@PathVariable Long parentBuildingId) {
		map.put("parentBuildingId", parentBuildingId);
		return CREATE;
	}

	
	@RequiresPermissions("Building:save")
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public @ResponseBody
	String create(Building building) {
		BeanValidators.validateWithException(validator, building);

		Building parentBuilding = buildingService.get(building.getParent()
				.getId());
		if (parentBuilding == null) {
			return AjaxObject.newError(
					"楼宇添加失败：id=" + building.getParent().getId() + "的父模块不存在！")
					.toString();
		}

		try {
			buildingService.save(building);
		} catch (ExistedException e) {
			return AjaxObject.newError("楼宇添加失败：" + e.getMessage()).toString();
		}

		return AjaxObject.newOk("楼宇添加成功!").toString();
	}

	@RequiresPermissions("Building:edit")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String preUpdate(@PathVariable Long id, Map<String, Object> map) {

		Building building = buildingService.get(id);

		map.put("building", building);
		return UPDATE;
	}

	@RequiresPermissions("Building:edit")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody
	String update(Building building) {
		BeanValidators.validateWithException(validator, building);

		Building oldBuilding = buildingService.get(building.getId());
		oldBuilding.setName(building.getName());
		oldBuilding.setSex(building.getSex());
		oldBuilding.setHeight(building.getHeight());
		oldBuilding.setLayerPRoom(building.getLayerPRoom());
		oldBuilding.setRoomPBed(building.getRoomPBed());
		oldBuilding.setContain(building.getContain());
		oldBuilding.setUsedBed(building.getUsedBed());

		buildingService.update(oldBuilding);

		return AjaxObject.newOk("楼宇修改成功！").toString();
	}

	@RequiresPermissions("Building:delete")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public @ResponseBody
	String delete(@PathVariable Long id) {

		AjaxObject ajaxObject = new AjaxObject();

		try {
			try {
				buildingService.delete(id);
			} catch (com.sys.dorm.exception.ServiceException e) {
				e.printStackTrace();
			}
			ajaxObject.setMessage("楼宇删除成功！");
		} catch (ServiceException e) {
			ajaxObject.setStatusCode(AjaxObject.STATUS_CODE_FAILURE);
			ajaxObject.setMessage("模块删除失败：" + e.getMessage());
		}

		ajaxObject.setCallbackType("");
		return ajaxObject.toString();
	}

	@RequiresPermissions("Building:view")
	@RequestMapping(value = "/tree", method = RequestMethod.GET)
	public String tree(Map<String, Object> map) {
		Building building = buildingService.getTree();
		map.put("building", building);
		return TREE;
	}

	@RequiresPermissions("Building:view")
	@RequestMapping(value = "/list/{parentBuildingId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public String list(Page page, @PathVariable Long parentBuildingId,
			String keywords, Map<String, Object> map) {
		List<Building> buildings = null;
		if (StringUtils.isNotBlank(keywords)) {
			buildings = buildingService.find(parentBuildingId, keywords, page);
		} else {
			buildings = buildingService.find(parentBuildingId, page);
		}

		map.put("page", page);
		map.put("buildings", buildings);
		map.put("keywords", keywords);
		map.put("parentBuildingId", parentBuildingId);

		return LIST;
	}

	@RequiresPermissions("Building:view")
	@RequestMapping(value = "/view/{id}", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String view(@PathVariable Long id, Map<String, Object> map) {

		Building building = buildingService.get(id);

		map.put("building", building);
		return VIEW;
	}
	
	@RequiresPermissions("Building:assign")
	@RequestMapping(value="/create/buildingUser", method={RequestMethod.POST})
	public @ResponseBody void assignManager(BuildingUser buildingUser) {
		buildingUserService.save(buildingUser);
	}
	
	@RequiresPermissions("Building:assign")
	@RequestMapping(value="/lookup2create/buildingManager/{buildingId}", method={RequestMethod.GET, RequestMethod.POST})
	public String listUnassignManager(Map<String, Object> map, @PathVariable Long buildingId) {
		Page page = new Page();
		page.setNumPerPage(Integer.MAX_VALUE);
		
		List<BuildingUser> buildingUsers = buildingUserService.find(buildingId);
		List<User> users = userService.findByOrgId(Constants.ROLE_BUILDING_MANAGER_ID);
		
		List<User> rentList = Lists.newArrayList();
		// 删除已分配users
		for (User user : users) {
			boolean isHas = false;
			for (BuildingUser or : buildingUsers) {
				if (or.getUser().getId().equals(user.getId())) {
					isHas = true;
					break;
				} 
			}
			if (isHas == false) {
				rentList.add(user);
			}
		}
		
		map.put("buildingUsers", buildingUsers);
		map.put("users", rentList);
		
		map.put("buildingId", buildingId);
		return ASSIGN_MANAGER;
	}
	
	@RequiresPermissions("Building:assign")
	@RequestMapping(value="/lookup2delete/buildingManager/{buildingId}", method={RequestMethod.GET, RequestMethod.POST})
	public String listBuildingUser(Map<String, Object> map, @PathVariable Long buildingId) {
		List<BuildingUser> buildingUsers = buildingUserService.find(buildingId);
		map.put("buildingUsers", buildingUsers);
		return DELETE_MANAGER;
	}
	
	@RequiresPermissions("Building:assign")
	@RequestMapping(value="/delete/buildingManager/{buildingUserId}", method={RequestMethod.POST})
	public @ResponseBody void deleteBuildingUser(@PathVariable Long buildingUserId) {
		buildingUserService.delete(buildingUserId);
	}

}
