<@dwz.pagerForm action="${request.contextPath}/management/security/building/list/${parentBuildingId}" page=page onsubmit="return divSearch(this, 'jbsxBox2building');">
	<input type="hidden" name="keywords" value="${keywords!''}"/>
</@dwz.pagerForm>

<@dwz.search_form action="${request.contextPath}/management/security/building/list/${parentBuildingId}" onsubmit="return divSearch(this, 'jbsxBox2building');">
	<@dwz.label_input2 content="楼宇名称：">
		<input type="text" name="keywords" value="${keywords!''}"/>
	</@dwz.label_input2>
</@dwz.search_form>

<@dwz.layout_content>
	<@dwz.tool_bar>
		<@shiro.hasPermission name="Building:view">
			<@dwz.tool_button content="查看楼宇" class="magnifier" width="530" height="500" href="${request.contextPath}/management/security/building/view/{slt_uid}"/>
		</@shiro.hasPermission>	
		<@shiro.hasPermission name="Building:save">
			<@dwz.tool_button content="添加楼宇" class="application_add" width="530" height="500" href="${request.contextPath}/management/security/building/create/${parentBuildingId}"/>
		</@shiro.hasPermission>
		<@shiro.hasPermission name="Building:edit">
			<@dwz.tool_button content="编辑楼宇" class="application_edit" width="530" height="500" href="${request.contextPath}/management/security/building/update/{slt_uid}"/>
		</@shiro.hasPermission>
		<@shiro.hasPermission name="Building:delete">
			<@dwz.tool_button content="删除楼宇" class="application_delete" target="ajaxTodo" callback="reloadRel" href="${request.contextPath}/management/security/building/delete/{slt_uid}" title="确认要删除该楼宇?"/>
		</@shiro.hasPermission>
		<@shiro.hasPermission name="Building:assign">
			<@dwz.tool_button content="分配管理员" class="shield_add" href="${request.contextPath}/management/security/building/lookup2create/buildingManager/{slt_uid}" width="400" height="500" title="分配管理员"/>
		</@shiro.hasPermission>
		<@shiro.hasPermission name="Building:assign">
			<@dwz.tool_button content="撤销管理员" class="shield_delete" href="${request.contextPath}/management/security/building/lookup2delete/buildingManager/{slt_uid}" width="400" height="500" title="撤销管理员"/>
		</@shiro.hasPermission>
	</@dwz.tool_bar>
	
	<@dwz.table_common layoutH="142" rel="jbsxBox2building">
		<thead>
			<tr>
				<th width="80">名称</th>
				<th width="70">性别</th>
				<th width="70">高度(层)</th>
				<th width="70">容量(人)</th>
				<th width="90">已用床位(张)</th>
				<th width="90">单层房间数(间)</th>
				<th width="90">单房床位数(张)</th>
				<th width="100">所属区域</th>
				<th >管理员</th>
			</tr>
		</thead>
		<tbody>
			<#list buildings as item>
			<tr target="slt_uid" rel="${item.id}">
				<td><a href="${request.contextPath}/management/security/building/list/${item.id}" target="ajax" rel="jbsxBox2building">${item.name}</a></td>
				<td>${item.sex}</td>
				<td>${item.height}</td>
				<td>${item.contain}</td>
				<td>${item.usedBed}</td>
				<td>${item.layerPRoom}</td>
				<td>${item.roomPBed}</td>
				<td>${item.parent.name}</td>
				<td>
					<#list item.buildingUsers as bu>
						${bu.user.realname!'' }
					</#list>
				</td>
			</tr>
			</#list>
		</tbody>
	</@dwz.table_common>
	<!-- 分页 -->
	<@dwz.pagerBar page=page rel="jbsxBox2building" onchange="navTabPageBreak({numPerPage:this.value}, 'jbsxBox2building')"/>
</@dwz.layout_content>