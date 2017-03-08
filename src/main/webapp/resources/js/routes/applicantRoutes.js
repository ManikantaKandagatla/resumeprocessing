'use strict';

angular.module('applicantApp')
.config(function($stateProvider, $urlRouterProvider){
	$urlRouterProvider.otherwise('/newApplicant');
	
	$stateProvider
	.state('new', {
		url: '/newApplicant',
		templateUrl: 'resources/templates/newApplicant.html'
	})
	
	.state('search',{
		url :'/searchApplicant',
		templateUrl: 'resources/templates/searchApplicant.html'	
	})
	
	.state('selectedApplicant',{
		url : '/selectedApplicant/:id',
		templateUrl: 'resources/templates/selectedApplicant.html'
	});

});