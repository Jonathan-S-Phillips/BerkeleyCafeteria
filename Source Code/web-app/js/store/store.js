/**
 * Cancels the checkout process by closing the checkout window.
 * @returns {Boolean}
 */
function cancelCheckout() {
	$.unblockUI();
	$("#checkout").css("visibility", "hidden");
	return false;
}

/**
 * Initiates the checkout process by opening the checkout window. The checkout window should
 * only be displayed if there are items in the shopping cart. If there are no items, then an
 * appropriate error message is displayed to the User.
 */
function checkout() {
	if(total > 0) {
		// Block the main part of the page.
		$.blockUI({message:$("#checkout")});
		// Set the 
		$("#checkout").css("visibility", "visible");
	}
	else {
		$("#error").css("visibility", "visible");
		$("#error").html("<p class='alert alert-danger' role='alert'>Please add at least 1 item to your shopping cart before trying to checkout</p>");
	}
}

/**
 * Changes the quantity for the given menuItem in the current CafeteriaOrder if the value
 * entered into the input field is greater than 1. If the value is less than 1, then an
 * appropriate error message is displayed.
 * 
 * @param input - The input quantity field that was changed.
 * @param menuItemId - The ID for the menuItem whose quantity is being updated.
 */
function quantityChange(input, menuItemId) {
	// The value should not be less than 1, so set it to 1 if it is.
	if(input.value < 1) {
		input.value = 1;
		$("#error").css("visibility", "visible");
		$("#error").html("<p class='alert alert-danger' role='alert'>Quantity values must be 1 or greater. If you want to remove an item from your cart, then click the corresponding 'Remove from My Cart' button.</p>");
	}
	else {
		// Update the quantity in the shopping cart and reload the page data if successful.
		jQuery.post(contextPath + "/store/updateQuantity", {
				menuItemId:menuItemId, 
				quantity:input.value
			},
			function(result) {
				var newDocument = document.open("text/html", "replace");
				newDocument.write(result);
				newDocument.close();
			}
		);
	}
}

/**
 * Validates that there is a date and time selected on the checkout form before submitting.
 * @returns {Boolean}
 */
function validateDateAndTime() {
	if($("#date").val() != "" && $("#time").val() != "") {
		return true;
	}
	else {
		$("#checkOutError").css("visibility", "visible");
		$("#checkOutError").html("<p class='alert alert-danger' role='alert'>Please enter both a date and time before checking out.</p>");
		return false;
	}
}