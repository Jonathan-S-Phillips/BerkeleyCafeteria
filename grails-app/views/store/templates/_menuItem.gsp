<li class="media">
	<div class="media-left">
		<g:img dir="images/food" file="${menuItem.image}" width="64" height="64"/>
	</div>
	<div class="media-body">
		<h4 class="media-heading">
			${menuItem.name}
			<small class="pull-right">
				<g:formatNumber number="${menuItem.price * quantity}" type="currency" currencyCode="USD"/>
			</small>
		</h4>
		<div class="col-md-3"></div>
		<div class="col-md-3"></div>
		<div class="col-md-3">
			<storeTag:menuItemQuantity menuItem="${menuItem}" quantity="${quantity}" displayQuantityField="${displayQuantityField}"/>
		</div>
		<div class="col-md-3">
			<storeTag:addToCartButton menuItem="${menuItem}" displayAddToCartButton="${displayAddToCartButton}" />
			<storeTag:removeFromCartButton menuItem="${menuItem}" displayRemoveFromCartButton="${displayRemoveFromCartButton}" />
		</div>
	</div>
</li>