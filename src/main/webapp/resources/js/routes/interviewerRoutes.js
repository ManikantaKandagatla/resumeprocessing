'use strict';

angular.module('interviewerApp')
.config(function($stateProvider, $urlRouterProvider){
	$urlRouterProvider.otherwise('/newInterviewer');
   
	$stateProvider

	.state('new', {
		url :'/newInterviewer',
		templateUrl: 'resources/templates/newInterviewer.html'
	})
	
	.state('search',{
		url :'/searchInterviewer',
		templateUrl: 'resources/templates/searchInterviewer.html'	
	})

	.state('scheduleInterview',{
		url : 'scheduleInterview',
		templateUrl: 'resources/templates/scheduleInterview.html'
	});
});