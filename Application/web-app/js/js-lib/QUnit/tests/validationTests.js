QUnit.test("testIsDateStringValid", function(assert) {
	assert.ok(!isDateStringValid(null), "Null is not a valid date!");
	assert.ok(!isDateStringValid(""), "Empty String is not a valid date!");
	assert.ok(isDateStringValid("9/28/15"), "9/28/15 is a valid date!");
});

QUnit.test("testIsTimeStringValid", function(assert) {
	assert.ok(!isTimeStringValid(null), "Null is not a valid time!");
	assert.ok(!isTimeStringValid(""), "Empty String is not a valid time!");
	assert.ok(isTimeStringValid("1:30"), "1:30 is a valid time!");
});

QUnit.test("testIsNotEmpty", function(assert) {
	assert.ok(!isNotEmpty(null), "Null is empty!");
	assert.ok(!isNotEmpty(""), "Empty String is empty!");
	assert.ok(isNotEmpty("1"), "'1' is not empty!");
});