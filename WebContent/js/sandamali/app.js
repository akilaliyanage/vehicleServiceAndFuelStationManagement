var app = angular.module("myModule", [])
		.controller(
				"myController",
				function($scope, $http) {

					$scope.newMember = {};
					$scope.clickedMembers = [];
					$scope.number = $scope.members = [];
					$scope.selectedMember = {};

					refreshPage();

					function refreshPage() {
						var config = {
							headers : {
								'Content-Type' : 'application/x-www-form-urlencoded;charset=utf-8;'
							}
						}

						$http
								.get(
										'http://localhost:8080/vehicleServiceAndFuelStationManagement/PackageManagerServlet?id=getall',
										config)
								.then(
										function successCallback(response) {
											$scope.number = $scope.members = response.data;
										},
										function errorCallback(response) {
											alert("Error. while created user Try Again!");

										});
					}
					;

					$scope.getId = function() {
						$scope.members.push($scope.newMember);
						$scope.newMember = {};
						console.log($scope.members);
					};

					$scope.selectMember = function(member) {
						$scope.selectedMember = member;
					};

					$scope.updateMember = function() {
						var dataObject = new Object();
						dataObject.packId = $scope.selectedMember.packId;
						dataObject.packName = $scope.selectedMember.packName;
						dataObject.adminRegNo = $scope.selectedMember.adminRegNo;
						dataObject.packType = $scope.selectedMember.packType;
						dataObject.price = $scope.selectedMember.price;
						dataObject.packDescription = $scope.selectedMember.packDescription;
						var content = JSON.stringify(dataObject);
						console.log(content);
						var data = $.param({
							package_info : content
						});

						var config = {
							headers : {
								'Content-Type' : 'application/x-www-form-urlencoded;charset=utf-8;'
							}
						}

						$http
								.post(
										'http://localhost:8080/vehicleServiceAndFuelStationManagement/PackageManagerServlet?method=update',
										data, config)
								.then(
										function successCallback(response) {
											console.log(response.data);
											refreshPage();
										},
										function errorCallback(response) {
											alert("Error. while updating user. Try Again!");

										});
					};
					

					$scope.deleteMember = function() {
						var dataObject = new Object();
						dataObject.id = $scope.selectedMember.id;
						dataObject.name = $scope.selectedMember.name;
						dataObject.age = $scope.selectedMember.age;
						dataObject.email = $scope.selectedMember.email;
						var content = JSON.stringify(dataObject);
						console.log(content);
						var data = $.param({
							student_info : content
						});

						var config = {
							headers : {
								'Content-Type' : 'application/x-www-form-urlencoded;charset=utf-8;'
							}
						}

						$http
								.post(
										'http://localhost:8080/student/deletestudent',
										data, config)
								.then(
										function successCallback(response) {
											console.log(response.data);
											refreshPage();
										},
										function errorCallback(response) {
											alert("Error. while deleting user. Try Again!");

										});
					};

					$scope.saveMember = function() {
						var dataObject = new Object();
						
						dataObject.packId = $scope.newMember.packId;
						dataObject.packName = $scope.newMember.packName;
						dataObject.adminRegNo = $scope.newMember.adminRegNo;
						dataObject.packType = $scope.newMember.packType;
						dataObject.price = $scope.newMember.price;
						dataObject.packDescription = $scope.newMember.packDescription;
						var content = JSON.stringify(dataObject);
						console.log("########## "+content);
						var data = $.param({
							package_info : content
						});

						var config = {
							headers : {
								'Content-Type' : 'application/x-www-form-urlencoded;charset=utf-8;'
							}
						}

						$http
								.post(
										'http://localhost:8080/vehicleServiceAndFuelStationManagement/PackageManagerServlet?method=update',
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

				});