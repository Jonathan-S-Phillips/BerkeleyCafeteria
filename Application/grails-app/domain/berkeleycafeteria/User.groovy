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
	
	/* The name that the User uses to log in to the application. */
	String name
	/* The password for the User to log into the application. */
	String password
	/* Boolean value indicating whether the User is a student. */
	boolean isStudent
	
	/* Any constraints when saving the database object are defined below. */
    static constraints = {
    }
	
	/**
	 * Creates a User if they do not already exist. This assumes that User's names are
	 * unique, which is technically not a constraint right now.
	 *
	 * @param name The name of the User.
	 * @param password The User's password.
	 * @param isStudent Boolean value indicating whether the user is a Student.
	 */
	public static void createUser(String name, String password, boolean isStudent) {
		User user = User.findByName(name)
		
		// Create the User if one is not found by the given name.
		if(!user) {
			user = new User(name:name, password:password, isStudent:isStudent)
			user.save(flush:true)
		}
	}
}
