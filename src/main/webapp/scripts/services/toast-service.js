
var app = angular.module("patientSearch");

app.service('toastService', function (ngToast) {

    this.openToast = function (textContent) {

        var content = '<div class="nhsd-m-emphasis-box nhsd-m-emphasis-box--warning nhsd-!t-margin-bottom-6">  <div class="nhsd-a-box nhsd-a-box--border-red"><div class="nhsd-m-emphasis-box__icon-box"></div><div class="nhsd-m-emphasis-box__content-box"><h1 class="nhsd-t-heading-s nhsd-t-word-break">Warning box</h1><p class="nhsd-t-body-s nhsd-t-word-break">' + textContent + '.</p>    </div>  </div></div>';

        ngToast.create({
            content: content
        });
    };
});