<tr>
	<td data-dateformat="MM/DD/YYYY h:mm a">
		<g:formatDate format="MM/dd/yyyy h:mm a" date="${order.pickupTime}"/>
	</td>
	<td>
		<storeTag:listMenuItems order="${order}"/>
	</td>
	<td>
		<g:formatNumber number="${order.price()}" type="currency" currencyCode="USD"/>
	</td>
	<storeTag:studentOrderActions addActionButtons="${addActionButtons}" order="${order}"/>
</tr>