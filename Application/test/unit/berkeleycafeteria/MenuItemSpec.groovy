package berkeleycafeteria

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(MenuItem)
@Mock([MenuItem, Store])
class MenuItemSpec extends Specification {

	private Store store1
	
	/**
	 * Perform any initial setup before running each test.
	 */
    def setup() {
		store1 = Store.findOrCreateStore("Test Store")
    }

	/**
	 * Perform any cleanup actions after running each test.
	 */
    def cleanup() {
    }
	
	/**
	 * Tests for the createMenuItem method.
	 */
    void testCreateMenuItem() {
		when:
		MenuItem.createMenuItem(store1, "TestMenuItem", "image.jpg", 7.5)
		MenuItem.createMenuItem(store1, "TestMenuItem2", null, 8.0)
		MenuItem.createMenuItem(store1, null, null, 5.0)
		
		then:
		MenuItem.findByName("TestMenuItem") != null
		MenuItem.findByName("TestMenuItem2") == null
		MenuItem.findAll().size() == 2
    }
}
