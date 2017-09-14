<@dwz.layout_content>
<@dwz.form action="${request.contextPath}/management/security/room/update" onsubmit="return validateCallback(this, dialogReloadNavTab);">
	<input type="hidden" name="id" value="${room.id}"/>
	<@dwz.layout_form_content layoutH="58">
		<@dwz.label_input content="房间名称:">
			<input type="text" name="name" class="required" size="20" maxlength="20" readonly="readonly" value="${room.name!''}"/>
		</@dwz.label_input>	
		<@dwz.label_input content="可住（人）:">
			<input type="text" name="contain" class="required digits" size="11" maxlength="11" value="${room.contain!''}"/>
		</@dwz.label_input>					
		<@dwz.label_input content="已住（人）:">
			<input type="text" name="used" class="required digits" size="11" maxlength="11" value="${room.used!''}"/>
		</@dwz.label_input>			
		<@dwz.label_input content="电话:">
			<input type="text" name="phone" class="phone" size="20" maxlength="20" value="${room.phone!''}"/>
		</@dwz.label_input>	
		<@dwz.label_input content="所属楼栋:">
			<input name="building.id" value="${room.building.id!''}" type="hidden"/>
			<input class="required" name="building.name" type="text" readonly="readonly"  value="${room.building.name!''}"/>
			<a class="btnLook" href="${request.contextPath}/management/security/room/lookup2building" lookupGroup="building" title="所属楼栋" width="400">查找带回</a>
		</@dwz.label_input>
	</@dwz.layout_form_content>
			
	<@dwz.form_bar submitTitle="确定" closeTitle="关闭"/>	
</@dwz.form>
</@dwz.layout_content>