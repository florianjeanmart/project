myApp.service("facebookService", function (Facebook) {

    this.login = function(successCallback,failCallback) {
        // From now on you can use the Facebook service just as Facebook api says
        Facebook.login(function(response) {
            console.log('FB.login');
            console.log(response);

            var access_token = response.authResponse.accessToken;
            var user_id = response.authResponse.userID;

            //TODO manage error
            this.loginToServer(access_token,user_id,successCallback,failCallback);
        });
    };

    this.getLoginStatus = function() {
        console.log('FB.getLoginStatus start');
        Facebook.getLoginStatus(function(response) {
            console.log('FB.getLoginStatus');
            console.log(response);
            if(response.status === 'connected') {
                var access_token = response.authResponse.accessToken;
                var user_id = response.authResponse.userID;
                this.loginToServer(access_token,user_id,function(){
                    console.log('success');
                },
                function(){
                    console.log('faild');
                });
            } else {
            }
        });
    };

    this.loginToServer = function (access_token, user_id,successCallback,failCallback) {

        //send request
        var dto = {
            userId: user_id,
            token: access_token
        };

        $http({
            'method': "POST",
            'url': "/login/facebook",
            'headers': "Content-Type:application/json",
            'data': dto
        }).success(function (data, status) {
            //store connected user
            modelService.store(modelService.MY_SELF,data.myself);
            //test lang
            var lang = $locale.id.split("-")[0];
            if(data.myself.lang.code != lang){

            }


            successCallback();
        })
            .error(function (data, status) {
                failCallback();
            });
    };


});