package berkeleycafeteria

import java.text.SimpleDateFormat

/**
 * The CafeteriaOrder class defines an order created by a User of the system. A CafeteriaOrder can have
 * as many MenuItems tied to it as the User wants.
 * 
 * @author JPhillips
 * @version 9/6/15
 */
class CafeteriaOrder {
	/* The list of statuses available for a CafeteriaOrder. */
	private static List<String> statuses = ["Incomplete", "Waiting Pickup", "Picked Up", "Missed"]
	
	//---Relational Definitions---------------------------------------------------
	
	static belongsTo = [user:User]
	static hasMany = [cafeteriaOrderMenuItems:CafeteriaOrderMenuItem]
	
	//---Field Definitions--------------------------------------------------------
	
	/* Boolean value to indicate whether the User has completed their order. */
	boolean isComplete = false
	/* The date and time the order was completed. */
	Date orderDate
	/* The date and time the User selected to pick up their order. */
	Date pickupTime
	/* The status of the order. */
	String status = "Incomplete"
	
	/* Any constraints when saving the database object are defined below. */
    static constraints = {
		orderDate(nullable:true)
		pickupTime(nullable:true)
		status(inList:statuses)
    }
	
	//---Static Methods-----------------------------------------------------------
	
	/**
	 * Finds or creates a new CafeteriaOrder for the given User.
	 *
	 * @param user - The User to tie to the CafeteriaOrder.
	 * @return The CafeteriaOrder that was just created.
	 */
	public static CafeteriaOrder findOrCreateCafeteriaOrder(User user) {
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
	
	//---Public Methods-----------------------------------------------------------
	
	/**
	 * Returns the number of MenuItems in this CafeteriaOrder. We need to take into account the quantities
	 * of each MenuItem when determining the total number of MenuItems in this CafeteriaOrder.
	 * 
	 * @return The number of MenuItems in this CafeteriaOrder.
	 */
	public int countMenuItems() {
		int count = 0
		for(CafeteriaOrderMenuItem comi in this.cafeteriaOrderMenuItems) {
			count += comi.quantity
		}
		return count
	}
	
	/**
	 * Returns the price for this CafeteriaOrder based on the price of each MenuItem
	 * in this CafeteriaOrder.
	 *  
	 * @return The total price of this CafeteriaOrder.
	 */
	public double price() {
		double price = 0.0
		for(CafeteriaOrderMenuItem comi in this.cafeteriaOrderMenuItems) {
			price += comi.menuItem.price * comi.quantity
		}
		return price
	}
	
	/**
	 * Returns a List of MenuItems in this CafeteriaOrder. The MenuItems are first sorted by store
	 * name, and then by MenuItem name.
	 * 
	 * @return A List of MenuItems in this CafeteriaOrder.
	 */
	public List<MenuItem> menuItems() {
		return this.cafeteriaOrderMenuItems?.sort{ a,b ->
			a.menuItem.store.name <=> b.menuItem.store.name ?: a.menuItem.name <=> b.menuItem.name
		}.collect{it.menuItem}
	}
	
	/**
	 * Completes this CafeteriaOrder by setting the necessary fields and updating its status.
	 * 
	 * @param dateTimeString The date and time to set for the pickupTime.
	 */
	public void setOrderComplete(String dateTimeString) {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy h:mm a")
		Date pickupTime = format.parse(dateTimeString)
		this.pickupTime = pickupTime
		this.orderDate = new Date()
		this.isComplete = true
		
		// Update the status of this CafeteriaOrder and save the changes.
		this.updateOrderStatus("Waiting Pickup")
	}
	
	/**
	 * Updates the status of this CafeteriaOrder.
	 *
	 * @param status - The status to set the CafeteriaOrder to.
	 */
	public void updateOrderStatus(String status) {
		this.status = status
		this.save(flush:true)
	}
}
