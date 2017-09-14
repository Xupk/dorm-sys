<@dwz.pagerForm action="${request.contextPath}/management/security/violation/list" page=page>
	<input type="hidden" name="keywords" value="${keywords!''}"/>
</@dwz.pagerForm>

<@dwz.search_form action="${request.contextPath}/management/security/violation/list">
	<@dwz.label_input2 content="宿舍号：">
		<input type="text" name="keywords" value="${keywords!''}"/>
	</@dwz.label_input2>
</@dwz.search_form>

<@dwz.layout_content>
	<@dwz.tool_bar>
		<@shiro.hasPermission name="Violation:save">
			<@dwz.tool_button content="添加记录" class="application_add" width="530" height="330" href="${request.contextPath}/management/security/violation/create"/>
		</@shiro.hasPermission>
		<@shiro.hasPermission name="Violation:edit">
			<@dwz.tool_button content="修改记录" class="application_edit" width="530" height="330" href="${request.contextPath}/management/security/violation/update/{slt_uid}"/>
		</@shiro.hasPermission>
		<@shiro.hasPermission name="Violation:delete">
			<@dwz.tool_button content="删除记录" class="application_delete" target="ajaxTodo" href="${request.contextPath}/management/security/violation/delete/{slt_uid}" title="确认要删除该记录?"/>
		</@shiro.hasPermission>
		<@shiro.hasPermission name="Violation:reset">
			<@dwz.tool_line/>
			<@dwz.tool_button content="更新状态" class="user_go" target="ajaxTodo" href="${request.contextPath}/management/security/violation/reset/status/{slt_uid}" title="确认更新状态?"/>
			<@dwz.tool_line/>
		</@shiro.hasPermission>
	</@dwz.tool_bar>
	
	<@dwz.table_common layoutH="138">
		<thead>
			<tr>
				<th width="100">宿舍号</th>
				<th width="100">违规信息</th>
				<th width="100">违规学生</th>
				<th width="100" orderField="date" class="date">时间</th>
				<th width="100" orderField="status" class="${(page.orderField=='status')?string(page.orderDirection,'')}">状态</th>
				<th width="100">记录人</th>
			</tr>
		</thead>
		<tbody>
			<#list violations as item>
			<tr target="slt_uid" rel="${item.id}">
				<td>${item.roomName!''}</td>
				<td>${item.message!''}</td>
				<td>${item.student!''}</td>
				<td>${item.date!''}</td>
				<td>${(item.status == "enabled")?string("未处理","已处理")}</td>
				<td>${item.manager!''}</td>
			</tr>			
			</#list>
		</tbody>
	</@dwz.table_common>
	<!-- 分页 -->
	<@dwz.pagerBar page=page/>
</@dwz.layout_content>
