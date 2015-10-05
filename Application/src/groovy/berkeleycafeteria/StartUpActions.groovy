package berkeleycafeteria

/**
 * A helper class which performs some basic actions when the application is started. This is called from the
 * Bootstrap.groovy class when the application is run in any environment. It can also be used when running
 * tests in order to have sample data to use.
 * 
 * @author JPhillips
 * @version 9/20/15
 */
class StartUpActions {

	/**
	 * Initialization function which automatically creates Users, Stores, and MenuItems if they
	 * do not already exist in the database.
	 */
	public static void init() {
		createUsers()
		createStoresAndItems()
	}
	
	/**
	 * Creates a sample CafeteriaOrder. Note that either the init() or createStoresAndItems() function
	 * must be called first.
	 * 
	 * @param user The User to tie to the CafeteriaOrder.
	 * @return The CafeteriaOrder that was created.
	 */
	public static CafeteriaOrder createSampleOrder(User user) {
		def cafeteriaOrderService = new CafeteriaOrderService()
		CafeteriaOrder order = CafeteriaOrder.findOrCreateCafeteriaOrder(user)
		
		MenuItem menuItem = MenuItem.findByName("Hamburger and Fries")
		cafeteriaOrderService.addMenuItemToOrder(user, menuItem, 1)
		return order
	}
	
	/**
	 * Creates all of the Stores and MenuItems if they do not already exist in the database.
	 */
	public static void createStoresAndItems() {
		// Create Lists of HashMaps containing information for MenuItems for each Store that will
		// be created.
		List<HashMap<String, Object>> americanItems = [[name:"Hamburger and Fries", image:"Hamburger.jpg", price:7.75],
			[name:"Cheeseburger and Fries", image:"Cheeseburger.jpg", price:7.75],
			[name:"Chicken Fingers and Fries", image:"ChickenFingers.jpg", price:6],
			[name:"Grilled Cheese and Fries", image:"GrilledCheese.jpg", price:5.5]]
		
		List<HashMap<String, Object>> pizzaItems = [[name:"Plain Pizza", image:"Plain.jpg", price:7.5],
			[name:"Pepperoni Pizza", image:"Pepperoni.jpg", price:8.0],
			[name:"Margarita Pizza", image:"Margarita.jpg", price:7.75],
			[name:"Meat Lovers Pizza", image:"MeatLovers.jpg", price:8.5]]
		
		List<HashMap<String, Object>> chineseItems = [[name:"Beef and Broccoli", image:"BeefBroccoli.jpg", price:8.0],
			[name:"Chicken Fried Rice", image:"FriedRice.jpg", price:6.0],
			[name:"Orange Chicken", image:"OrangeChicken.jpg", price:7.5],
			[name:"General Tso's Chicken", image:"GeneralTsos.jpg", price:7.5]]
		
		List<HashMap<String, Object>> sushiItems = [[name:"Assorted Sushi", image:"AssortedSushi.jpg", price:8.0],
			[name:"California Roll", image:"CaliforniaRoll.jpg", price:7.5],
			[name:"Rainbow Roll", image:"RainbowRoll.jpg", price:8.0],
			[name:"Spicy Tuna Roll", image:"SpicyTuna.jpeg", price:8.0]]
		
		// Create the Stores and MenuItems.
		createStoreAndItems("American", americanItems)
		createStoreAndItems("Pizza", pizzaItems)
		createStoreAndItems("Chinese", chineseItems)
		createStoreAndItems("Sushi", sushiItems)
	}
	
	/**
	 * Creates 2 Users, a student and a cashier, if they do not already exist in the database.
	 */
	public static void createUsers() {
		User.createUser("Arun", "berkeley1234", true)
		User.createUser("Cashier", "money1234", false)
	}
	
	/**
	 * Creates a Store with the given store name and adds MenuItems to the Store based on the given
	 * List of HashMaps containing the information for each MenuItem.
	 * 
	 * @param storeName The name of the Store.
	 * @param items A List of HashMaps containing the information for each MenuItem.
	 */
	private static void createStoreAndItems(String storeName, List<HashMap<String, Object>> items) {
		Store store = Store.findOrCreateStore(storeName)
		for(HashMap<String, Object> item in items) {
			MenuItem.createMenuItem(store, item.get("name"), item.get("image"), item.get("price"))
		}
	}
}
