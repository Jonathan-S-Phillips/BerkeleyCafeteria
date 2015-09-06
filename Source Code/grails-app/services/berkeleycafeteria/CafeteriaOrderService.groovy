package berkeleycafeteria

import java.text.SimpleDateFormat

/**
 * The CafeteriaOrderService class handles all actions related to a CafeteriaOrder.
 * 
 * @author JPhillips
 * @version 9/6/15
 */
class CafeteriaOrderService {

	/**
	 * Adds the given MenuItem to the latest CafeteriaOrder for the given User. If the given User does not
	 * have a CafeteriaOrder that is not complete, then a new one will automatically be created.
	 * 
	 * @param user - The User that is adding the given MenuItem to their shopping cart.
	 * @param menuItem - The MenuItem to add to the User's shopping cart.
	 */
	public void addMenuItemToOrder(User user, MenuItem menuItem, int quantity) {
		CafeteriaOrder order = CafeteriaOrder.findByUserAndIsComplete(user, false)
		if(order == null) {
			order = findOrCreateCafeteriaOrder(user)
		}
		menuItem.addToCafeteriaOrder(order, quantity)
		order.save(flush:true)
	}
	
	/**
	 * Completes the given CafeteriaOrder. A completed CafeteriaOrder will have a pickup time (set by the user),
	 * the date the order was completed, the isComplete field will be true, and it will have a status of "Waiting Pickup".
	 * Once a CafeteriaOrder is complete it cannot be modified by the User.
	 * 
	 * @param user - The User that is completing their current CafeteriaOrder.
	 * @param params - The parameters returned from the front end form containing the pickup date and time values.
	 */
	public void completeOrder(User user, params) {
		CafeteriaOrder order = CafeteriaOrder.findByUserAndIsComplete(user, false)
		// Parse the date and time values returned from the front end. Since these are 2 separate fields they need to
		// be combined before the full date can be parsed.
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy h:mm a")
		String timeString = params.date + " " + params.time
		
		// Update the necessary fields in the CafeteriaOrder to mark it as complete.
		Date pickupTime = format.parse(timeString)
		order.pickupTime = pickupTime
		order.orderDate = new Date()
		order.isComplete = true
		order.status = "Waiting Pickup"
		order.save(flush:true)
	}
	
	/**
	 * Finds or creates a new CafeteriaOrder for the given User.
	 * 
	 * @param user - The User to tie to the CafeteriaOrder.
	 * @return The CafeteriaOrder that was just created.
	 */
    public CafeteriaOrder findOrCreateCafeteriaOrder(User user) {
		CafeteriaOrder order = CafeteriaOrder.findByUserAndIsComplete(user, false)
		
		// If a CafeteriaOrdre is not found, then create one and tie it to the given User.
		if(!order) {
			order = new CafeteriaOrder()
			order.user = user
			if(order.save(flush:true)) {
				user.addToOrders(order)
				user.save(flush:true)
			}
		}
		return order
	}
	
	/**
	 * Removes all MenuItems from the latest CafeteriaOrder for the given User. The simplest solution
	 * is to just delete the latest CafeteriaOrder to accomplish this. If the CafeteriaOrder is deleted,
	 * then a string value of "success" is returned. This String is used to render an appropriate error
	 * message to the User on the front end.
	 * 
	 * @param user - The User that is removing all MenuItems from their latest CafeteriaOrder.
	 * @return The 
	 */
	public String removeAllMenuItems(User user) {
		CafeteriaOrder order = CafeteriaOrder.findByUserAndIsComplete(user, false)
		
		// Only delete the CafeteriaOrder if one is found and it has MenuItems.
		if(order && order.countMenuItems() > 0) {
			order.delete()
			return "success"
		}
		return "failure"
	}
	
	/**
	 * Removes a MenuItem from the latest CafeteriaOrder for the given User.
	 * 
	 * @param user - The User that is removing the given MenuItem from their shopping cart.
	 * @param menuItem - The MenuItem to remove from the User's shopping cart.
	 */
	public void removeMenuItemFromOrder(User user, MenuItem menuItem) {
		CafeteriaOrder order = CafeteriaOrder.findByUserAndIsComplete(user, false)
		menuItem.removeFromCafeteriaOrder(order)
		order.save(flush:true)
	}
	
	/**
	 * Adds all of the MenuItems from the given CafeteriaOrder to the User's current order.
	 * 
	 * @param user - The User that is re-ordering a past CafeteriaOrder.
	 * @param pastOrder - The past CafeteriaOrder to use.
	 */
	public CafeteriaOrder reOrder(User user, CafeteriaOrder pastOrder) {
		CafeteriaOrder order = findOrCreateCafeteriaOrder(user)
		for(CafeteriaOrderMenuItem comi in pastOrder.cafeteriaOrderMenuItems) {
			addMenuItemToOrder(user, comi.menuItem, comi.quantity)
		}
		return order
	}
	
	/**
	 * Updates the quantity for the given MenuItem in the given CafeteriaOrder.
	 * 
	 * @param order - The CafeteriaOrder containing the MenuItem whose quantity should be updated.
	 * @param menuItem - The MenuItem whose quantity should be updated.
	 * @param quantity - The new quantity for the MenuItem in the CafeteriaOrder.
	 */
	public void updateMenuItemQuantity(CafeteriaOrder order, MenuItem menuItem, int quantity) {
		CafeteriaOrderMenuItem comi = CafeteriaOrderMenuItem.findByCafeteriaOrderAndMenuItem(order, menuItem)
		comi.quantity = quantity
		order.save(flush:true)
	}
	
	/**
	 * Updates the status of the CafeteriaOrder.
	 * 
	 * @param order - The CafeteriaOrder to be updated.
	 * @param status - The status to set the CafeteriaOrder to.
	 */
	public void updateOrderStatus(CafeteriaOrder order, String status) {
		order.status = status
		order.save(flush:true)
	}
}
