<@dwz.layout_content>
<@dwz.form action="${request.contextPath}/management/security/room/create" onsubmit="return validateCallback(this, dialogReloadNavTab);">
	<@dwz.layout_form_content layoutH="58">
		<@dwz.label_input content="房间名称:">
			<input type="text" name="name" class="required" size="20" maxlength="20"/>
		</@dwz.label_input>	
		<@dwz.label_input content="可住（人）:">
			<input type="text" name="contain" class="required digits" size="11" maxlength="11"/>
		</@dwz.label_input>					
		<@dwz.label_input content="已住（人）:">
			<input type="text" name="used" class="required digits" size="11" maxlength="11" />
		</@dwz.label_input>			
		<@dwz.label_input content="电话:">
			<input type="text" name="phone" class="phone" size="20" maxlength="20"/>
		</@dwz.label_input>	
		<@dwz.label_input content="所属楼栋:">
			<input name="building.id" value="" type="hidden"/>
			<input class="required" name="building.name" type="text" readonly="readonly"/>
			<a class="btnLook" href="${request.contextPath}/management/security/room/lookup2building" lookupGroup="building" title="所属楼栋" width="400">查找带回</a>
		</@dwz.label_input>
	</@dwz.layout_form_content>
			
	<@dwz.form_bar submitTitle="确定" closeTitle="关闭"/>	
</@dwz.form>
</@dwz.layout_content>