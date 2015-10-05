package berkeleycafeteria

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.GroovyPageUnitTestMixin} for usage instructions
 */
@TestFor(ApplicationTagLib)
@Mock([CafeteriaOrder, CafeteriaOrderMenuItem, MenuItem, Store, User])
class ApplicationTagLibSpec extends Specification {
	
	private CafeteriaOrder order
	private User user
	
	/**
	 * Perform any initial setup before running each test.
	 */
    def setup() {	
		StartUpActions.init()
		user = User.findByName("Cashier")
		order = StartUpActions.createSampleOrder(user)
    }

	/**
	 * Perform any cleanup actions after running each test.
	 */
    def cleanup() {
		def cafeteriaOrderService = new CafeteriaOrderService()
		cafeteriaOrderService.removeAllMenuItems(user)
    }

	/**
	 * Tests for the error tag.
	 */
    void testError() {
		expect:
		applyTemplate('<applicationTag:error />') == ""
		applyTemplate('<applicationTag:error error="Default Error" />') == alertTag("alert alert-danger", "Default Error")
    }
	
	/**
	 * Tests for the getOrdersString tag.
	 */
	void testGetOrdersString(){
		expect:
		applyTemplate('<applicationTag:getOrdersString />') == "<tr><td colspan='4' style='text-align:center'>No Orders to display</td></tr>"
	}
	
	/**
	 * Tests for the listMenuItems tag.
	 */
	void testListMenuItems() {	
		expect:
		applyTemplate('<applicationTag:listMenuItems />') == "Error reading items in order"
		applyTemplate('<applicationTag:listMenuItems order="${order}"/>', [order:order]) == "1 x Hamburger and Fries<br/>"
	}
	
	/**
	 * Tests for the orderActions tag.
	 */
	void testOrderActions() {	
		expect:
		applyTemplate("<applicationTag:orderActions />") == ""
		applyTemplate('<applicationTag:orderActions addActionButtons="true" template="/store/templates/studentActionButtons" order="${order}"/>', 
			[order:order]) == '<td>\n\t<a href="/store/reOrder/1" class="btn btn-default">\n\t\tRe-Order\n\t</a>\n</td>'
	}
	
	/**
	 * Tests for the orderActionsHeader tag.
	 */
	void testOrderActionsHeader() {
		expect:
		applyTemplate('<applicationTag:orderActionsHeader />') == ""
		applyTemplate('<applicationTag:orderActionsHeader addActionsHeader="true"/>') == "<th data-defaultsort='disabled'>Actions</th>"
	}
	
	/**
	 * Tests for the success tag.
	 */
	void testSuccess() {
		expect:
		applyTemplate('<applicationTag:success />') == ""
		applyTemplate('<applicationTag:success success="Default Success" />') == alertTag("alert alert-success", "Default Success")
	}
	
	/**
	 * Returns an alert tag with the given class attribute, and message as the body.
	 * 
	 * @param classAttribute The class attribute for the tag.
	 * @param message The body of the tag.
	 * @return A String representing an alert tag.
	 */
	private String alertTag(String classAttribute, String message) {
		return "<div class='" + classAttribute + "' role='alert'>" + message + "</div>"
	}
}
