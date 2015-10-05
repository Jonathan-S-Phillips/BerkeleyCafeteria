package berkeleycafeteria

import java.util.List;

/**
 * The ApplicationTagLib class defines custom tags useful for the entire application.
 * @author Jonathan
 *
 */
class ApplicationTagLib {
	
	/* The namespace to use when writing tags in GSP pages. */
    static namespace = "applicationTag"
	
	/**
	 * Renders an error message to the User.
	 */
	def error = { attrs, body ->
		if(attrs.error) {
			out << "<div id='error' class='alert alert-danger' role='alert'>" + attrs.error + "</div>"
		}
	}
	
	/**
	 * Renders a success message to the User.
	 */
	def success = { attrs, body ->
		if(attrs.success) {
			out << "<div id='success' class='alert alert-success' role='alert'>" + attrs.success + "</div>"
		}
	}
}
