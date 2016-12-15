(function(){
var empappobj = angular.module("empapp",[]);
var projectcount = 0;

empappobj.controller("mainController",function($http,$scope,EmpshowService,$location,$sce){
	
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
	$scope.searchCriteria='searchByName';
	
	$scope.techSkills={
		"Languages":["C","C++","JAVA","Python","C#","Perl"],
		"SouceControlTools":["Git","Clear Case","SVN"],
		"WebTechnologies" :["html","css","Jquery","JSP","Angular JS","node.js","backbonejs","Ruby on Rails"],
		"OperatingSystems":["Windows","Linux","Solaris","Unix","IBM","Redhat"]
	};
	$scope.qualification = ["B.Tech","M.Tech","B.Sc. Computers","Other"];
	$scope.addEmp= function(empobj,empProjs,addedprojs)
	{
		console.log("init");
		empobj['skillset'] = $scope.skillset.join(',');
		$scope.employee['emp'] = empobj;
		empProjs= empProjs.concat(addedprojs);
		$scope.setAllProjectsContactandId(empProjs,empobj.contact);
		console.log( empProjs);
		$scope.employee['projects'] = empProjs;
		console.log($scope.employee);
		var input = document.getElementById('resume');
		//console.log(input.files[0]);
		//console.log(JSON.stringify($scope.employee));
		var formData = new FormData();
		formData.append('employee', JSON.stringify($scope.employee));
        formData.append('resume', input.files[0]);
		
		//console.log(formData.getAll('employee'));
		//console.log(formData.getAll('resume'));
		
		$http.post($scope.baseUrl+'/addEmp',formData, { transformRequest: angular.identity, headers: {'Content-Type': undefined} })
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
		$http.post($scope.baseUrl+'/retrieveAllEmps')
		.then(
				function(response) 
				{
					console.log("Retrieved emps");
					console.log(response.data);
					$scope.Allemps = response.data;
				},
				function(errResponse){
					console.error('Error reaching the url /retrieveAllEmps specified');
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
			$scope.param = $scope.param.split(' ').join('%');
		console.log($scope.param);
		$http.post($scope.baseUrl+'/'+$scope.searchCriteria,$scope.param)
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
});


empappobj.controller("displayController" ,function($http,$scope,$routeParams,EmpshowService){
	
	$scope.employee = {};
	$scope.getEmpdata = function(){
		$scope.employee  = EmpshowService.getSelEmp();
		console.log("in init function");
		console.log($scope.selemp);
	};
	
});

empappobj.factory('EmpshowService', function() {
 
 var SelEmp = {};
 var selEmpforEdit = {};
 var editDiv = false;
 var datafunctions = {};
	datafunctions.setSelEmp = function(emp) {
	console.log("Storing employee!!!!!!!!!");
	SelEmp = emp;
	console.log(SelEmp);
 }
 
 datafunctions.getSelEmp = function() {
	console.log("getting employee!!!!!!!!!");
	console.log(SelEmp);
	return SelEmp;
 }
 
 
 return datafunctions;

});





empappobj.config(function($routeProvider) {  
    $routeProvider  
    .when('/showEmp', {  
        templateUrl: 'Employee.jsp',  
        controller: 'displayController'  
    })   
});  





empappobj.directive("addprojectsdiv", function(){
	return {
		restrict: "E",
		template: "<button adddivs class='button' ng-click='addToProjectArray()'>Add new Project</button>"
	}
});

//Directive for adding  projects
empappobj.directive("adddivs", function($compile){
	return function(scope, element, attrs){
		element.bind("click", function(){
			projectcount++;
			console.log("projectcount "+projectcount)
			angular.element(document.getElementById('projects-div')).append($compile("<div class='callout panel'><table width='100%'><tr><td><pre>project Title</pre></td><td><input type='textbox' ng-model = 'newprojects["+(projectcount-1)+"].projecttitle'></td></tr><tr><td><pre>Project Duration</pre></td><td><input type='textfield' ng-model = 'newprojects["+(projectcount-1)+"].projectduration'></td></tr><tr><td><pre>Project description</pre></td><td><textarea  rows='3' columns='50' wrap='hard' ng-model = 'newprojects["+(projectcount-1)+"].projectdescription'></textarea></td></tr><tr><td><pre>Role in Project</pre></td><td><textarea  rows='2' columns='50' wrap='hard' ng-model = 'newprojects["+(projectcount-1)+"].projectrole'></textarea></td></tr></table></div>")(scope));
			
		});
	};
});



empappobj.directive("addeditprojectsdiv", function(){
	return {
		restrict: "E",
		template: "<button addeditdivs class='button' ng-click='addToEditProjectArray()'>Add new Project</button>"
	}
});

//Directive for adding  projects
empappobj.directive("addeditdivs", function($compile){
	return function(scope, element, attrs){
		element.bind("click", function(){
			projectcount++;
			console.log("projectcount "+projectcount)
			angular.element(document.getElementById('editprojects-div')).append($compile("<div class='callout panel'><table width='100%'><tr><td><pre>project Title</pre></td><td><input type='textbox' ng-model = 'neweditprojects["+(projectcount-1)+"].projecttitle'></td></tr><tr><td><pre>Project Duration</pre></td><td><input type='textfield' ng-model = 'neweditprojects["+(projectcount-1)+"].projectduration'></td></tr><tr><td><pre>Project description</pre></td><td><textarea  rows='3' columns='50' wrap='hard' ng-model = 'neweditprojects["+(projectcount-1)+"].projectdescription'></textarea></td></tr><tr><td><pre>Role in Project</pre></td><td><textarea  rows='2' columns='50' wrap='hard' ng-model = 'neweditprojects["+(projectcount-1)+"].projectrole'></textarea></td></tr></table></div>")(scope));
			
		});
	};
});


})();