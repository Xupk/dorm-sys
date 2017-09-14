<@dwz.layout_content>
<@dwz.form action="${request.contextPath}/management/security/repair/create" onsubmit="return validateCallback(this, dialogReloadNavTab);">
	<@dwz.layout_form_content layoutH="58">
		<@dwz.label_input content="宿舍号:">
			<input type="text" name="roomName" class="required" size="20" maxlength="20"/>
		</@dwz.label_input>	
		<@dwz.label_input content="报修信息:">
			<input type="text" name="message" class="required" size="20" maxlength="255"/>
		</@dwz.label_input>					
		<@dwz.label_input content="报修学生:">
			<input type="text" name="student" class="required" size="20" maxlength="255"/>
		</@dwz.label_input>			
		<@dwz.label_input content="处理人:">
			<input type="text" name="manager" class="required" size="20" maxlength="20"/>
		</@dwz.label_input>	
		<@dwz.label_input content="时间:">
			<input type="text" name="date" class="date" readonly="true"/>
			<a class="inputDateButton" href="javascript:;">选择</a>
		</@dwz.label_input>	
		<@dwz.label_input content="状态:">
			<select name="status">
				<option value="enabled">未处理</option>
				<option value="disabled">已处理</option>
			</select>
		</@dwz.label_input>							
	</@dwz.layout_form_content>
			
	<@dwz.form_bar submitTitle="确定" closeTitle="关闭"/>	
</@dwz.form>
</@dwz.layout_content>