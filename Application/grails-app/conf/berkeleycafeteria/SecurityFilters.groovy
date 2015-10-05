package berkeleycafeteria

class SecurityFilters {

    def filters = {
		// Filter every action except the show action in the StoreController.
        store(controller:'store', action:'addToCart|checkout|displayCart|emptyCart|pastOrders|removeFromCart|reOrder|updateQuantity') {
            before = {
				User user = User.get(session.userId)
				if(!user) {
					flash.error = "Please login before performing that action."
					redirect(controller:"session", action: 'login')
					return false
				}
            }
        }
		
		// Filter every action in the PosController.
		pos(controller:"pos", action:"*") {
			before = {
				User user = User.get(session.userId)
				// If there is no current User or the User is a student redirect them
				// to the main index page of the application.
				if(!user || user.isStudent) {
					redirect(controller:"session", action:"index")
					return false
				}
			}
		}
    }
}
