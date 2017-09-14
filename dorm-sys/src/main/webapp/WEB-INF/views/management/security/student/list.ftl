<@dwz.pagerForm action="${request.contextPath}/management/security/student/list" page=page>
	<input type="hidden" name="keywords" value="${keywords!''}"/>
</@dwz.pagerForm>

<@dwz.search_form action="${request.contextPath}/management/security/student/list">
	<@dwz.label_input2 content="学生姓名：">
		<input type="text" name="keywords" value="${keywords!''}"/>
	</@dwz.label_input2>
</@dwz.search_form>

<@dwz.layout_content>
	<@dwz.tool_bar>
		<@shiro.hasPermission name="Student:save">
			<@dwz.tool_button content="入住" class="user_add" width="530" height="330" rel="lookup2organization_add" href="${request.contextPath}/management/security/student/create"/>
		</@shiro.hasPermission>
		<@shiro.hasPermission name="Student:edit">
			<@dwz.tool_button content="修改" class="user_edit" width="530" height="330" rel="lookup2organization_add" href="${request.contextPath}/management/security/student/update/{slt_uid}"/>
		</@shiro.hasPermission>
		<@shiro.hasPermission name="Student:delete">
			<@dwz.tool_button content="退宿" class="user_delete" target="ajaxTodo" href="${request.contextPath}/management/security/student/delete/{slt_uid}" title="确认要退宿?"/>
		</@shiro.hasPermission>
	</@dwz.tool_bar>
	
	<@dwz.table_common layoutH="138">
		<thead>
			<tr>
				<th width="150">学号</th>
				<th width="150">姓名</th>
				<th width="150">性别</th>
				<th width="150">年级</th>
				<th width="150">电话</th>
				<th width="150" orderField=room.name class="${(page.orderField=='room.name')?string(page.orderDirection,'')}">宿舍</th>
			</tr>
		</thead>
		<tbody>
			<#list students as item>
				<tr target="slt_uid" rel="${item.id}">
					<td>${item.stuNo}</td>
					<td>${item.name}</td>
					<td>${item.sex!''}</td>
					<td>${item.grade!''}</td>
					<td>${item.phone!''}</td>
					<td>${item.room.name!''}</td>
				</tr>			
			</#list>
		</tbody>
	</@dwz.table_common>
	<!-- 分页 -->
	<@dwz.pagerBar page=page/>
</@dwz.layout_content>
