<g:form id="checkoutForm" controller="store" action="checkout">
	<div id="checkOutError" style="visibility:hidden;"></div>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h4>Checkout</h4>
		</div>
		<div class="panel-body">
			<p>Pick a date and time to pickup your order</p>
			<input name="date" id="date" class="datepicker" placeholder="Date" />
			<input name="time" id="time" class="timepicker" placeholder="Time" />
			<div class="wrapper">
				<span class="group-btn pull-right"> 
					<g:link url="#" class="btn btn-default" value="Cancel" onclick="cancelCheckout();">Cancel</g:link>
					<input type="submit" class="btn btn-default" onclick="return validateDateAndTime();" value="Complete">
				</span>
			</div>
		</div>
	</div>
</g:form>
<script type="text/javascript">
	$('.datepicker').pickadate({
		format:"mm/dd/yyyy",
		formatSubmit:"mm/dd/yyyy"	
	});
	$('.timepicker').pickatime({
		min: [8,0],
		max: [22,0]
	});
</script>