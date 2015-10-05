<table class="table sortable">
	<thead>
		<tr>
			<th data-defaultsort="asc">Scheduled Pickup Time</th>
			<th>User Name</th>
			<th  data-defaultsort="disabled">Items</th>
			<th>Total</th>
			<orderTag:orderActionsHeader addActionsHeader="${addActions}"/>
		</tr>
	</thead>
	<tbody>
		<posTag:orders orders="${orders}" addActionButtons="${addActions}"/>
	</tbody>
</table>
