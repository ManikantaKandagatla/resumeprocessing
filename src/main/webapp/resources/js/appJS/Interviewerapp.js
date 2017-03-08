'use strict';

var interviewerApp = angular.module('interviewerApp',['ngRoute','ui.router']);

interviewerApp.run(function($rootScope, $state) {
    $rootScope.$on('$stateChangeStart',
        function(event, toState, toParams, fromState, fromParams) {
            window.scrollTo(0, 0);
        });
});