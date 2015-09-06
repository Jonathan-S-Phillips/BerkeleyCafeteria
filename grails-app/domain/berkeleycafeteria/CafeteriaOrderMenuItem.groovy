package berkeleycafeteria

/**
 * The CafeteriaOrderMenuItem class is a binding table between CafeteriaOrders and MenuItems. This class
 * allows as many MenuItems to be added to a CafeteriaOrder as the User wants.
 * 
 * @author JPhillips
 * @version 9/6/15
 */
class CafeteriaOrderMenuItem {

	//---Relational Definitions---------------------------------------------------
	
	static belongsTo = [cafeteriaOrder:CafeteriaOrder, menuItem:MenuItem]
	
	//---Field Definitions--------------------------------------------------------
	
	/* The number of the particular MenuItems to add to the CafeteriaOrder. */
	int quantity = 1
	
	/* Any constraints when saving the database object are defined below. */
    static constraints = {
    }
	
	//---Static Methods-----------------------------------------------------------
	
	/**
	 * Creates a link between the given CafeteriaOrder and MenuItem. If a link already exists, then a new
	 * does not need to be created, we just updated the quantity by 1.
	 * 
	 * @param order - The CafeteriaOrder to tie to the given MenuItem.
	 * @param menuItem - The MenuItem to tie to the given CafeteriaOrder.
	 * @param quantity - The number of the given MenuItem that should be added to the CafeteriaOrder.
	 * @return The CafeteriaMenuItem object that was created or updated.
	 */
	public static CafeteriaOrderMenuItem link(CafeteriaOrder order, MenuItem menuItem, int quantity) {
		CafeteriaOrderMenuItem comi = CafeteriaOrderMenuItem.findByCafeteriaOrderAndMenuItem(order, menuItem)
		if(!comi) {
			comi = new CafeteriaOrderMenuItem(order:order, menuItem:menuItem, quantity:quantity)
			order?.addToCafeteriaOrderMenuItems(comi)
			menuItem?.addToCafeteriaOrderMenuItems(comi)
			comi.save(flush:true)
		}
		else {
			comi.quantity += 1
			comi.save(flush:true)
		}
		return comi
	}
	
	/**
	 * Removes a link between the given CafeteriaOrder and MenuItem.
	 * 
	 * @param order - The CaferiaOrder to remove the MenuItem from.
	 * @param menuItem - The MenuItem to remove from the CafeteriaOrder.
	 */
	public static void unlink(CafeteriaOrder order, MenuItem menuItem) {
		CafeteriaOrderMenuItem comi = CafeteriaOrderMenuItem.findByCafeteriaOrderAndMenuItem(order, menuItem)
		order?.removeFromCafeteriaOrderMenuItems(comi)
		menuItem?.removeFromCafeteriaOrderMenuItems(comi)
		comi.delete()
	}
}
