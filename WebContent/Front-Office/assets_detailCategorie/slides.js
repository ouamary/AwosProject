jQuery(function() {
	jQuery(".rslides").responsiveSlides( {
		speed: 500,				// Integer: Speed of the transition, in milliseconds
		timeout: 7000,			// Integer: Time between slide transitions, in milliseconds
		pager: true,			// Boolean: Show pager, true or false
		pause: true,			// Boolean: Pause on hover, true or false
		pauseControls: true,	// Boolean: Pause when hovering controls, true or false
		maxwidth: "978"			// Integer: Max-width of the slideshow, in pixels
	});
});