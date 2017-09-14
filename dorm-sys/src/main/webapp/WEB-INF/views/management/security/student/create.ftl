<@dwz.layout_content>
<@dwz.form action="${request.contextPath}/management/security/student/create" onsubmit="return validateCallback(this, dialogReloadNavTab);">
	<@dwz.layout_form_content layoutH="58">
		<@dwz.label_input content="姓名:">
			<input type="text" name="name" class="required" size="20" maxlength="20"/>
		</@dwz.label_input>	
		<@dwz.label_input content="学号:">
			<input type="text" name="stuNo" class="required digits" size="20" maxlength="20"/>
		</@dwz.label_input>					
		<@dwz.label_input content="性别:">
			<input type="text" name="sex" class="required" size="20" maxlength="20" />
		</@dwz.label_input>			
		<@dwz.label_input content="年级:">
			<input type="text" name="grade" class="required" size="20" maxlength="20"/>
		</@dwz.label_input>	
		<@dwz.label_input content="电话:">
			<input type="text" name="phone" class="required phone" size="20" maxlength="20"/>
		</@dwz.label_input>
		<@dwz.label_input content="宿舍:">
			<input name="room.id" value="" type="hidden"/>
			<input class="required" name="room.name" type="text" readonly="readonly" lookupGroup="room"/>
			<a class="btnLook" href="${request.contextPath}/management/security/student/lookup2room" lookupGroup="room" title="入住宿舍" width="400">查找带回</a>
		</@dwz.label_input>
	</@dwz.layout_form_content>
			
	<@dwz.form_bar submitTitle="确定" closeTitle="关闭"/>	
</@dwz.form>
</@dwz.layout_content>