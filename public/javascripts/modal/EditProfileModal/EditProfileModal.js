myApp.controller('EditProfileModalCtrl', function ($scope, $http, $flash, $modalInstance,$modal,account,languages) {

    $scope.loading = false;

    $scope.fields = {
        gender:{
            name:'gender',
            fieldTitle: "--.generic.gender",
            options:[{key:'male',value:'--.generic.male'},{key:'female',value:'--.generic.female'}],
            disabled: function () {
                return $scope.loading;
            },
            field:(account.male)?'male':'female'

        },
        language:{
            name:'language',
            fieldTitle: "--.generic.yourLanguage",
            options:languages,
            disabled: function () {
                return $scope.loading;
            },
            field:angular.copy(account.language)

        },
        firstname: {
            name:'firstname',
            fieldTitle: "--.generic.firstname",
            validationRegex: "^.{2,50}$",
            validationMessage: ['--.generic.validation.size', '2', '50'],
            disabled: function () {
                return $scope.loading;
            },
            field:angular.copy(account.firstname)
        },
        lastname: {
            name:'lastname',
            fieldTitle: "--.generic.lastname",
            validationRegex: "^.{2,50}$",
            validationMessage: ['--.generic.validation.size', '2', '50'],
            disabled: function () {
                return $scope.loading;
            },
            field:angular.copy(account.lastname)
        },
        openSession:{
            fieldTitle: "--.registration.form.keepSessionOpen",
            disabled: function () {
                return $scope.loading;
            },
            field:angular.copy(account.keepSessionOpen)
        },
        login: {
            fieldType:"email",
            name:'email',
            fieldTitle: "--.generic.email",
            disabled: function () {
                return true;
            },
            field:angular.copy(account.email),
            isValid:true
        },
        password: {
            name: 'password',
            fieldTitle: "--.registration.form.password",
            fieldType: 'password',
            disabled: function () {
                return true;
            },
            field:'********',
            isValid:true
        }
    };

    $scope.close = function () {
        $modalInstance.close();
    };

    $scope.allFieldValid = function () {

        var validation = true;

        for (var key in $scope.fields) {
            var obj = $scope.fields[key];
            console.log(obj);
            if ($scope.fields.hasOwnProperty(key) && (obj.isValid == null || obj.isValid === false)) {
                obj.firstAttempt = false;
                validation= false;
            }
        }
        return validation;
    };

    $scope.save = function () {

        if ($scope.allFieldValid()) {
            var dto = {
                male:($scope.fields.gender.field=='male'),
                firstname:$scope.fields.firstname.field,
                lastname:$scope.fields.lastname.field,
                email:$scope.fields.login.field,
                keepSessionOpen:$scope.fields.openSession.field,
                languageCode:$scope.fields.language.field
            }

            $scope.loading = true;

            $http({
                'method': "PUT",
                'url': "/account/"+account.id,
                'headers': "Content-Type:application/json",
                'data': dto
            }).success(function (data, status) {
                $scope.loading = false;
                $scope.close();
                //TODO setEmail(data.email);
            })
                .error(function (data, status) {
                    $scope.loading = false;
                    $flash.error(data.message);
                });
        }
    }

    $scope.editEmail = function(){
        var resolve = {
            account: function () {
                return account;
            },
            setEmail:function(){
                return null;
            }
        };
        $modal.open({
            templateUrl: "/assets/javascripts/modal/ChangeEmail/view.html",
            controller: "ChangeEmailModalCtrl",
            size:"l",
            resolve: resolve
        });
    }

    $scope.editPassword = function(){
        var resolve = {
            account: function () {
                return account;
            }
        };
        $modal.open({
            templateUrl: "/assets/javascripts/modal/ChangePassword/view.html",
            controller: "ChangePasswordModalCtrl",
            size:"l",
            resolve: resolve
        });
    }

});