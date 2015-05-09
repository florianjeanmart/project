myApp.service("modelService", function($rootScope) {

    this.MY_SELF="MYSELF";
    this.APP_STATUS="APP_STATUS";

    this.model = {};

    this.set = function(key,content) {
        this.model[key]= content;
    };

    this.get = function(key){
        return this.model[key];
    };

    this.remove = function(key){
        delete this.model[key];
    };
});