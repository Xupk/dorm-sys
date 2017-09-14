<@dwz.layout_content>
<@dwz.form action="${request.contextPath}/management/security/building/update" id="permissionForm" onsubmit="return validateCallback(this, dialogReloadRel)">
	<input type="hidden" name="id" value="${building.id }"/>
	<input type="hidden" name="parent.id" value="${building.parent.id }"/>
	<@dwz.layout_form_content layoutH="58" id="permissionFormContent">
	<@dwz.fieldset title="基本信息">
		<@dwz.label_input content="名称：">
			<input type="text" name="name" class="required" size="20" maxlength="20" value="${building.name }"/>
		</@dwz.label_input>	
		<@dwz.label_input content="性别：">
			<input type="text" name="sex" size="20" maxlength="20" value="${building.sex!'' }" alt=""/>
		</@dwz.label_input>					
		<@dwz.label_input content="高度(层)：">
			<input type="text" name="height" size="20" maxlength="20" value="${building.height!'' }" alt=""/>
		</@dwz.label_input>			
		<@dwz.label_input content="容量(人)：">
			<input type="text" name="contain" size="20" maxlength="20" value="${building.contain!'' }" alt=""/>
		</@dwz.label_input>	
		<@dwz.label_input content="已用床位(张)：">
			<input type="text" name="usedBed" size="20" maxlength="20" value="${building.usedBed!'' }" alt=""/>
		</@dwz.label_input>
		<@dwz.label_input content="单层房间数(间)：">
			<input type="text" name="layerPRoom" size="20" maxlength="20" value="${building.layerPRoom!'' }" alt=""/>
		</@dwz.label_input>
		<@dwz.label_input content="单房床位数(张)：">
			<input type="text" name="roomPBed" size="20" maxlength="20" value="${building.roomPBed!'' }" alt=""/>
		</@dwz.label_input>
	</@dwz.fieldset>
	</@dwz.layout_form_content>
	<@dwz.form_bar submitTitle="确定" closeTitle="关闭"/>	
</@dwz.form>
</@dwz.layout_content>