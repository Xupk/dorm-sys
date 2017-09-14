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
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.beanvalidator.BeanValidators;

import com.sys.dorm.entity.main.Building;
import com.sys.dorm.entity.main.Room;
import com.sys.dorm.entity.main.User;
import com.sys.dorm.exception.ExistedException;
import com.sys.dorm.exception.ServiceException;
import com.sys.dorm.service.BuildingService;
import com.sys.dorm.service.RoomService;
import com.sys.dorm.util.dwz.AjaxObject;
import com.sys.dorm.util.dwz.Page;

/**
 * <p>
 * <b>Title: </b>RoomController.java
 * <p>
 * <b>Description: </b>房间管理Controller
 * 
 * @author Xupk
 * @version V1.0
 *          <p>
 *          2016年4月7日 Xupk 创建类 <br>
 * 
 */

@Controller
@RequestMapping("/management/security/room")
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private BuildingService buildingService;
	
	@Autowired
	private Validator validator;

	private static final String CREATE = "management/security/room/create";
	private static final String UPDATE = "management/security/room/update";
	private static final String LIST = "management/security/room/list";
	private static final String LOOK_BUILDING = "management/security/room/lookup_building";
	
	@RequiresPermissions("Room:view")
	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
	public String list(Page page, String keywords, Map<String, Object> map) {
		List<Room> rooms;
		if (StringUtils.isNotBlank(keywords)) {
			rooms = roomService.find(page, keywords);
		} else {
			rooms = roomService.findAll(page);
		}
		map.put("page", page);
		map.put("rooms", rooms);
		map.put("keywords", keywords);
		return LIST;
	}
	
	@RequiresPermissions("Room:save")
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String preCreate() {
		return CREATE;
	}
	
	@RequiresPermissions("Room:save")
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public @ResponseBody String create(Room room) {	
		BeanValidators.validateWithException(validator, room);
		
		try {
			roomService.save(room);
		} catch (ExistedException e) {
			AjaxObject ajaxObject = new AjaxObject(e.getMessage());
			ajaxObject.setCallbackType("");
			ajaxObject.setStatusCode(AjaxObject.STATUS_CODE_FAILURE);
			return ajaxObject.toString();
		}
		
		return AjaxObject.newOk("添加房间成功！").toString();
	}
	
	@RequiresPermissions(value={"Room:edit", "Room:save"}, logical=Logical.OR)
	@RequestMapping(value="/lookup2building", method={RequestMethod.GET})
	public String lookup(Map<String, Object> map) {
		Building building = buildingService.getTree();
		
		map.put("building", building);
		return LOOK_BUILDING;
	}
	
	@ModelAttribute("preloadRoom")
	public Room getOne(@RequestParam(value = "id", required = false) Long id) {
		if (id != null) {
			Room room = roomService.get(id);
			room.setBuilding(null);
			return room;
		}
		return null;
	}
	
	@RequiresPermissions("Room:edit")
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public String preUpdate(@PathVariable Long id, Map<String, Object> map) {
		Room room = roomService.get(id);
		
		map.put("room", room);
		return UPDATE;
	}
	
	@RequiresPermissions("Room:edit")
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public @ResponseBody String update(@ModelAttribute("preloadRoom")Room room) {
		BeanValidators.validateWithException(validator, room);
		roomService.update(room);
		return	AjaxObject.newOk("编辑房间成功！").toString(); 
	}
	
	@RequiresPermissions("Room:delete")
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
	public @ResponseBody String delete(@PathVariable Long id) {
		AjaxObject ajaxObject = new AjaxObject("删除房间成功！");
		try {
			roomService.delete(id);
		} catch (ServiceException e) {
			ajaxObject.setMessage(e.getMessage());
		}
		
		ajaxObject.setCallbackType("");
		return ajaxObject.toString();
	}

}
