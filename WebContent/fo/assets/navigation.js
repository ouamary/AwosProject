jQuery(function () {
	jQuery("#primary-nav ul").tinyNav( {
		active: 'current-menu-item', // String: Set the "active" class
		header: 'Products...', // String: Specify text for "header" and show header instead of the active item
	});
});

jQuery(function () {
	jQuery("#secondary-nav ul").tinyNav( {
		active: 'current-menu-item', // String: Set the "active" class
		header: 'Go to...', // String: Specify text for "header" and show header instead of the active item
	});
});