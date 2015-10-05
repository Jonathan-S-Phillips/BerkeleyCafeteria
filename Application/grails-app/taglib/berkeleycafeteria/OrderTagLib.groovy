package berkeleycafeteria

class OrderTagLib {
    
	/* The namespace to use when writing tags in GSP pages. */
	static namespace = "orderTag"
	
	/**
	 * Renders the appropriate template for the given list of CafeteriaOrders.
	 *
	 * @param orders - The CafeteriaOrders to render.
	 * @param addActionButtons - A boolean value indicating whether the action buttons should be rendered.
	 * @param template - The template to use when rendering (cashier or student).
	 * @return The List of CafeteriaOrders in nicely formatted HTML.
	 */
	def getOrdersString = { attrs, body ->
		String string = ""
		List<CafeteriaOrder> orders = attrs.orders
		boolean addActionButtons = attrs.addActionButtons
		String template = attrs.template
		for(CafeteriaOrder order in orders) {
			string += g.render(template:template, model:[order:order, student:order.user,
					addActionButtons:addActionButtons])
		}
		
		// If the string is empty, then add "No Orders to display" text to the view.
		if(string.equals("")) {
			int colspan = 4
			if(addActionButtons) {
				colspan = 5
			}
			string += "<tr><td colspan='" + colspan + "' style='text-align:center'>No Orders to display</td></tr>"
		}
		out << string
	}
	
	/**
	 * Renders a list of the given MenuItems. This is used in either the Past Orders or POS pages.
	 */
	def listMenuItems = { attrs, body ->
		String string = ""
		try {
			List<CafeteriaOrderMenuItem> comis = attrs.order.cafeteriaOrderMenuItems.sort{ a,b ->
				a.menuItem.store.name <=> b.menuItem.store.name ?: a.menuItem.name <=> b.menuItem.name
			}
			for(CafeteriaOrderMenuItem comi in comis) {
				string += comi.quantity + " x "
				string += comi.menuItem.name + "<br/>"
			}
		}
		catch(NullPointerException e) {
			string = "Error reading items in order"
		}
		out << string
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
	 * Renders the action buttons for an order on either the Past Order or POS page.
	 */
	def orderActions = { attrs, body ->
		if(attrs.addActionButtons) {
			out << g.render(template:attrs.template, model:[order:attrs.order])
		}
	}
}
