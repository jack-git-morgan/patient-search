
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>...</title>

        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="css/ngToast.css">
        <link rel="stylesheet" href="css/ngToast-animations.css">


        <script type="text/javascript" src="scripts/libs/angular.js"></script>
        <script type="text/javascript" src="scripts/libs/angular-route.js"></script>
        <script type="text/javascript" src="scripts/libs/angular-sanitize.js"></script>
        <script type="text/javascript" src="scripts/libs/angular-ui-router.js"></script>
        <script type="text/javascript" src="scripts/libs/angular-resource.js"></script>
        <script type="text/javascript" src="scripts/libs/ngToast.min.js"></script>

        <script type="text/javascript" src="scripts/router.js"></script>
        <script type="text/javascript" src="scripts/controllers/master-controller.js"></script>
        
        <script type="text/javascript" src="scripts/services/toast-service.js"></script>
    </head>
    
    <toast style='z-index: 99999999999'></toast>
    <body ng-app="birthApp" >
        <div>
            <div>
                <menu-component></menu-component>
            </div>
            <div id='top'>
                <div ui-view></div>
            </div>
        </div>
    </body>
</html>

