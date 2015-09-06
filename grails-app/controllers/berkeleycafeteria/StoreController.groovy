package berkeleycafeteria

/**
 * The StoreController which handles the majority of the actions in the application.
 * 
 * @author JPhillips
 * @version 9/6/15
 */
class StoreController {

	def cafeteriaOrderService
	
	/**
	 * Adds a MenuItem to the latest CafeteriaOrder for the current User.
	 */
	def addToCart() {
		User user = User.get(session.userId)
		if(user) {
			MenuItem menuItem = MenuItem.get(params.id)
			cafeteriaOrderService.addMenuItemToOrder(user, menuItem, 1)
			session.cartItems += 1
			flash.success = menuItem.name + " successfully added to your cart"
			redirect(action:"displayCart")
		}
		else {
			flash.error = "Please log in to add an item to your shopping cart."
			redirect(controller:"session", action:"index")
		}
	}
	
	/**
	 * Completes the latest CafeteriaOrder for the current User.
	 */
	def checkout() {
		User user = User.get(session.userId)
		if(user) {
			try {
				cafeteriaOrderService.completeOrder(user, params)
				session.cartItems = 0
				flash.success = "Order complete! It will be ready for pickup on "
				flash.success += params.date + " at " + params.time + ". "
				flash.success += "Thank you for using UC Berkeley Cafteria Online."
				redirect(controller:"session", action:"index")
			}
			catch(Exception e) {
				flash.error = "We are sorry but an error occurred when attempting to complete your order. Please try to complete your order again."
				redirect(action:"displayCart")
			}
		}
		else {
			flash.error = "Please log in to initiate the checkout process."
			redirect(controller:"session", action:"index")
		}
	}
	
	/**
	 * Displays the shopping cart with the latest CafeteriaOrder for the current User. The shopping cart
	 * should only be displayed if the current User is logged in. Otherwise the User should be redirected
	 * to the main index page with a message telling them to log in to view their shopping cart. 
	 */
	def displayCart() {
		User user = User.get(session.userId)
		if(user) {
			CafeteriaOrder order = cafeteriaOrderService.findOrCreateCafeteriaOrder(user)
			return [order:order]
		}
		else {
			flash.error = "Please log in to view your shopping cart."
			redirect(controller:"session", action:"index")
		}
	}
	
	/**
	 * Removes all MenuItems from the latest CafeteriaOrder for the current User.
	 */
	def emptyCart() {
		User user = User.get(session.userId)
		if(user) {
			String result = cafeteriaOrderService.removeAllMenuItems(user)
			// If the result is successful, then the latest CafeteriaOrder had items to remove.
			// Otherwise no order was found or there were no items to remove from the shopping cart.
			if(result.equals("success")) {
				session.cartItems = 0
				flash.success = "All items have been removed from your cart successfully."
			}
			else {
				flash.error = "You either do not have any items in your shopping cart to remove, or no order was found."
			}
			redirect(action: "displayCart")
		}
		else {
			flash.error = "Please log in to view your shopping cart."
			redirect(controller:"session", action:"index")
		}
	}
	
	/**
	 * Displays all past orders for the current User. 
	 */
	def pastOrders() {
		User user = User.get(session.userId)
		if(user) {
			List<CafeteriaOrder> outstanding = CafeteriaOrder.findAllByUserAndIsCompleteAndStatus(user, true, "Waiting Pickup")
			List<CafeteriaOrder> completed = CafeteriaOrder.findAllByUserAndIsCompleteAndStatus(user, true, "Picked Up")
			List<CafeteriaOrder> missed = CafeteriaOrder.findAllByUserAndIsCompleteAndStatus(user, true, "Missed")
			return [outstanding:outstanding, completed:completed, missed:missed]
		}
		else {
			flash.error = "Please log in to view your past orders."
			redirect(controller:"session", action:"index")
		}
	}
	
	/**
	 * Displays the POS system for the cafeteria. The POS system should only be displayed to non-student
	 * Users. If a Student or anyone else tries to access this page, they should be redirected to the
	 * main index page.
	 */
	def pos() {
		User user = User.get(session.userId)
		if(user && !user.isStudent) {
			List<CafeteriaOrder> outstanding = CafeteriaOrder.findAllByIsCompleteAndStatus(true, "Waiting Pickup")
			List<CafeteriaOrder> completed = CafeteriaOrder.findAllByIsCompleteAndStatus(true, "Picked Up")
			List<CafeteriaOrder> missed = CafeteriaOrder.findAllByIsCompleteAndStatus(true, "Missed")
			return [outstanding:outstanding, completed:completed, missed:missed]
		}
		else {
			redirect(controller:"session", action:"index")
		}
	}
	
	/**
	 * Removes the MenuItem with the given ID from the latest CafeteriaOrder.
	 */
	def removeFromCart() {
		User user = User.get(session.userId)
		if(user) {
			MenuItem menuItem = MenuItem.get(params.id)
			cafeteriaOrderService.removeMenuItemFromOrder(user, menuItem)
			session.cartItems -= 1
			flash.success = menuItem.name + " successfully removed from your cart"
			redirect(action:"displayCart")
		}
		else {
			redirect(controller:"session", action:"index")
		}
	}
	
	/**
	 * Adds all of the MenuItems from the given CafeteriaOrder to the User's current order.
	 */
	def reOrder() {
		User user = User.get(session.userId)
		CafeteriaOrder order = CafeteriaOrder.findByUserAndId(user, params.id)
		if(order) {
			order = cafeteriaOrderService.reOrder(user, order)
			session.cartItems = order.countMenuItems()
			flash.success = "Previous Order added to your cart successfully. You may modify your cart, continue shopping, or checkout with the order as it is. "
			redirect(action:"displayCart")
		}
		else {
			flash.error = "An error has occurred. We are sorry for the inconvenience."
		}
	}
	
	/**
	 * Displays the Store with all of its MenuItems.
	 */
	def show() {
		Store store = Store.get(params.id)
		return [store:store]
	}
	
	/**
	 * Updates the status for the given CafeteriaOrder. This is a function for non-students only, so
	 * we need to check that the current User has the right permissions before performing any actions.
	 */
	def updateOrderStatus() {
		User user = User.get(session.userId)
		if(user && !user.isStudent) {
			CafeteriaOrder order = CafeteriaOrder.get(params.id)
			cafeteriaOrderService.updateOrderStatus(order, params.status)
			flash.success = "Order updated successfully"
			redirect(action:"pos")
		}
		else {
			redirect(controller:"session", action:"index")
		}
	}
	
	/**
	 * Updates the quantity of the given MenuItem in the latest CafeteriaOrder for the current User.
	 */
	def updateQuantity() {
		User user = User.get(session.userId)
		if(user) {
			CafeteriaOrder order = CafeteriaOrder.findByUserAndIsComplete(user, false)
			MenuItem menuItem = MenuItem.get(params.menuItemId)
			cafeteriaOrderService.updateMenuItemQuantity(order, menuItem, Integer.parseInt(params.quantity))
			session.cartItems = order.countMenuItems()
			flash.success = menuItem.name + " quantity updated successfully"
			redirect(action:"displayCart")
		}
		else {
			flash.error = "Please log in to update an item's quantity in your shopping cart."
			redirect(controller:"session", action:"index")
		}
		
	}
}
