angular.module('interviewerApp')
.controller('utilController',['$http','$scope','InterviewerUtilService',function($http,$scope,InterviewerUtilService){
		
		$scope.interviewer = {};
		$scope.expertese = [];
		$scope.techSkills={
				"Languages":["C","C++","JAVA","Python","C#","Perl"],
				"SouceControlTools":["Git","Clear Case","SVN"],
				"WebTechnologies" :["html","css","Jquery","JSP","Angular JS","node.js","backbonejs","Ruby on Rails"],
				"OperatingSystems":["Windows","Linux","Solaris","Unix","IBM","Redhat"]
			};
		
		$scope.addInterviewer = function()
		{
			$scope.interviewer['expertese'] = $scope.expertese.join(',');;
			InterviewerUtilService.setInterviewer($scope.interviewer);
			InterviewerUtilService.addInterviewer().
			then(function(data){
				$scope.interviewer = {};
			},
			function(errResponse){
                console.error('Error while creating User');
            }
			);
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
			InterviewerUtilService.getAllInterviewers()
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
			if(angular.equals($scope.searchCriteria, "searchByExpertese"))
				$scope.param = $scope.param.split(' ').join('%');
			console.log($scope.param);
			InterviewerUtilService.retrivebySearch($scope.searchCriteria, $scope.param);
		};
		
	}]);