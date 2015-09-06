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
}
