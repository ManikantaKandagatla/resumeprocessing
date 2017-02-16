'use strict';

angular.module('applicantApp')
.config(function($routeProvider){
	$routeProvider
	.when('/newApplicant', {
		templateUrl: 'resources/templates/newApplicant.html'
	})
	
	.when('/', {
		templateUrl: 'resources/templates/newApplicant.html'
	})
	
	.when('/searchApplicant',{
		templateUrl: 'resources/templates/searchApplicant.html'	
	})
	.otherwise({
	redirectTo: '/'});
});