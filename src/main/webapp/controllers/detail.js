'use strict';

angular.module('test').controller('DetailCtrl', function ($scope, $routeParams, test) {

        $scope.load = function() {
            test.get($routeParams.id, function (list) {
                $scope.details = list.data;
            })
            ;
        }
        $scope.form = {};
        $scope.load();
    });
