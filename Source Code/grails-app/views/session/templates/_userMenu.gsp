<li>
	<g:link controller="store" action="displayCart">
		Shopping Cart 
		<span class="badge">${session.cartItems}</span>
	</g:link>
</li>
<li id="userMenu" class="dropdown">
	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
		Welcome ${user.name}<span class="caret white"></span>
	</a>
	<ul class="dropdown-menu blue" role="menu">
		<li>
			<g:link controller="store" action="pastOrders">
				Past Orders 
			</g:link>
		</li>
		<li><g:link controller="session" action="logout">Logout</g:link></li>
	</ul>
</li>