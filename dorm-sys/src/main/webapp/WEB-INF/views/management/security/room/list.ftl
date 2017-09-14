<@dwz.pagerForm action="${request.contextPath}/management/security/room/list" page=page>
	<input type="hidden" name="keywords" value="${keywords!''}"/>
</@dwz.pagerForm>

<@dwz.search_form action="${request.contextPath}/management/security/room/list">
	<@dwz.label_input2 content="房间名称：">
		<input type="text" name="keywords" value="${keywords!''}"/>
	</@dwz.label_input2>
</@dwz.search_form>

<@dwz.layout_content>
	<@dwz.tool_bar>
		<@shiro.hasPermission name="Room:save">
			<@dwz.tool_button content="添加房间" class="application_add" rel="lookup2organization_add" width="530" height="330" href="${request.contextPath}/management/security/room/create"/>
		</@shiro.hasPermission>
		<@shiro.hasPermission name="Room:edit">
			<@dwz.tool_button content="编辑房间" class="application_edit" rel="lookup2organization_edit" width="530" height="330" href="${request.contextPath}/management/security/room/update/{slt_uid}"/>
		</@shiro.hasPermission>
		<@shiro.hasPermission name="Room:delete">
			<@dwz.tool_button content="删除房间" class="application_delete" target="ajaxTodo" href="${request.contextPath}/management/security/room/delete/{slt_uid}" title="确认要删除该房间?"/>
		</@shiro.hasPermission>
	</@dwz.tool_bar>
	
	<@dwz.table_common layoutH="138">
		<thead>
			<tr>
				<th width="200">房间名称</th>
				<th width="200">可住（人）</th>
				<th width="200">已住（人）</th>
				<th width="200">电话</th>
			</tr>
		</thead>
		<tbody>
			<#list rooms as item>
			<tr target="slt_uid" rel="${item.id}">
				<td>
					${item.name!''}
				</td>
				<td>${item.contain!''}</td>
				<td>${item.used!''}</td>
				<td>${item.phone!''}</td>
			</tr>			
			</#list>
		</tbody>
	</@dwz.table_common>
	<!-- 分页 -->
	<@dwz.pagerBar page=page/>
</@dwz.layout_content>
