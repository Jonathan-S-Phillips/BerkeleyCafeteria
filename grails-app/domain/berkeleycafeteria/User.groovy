package berkeleycafeteria

/**
 * The User class defines a User in the application. A User of the system is either a 
 * Student or a Cashier. The Cashier has access to the POS system.
 * 
 * @author JPhillips
 * @version 9/6/15
 */
class User {

	//---Relational Definitions---------------------------------------------------
	
	static hasMany = [orders:CafeteriaOrder]
	
	//---Field Definitions--------------------------------------------------------
	
	/* The name of that the User uses to log in to the application. */
	String name
	/* The password for the User to log into the application. */
	String password
	/* Boolean value indicating whether the User is a student. */
	boolean isStudent
	
	/* Any constraints when saving the database object are defined below. */
    static constraints = {
    }
}