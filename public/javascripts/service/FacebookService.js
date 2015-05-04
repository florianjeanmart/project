myApp.service("facebookService", function ($sce, $window) {

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


});