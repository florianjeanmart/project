
//
// initialization external modules
//
var myApp = angular.module('app', [
    'ngAnimate',
    'ui.bootstrap',
    'ui.bootstrap.datetimepicker',
    "angucomplete",
    'tmh.dynamicLocale',
    'angularFileUpload',
    'ngRoute',
    'ngTable']);

//
// initialize routes
//
initializeCommonRoutes();

//
// main ctrl
//
myApp.controller('MainCtrl', function ($scope,$locale, tmhDynamicLocale,translationService,$modal,$window,facebookService) {

    //
    // initialize translations
    // load from data var and insert into into translationService
    //
    if ("data" in window && data!=undefined && data!=null) {
        translationService.set(data.translations);
    }

    //
    //facebook initialization
    //
    //window.fbAsyncInit = function () {
    //    console.log('start ini 2');
    //    FB.init({
    //        appId: '1432915530336007',
    //        cookie: true,
    //        xfbml: true,
    //        version: 'v2.3'
    //    });
    //    FB.getLoginStatus(function (response) {
    //        statusChangeCallback(response);
    //        console.log("FB.getLoginStatus");
    //        console.log(response);
    //        //connection user with facebook connector
    //    });
    //};
    //$scope.$watch(function() {
    //    // This is for convenience, to notify if Facebook is loaded and ready to go.
    //    return Facebook.isReady();
    //}, function(newVal) {
    //    // You might want to use this to disable/show/hide buttons and else
    //    console.log('ready !! ');
    //    facebookService.getLoginStatus();
    //});
    facebookService.getLoginStatus();

    //
    // help functionalities
    //
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