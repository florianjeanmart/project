myApp.controller('WelcomeCtrl',  function ($scope, $modal,$window,$flash,$http) {

    //import data
    $scope.myself = data.mySelf;
    $scope.languages = languages;
    $scope.languagesList = [];

    console.log("$scope.myself");
    console.log($scope.myself);
    console.log("$scope.languages");
    console.log($scope.languages);

    for(var key in $scope.languages){
        if($scope.languages.hasOwnProperty(key)){
            $scope.languagesList.push({
                key:$scope.languages[key].code,
                value:$scope.languages[key].language
            });
        }
    }


    //login open modal
    $scope.login= function(){

        var resolve = {
            login:function(){
                return function(myself){
                    $scope.myself = myself;
                }
            }
        };

        $modal.open({
            templateUrl: "/assets/javascripts/modal/LoginModal/view.html",
            controller: "LoginModalCtrl",
            size:"l",
            resolve: resolve
        });
    };

    //registration open modal
    $scope.registration= function(){

        var resolve = {
            login:function(){
                return function(myself){
                    $scope.myself = myself;
                }
            }
        };

        $modal.open({
            templateUrl: "/assets/javascripts/modal/RegistrationModal/view.html",
            controller: "RegistrationModalCtrl",
            size:"l",
            resolve: resolve
        });
    };

    //edit profile
    $scope.editProfile = function(){
        var resolve = {
            account: function () {
                return $scope.myself;
            },
            languages : function(){
                return $scope.languagesList;
            }

        };

        $modal.open({
            templateUrl: "/assets/javascripts/modal/EditProfileModal/view.html",
            controller: "EditProfileModalCtrl",
            size:"l",
            resolve: resolve
        });
    };

    //log out
    $scope.logout = function(){
        $http({
            'method': "GET",
            'url': "logout",
            'headers': "Content-Type:application/json"
        }).success(function (data, status) {
            $scope.myself=null;
        })
            .error(function (data, status) {
                $flash.error(data.message);
            });
    };


    //load - store translation
    $scope.languages = languages;

    $scope.languagesList = [];

    $scope.lang = lang.split('-')[0];
    $scope.langIni = angular.copy($scope.lang);

    for(var key in $scope.languages){
        if($scope.languages.hasOwnProperty(key)){
            $scope.languagesList.push({
                key:$scope.languages[key].code,
                value:$scope.languages[key].language
            });
        }
    }

    $scope.$watch('lang',function(){
        if($scope.lang != $scope.langIni){

            $http({
                'method': "GET",
                'url': "/changeLanguage/"+$scope.lang,
                'headers': "Content-Type:application/json"
            }).success(function (data, status) {
                $window.location.reload();
            })
            .error(function (data, status) {
                $flash.error(data.message);
            });
        }
    });

});