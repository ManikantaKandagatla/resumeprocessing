'use strict';

angular.module('applicantApp')
.controller('mainController',['$http','applicantUtilService','$scope',function($http,$scope,applicantUtilService,$location,$sce){
	
	
	$scope.initEmp = function()
	{
		$scope.skillset=[];
		$scope.empobj = {};
		$scope.Allemps = [];
		$scope.newprojects = [];
		$scope.neweditprojects =[];
		$scope.employee={};
		$scope.empProjs = [];
		$scope.empProj = {};
	};
	
	$scope.skillset=[];
	$scope.empobj = {};
	$scope.Allemps = [];
	$scope.newprojects = [];
	$scope.neweditprojects =[];
	$scope.employee={};
	$scope.empProjs = [];
	$scope.empProj = {};
	
	$scope.projectscount = 0;
	$scope.baseUrl = '/resumeprocessing';
	/*$scope.skillset=[];
	$scope.empobj = {};
	$scope.Allemps = [];
	$scope.newprojects = [];
	$scope.neweditprojects =[];
	$scope.employee={};*/
	$scope.searchObj = {};
	$scope.showsearchdiv=false;
	$scope.showempResume = false;
	$scope.Viewall = false;
	$scope.ViewSelected = false;
	$scope.param ='';
	$scope.searchCriteria='search By Name';
	
	$scope.techSkills={
		"Languages":["C","C++","JAVA","Python","C#","Perl"],
		"SouceControlTools":["Git","Clear Case","SVN"],
		"WebTechnologies" :["html","css","Jquery","JSP","Angular JS","node.js","backbonejs","Ruby on Rails"],
		"OperatingSystems":["Windows","Linux","Solaris","Unix","IBM","Redhat"]
	};
	$scope.qualification = ["B.Tech","M.Tech","B.Sc. Computers","Other"];
	$scope.addApplicant= function(empobj,empProjs,addedprojs)
	{
		console.log("init");
		empobj['skillset'] = $scope.skillset.join(',');
		$scope.employee['emp'] = empobj;
		empProjs= empProjs.concat(addedprojs);
		$scope.setAllProjectsContactandId(empProjs,empobj.contact);
		$scope.employee['projects'] = empProjs;
		console.log($scope.employee);
		var input = document.getElementById('resume');
		var formData = new FormData();
		formData.append('employee', JSON.stringify($scope.employee));
        formData.append('resume', input.files[0]);
		
        applicantUtilService.addApplicant(formData)
		.then(
				function(response) 
				{
					console.log("employee details stored..!!!!!!!!!!!!");
					$scope.initEmp();
					empobj= {};
					addedprojs=[];
					$scope.skillset = [];
					empProjs = [];
					$scope.employee = {};
					projectcount=1;
				},
				function(errResponse){
					console.error('Error reaching the url /addEmp  specified');
				}
			);
	};	


	$scope.dispAllemp = function()
	{
		console.log("Retrieving all emps");
		$scope.toAdd  = false;
		$scope.ViewAll = true;
		$scope.showsearchdiv = false;
		$scope.ViewSelected = false;
		$scope.editDiv=false;
		applicantUtilService.getAllApplicants()
		.then(
				function(response) 
				{
					console.log("Retrieved applicants");
					console.log(response.data);
					$scope.Allemps = response.data;
				},
				function(errResponse){
					console.error('Error reaching the url /retrieveAllapplicants specified');
				});
		
	};
	
	$scope.deleteEmployee = function(id)
	{
		console.log("deleting the choosen id" +id);
		$http.post($scope.baseUrl+'/deleteEmployee',id)
		.then(
				function(response) 
				{
					console.log("Deleted choosen id successfully...!!!!!!!");
				},
				function(errResponse){
					console.error('Error reaching the url /deleteEmployee specified');
				});
	};
	
	
	$scope.editEmployee = function(id)
	{
		console.log("In edit module..!!!");
		$http.post($scope.baseUrl+'/editEmployee',id)
		.then(
				function(response) 
				{
					console.log("Actual details of employee obtained.....!!!!! you can update them..");
					$scope.employee= response.data;
					$scope.skillset =  $scope.employee.emp.skillset.split(',');
					$scope.editdiv = true; 
					$scope.ViewSelected = false;
					projectcount = 0;
					console.log(projectcount);
					console.log($scope.skillset);
				},
				function(errResponse){
					console.error('Error reaching the url /editEmployee specified');
				});
		
	};
	
	
	$scope.setAllProjectsContactandId = function(projects,contact){
		angular.forEach(projects,function(project){
			project.contact = contact;
			project.Id = '';
		});
		console.log(projects);
	};
	
	
	$scope.toggleSelection = function(skillname)
	{
		var index = $scope.skillset.indexOf(skillname);
		if(index >-1)
			$scope.skillset.splice(index,1);
		else $scope.skillset.push(skillname);
		console.log($scope.skillset);
		
		if(angular.equals($scope.searchCriteria, "searchBySkillset"))
		{
			$scope.param = $scope.skillset.join(' ');
		}
	};
	
	$scope.selectAll = function()
	{
		$scope.selected = [];
		console.log("selecting all");
		 angular.forEach($scope.techSkills, function (item) {
            item.Selected = true;
			$scope.skillset.push(item.skillname);
        });

	};
	
	$scope.clearAll = function()
	{
		console.log("selecting all");
		 angular.forEach($scope.techSkills, function (item) {
            item.Selected = false;
		$scope.selected = [];
        });
		
	};
	
	$scope.searchdiv = function()
	{
		console.log("Searching function");
		$scope.showsearchdiv = true;
		$scope.ViewAll = false;
		$scope.ViewSelected = false;
		
	};
	
	$scope.retrivebySearch = function()
	{
		console.log("Searching initiated...!!!!");
		if(angular.equals($scope.searchCriteria, "searchBySkillset"))
			$scope.param = $scope.param.split(' ').join(',');
		console.log($scope.param);
		applicantUtilService.retrivebySearch($scope.searchCriteria,$scope.param)
		.then(
				function(response) 
				{
					console.log("Retrieved some entries...!!!!");
					$scope.Allemps = response.data;
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
	
	$scope.CheckforSkills =  function()
	{
		$scope.param = '';
		$scope.skillset = [];
		if(angular.equals($scope.searchCriteria, "searchBySkillset"))
				$scope.showsearchskills = true;
		else $scope.showsearchskills = false;
	};
	
	$scope.selEmp = function(emp){
		$scope.selemp=emp;
		$scope.ViewAll=false;
		$scope.ViewSelected = true;
	};
	
	$scope.restoreViewAll = function(){
		$scope.ViewAll=true;
		$scope.ViewSelected = false;
	};
	
	$scope.isAskill = function(skillname){
		var index = $scope.skillset.indexOf(skillname);
		if(index >-1)
			return true;
		else 
			return false;
	};
	
	$scope.ViewResume = function(id){
		console.log(id);
		$http.get($scope.baseUrl+'/getEmpResume/'+id,{responseType:'arraybuffer'}).then(
				
				function(response) 
				{
					console.log("Retrieved Employee Resume...!!!!");
					var file = new Blob([response.data], {type: 'application/pdf'});
					var fileURL = URL.createObjectURL(file);
					var a         = document.createElement('a');
					a.href        = fileURL; 
					a.target      = '_blank';
					document.body.appendChild(a);
					a.click();
				},
				function(errResponse){
					console.error('Error reaching the url /getEmpResume specified');
				}
		);
		
	};
}]);
