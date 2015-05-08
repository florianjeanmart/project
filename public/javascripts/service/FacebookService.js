myApp.service("facebookService", function ($sce, $window,modelService,$locale) {

    this.login = function (access_token, user_id,successCallback,failCallback) {

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
                //TODO set locale
            }
            successCallback();
        })
        .error(function (data, status) {
            failCallback();
        });
    };


});