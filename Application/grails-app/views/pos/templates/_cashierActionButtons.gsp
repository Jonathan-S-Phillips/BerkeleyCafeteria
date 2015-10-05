<td>
	<g:link controller="pos" action="updateOrderStatus" id="${order.id}" params="[status:'Picked Up']"
		class="btn btn-default" >
		Picked Up
	</g:link>
	<g:link controller="pos" action="updateOrderStatus" id="${order.id}" params="[status:'Missed']"
		class="btn btn-default" >
		Missed
	</g:link>
</td>