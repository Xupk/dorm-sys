<@dwz.layout_content>
	<@dwz.table_common layoutH="138">
			<thead>
				<tr>
					<th orderfield="name">宿舍名称</th>
					<th orderfield="contain">可住人数</th>
					<th orderfield="used">已住人数</th>
					<th orderfield="phone">电话</th>
					<th width="80">选择</th>
				</tr>
			</thead>
			<tbody>
				<#list rooms as room>
					<tr>
						<td>${room.name}</td>
						<td>${room.contain}</td>
						<td>${room.used}</td>
						<td>${room.phone}</td>
						<td>
							<a class="btnSelect" href="javascript:" onclick="$.bringBack({id:'${room.id}', name:'${room.name}'})" title="查找带回" lookupGroup="room" >选择</a>
						</td>
					</tr>
				</#list>
			</tbody>
		</table>
	</@dwz.table_common>
</@dwz.layout_content>