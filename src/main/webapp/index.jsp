
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Patient Search</title>

        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="css/ngToast.css">
        <link rel="stylesheet" href="css/ngToast-animations.css">
        <link rel="stylesheet" href="css/nhsd-frontend.css" media="screen" type="text/css"/>

        <link rel="icon" href="./images/nhs_logo.svg">
        
        <script type="text/javascript" src="scripts/libs/angular.js"></script>
        <script type="text/javascript" src="scripts/libs/angular-route.js"></script>
        <script type="text/javascript" src="scripts/libs/angular-sanitize.js"></script>
        <script type="text/javascript" src="scripts/libs/angular-ui-router.js"></script>
        <script type="text/javascript" src="scripts/libs/angular-resource.js"></script>
        <script type="text/javascript" src="scripts/libs/ngToast.min.js"></script>

        <script type="text/javascript" src="scripts/router.js"></script>
        <script type="text/javascript" src="scripts/controllers/patient-search-controller.js"></script>

        <script src="components/menu-component/menu-component-controller.js"></script>
        <script type="text/javascript" src="scripts/services/toast-service.js"></script>
    </head>

    <toast></toast>
    <body ng-app="patientSearch">
        <div>
            <div>
                <menu-component title="Patient Search"></menu-component>
            </div>
            <div>
                <div ui-view></div>
            </div>
        </div>
    </body>
</html>

