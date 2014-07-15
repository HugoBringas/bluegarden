(function () {
	'use strict';
	
	// Create services module
	angular.module(appName + '.Services', ['ngResource']);

	// Register Main app module
	var app = angular.module(appName, [appName + '.Services','ui.router']);

	app.run(['$rootScope',function ($rootScope) {
		$rootScope.safeApply = function (fn) {
			var phase = this.$root.$$phase;
			if (phase == '$apply' || phase == '$digest') {
				if (typeof (fn) === 'function') {
					fn.apply(this);
				}
			} else {
				this.$apply(fn);
			}
		};
	}]);
})();