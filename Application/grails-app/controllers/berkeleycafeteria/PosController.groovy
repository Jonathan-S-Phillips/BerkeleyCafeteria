package berkeleycafeteria

class PosController {

    def cafeteriaOrderService
	
	/**
	 * Displays the POS system for the cafeteria. The POS system should only be displayed to non-student
	 * Users. If a Student or anyone else tries to access this page, they should be redirected to the
	 * main index page.
	 */
	def index() {
		User user = User.get(session.userId)
		List<CafeteriaOrder> outstanding = CafeteriaOrder.findAllByIsCompleteAndStatus(true, "Waiting Pickup")
		List<CafeteriaOrder> completed = CafeteriaOrder.findAllByIsCompleteAndStatus(true, "Picked Up")
		List<CafeteriaOrder> missed = CafeteriaOrder.findAllByIsCompleteAndStatus(true, "Missed")
		return [outstanding:outstanding, completed:completed, missed:missed]
	}
	
	/**
	 * Updates the status for the given CafeteriaOrder. This is a function for non-students only, so
	 * we need to check that the current User has the right permissions before performing any actions.
	 */
	def updateOrderStatus() {
		User user = User.get(session.userId)
		CafeteriaOrder order = CafeteriaOrder.get(params.id)
		order.updateOrderStatus(params.status)
		flash.success = "Order updated successfully"
		redirect(action:"index")
	}
}
