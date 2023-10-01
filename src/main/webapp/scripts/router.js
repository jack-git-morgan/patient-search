
var app = angular.module('birthApp', ['ui.router', 'ngToast']);
app.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

        var masterState = {
            name: 'master',
            controller: 'masterController',
            url: '/master',
            templateUrl: 'pages/master.html'
        };

        $stateProvider.state(masterState);
        $urlRouterProvider.otherwise('/master');
    }]);
