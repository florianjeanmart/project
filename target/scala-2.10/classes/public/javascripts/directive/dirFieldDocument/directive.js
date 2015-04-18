myApp.directive("dirFieldDocument", function(directiveService, $upload, $flash, $filter,generateId,$window) {
    return {
        restrict: "E",
        scope: directiveService.autoScope({
            ngInfo: '='
        }),
        templateUrl: "/assets/javascripts/directive/dirFieldDocument/template.html",
        replace: true,
        transclude: true,
        compile: function () {
            return {
                pre: function (scope) {
                    return directiveService.autoScopeImpl(scope);
                },
                post: function (scope) {
                    directiveService.autoScopeImpl(scope);

                    scope.id = generateId.generate();
                    scope.errorMessage = "";


                    scope.isValid = function () {
                        scope.getInfo().isValid = scope.getInfo().field!=null;
                    }

                    scope.isValid();

                    scope.displayError = function () {
                        if (scope.getInfo().isValid == false && scope.getInfo().firstAttempt === false) {
                            return true;
                        }
                        return false;
                    };


                    scope.inDownload = false;
                    scope.percent = 0;
                    scope.$watch('percent', function() {
                        var _ref;
                        return scope.style = {
                            "width": scope.percent + "%",
                            "color": (_ref = scope.percent > 50) != null ? _ref : {
                                "white": "black"
                            }
                        };
                    });

                    scope.download = function(){
                      if(scope.getInfo().field!=null){
                          var url = "/rest/file/"+scope.getInfo().field.id;
                          $window.open(url);
                      }
                    };

                    scope.onFileSelect = function($files) {
                        var file, i;
                        scope.inDownload = true;
                        i = 0;
                        while (i < $files.length) {
                            file = $files[i];


                            scope.upload = $upload.upload({
                                url: "/rest/file/",
                                data: {
                                    myObj: scope.myModelObj
                                },
                                file: file
                            }).progress(function(evt) {
                                scope.percent = parseInt(100.0 * evt.loaded / evt.total);
                            }).success(function (data, status) {
                                scope.percent = 100.0;
                                scope.getInfo().field = data;
                                scope.inDownload=false;
                            })
                                .error(function (data, status) {
                                    scope.percent = 0;
                                    scope.inDownload = false;
                                    $flash.error(data.message);
                                });
                            /*
                            scope.upload = $upload.upload({
                                url: "/rest/file/",
                                data: {
                                    myObj: scope.myModelObj
                                },
                                file: file
                            }).progress(function(evt) {
                                scope.percent = parseInt(100.0 * evt.loaded / evt.total);
                            }).success(function(data, status, headers, config) {
                                var fileName;
                                scope.percent = 0;
                                scope.inDownload = false;
                                fileName = data.name;
                                //$flash.error('FILE_UPLOAD_SUCCESS');
                                if (scope.getAnswer().value === null || scope.getAnswer().value === void 0) {
                                    scope.getAnswer().value = {};
                                }
                                scope.getAnswer().value[data.id] = data.name;
                                //scope.$parent.edited();
                            }).error(function(data, status, headers, config) {
                                scope.percent = 0;
                                scope.inDownload = false;
                                //$flash.error('FILE_UPLOAD_FAIL');
                            });
                            */
                            i++;
                        }
                    };




                    /*
                    scope.getDisabled = function() {
                        return scope.$parent.isDisabled();
                    };
                    scope.getQuestionCode = function() {
                        return scope.$parent.getQuestionCode();
                    };
                    scope.getAnswer = function() {
                        return scope.$parent.getAnswer(scope.getDataToCompare());
                    };
                    if (scope.getDataToCompare() === false && scope.getIsAggregation() === false) {
                        scope.$watch('getAnswer().value', function(o, n) {
                            if ("" + n !== "" + o) {
                                return scope.$parent.edited();
                            }
                        });
                    }
                    *//*
                    scope.inDownload = false;
                    scope.percent = 0;
                    scope.$watch('percent', function() {
                        var _ref;
                        return scope.style = {
                            "width": scope.percent + "%",
                            "color": (_ref = scope.percent > 50) != null ? _ref : {
                                "white": "black"
                            }
                        };
                    });
                    /*
                    scope.getDisabled = function() {
                        return scope.$parent.isDisabled();
                    };
                    *//*
                    scope.openDocumentManager = function() {
                        var args;
                        if (scope.getAnswer() !== null) {
                            args = {};
                            args.listDocuments = scope.getAnswer().value;
                            args.readyOnly = scope.getDataToCompare() === true || scope.getIsAggregation() === true || scope.getDisabled() === true;
                            args.wasEdited = function() {
                                return scope.$parent.edited();
                            };
                            return modalService.show(modalService.DOCUMENT_MANAGER, args);
                        }
                    };
                    scope.getFileNumber = function() {
                        if (scope.getInfo().field === null ||  scope.getInfo().field === void 0) {
                            return 0;
                        }
                        return Object.keys(scope.getInfo().field).length;
                    };
                    return scope.onFileSelect = function($files) {
                        var file, i;
                        scope.inDownload = true;
                        i = 0;
                        while (i < $files.length) {
                            file = $files[i];
                            scope.upload = $upload.upload({
                                url: "/awac/file/upload/",
                                data: {
                                    myObj: scope.myModelObj
                                },
                                file: file
                            }).progress(function(evt) {
                                scope.percent = parseInt(100.0 * evt.loaded / evt.total);
                            }).success(function(data, status, headers, config) {
                                var fileName;
                                scope.percent = 0;
                                scope.inDownload = false;
                                fileName = data.name;
                                //$flash.error('FILE_UPLOAD_SUCCESS');
                                if (scope.getAnswer().value === null || scope.getAnswer().value === void 0) {
                                    scope.getAnswer().value = {};
                                }
                                scope.getAnswer().value[data.id] = data.name;
                                //scope.$parent.edited();
                            }).error(function(data, status, headers, config) {
                                scope.percent = 0;
                                scope.inDownload = false;
                                //$flash.error('FILE_UPLOAD_FAIL');
                            });
                            i++;
                        }
                    };
                    */
                }
            };
        }
    };
});