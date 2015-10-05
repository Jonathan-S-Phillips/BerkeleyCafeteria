package berkeleycafeteria

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(SessionController)
@Mock([CafeteriaOrder, CafeteriaOrderMenuItem, MenuItem, Store, User])
class SessionControllerSpec extends Specification {

	/**
	 * Perform any initial setup before running each test.
	 */
    def setup() {
		StartUpActions.init()
    }

    def cleanup() {
    }

	/**
	 * Tests for the index action.
	 */
	void testIndex() {
		Store store = Store.findByName("American")
		
		when:
		def model = controller.index()
		
		then:
		model.store == store
	}
	
	/**
	 * Tests for the logout action.
	 */
    void testLogout() {
		when:
		controller.logout()
		
		then:
		response.redirectedUrl == '/'
    }
	
	/**
	 * Tests for the processLogin action.
	 */
	void testProcessLogin() {
		// Test a failed login with no userName or password.
		when:
		controller.processLogin()
		
		then:
		response.redirectedUrl == "/login"
		flash.error == "Username or password is incorrect. Please try again."
		
		// Test a failed login with a bad password.
		when:
		response.reset() // Reset the response before running another test case.
		params.userName = "Cashier"
		params.password = "money"
		controller.processLogin()
		
		then:
		response.redirectedUrl == "/login"
		flash.error == "Username or password is incorrect. Please try again."
		
		// Test a failed login with a bad userName.
		when:
		response.reset() // Reset the response before running another test case.
		params.userName = "Jon"
		params.password = "money1234"
		controller.processLogin()
		
		then:
		response.redirectedUrl == "/login"
		flash.error == "Username or password is incorrect. Please try again."
		
		// Test a successful login for the student.
		when:
		response.reset() // Reset the response before running another test case.
		params.userName = "Arun"
		params.password = "berkeley1234"
		controller.processLogin()
		
		then:
		response.redirectedUrl == "/"
		session.userId == 1
		session.name == "Arun"
		session.cartItems == 0
		
		// Test a successful login for the cashier.
		when:
		response.reset() // Reset the response before running another test case.
		params.userName = "Cashier"
		params.password = "money1234"
		controller.processLogin()
		
		then:
		response.redirectedUrl == "/pos/index"
		session.userId == 2
		session.name == "Cashier"
		session.cartItems == 0
	}
}
