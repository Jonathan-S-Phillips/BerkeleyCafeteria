<tr>
	<td data-dateformat="MM/DD/YYYY h:mm a">
		<g:formatDate format="MM/dd/yyyy h:mm a" date="${order.pickupTime}"/>
	</td>
	<td>${student.name}</td>
	<td>
		<applicationTag:listMenuItems order="${order}"/>
	</td>
	<td>
		<g:formatNumber number="${order.price()}" type="currency" currencyCode="USD"/>
	</td>
	<posTag:orderActions addActionButtons="${addActionButtons}" order="${order}"/>
</tr>