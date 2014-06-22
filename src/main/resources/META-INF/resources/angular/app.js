

var EbeanBootApp = angular.module('ebean-boot', ['ngRoute']);

EbeanBootApp.config(['$routeProvider', function($routeProvider) {

		$routeProvider
			.when('/albums', {templateUrl: 'albums.html', controller: 'AlbumController'})
		  .otherwise({redirectTo: '/albums'});
	}]);

