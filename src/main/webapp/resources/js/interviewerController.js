(function(){

	var interviwer = angular.module("interviewer",[]);
	
	/*
	 * Controller handling requesting from view and passing into service
	 */
	
	interviwer.controller("utilController",function($http,$scope,utilService){
		
		$scope.id = null;
		$scope.name = null;
		$scope.role = null;
		$scope.mail = null;
		$scope.expertese = null;
		$scope.id = null;
		$scope.techSkills={
				"Languages":["C","C++","JAVA","Python","C#","Perl"],
				"SouceControlTools":["Git","Clear Case","SVN"],
				"WebTechnologies" :["html","css","Jquery","JSP","Angular JS","node.js","backbonejs","Ruby on Rails"],
				"OperatingSystems":["Windows","Linux","Solaris","Unix","IBM","Redhat"]
			};
		
		$scope.addInterviewer = function()
		{
			var interviewer = {
				id : $scope.id,
				name: $scope.name,
				role: $scope.mail,
				expertese : $scope.expertese
			};
			utilService.setInterviewer(interviewer);
			utilService.addInterviewer();
		};
		
		$scope.getEmp = function()
		{
			$scope.dbInterviewers = utilService.getInterviewersfromRepo();
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
		
		$scope.selInterviewer = function(interviewer){
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
			$http.post($scope.baseUrl+'/'+$scope.searchCriteria,$scope.param)
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
	
	interviewer.factory("utilService",function()
	{
		var datafunctions = {};
		this.interviewer = null;
		datafunctions.clearAll =function(){
			this.interviwer = null;
		};
		datafunctions.setInterviewer = function(interviewer)
		{
			this.interviewer = interviewer;
		};
		datafunctions.getInterviewer = function()
		{
			return this.interviewer;
		};
		
		/*
		 * API to handle adding interviewer into the list
		 * */
		datafunctions.addInterviewer = function()
		{
			var interviewer = datafunctions.getInterviewer();
			$http.post($scope.baseUrl+'/addInterviewer',interviewer)
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
		datafunctions.getInterviewersfromrepo = function(interviewerId)
		{
			$http.post($scope.baseUrl+'/retrieveAllInterviewers')
			.then(
					function(response) 
					{
						console.log("Retrieved interviewers");
						console.log(response.data);
						$scope.AllInterviewers = response.data;
					},
					function(errResponse){
						console.error('Error reaching the url /retrieveAllInterviewers specified');
					});
		};//end of getInterviewersfromrepo
			
	});//end of util service
	
});//end of function