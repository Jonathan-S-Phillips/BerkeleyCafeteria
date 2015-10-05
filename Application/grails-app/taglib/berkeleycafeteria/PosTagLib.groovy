package berkeleycafeteria

class PosTagLib {
	/* The namespace to use when writing tags in GSP pages. */
	static namespace = "posTag"
	
	/**
	 * Renders all CafeteriaOrders for the cashier.
	 */
	def orders = { attrs, body ->
		out << orderTag.getOrdersString(orders:attrs.orders, addActionButtons:attrs.addActionButtons, template:"/pos/templates/order")
	}
	
	/**
	 * Renders the Cashier action buttons for a CafeteriaOrder.
	 */
	def orderActions = { attrs, body ->
		out << orderTag.orderActions(order:attrs.order, addActionButtons:attrs.addActionButtons, template:"/pos/templates/cashierActionButtons")
	}
}
