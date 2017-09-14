<@dwz.layout_content>
<@dwz.form action="${request.contextPath}/management/security/building/create" onsubmit="return validateCallback(this, dialogReloadRel);">
	<input type="hidden" name="parent.id" value="${parentBuildingId }"/>
	<@dwz.layout_form_content layoutH="58">
	<@dwz.fieldset title="基本信息">
		<@dwz.label_input content="名称：">
			<input type="text" name="name" class="required" size="20" maxlength="20" alt=""/>
		</@dwz.label_input>	
		<@dwz.label_input content="性别：">
			<input type="text" name="sex" class="required" size="20" maxlength="20" value="男"/>
		</@dwz.label_input>					
		<@dwz.label_input content="高度(层)：">
			<input type="text" name="height" class="digits" size="20" maxlength="20" value="6"/>
		</@dwz.label_input>			
		<@dwz.label_input content="容量(人)：">
			<input type="text" name="contain" class="digits" size="20" maxlength="20" value="1000"/>
		</@dwz.label_input>	
		<@dwz.label_input content="已用床位(张)：">
			<input type="text" name="usedBed" class="digits" size="20" maxlength="20" value="0"/>
		</@dwz.label_input>
		<@dwz.label_input content="单层房间数(间)：">
			<input type="text" name="layerPRoom" class="digits" size="20" maxlength="20" value="30"/>
		</@dwz.label_input>
		<@dwz.label_input content="单房床位数(张)：">
			<input type="text" name="roomPBed" class="digits" size="20" maxlength="20" value="6"/>
		</@dwz.label_input>
	</@dwz.fieldset>			
	</@dwz.layout_form_content>
	<@dwz.form_bar submitTitle="确定" closeTitle="关闭"/>	
</@dwz.form>
</@dwz.layout_content>