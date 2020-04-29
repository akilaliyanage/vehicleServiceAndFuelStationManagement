var app = angular.module("myModule", [])
		.controller(
				"myController",
				function($scope, $http) {

					$scope.newMember = {};
					$scope.clickedMembers = [];
					$scope.number = $scope.members = [];
					$scope.items = [];
					$scope.selectedMember = {};
					$scope.pimage = "";
					$scope.qty = "";

					refreshPage();

					function refreshPage() {
						var config = {
							headers : {
								'Content-Type' : 'application/x-www-form-urlencoded;charset=utf-8;'
							}
						}

						$http
								.get(
										'PurchaseItemsServlet?id=getall',
										config)
								.then(
										function successCallback(response) {
											$scope.number = $scope.members = response.data;
										},
										function errorCallback(response) {
											alert("Error. while created user Try Again!");

										});
					};



					$scope.addItem = function(pickedItem) {
						pickedItem.quantity=document.getElementById(pickedItem.itemId).value;
						pickedItem.itemType= pickedItem.price * pickedItem.quantity; 
						$scope.items.push(pickedItem);
						console.log($scope.items);
						
					};


				});