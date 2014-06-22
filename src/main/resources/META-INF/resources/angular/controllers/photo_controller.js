

EbeanBootApp.controller('PhotoController', ['$scope', function($scope) {
	$scope.photos = [
		{id: 1, title: 'Photo 1', url: '/images/wat1.png'},
		{id: 2, title: 'Photo 2', url: '/images/wat2.png'},
		{id: 3, title: 'Photo 3', url: '/images/wat3.png'},
		{id: 4, title: 'Photo 4', url: '/images/wat4.png'},
		{id: 5, title: 'Photo 5', url: '/images/wat5.png'},
		{id: 6, title: 'Photo 6', url: '/images/wat6.png'}
	];

	angular.extend($scope, {
		splitPhotos: function(num) {
			var splits = [];
			var inner = [];

			var count, iCount = 0;
			for(count = 0; count < $scope.photos.length; count ++) {
				if (count % num === 0) {
					iCount = 0;

					if (inner.length > 0) {
						splits.push(inner);
						inner = [];
					}
				}

				inner.push($scope.photos[count]);
			}
		}
	});
}]);