<div class="panel-heading">
	<div class="pull-left">
		<h4>
			${order.countMenuItems()} Item(s) in your shopping cart: 
			<g:formatNumber number="${order.price()}" type="currency" currencyCode="USD"/>
		</h4>
	</div>
	<div class="pull-right">
		<g:link controller="store" action="emptyCart" class="btn btn-default pull-right" 
			role="button">
			Empty My Cart
		</g:link>
	</div>
	<div class="clearfix"></div>
</div>
<div class="panel-body">
	<ul class="media-list">
		<storeTag:menuItems menuItems="${order.menuItems()}" order="${order}" displayQuantityField="${displayQuantityField}"/>
	</ul>
</div>
<div class="panel-footer">
	<div class="pull-right">
		Grand Total:
		<g:formatNumber number="${order.price()}" type="currency" currencyCode="USD"/>
	</div>
	<div class="clearfix"></div>
</div>