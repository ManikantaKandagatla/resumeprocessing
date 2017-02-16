'use strict';

angular.module('interviewerApp')
.config(function($routeProvider){
	$routeProvider
	.when('/newInterviewer', {
		templateUrl: 'resources/templates/newInterviewer.html'
	})
	
	.when('/', {
		templateUrl: 'resources/templates/newInterviewer.html'
	})
	
	.when('/searchInterviewer',{
		templateUrl: 'resources/templates/searchInterviewer.html'	
	})
	.otherwise({
	redirectTo: '/'});
});