myApp.service("modelService", function($rootScope) {

    var svc;
    svc = this;
    svc.container = {};

    this.store = function(key,content) {
        svc.container[key]= content;
    };

    this.get = function(key){
        return svc.container[key];
    }
});