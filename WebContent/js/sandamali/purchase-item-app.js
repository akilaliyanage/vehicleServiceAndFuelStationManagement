//IT19120058
//Geethika L.W.S

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
					$scope.cartTot = 0;
					$scope.capacity = 250;
					
					$scope.rand = 10;

					$scope.getRandomSpan = function(){
						$scope.rand = $scope.rand + 50;
						return $scope.rand;
					}

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
							var random = Math.random( );
							if($scope.items.length > 0){
							var content = JSON.stringify($scope.items);
							console.log("########## " + content);
							var data = $.param({
								package_info : content
							});

							var config = {
								headers : {
									'Content-Type' : 'application/x-www-form-urlencoded;charset=utf-8;'
								}
							}

							$http
									.post('PurchaseItemsServlet?cartNo='+random+'',
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
							}else{
								alert("Please add items to your cart before checkout");
							}
					};

					$scope.SelectFile = function(e) {
						var reader = new FileReader();
						reader.onload = function(e) {
							$scope.PreviewImage = e.target.result;
							$scope.$apply();
						};

						reader.readAsDataURL(e.target.files[0]);
						$scope.pimage = (e.target.files[0]).name;
					};

					$scope.addItem = function(pickedItem) {
						pickedItem.quantity = document
								.getElementById(pickedItem.itemId).value;
						pickedItem.totPrice = pickedItem.price
								* pickedItem.quantity;
						$scope.items.push(pickedItem);
						$scope.cartTot =$scope.cartTot + pickedItem.totPrice;
						console.log($scope.items);

					};

				});