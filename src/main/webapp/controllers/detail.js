'use strict';

angular.module('test').controller('DetailCtrl', function ($scope, test) {

        $scope.load = function() {
            test.list(function (list) {
                $scope.list = list.data;
            });
        }
        $scope.form = {};
        $scope.load();
    });
