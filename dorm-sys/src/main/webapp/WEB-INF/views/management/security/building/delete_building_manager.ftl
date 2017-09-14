<script type="text/javascript">
<!--
// top
jQuery(document).ready(function(){
     
    $(".deleteManager").click(function(){
    	var buildingUserId = $(this).attr("id").split("submit_")[1];
    	jQuery.ajax({
            type: 'POST',
            contentType: 'application/x-www-form-urlencoded;charset=UTF-8',
            url: '${request.contextPath}/management/security/building/delete/buildingManager/' + buildingUserId,
            error: function() { 
    	 		alertMsg.error('删除角色关联失败！');
    		},
    		success: function() { 
    	    	// 删除已分配
    	    	var $remove = $("#managerRow_" + buildingUserId).remove();
	        	var managerName = $remove.find("td").eq(0).text()
		    	// 添加分配
				var	$div = $('tr[class="selected"]', getCurrentNavtabRel()).find("td").eq(8).find("div");
				var text = $div.text();
				$div.text(text.replace(managerName, ""));
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
						<th width="30%">管理员</th>
						<th width="40%">联系方式</th>
						<th width="30%">操作</th>
					</tr>
				</thead>
				<tbody id="hasManagers">
					<#list buildingUsers as item>
					<tr id="managerRow_${item.id}">
						<td>${item.user.realname}</td>
						<td>${item.user.phone}</td>
						<td>
							<@dwz.button title="撤销管理员" id="submit_${item.id}" class="deleteManager"/>
						</td>
					</tr>
					</#list>
				</tbody>
			</@dwz.table_css>
		</@dwz.table_common>
	</@dwz.fieldset>
</@dwz.layout_content>
