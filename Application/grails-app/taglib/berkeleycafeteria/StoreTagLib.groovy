package berkeleycafeteria

/**
 * The StoreTagLib class defines custom tags that are useful for rendering store related
 * actions.
 * 
 * @author JPhillips
 * @version 9/6/15
 */
class StoreTagLib {
	/* The namespace to use when writing tags in GSP pages. */
    static namespace = "storeTag"
	
	/**
	 * Renders the "Add to Cart" button.
	 */
	def addToCartButton = { attrs, body ->
		if(attrs.displayAddToCartButton) {
			out << g.render(template:"/store/templates/addToCartButton", model:[menuItem:attrs.menuItem])
		}
	}
	
	/**
	 * Renders all of the MenuItems given MenuItems in a list.
	 */
	def menuItems = { attrs, body ->
		String string = ""
		for(MenuItem menuItem in attrs.menuItems) {
			int quantity = 1
			boolean displayAddToCartButton = false
			boolean displayRemoveFromCartButton = false
			
			// Certain buttons should only appear in the list of MenuItems depending on when this method is
			// called. If this is used to render the list of MenuItems in the shopping cart, then the quantity
			// and "Remove from Cart" button should be displayed. If this is used to render the list of MenuItems
			// in a Store, then the "Add to Cart" button should be displayed (as long as there is a current user
			// logged in to the application.
			if(attrs.order) {
				CafeteriaOrderMenuItem comi = CafeteriaOrderMenuItem.findByCafeteriaOrderAndMenuItem(attrs.order, menuItem)
				quantity = comi.quantity
				displayAddToCartButton = false
				displayRemoveFromCartButton = true
			}
			else if(session.userId) {
				displayAddToCartButton = true
			}
			string += g.render(template:"/store/templates/menuItem", model:[menuItem:menuItem, quantity:quantity, 
				displayQuantityField:attrs.displayQuantityField, displayAddToCartButton:displayAddToCartButton,
				displayRemoveFromCartButton:displayRemoveFromCartButton])
		}
		out << string
	}
	
	/**
	 * Renders the quantity field for a MenuItem. This should only be rendered in the shopping cart.
	 */
	def menuItemQuantity = { attrs, body ->
		if(attrs.displayQuantityField) {
			out << g.render(template:"/store/templates/quantityField", model:[menuItem:attrs.menuItem, quantity:attrs.quantity])
		}
	}
	
	/**
	 * Renders the student action buttons for a CafeteriaOrder.
	 */
	def orderActions = { attrs, body ->
		out << orderTag.orderActions(order:attrs.order, addActionButtons:attrs.addActionButtons, template:"/store/templates/studentActionButtons")
	}
	
	/**
	 * Renders the past CafeteriaOrders for a particular user.
	 */
	def pastOrders = { attrs, body ->
		out << orderTag.getOrdersString(orders:attrs.orders, addActionButtons:attrs.addActionButtons, template:"/store/templates/pastOrder")
	}
	
	/**
	 * Renders the "Remove from Cart" button.
	 */
	def removeFromCartButton = { attrs, body ->
		if(attrs.displayRemoveFromCartButton) {
			out << g.render(template:"/store/templates/removeFromCartButton", model:[menuItem:attrs.menuItem])
		}
	}
	
	/**
	 * Renders the links to each store in the database.
	 */
	def stores = { attrs, body ->
		String string = "<ul class='nav navbar-nav'>"
		List<Store> stores = Store.findAll()
		for(Store store in stores) {
			if(attrs.active.equals(store.id.toString())) {
				string += "<li class='active'>"
			}
			else {
				string += "<li>"
			}
			string += g.link(controller:"store", action:"show", id:store.id){store.name} 
			string += "</li>"
		}
		string += "</ul>"
		out << string
	}
}
