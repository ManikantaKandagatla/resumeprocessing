'use strict';

angular.module('interviewerApp')
.factory('InterviewerUtilService',['$http','$q',function($http,$q)
	{
		var datafunctions = {};
		this.interviewer = null;
		datafunctions.clearAll =function(){
			this.interviwer = null;
		};
		
		var baseUrl = "/resumeprocessing";
		
		datafunctions.setInterviewer = function(interviewer){
			this.interviewer = interviewer;
		};
		
		datafunctions.getInterviewer = function(){
			return this.interviewer;
		};
		
		/*
		 * API to handle adding interviewer into the list
		 * */
		datafunctions.addInterviewer = function()
		{
			var defer = $q.defer();
			var interviewer = datafunctions.getInterviewer();
			var formData = new FormData();
			formData.append('interviewer', JSON.stringify(interviewer));
			$http.post(baseUrl+'/addInterviewer',formData,{ transformRequest: angular.identity, headers: {'Content-Type': undefined} })
			.then(
					function(response) 
					{
						console.log("interviewer details stored..!!!!!!!!!!!!");
						datafunctions.clearAll();
						defer.resolve(response.data);
					},
					function(errResponse){
						defer.reject(response.data);
						console.error('Error reaching the url /addInterviewer  specified');
					}
				);
			return defer.promise;
		};//end of addInterviewer
		
		
		/*
		 * API to handle retrieving interviewers from the repository
		 * */
		datafunctions.getAllInterviewers = function()
		{
			var defer = $q.defer();
			$http.get(this.baseUrl+'/retrieveAllInterviewers')
			.then(
					function(response) 
					{
						console.log("Retrieved interviewers");
						console.log(response.data);
						defer.resolve(response.data);
					},
					function(errResponse){
						defer.reject(response.data);
						console.error('Error reaching the url /retrieveAllInterviewers specified');
					});
			return defer.promise;
		};//end of getAllInterviewers
		
		datafunctions.retrivebySearch = function(searchCriteria,param)
		{
			console.log("Searching initiated...!!!!");
			if(angular.equals(searchCriteria, "search By Expertese"))
				param = param.split(' ').join('%');
			console.log($scope.param);
			$http.get(baseUrl+'/'+searchCriteria,param)
			.then(
					function(response) 
					{
						console.log("Retrieved some entries...!!!!");
						$scope.AllInterviewers = response.data;
						console.log($scope.Allemps);
						$scope.ViewAll = true;
						$scope.showsearchdiv = false;
						$scope.editDiv = false;
					},
					function(errResponse){
						console.error('Error reaching the url specified');
					}
					
			);
		};
		
		
		return datafunctions;	
	}]);//end of util service