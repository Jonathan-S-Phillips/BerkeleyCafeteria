package berkeleycafeteria

/**
 * The Store class defines a store in the Cafeteria. A Store can have as many MenuItems
 * tied to it, which can in turn be added to a CafeteriaOrder.
 * 
 * @author JPhillips
 * @version 9/6/15
 */
class Store {

	//---Relational Definitions---------------------------------------------------
	
	static hasMany = [menuItems:MenuItem]
	
	//---Field Definitions--------------------------------------------------------
	
	/* The name of the store. */
	String name
	
	/* Any constraints when saving the database object are defined below. */
    static constraints = {
    }
	
	/* And mapping actions to be performed in the database when this object is updated. */
	static mapping = {
		menuItems cascade: "all-delete-orphan", sort:"name"
	}
	
	//---Public Static Methods----------------------------------------------------
	
	/**
	 * Finds or creates a Store with the given name.
	 *
	 * @param name - The name of the Store to find or create.
	 * @return The Store that was found or created.
	 */
	public static Store findOrCreateStore(String name) {
		Store store = Store.findByName(name)
		
		// If no Store is found, then create one with the given name.
		if(!store) {
			store = new Store(name:name)
			store.save(flush:true)
		}
		return store
	}
}
