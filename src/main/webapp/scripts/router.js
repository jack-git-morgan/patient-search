
var app = angular.module('patientSearch', ['ui.router', 'ngToast']);
app.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

        var masterState = {
            name: 'search',
            controller: 'patientSearchController',
            url: '/search',
            templateUrl: 'pages/patient-search.html'
        };

        $stateProvider.state(masterState);
        $urlRouterProvider.otherwise('/search');
    }]);
