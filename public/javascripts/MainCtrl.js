
angular.module("tmh.dynamicLocale").config(function (tmhDynamicLocaleProvider) {
    tmhDynamicLocaleProvider.localeLocationPattern('/assets/components/angular-i18n/angular-locale_{{locale}}.js');
});

var myApp = angular.module('app', [
    'ngAnimate',
    'ui.bootstrap',
    'ui.bootstrap.datetimepicker',
    "angucomplete",
    'tmh.dynamicLocale',
    'angularFileUpload',
    'ngRoute',
    'ngTable']);

initializeCommonRoutes();

myApp.controller('MainCtrl', function ($scope,$locale, tmhDynamicLocale,translationService,$modal,$window,facebookService) {

    if ("data" in window && data!=undefined && data!=null) {
        tmhDynamicLocale.set(data.langId);

        translationService.set(data.translations);
    }

    //test is the user is currently connected
    $window.fbAsyncInit = function () {
        FB.init({
            appId: '1432915530336007',
            cookie: true,
            xfbml: true,
            version: 'v2.3'
        });
    };

    this.getStatus = function (callback) {
        //test is the user is currently connected
        FB.getLoginStatus(function (response) {
            statusChangeCallback(response);
            console.log("FB.getLoginStatus");
            console.log(response);
            callback(response);
        });
    }


    $scope.helpDisplayed=false;

    $scope.displayHelp = function(){
        $scope.helpDisplayed = true;
    };

    $scope.maskHelp = function(){
        $scope.helpDisplayed = false;
    };

    $scope.openHelp = function(message){

        var resolve = {
            message: function () {
                return message;
            }
        };

        $modal.open({
            templateUrl: "/assets/javascripts/modal/HelpModal/view.html",
            controller: "HelpModalCtrl",
            size: 'sm',
            resolve: resolve
        });
    };
});