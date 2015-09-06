import berkeleycafeteria.MenuItem
import berkeleycafeteria.Store
import berkeleycafeteria.User

class BootStrap {

	def storeService
	
    def init = { servletContext ->
		// Check for and add Arun to the database if he does not already exist.
		User user = User.findByName("Arun")
		if(!user) {
			user = new User(name:"Arun", password:"berkeley1234", isStudent:true)
			user.save(flush:true)
		}
		
		// Check for and add the Cashier to the database if they do not already exist.
		user = User.findByName("Cashier")
		if(!user) {
			user = new User(name:"Cashier", password:"money1234", isStudent:false)
			user.save(flush:true)
		}
		
		// Check for and add the American Store to the database as well as its MenuItems if they do 
		// not already exist.
		Store store = storeService.findOrCreateStore("American")
		storeService.createMenuItem(store, "Hamburger and Fries", "Hamburger.jpg", 7.5)
		storeService.createMenuItem(store, "Cheeseburger and Fries", "Cheeseburger.jpg", 7.75)
		storeService.createMenuItem(store, "Chicken Fingers and Fries", "ChickenFingers.jpg", 6)
		storeService.createMenuItem(store, "Grilled Cheese and Fries", "GrilledCheese.jpg", 5.5)
		
		store = storeService.findOrCreateStore("Pizza")
		storeService.createMenuItem(store, "Plain Pizza", "Plain.jpg", 7.5)
		storeService.createMenuItem(store, "Pepperoni Pizza", "Pepperoni.jpg", 8.0)
		storeService.createMenuItem(store, "Margarita Pizza", "Margarita.jpg", 7.75)
		storeService.createMenuItem(store, "Meat Lovers Pizza", "MeatLovers.jpg", 8.5)
		
		store = storeService.findOrCreateStore("Chinese")
		storeService.createMenuItem(store, "Beef and Broccoli", "BeefBroccoli.jpg", 8.0)
		storeService.createMenuItem(store, "Chicken Fried Rice", "FriedRice.jpg", 6.0)
		storeService.createMenuItem(store, "Orange Chicken", "OrangeChicken.jpg", 7.5)
		storeService.createMenuItem(store, "General Tso's Chicken", "GeneralTsos.jpg", 7.5)
		
		store = storeService.findOrCreateStore("Sushi")
		storeService.createMenuItem(store, "Assorted Sushi", "AssortedSushi.jpg", 8.0)
		storeService.createMenuItem(store, "California Roll", "CaliforniaRoll.jpg", 7.5)
		storeService.createMenuItem(store, "Rainbow Roll", "RainbowRoll.jpg", 8.0)
		storeService.createMenuItem(store, "Spicy Tuna Roll", "SpicyTuna.jpeg", 8.0)
    }
    def destroy = {
    }
}
