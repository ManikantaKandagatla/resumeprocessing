'use strict';

angular.module('applicantApp')
.factory('applicantUtilService',['$http','$q',function($http,$q){
	var datafunctions = {};
	
	var baseUrl = '/resumeprocessing';
	
	datafunctions.addApplicant = function(formData)
	{
		var defer = $q.defer();
		$http.post(baseUrl+'/addApplicant',formData, { transformRequest: angular.identity, headers: {'Content-Type': undefined} })
		.then(
				function(response) 
				{
					console.log("employee details stored..!!!!!!!!!!!!");
					defer.resolve(response.data);
				},
				function(errResponse){
					defer.reject(response.data);
					console.error('Error reaching the url /addEmp  specified');
				}
			);
		return defer.promise;
	};
	
	datafunctions.getAllApplicants = function()
	{
		var defer = $q.defer();
		$http.get(baseUrl+'/retrieveAllApplicants')
		.then(
				function(response) 
				{
					console.log("Retrieved applicants");
					console.log(response.data);
					defer.resolve(response.data);
				},
				function(errResponse){
					defer.reject(response.data);
					console.error('Error reaching the url /retrieveAllEmps specified');
				});
		return defer.promise;
	};//end of getAllapplicants
	
	datafunctions.retrivebySearch = function(searchCriteria, param)
	{
		var defer = $q.defer();
		$http.get(baseUrl+'/'+ searchCriteria+'/'+ param)
		.then(
				function(response) 
				{
					console.log("Retrieved some entries...!!!!");
					defer.resolve(response.data);
				},
				function(errResponse){
					defer.reject(response.data);
					console.error('Error reaching the url specified');
				});
		return defer.promise;
	};
	
	datafunctions.getApplicantResume = function(applicantId)
	{
		var defer = $q.defer();
		$http.get(baseUrl+'/getApplicantResume/'+applicantId,{responseType:'arraybuffer'})
		.then(
				function(response) 
				{
					console.log("Retrieved Employee Resume...!!!!");
					defer.resolve(response.data);
				},
				function(errResponse){
					defer.reject(response.data);
					console.error('Error reaching the url /getApplicantResume specified');
				});
		return defer.promise;
	};
	return datafunctions;
}]);