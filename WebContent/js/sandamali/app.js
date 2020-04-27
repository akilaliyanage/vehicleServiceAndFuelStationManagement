var app = angular.module("myModule", [])
		.controller(
				"myController",
				function($scope, $http) {

					$scope.newMember = {};
					$scope.clickedMembers = [];
					$scope.number = $scope.members = [];
					$scope.selectedMember = {};
					$scope.pimage = "";

					refreshPage();

					function refreshPage() {
						var config = {
							headers : {
								'Content-Type' : 'application/x-www-form-urlencoded;charset=utf-8;'
							}
						}

						$http
								.get(
										'PackageManagerServlet?id=getall',
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
						document.getElementById("fileChooser").value = '';
						$scope.pimage = "";
						$scope.selectedMember = member;
						$scope.PreviewImage = "./img/sandamali/"+$scope.selectedMember.packImage;
					};
					
					$scope.clearImage = function() {
						document.getElementById("addPack").reset();
						document.getElementById("pimg").src = "";
						$scope.PreviewImage = "";
					};

					$scope.updateMember = function() {
						var dataObject = new Object();
						dataObject.packId = $scope.selectedMember.packId;
						dataObject.packName = $scope.selectedMember.packName;
						dataObject.adminRegNo = $scope.selectedMember.adminRegNo;
						dataObject.packType = $scope.selectedMember.packType;
						dataObject.price = $scope.selectedMember.price;
						dataObject.packDescription = $scope.selectedMember.packDescription;
						dataObject.packImage = $scope.selectedMember.packImage;
						if($scope.pimage != ""){
                            dataObject.packImage = $scope.pimage;
                        }
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
										'PackageManagerServlet?method=update',
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
										'PackageManagerServlet?method=delete',
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
						if($scope.newMember.packId!="" && $scope.newMember.packName!="" && $scope.newMember.adminRegNo!="" && $scope.newMember.packType!="" && $scope.newMember.price!="" && $scope.newMember.packDescription!="" && $scope.pimage!=""){
						
						dataObject.packId = $scope.newMember.packId;
						dataObject.packName = $scope.newMember.packName;
						dataObject.adminRegNo = $scope.newMember.adminRegNo;
						dataObject.packType = $scope.newMember.packType;
						dataObject.price = $scope.newMember.price;
						dataObject.packDescription = $scope.newMember.packDescription;
						dataObject.packImage = $scope.pimage;
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
										'PackageManagerServlet?method=save',
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
							alert("Please Fill The Form First!");
						}
					};
					
				    $scope.SelectFile = function (e) {
		                var reader = new FileReader();
		                reader.onload = function (e) {
		                    $scope.PreviewImage = e.target.result;
		                    $scope.$apply();
		                };

		                reader.readAsDataURL(e.target.files[0]);
		                $scope.pimage=(e.target.files[0]).name;
		            };

				});