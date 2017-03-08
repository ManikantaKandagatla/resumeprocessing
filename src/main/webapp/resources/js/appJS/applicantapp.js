'use strict';

var applicantApp = angular.module('applicantApp',['ngRoute','ui.router']);

applicantApp.run(function($rootScope, $state) {
    $rootScope.$on('$stateChangeStart',
        function(event, toState, toParams, fromState, fromParams) {
            window.scrollTo(0, 0)
        })
});
