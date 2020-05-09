var app = angular
		.module("myModule", [])
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
								.get('PurchaseItemsServlet?id=getall', config)
								.then(
										function successCallback(response) {
											$scope.number = $scope.members = response.data;
										},
										function errorCallback(response) {
											alert("Error. while created user Try Again!");

										});
					}
					;

					$scope.checkoutItems = function() {
					
						var dataObject = new Object();
		
						dataObject.items = $scope.items;
						var content = JSON.stringify(dataObject);
						console.log("########## "+content);
						var data = $.param({
							cart_items : content
						});

						var config = {
							headers : {
								'Content-Type' : 'application/x-www-form-urlencoded;charset=utf-8;'
							}
						}

						$http
								.post(
										'PurchaseItemsServlet?method=save',
										data, config)
								.then(
										function successCallback(response) {
											console.log(response.data);
											refreshPage();
											$scope.newMember = {};
										},
										function errorCallback(response) {
											alert("Error. while creating user Try Again!");

										});
					

					};

					$scope.addItem = function(pickedItem) {
						pickedItem.quantity = document
								.getElementById(pickedItem.itemId).value;
						pickedItem.itemType = pickedItem.price
								* pickedItem.quantity;
						$scope.items.push(pickedItem);
						console.log($scope.items);

					};

				});