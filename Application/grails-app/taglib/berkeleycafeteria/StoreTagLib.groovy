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
	 * Renders a list of the given MenuItems. This is used in either the Past Orders or POS pages.
	 */
	def listMenuItems = { attrs, body ->
		String string = ""
		List<CafeteriaOrderMenuItem> comis = attrs.order.cafeteriaOrderMenuItems.sort{ a,b ->
			a.menuItem.store.name <=> b.menuItem.store.name ?: a.menuItem.name <=> b.menuItem.name
		}
		for(CafeteriaOrderMenuItem comi in comis) {
			string += comi.quantity + " x "
			string += comi.menuItem.name + "<br/>"
		}
		out << string
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
	 * Renders the Actions column on either the Past Order or POS page.
	 */
	def orderActionsHeader = { attrs, body ->
		if(attrs.addActionsHeader) {
			out << "<th data-defaultsort='disabled'>Actions</th>"
		}
	}
	
	/**
	 * Renders the Cashier action buttons for a CafeteriaOrder.
	 */
	def orderActions = { attrs, body ->
		if(attrs.addActionButtons) {
			out << g.render(template:"/store/templates/cashierActionButtons", model:[order:attrs.order])
		}
	}
	
	/**
	 * Renders the past CafeteriaOrders for a particular user.
	 */
	def pastOrders = { attrs, body ->
		out << getOrdersString(attrs.orders, attrs.addActionButtons, "student")
	}
	
	/**
	 * Renders all CafeteriaOrders for the cashier.
	 */
	def orders = { attrs, body ->
		out << getOrdersString(attrs.orders, attrs.addActionButtons, "cashier")
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
	
	/**
	 * Renders the student action buttons for a CafeteriaOrder.
	 */
	def studentOrderActions = { attrs, body ->
		if(attrs.addActionButtons) {
			out << g.render(template:"/store/templates/studentActionButtons", model:[order:attrs.order])
		}
	}
	
	/**
	 * Renders the appropriate template for the given list of CafeteriaOrders.
	 * 
	 * @param orders - The CafeteriaOrders to render.
	 * @param addActionButtons - A boolean value indicating whether the action buttons should be rendered.
	 * @param template - The template to use when rendering (cashier or student).
	 * @return The List of CafeteriaOrders in nicely formatted HTML.
	 */
	private String getOrdersString(List<CafeteriaOrder> orders, boolean addActionButtons, String template) {
		String string = ""
		for(CafeteriaOrder order in orders) {
			if(template.equals("cashier")) {
				string += g.render(template:"/store/templates/order", model:[order:order, student:order.user,
					addActionButtons:addActionButtons])
			}
			else {
				string += g.render(template:"/store/templates/pastOrder", model:[order:order, student:order.user,
					addActionButtons:addActionButtons])
			}
		}
		
		// If the string is empty, then add "No Orders to display" text to the view.
		if(string.equals("")) {
			int colspan = 4
			if(addActionButtons) {
				colspan = 5
			}
			string += "<tr><td colspan='" + colspan + "' style='text-align:center'>No Orders to display</td></tr>"
		}
		return string
	}
}
