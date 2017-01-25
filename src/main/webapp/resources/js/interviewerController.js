(function(){

	var interviewerApp = angular.module("interviewerApp",[]);
	
	/*
	 * Controller handling requesting from view and passing into service
	 */
	
	interviewerApp.controller("utilController",function($http,$scope,utilService){
		
		$scope.interviewer = {};
		$scope.expertese = [];
		$scope.baseUrl = '/resumeprocessing';
		$scope.techSkills={
				"Languages":["C","C++","JAVA","Python","C#","Perl"],
				"SouceControlTools":["Git","Clear Case","SVN"],
				"WebTechnologies" :["html","css","Jquery","JSP","Angular JS","node.js","backbonejs","Ruby on Rails"],
				"OperatingSystems":["Windows","Linux","Solaris","Unix","IBM","Redhat"]
			};
		
		$scope.init = function(){
			utilService.setBaseUrl($scope.baseUrl);
		}
		
		$scope.addInterviewer = function()
		{
			$scope.interviewer['expertese'] = $scope.expertese.join(',');;
			utilService.setInterviewer($scope.interviewer);
			utilService.addInterviewer();
		};
		
		$scope.getEmp = function()
		{
			$scope.dbInterviewers = utilService.getInterviewersfromRepo();
		};
		
		$scope.dispAllInterviewers = function()
		{
			console.log("Retrieving all emps");
			$scope.toAdd  = false;
			$scope.ViewAll = true;
			$scope.showsearchdiv = false;
			$scope.ViewSelected = false;
			$scope.editDiv=false;
			$scope.AllInterviewers = [];
			console.log($scope.AllInterviewers);
			utilService.getAllInterviewers()
			.then(
					function(allInterviewers){
						$scope.AllInterviewers = allInterviewers;
					},
					function(errResponse)
					{
					
					});
			console.log($scope.AllInterviewers);
		};
		
		$scope.selInterviewer = function(interviewer)
		{
			$scope.selInterviewer=interviewer;
			$scope.ViewAll=false;
			$scope.ViewSelected = true;
		};
		
		$scope.toggleSelection = function(skillname)
		{
			var index = $scope.expertese.indexOf(skillname);
			if(index >-1)
				$scope.expertese.splice(index,1);
			else $scope.expertese.push(skillname);
			console.log($scope.expertese);
			
			if(angular.equals($scope.searchCriteria, "searchByExpertese"))
			{
				$scope.param = $scope.expertese.join(' ');
			}
		};
		
		
		$scope.searchdiv = function()
		{
			console.log("Searching function");
			$scope.showsearchdiv = true;
			$scope.ViewAll = false;
			$scope.ViewSelected = false;
			
		};
		
		$scope.CheckforSkills =  function()
		{
			$scope.param = '';
			$scope.expertese = [];
			if(angular.equals($scope.searchCriteria, "search By Expertese"))
					$scope.showsearchskills = true;
			else $scope.showsearchskills = false;
		};
		
		$scope.restoreViewAll = function(){
			$scope.ViewAll=true;
			$scope.ViewSelected = false;
		};
		
		$scope.DetailInterviewer = function(interviewer){
			$scope.selInterviewer = interviewer;
			$scope.ViewAll = false;
			$scope.ViewSelected = true;
		};
		
		$scope.retrivebySearch = function()
		{
			console.log("Searching initiated...!!!!");
			if(angular.equals($scope.searchCriteria, "search By Expertese"))
				$scope.param = $scope.param.split(' ').join('%');
			console.log($scope.param);
			$http.get($scope.baseUrl+'/'+$scope.searchCriteria,$scope.param)
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
		
		
		
	});//end of utilcontroller
	
	/*
	 * Angular factory providing calls to java application
	 */
	
	interviewerApp.factory("utilService",function($http,$q)
	{
		var datafunctions = {};
		this.interviewer = null;
		datafunctions.clearAll =function(){
			this.interviwer = null;
		};
		
		datafunctions.setBaseUrl = function(baseUrl){
			this.baseUrl = baseUrl;
		};
		
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
			var interviewer = datafunctions.getInterviewer();
			var formData = new FormData();
			formData.append('interviewer', JSON.stringify(interviewer));
			$http.post(this.baseUrl+'/addInterviewer',formData,{ transformRequest: angular.identity, headers: {'Content-Type': undefined} })
			.then(
					function(response) 
					{
						console.log("interviewer details stored..!!!!!!!!!!!!");
						datafunctions.clearAll();
					},
					function(errResponse){
						console.error('Error reaching the url /addInterviewer  specified');
					}
				);
		};//end of addInterviewer
		
		
		/*
		 * API to handle retrieving interviewers from the repository
		 * */
		datafunctions.getAllInterviewers = function(interviewerId)
		{
			var defer = $q.defer();
			$http.get(this.baseUrl+'/retrieveAllInterviewers')
			.then(
					function(response) 
					{
						console.log("Retrieved interviewers");
						console.log(response.data);
						defer.resolve(response.data);
						this.AllInterviewers = response.data;
					},
					function(errResponse){
						defer.reject(response.data);
						this.AllInterviewers = [];
						console.error('Error reaching the url /retrieveAllInterviewers specified');
					});
			return defer.promise;
		};//end of getAllInterviewers
		return datafunctions;	
	});//end of util service
	
})();//end of function