'use strict';

angular.module('test')
    .service('test', function ($http) {
        return {
            list: function (success) {
                return $http.get("/rest/test").then(success);
            },
            save: function (test, success) {
                return $http.post("/rest/test", test).then(success);
            }
            ,
            search: function (test, success) {
                return $http.get("/rest/test/search/" + test).then(success);
            },
            delete: function (id, success) {
                return $http.delete("/rest/test/" + id).then(success);
            },
            get: function (id, success) {
                return $http.get("/rest/test/" + id).then(success);
            }
        };
    });
