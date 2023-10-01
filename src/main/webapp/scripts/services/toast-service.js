
var app = angular.module("birthApp");

app.service('toastService', function (ngToast) {

    this.openToast = function (textContent) {

        var content = textContent;

        ngToast.create({
            content: content
        });
    };
});