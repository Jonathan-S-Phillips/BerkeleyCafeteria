package berkeleycafeteria

/**
 * The UserTagLib class defines custom tags that are useful for rendering User actions.
 * 
 * @author JPhillips
 * @version 9/6/15
 */
class UserTagLib {
	/* The namespace to use when writing tags in GSP pages. */
    static namespace = "userTag"
	
	/**
	 * Renders either the button to log in to the application or the user menu if there
	 * is a User already logged in. 
	 */
	def login = { attrs, body ->
		String string = ""
		User user = User.get(session.userId)
		if(user != null) {
			if(!user.isStudent) {
				string += g.render(template:"/session/templates/cashierMenu", model:[user:user])
			}
			string += g.render(template:"/session/templates/userMenu", model:[user:user])
		}
		else {
			string = g.link(uri:"/login"){"Log In"}
		}
		out << string
	}
}
