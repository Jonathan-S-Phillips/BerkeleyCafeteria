package berkeleycafeteria

/**
 * The StoreService class handles all actions related to a Store.
 * 
 * @author JPhillips
 * @version 9/6/15
 */
class StoreService {

	/**
	 * Finds or creates a Store with the given name.
	 * 
	 * @param name - The name of the Store to find or create.
	 * @return The Store that was found or created.
	 */
    public Store findOrCreateStore(String name) {
		Store store = Store.findByName(name)
		if(!store) {
			store = new Store(name:name)
			store.save(flush:true)
		}
		return store
	}
	
	/**
	 * Creates a MenuItem and adds it to the given Store if a MenuItem with the given name
	 * is not already tied to the given Store.
	 * 
	 * @param store - The Store to tie the MenuItem to.
	 * @param name - The name of the MenuItem.
	 * @param image - The name of the image file for the MenuItem.
	 * @param price - The price of the MenuItem.
	 */
	public void createMenuItem(Store store, String name, String image, double price) {
		MenuItem menuItem = MenuItem.findByNameAndStore(name, store)
		if(!menuItem) {
			menuItem = new MenuItem(store:store, name:name, image:image, price:price)
			menuItem.save(flush:true)
		}
	}
}
