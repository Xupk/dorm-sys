<@dwz.layout_content>
<@dwz.form action="${request.contextPath}/management/security/violation/update" onsubmit="return validateCallback(this, dialogReloadNavTab);">
	<input type="hidden" name="id" value="${violation.id}"/>
	<@dwz.layout_form_content layoutH="58">
		<@dwz.label_input content="宿舍号:">
			<input type="text" name="roomName" class="required" size="20" maxlength="20" value="${violation.roomName!''}"/>
		</@dwz.label_input>	
		<@dwz.label_input content="违规信息:">
			<input type="text" name="message" class="required" size="20" maxlength="255" value="${violation.message!''}"/>
		</@dwz.label_input>					
		<@dwz.label_input content="违规学生:">
			<input type="text" name="student" class="required" size="20" maxlength="255" value="${violation.student!''}"/>
		</@dwz.label_input>			
		<@dwz.label_input content="记录人:">
			<input type="text" name="manager" class="" size="20" maxlength="20" value="${violation.manager!''}"/>
		</@dwz.label_input>	
		<@dwz.label_input content="时间:">
			<input type="text" name="date" class="date" readonly="true" value="${violation.date!''}"/>
			<a class="inputDateButton" href="javascript:;">选择</a>
		</@dwz.label_input>	
		<@dwz.label_input content="状态:">
			<select name="status">
				<option value="enabled" ${(violation.status == "enabled")?string('selected="selected"','')}>未处理</option>
				<option value="disabled" ${(violation.status == "disabled")?string('selected="selected"','')}>已处理</option>
			</select>
		</@dwz.label_input>							
	</@dwz.layout_form_content>
			
	<@dwz.form_bar submitTitle="确定" closeTitle="关闭"/>	
</@dwz.form>
</@dwz.layout_content>