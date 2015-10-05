package berkeleycafeteria

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(PosController)
@Mock([SecurityFilters, CafeteriaOrder, CafeteriaOrderMenuItem, MenuItem, Store, User])
class PosControllerSpec extends Specification {

    /**
	 * Perform any initial setup before running each test.
	 */
    def setup() {
		StartUpActions.init()
    }

    def cleanup() {
    }

    void testPosFilter() {
		when:
		withFilters(action:"index") {
			controller.index()
		}
		
		then:
		response.redirectedUrl == '/'
		
		// Test a successful pass through the pos filter.
		when:
		response.reset() // Reset the response before running another test case.
		// Log the Cashier into the system so they are in the session in order to
		// test a valid pass through the pos filter.
		SessionController sessionController = new SessionController()
		params.userName = "Cashier"
		params.password = "money1234"
		sessionController.processLogin()
		
		withFilters(action:"index") {
			controller.index()
		}
		
		then:
		response.redirectedUrl == '/pos/index'
    }
}
