'use strict';

angular.module('applicantApp')
.directive("addprojectsdiv", function(){
	return {
		restrict: "E",
		template: "<button adddivs class='button' ng-click='addToProjectArray()'>Add new Project</button>"
	}
})

//Directive for adding  projects
.directive("adddivs", function($compile){
	return function(scope, element, attrs){
		element.bind("click", function(){
			projectcount++;
			console.log("projectcount "+projectcount)
			angular.element(document.getElementById('projects-div')).append($compile("<div class='callout panel'><table width='100%'><tr><td><pre>project Title</pre></td><td><input type='textbox' ng-model = 'newprojects["+(projectcount-1)+"].projecttitle' ng-required='true'></td></tr><tr><td><pre>Project Duration</pre></td><td><input type='textfield' ng-model = 'newprojects["+(projectcount-1)+"].projectduration' ng-required='true'></td></tr><tr><td><pre>Project description</pre></td><td><textarea  rows='3' columns='50' wrap='hard' ng-model = 'newprojects["+(projectcount-1)+"].projectdescription' ng-required='true'></textarea></td></tr><tr><td><pre>Role in Project</pre></td><td><textarea  rows='2' columns='50' wrap='hard' ng-model = 'newprojects["+(projectcount-1)+"].projectrole' ng-required='true'></textarea></td></tr></table></div>")(scope));
			
		});
	};
});