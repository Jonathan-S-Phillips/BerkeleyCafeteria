package berkeleycafeteria

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(CafeteriaOrderMenuItem)
@Mock([CafeteriaOrder, CafeteriaOrderMenuItem, MenuItem, Store, User])
class CafeteriaOrderMenuItemSpec extends Specification {

	private CafeteriaOrder order
	private CafeteriaOrderMenuItem comi
	private MenuItem menuItem
	
	/**
	 * Perform any initial setup before running each test.
	 */
    def setup() {
		StartUpActions.init()
		User user = User.findByName("Cashier")
		menuItem = MenuItem.findByName("Hamburger")
		order = CafeteriaOrder.findOrCreateCafeteriaOrder(user)
    }

	/**
	 * Perform any cleanup actions after running each test.
	 */
    def cleanup() {
    }

	/**
	 * Tests the link method.
	 */
	void testLink() {
		when:
		comi = CafeteriaOrderMenuItem.link(order, menuItem, 1)
		// Add the same MenuItem again so we can test to make sure the quantity of
		// the CafeteriaOrderMenuItem was increased by 1.
		CafeteriaOrderMenuItem.link(order, menuItem, 1)
		order.save(flush:true)
		
		then:
		order.cafeteriaOrderMenuItems.contains(comi)
		
		// There should be 1 CafeteriaOrderMenuItem in the Order, but 2 total 
		// MenuItems because the MenuItem was added twice.
		order.cafeteriaOrderMenuItems.size() == 1
		order.countMenuItems() == 2
	}
	
	/**
	 * Tests the quantity constraint.
	 */
	void testQuantityConstraint() {
		when:
		comi = new CafeteriaOrderMenuItem(order:order, menuItem:menuItem, quantity:0)
		comi.validate()
		
		then:
		comi.hasErrors()
	}
	
	/**
	 * Tests the updateQuantity method.
	 */
    void testUpdateQuantity() {
		when:
		comi = CafeteriaOrderMenuItem.link(order, menuItem, 1)
		comi.updateQuantity(2)
		
		then:
		comi.quantity == 2
    }
}
