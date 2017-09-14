<script type="text/javascript">
<!--
// top
jQuery(document).ready(function(){
     
    $(".assignManager").click(function(){
    	var userId = $(this).attr("id").split("submit_")[1];
    	var $userRow = $("#managerRow_" + userId);
    
    	jQuery.ajax({
            type: 'POST',
            contentType: 'application/x-www-form-urlencoded;charset=UTF-8',
            url: '${request.contextPath}/management/security/building/create/buildingUser?building.id=${buildingId}&user.id=' + userId,
            error: function() { 
            	 alertMsg.error('分配管理员失败！');
            },
            success: function() { 
            	// 删除已分配
				var $remove = $userRow.remove();
	        	var managerName = $remove.find("td").eq(0).text();
	        	var phone = $remove.find("td").eq(1).text();
		    	// 添加分配
				$("#hasManagers").append("<tr><td>" + managerName + "</td><td>" + phone + "</td></tr>");
				$('tr[class="selected"]', getCurrentNavtabRel()).find("td").eq(8).find("div").append(managerName + "  ");
    		}		
        });	
    });
    
});
//-->
</script>
<@dwz.layout_content>
	<@dwz.fieldset  title="已分配管理员">
		<@dwz.table_common layoutH="138">
			<@dwz.table_css>
				<thead>
					<tr>
						<th width="40%">管理员</th>
						<th width="60%">联系方式</th>
					</tr>
				</thead>
				<tbody id="hasManagers">
					<#list buildingUsers as item>
					<tr>
						<td>${item.user.realname}</td>
						<td>${item.user.phone}</td>
					</tr>
					</#list>
				</tbody>
			</@dwz.table_css>
		</@dwz.table_common>
	</@dwz.fieldset>
	<@dwz.fieldset  title="可分配管理员">
		<@dwz.table_common layoutH="100" cellspacing="30">
			<@dwz.table_css>
				<thead>
					<tr>
						<th width="30%">管理员</th>
						<th width="40%">联系方式</th>
						<th width="30%">操作</th>
					</tr>
				</thead>
				<tbody>
					<#list users as item>
					<tr id="managerRow_${item.id}">
						<td>${item.realname}</td>
						<td>${item.phone}</td>
						<td>
							<@dwz.button title="分配" id="submit_${item.id}" class="assignManager"/>
						</td>
					</tr>
					</#list>
				</tbody>
			</@dwz.table_css>
		</@dwz.table_common>
	</@dwz.fieldset>
</@dwz.layout_content>
