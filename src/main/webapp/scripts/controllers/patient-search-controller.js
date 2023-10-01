
var app = angular.module("patientSearch");

app.controller("patientSearchController", ["$scope", "$http", "toastService", function ($scope, $http, toastService)
    {
        $scope.loading = false;
        $scope.searchComplete = false;
        $scope.patientsFound = [];
        $scope.selectedPatient = {};

        $scope.searchRequest = {
            dateOfBirth: {
                day: 0,
                month: 0,
                year: 0
            },
            nhsNumber: "",
            familyName: "",
            givenName: ""
        };

        $scope.search = function () {

            $scope.loading = true;

            var dob = $scope.searchRequest.dateOfBirth;

            dob.day = !dob.day ? 0 : dob.day;
            dob.month = !dob.month ? 0 : dob.month;
            dob.year = !dob.year ? 0 : dob.year;

            var validDate = true;
            var dobSupplied = false;

            if (dob.day > 0 || dob.month > 0 || dob.year > 0) {

                if (dob.day == 0 || dob.month == 0 || dob.year == 0) {
                    validDate = false;
                }

                if (dob.day.length != 2 || dob.month.length != 2 || dob.year.length != 4) {
                    validDate = false;
                }

                if (validDate) {
                    dobSupplied = true;
                }
            }

            if (!validDate) {
                toastService.openToast("Date provided is invalid. Date must be supplied in the following format DD-MM-YYYY");
                $scope.loading = false;
                return;
            }

            if ($scope.searchRequest.nhsNumber != null && $scope.searchRequest.nhsNumber.trim().length > 0) {

                const isNumbersOnly = /^\d+$/.test($scope.searchRequest.nhsNumber);

                if (!isNumbersOnly) {
                    toastService.openToast("NHS number can only contain digits");
                    $scope.loading = false;
                    return;
                }

                if ($scope.searchRequest.nhsNumber.trim().length != 10) {
                    toastService.openToast("NHS number must be 10 digits long");
                    $scope.loading = false;
                    return;
                }
            }

            if (!dobSupplied && (($scope.searchRequest.nhsNumber == null || $scope.searchRequest.nhsNumber.trim().length == 0) &&
                    ($scope.searchRequest.familyName == null || $scope.searchRequest.familyName.trim().length == 0) &&
                    ($scope.searchRequest.givenName == null || $scope.searchRequest.givenName.trim().length == 0))) {

                toastService.openToast("No search terms provided. You must provide at least one search value");
                $scope.loading = false;

            } else {
                $http.post("/api/resource/search_patients", $scope.searchRequest).then(function (result) {

                    $scope.loading = false;
                    $scope.searchComplete = true;
                    $scope.patientsFound = result.data.entry != null ? result.data.entry : [];

                    angular.forEach($scope.patientsFound, function (patient, index) {
                        angular.forEach(patient.resource.identifier, function (id, key) {
                            if (id.system == 'https://fhir.nhs.uk/Id/nhs-number') {
                                patient.resource["nhsNumber"] = id.value;
                            }
                        });

                        var patientFamilyNames = "";
                        var patientGivenNames = "";

                        angular.forEach(patient.resource.name, function (names, index) {
                            patientFamilyNames += names.family.join(",");
                            patientGivenNames += names.given.join(",");
                        });

                        patient.resource["familyNames"] = patientFamilyNames;
                        patient.resource["givenNames"] = patientGivenNames;
                    });

                }, function (error) {
                    toastService.openToast(error.data.errorMessage);
                    $scope.loading = false;
                });
            }
        };

        $scope.setSelected = function (patientId) {
            $scope.selectedPatient = patientId;
        };
    }
]);

app.component('menuComponent', {
    templateUrl: 'components/menu-component/menu-component.html',
    controller: 'menuComponentController',
    bindings: {
        title: '@'
    }
});


