myApp.controller('HomeCtrl', function ($scope, $modal) {

    //registration open modal
    $scope.downloadModal= function(){

        $modal.open({
            templateUrl: "/assets/javascripts/modal/DownloadFieldModal/view.html",
            controller: "DownloadFieldModalCtrl",
            size:"l"
        });
    };
});