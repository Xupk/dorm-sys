<@dwz.layout_content>
<@dwz.form action="${request.contextPath}/management/security/student/update" onsubmit="return validateCallback(this, dialogReloadNavTab);">
	<input type="hidden" name="id" value="${student.id}"/>
	<@dwz.layout_form_content layoutH="58">
		<@dwz.label_input content="姓名:">
			<input type="text" name="name" class="required" size="20" maxlength="20" value="${student.name!''}"/>
		</@dwz.label_input>	
		<@dwz.label_input content="学号:">
			<input type="text" name="stuNo" class="required digits" size="20" maxlength="20" readonly="readonly" value="${student.stuNo!''}"/>
		</@dwz.label_input>					
		<@dwz.label_input content="性别:">
			<input type="text" name="sex" class="required" size="20" maxlength="20" value="${student.sex!''}"/>
		</@dwz.label_input>			
		<@dwz.label_input content="年级:">
			<input type="text" name="grade" class="required" size="20" maxlength="20" value="${student.grade!''}"/>
		</@dwz.label_input>	
		<@dwz.label_input content="电话:">
			<input type="text" name="phone" class="required phone" size="20" maxlength="20" value="${student.phone!''}"/>
		</@dwz.label_input>
		<@dwz.label_input content="宿舍:">
			<input name="room.id" value="${student.room.id}" type="hidden"/>
			<input class="required" name="room.name" type="text" value="${student.room.name}" readonly="readonly" lookupGroup="room"/>
		</@dwz.label_input>
	</@dwz.layout_form_content>
	
	<@dwz.form_bar submitTitle="确定" closeTitle="关闭"/>	
</@dwz.form>
</@dwz.layout_content>