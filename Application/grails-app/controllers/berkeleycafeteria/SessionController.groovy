package berkeleycafeteria

/**
 * The SessionController handles actions related to the User's session, including logging in and logging out.
 * 
 * @author JPhillips
 * @version 9/6/15
 */
class SessionController {

	/**
	 * Displays the main index page, which is just the first Store's page.
	 */
    def index() { 
		Store store = Store.get(1)
		return [store:store]
	}
	
	/**
	 * Displays the login form.
	 */
	def login() {}
	
	/**
	 * Clears the session, logs the User out, and redirects them to the home page.
	 */
	def logout() {
		session.invalidate()
		redirect(action:"index")
	}
	
	/**
	 * Processes the login request using the username and password entered on the
	 * login form. If successful, then the user is redirected to the main index
	 * page, otherwise the user is redirected back to the login page.
	 */
	def processLogin() {
		User user = User.findByNameAndPassword(params.userName, params.password)
		if(user != null) {
			// Set the various session values that are required.
			session.userId = user.id
			session.name = user.name
			
			// Count the number of MenuItems in the latest CafeteriaOrder and keep that in
			// the session for ease of access in the top menu bar.
			CafeteriaOrder order = CafeteriaOrder.findByUserAndIsComplete(user, false)
			if(order) {
				session.cartItems = order.countMenuItems()
			}
			else {
				session.cartItems = 0
			}
			
			// If the current User is not a Student, then they should be redirected to the
			// the POS system. Otherwise they should be redirected to the main index page.
			if(!user.isStudent) {
				redirect(controller:"pos", action:"index")
			}
			else {	
				redirect(action:"index")
			}
		}
		else {
			flash.error = "Username or password is incorrect. Please try again."
			redirect(action:"login")
		}
	}
}
