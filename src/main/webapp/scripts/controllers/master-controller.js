
var app = angular.module("birthApp");

app.controller("masterController", ["$scope", "$http", "$rootScope", "$state", "$transitions", function ($scope, $http, $state)
    {
        $http.get("/api/resource/default_request").then(function (result) {
            console.log("result", result);
        }, function (error) {
            console.log("error", error);
        });
    }
]);

