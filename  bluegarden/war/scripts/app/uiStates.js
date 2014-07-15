(function() {
	//'use strict';

	var app = angular.module(appName);

	app.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
		var base = 'handleajax/view/';
		// For any unmatched url, send to default page
		$urlRouterProvider.otherwise('testc');

		$stateProvider
			.state('testc', {
				url: '/testo',
				templateUrl: base +'eltnum',
				controller: 'testController',
				data: {
					title: 'main'
				}
			}).state('test3', {
				url: '/test3',
				templateUrl: base +'test3',
				controller: 'testController',
				data: {
					title: 'test3'
				}
			});
		//check this https://github.com/resthub/springmvc-router
	}]);
})();