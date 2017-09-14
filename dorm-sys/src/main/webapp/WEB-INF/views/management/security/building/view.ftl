<@dwz.layout_content>
	<@dwz.layout_form_content layoutH="58" id="permissionFormContent">
	<@dwz.fieldset title="基本信息">
		<@dwz.label_input content="名称：">
			<input type="text" name="name" class="required" size="20" maxlength="20" value="${building.name }" alt="" readOnly=readOnly/>
		</@dwz.label_input>	
		<@dwz.label_input content="性别：">
			<input type="text" name="sex" size="20" maxlength="20" value="${building.sex!'' }" readOnly=readOnly/>
		</@dwz.label_input>					
		<@dwz.label_input content="高度(层)：">
			<input type="text" name="height" size="20" maxlength="20" alt="" value="${building.height!'' }" readOnly=readOnly/>
		</@dwz.label_input>			
		<@dwz.label_input content="容量(人)：">
			<input type="text" name="contain" class="contain" size="20" maxlength="20" alt="" value="${building.contain!'' }" readOnly=readOnly/>
		</@dwz.label_input>	
		<@dwz.label_input content="已用床位(张)：">
			<input type="text" name="usedBed" size="20" maxlength="20" alt="" value="${building.usedBed!'' }" readOnly=readOnly/>
		</@dwz.label_input>	
		<@dwz.label_input content="单层房间数(间)：">
			<input type="text" name="layerPRoom" size="20" maxlength="20" alt="" value="${building.layerPRoom!'' }" readOnly=readOnly/>
		</@dwz.label_input>	
		<@dwz.label_input content="单房床位数(张)：">
			<input type="text" name="roomPBed" size="20" maxlength="20" alt="" value="${building.roomPBed!'' }" readOnly=readOnly/>
		</@dwz.label_input>	
		<#list building.buildingUsers as bu>
			<@dwz.label_input content="管理员：">
				<input type="text" name="manager" size="20" maxlength="20" alt="" value="${bu.user.username!'' } " readOnly=readOnly/>
			</@dwz.label_input>	
		</#list>
	</@dwz.fieldset>			
	</@dwz.layout_form_content>
	<@dwz.form_bar closeTitle="关闭"/>	
</@dwz.layout_content>