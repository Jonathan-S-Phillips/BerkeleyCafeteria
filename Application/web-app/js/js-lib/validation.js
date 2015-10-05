function isDateStringValid(dateString) {
	if(isNotEmpty(dateString)) {
		return true;
	}
	else {
		return false;
	}
}

function isTimeStringValid(timeString) {
	if(isNotEmpty(timeString)) {
		return true;
	}
	else {
		return false;
	}
}

function isNotEmpty(field) {
	if(field == null || field == "") {
		return false;
	}
	else {
		return true;
	}
}