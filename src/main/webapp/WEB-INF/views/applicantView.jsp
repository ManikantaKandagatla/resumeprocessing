<!DOCTYPE html>
<head>
<meta charset="UTF-8">
	<title>
	EmpApp
	</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.0.1/css/foundation.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.0.1/js/vendor/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.0.1/js/foundation.min.js"></script>
	
	<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.2.0/angular.js"></script>-->
	
	<!--<script src = "https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.2.0/angular-route.js"></script>-->
	<script src="/resumeprocessing/resources/js/angular.min.js"></script> 	
	 
    <script src="/resumeprocessing/resources/js/empcontroller.js"></script>
    
</head>

<body ng-app="empapp">
<div class="large-12 columns">
<center><h3>Employee Interview App</h3></center>
</div>
<div class="large-12 columns" ng-controller="mainController as ctrl" ng-init="initEmp()">
  <div class="medium-3 columns">
    <ul class="tabs vertical" id="example-vert-tabs" data-tabs>
      <li class="tabs-title is-active"><a href="#panel1v" aria-selected="true">New Details</a></li>
      <li class="tabs-title"><a href="#panel2v">Retrieve Employees</a></li>
      <li class="tabs-title"><a href="#panel3v">Edit Employee</a></li>
      <li class="tabs-title"><a href="#panel4v">Function 4</a></li>
      <li class="tabs-title"><a href="#panel3v">Function 5</a></li>
      <li class="tabs-title"><a href="#panel4v">Function  6</a></li>
    </ul>
    </div>
    <div class="medium-9 columns">
    <div class="tabs-content vertical" data-tabs-content="example-vert-tabs">
      <div class="tabs-panel is-active" id="panel1v">
        <div class = "row">
						<div  class="large-12 columns"  >
								<div class="callout panel">
									<form name="empform">
									<fieldset>
										<legend>Personal Details</legend>
											<div class="callout panel">
											
												<table width="100%">	
													 <tr><td><pre>First Name</pre></td><td><input type="textbox" ng-model="empobj.firstname" ng-required="true"></td></tr>
													 <tr><td><pre>Last Name</pre></td><td><input type="textbox" ng-model="empobj.lastname" ng-required="true"></td></tr>						
													 <tr><td><pre>Current Experience</pre></td><td><input type="textbox" ng-model="empobj.currentexperience" ng-required="true"></td></tr>
													 <tr><td><pre>Total Experience</pre></td><td><input type="textbox" ng-model="empobj.totalexperience" ng-required="true"></td></tr>
													 <tr><td><pre>Designation</pre></td><td><input type="textbox" ng-model="empobj.designation" ng-required="true"></td></tr>
													 <tr><td><pre>Qualification</pre></td><td><select ng-model ="empobj.qualification" ><option ng-repeat="qualification in qualification">{{qualification}}</option></select> </td></tr>
													 <tr><td><pre>Contact</pre></td><td><input type="textbox" ng-model = "empobj.contact" ng-required="true"></td></tr>					
													 <tr><td><pre>mail</pre></td><td><input type="email" ng-model = "empobj.email" ng-required="true"></td></tr>
													 <tr><td><pre>Location</pre></td><td><input type="textbox" ng-model = "empobj.location" ng-required="true"></td></tr>
												</table>
											</div>
									</fieldset>
									
									<fieldset>
										<legend>Project details</legend>
										<div id="projects-div">
											<div class="callout panel">
												<table width="100%">	
														 <tr><td><pre>project Title</pre></td><td><input type="textbox" ng-model = "empProjs[0].projecttitle" ng-required="true"></td></tr>
														 <tr><td><pre>Project Duration</pre></td><td><input type="textfield" ng-model = "empProjs[0].projectduration" ng-required="true"></td></tr>
														 <tr><td><pre>Project description</pre></td><td><textarea  rows="3" columns="50" wrap="hard" ng-model = "empProjs[0].projectdescription" ng-required="true"></textarea></td></tr>
														  <tr><td><pre>Role in Project</pre></td><td><textarea  rows="2" columns="50" wrap="hard" ng-model = "empProjs[0].projectrole" ng-required="true"></textarea></td></tr>
												</table>
												
												</div>
											</div>
											<addprojectsdiv></addprojectsdiv>
									</fieldset>
									
									<fieldset>
										<legend>Techincal Skills</legend>
											<div class="callout panel">
												<fieldset>
													
													<div class = "small-3 columns"><h5>Languages</h5><pre ng-repeat="language in techSkills.Languages"><input type="checkbox"  ng-click="toggleSelection(language)"/>{{language}}</pre></div>													
													<div class = "small-3 columns"><h5>Source control Tools</h5><pre ng-repeat="tool in techSkills.SouceControlTools"><input type="checkbox" ng-click="toggleSelection(tool)"/>{{tool}}</pre></div>
													<div class = "small-3 columns"><h5>Web Technologies</h5><pre ng-repeat="technology in techSkills.WebTechnologies"><input type="checkbox"  ng-click="toggleSelection(technology)"/>{{technology}}</pre></div>
													<div class = "small-3 columns"><h5>Operating Systems</h5><pre ng-repeat="os in techSkills.OperatingSystems"><input type="checkbox"  ng-click="toggleSelection(os)"/>{{os}}</pre></div>
												</fieldset>
												 <input type="file" id="resume" name="resume" ng-required = "true"/>
												<button class="button" ng-click="empform.$valid && addEmp(empobj,empProjs,newprojects)">Submit</button>
											</div>	
									</fieldset>	
									</form>
								</div>
						</div>
      </div>
	  </div>
      <div class="tabs-panel" id="panel2v">
		<div class="row" >
				   <div class="callout panel">
						<button class="button" ng-click="dispAllemp()">RetrieveAllEmployees</button>
						<button class="button" ng-click="searchdiv()">Search</button>
						<div class="callout panel" ng-show="showsearchdiv">
						
							<table width="60%">
							<tr>
							<td><input type="text"  ng-model="param"></td>
							<td>
								<select ng-model="searchCriteria" ng-change="CheckforSkills()">
									<option>searchByName</option>
									<option>searchBySkillset</option>
									<option>searchByContact</option>
								</select>
							</td>
							</tr>
							</table>
							
							<fieldset ng-show="showsearchskills">
										<legend>Techincal Skills</legend>
											<div class="callout panel">
												<fieldset>
													<div class = "small-3 columns"><h5>Languages</h5><pre ng-repeat="language in techSkills.Languages"><input type="checkbox" ng-model="names.Selected" ng-click="toggleSelection(language)"/>{{language}}</pre></div>
													
													<div class = "small-3 columns"><h5>Source control Tools</h5><pre ng-repeat="tool in techSkills.SouceControlTools"><input type="checkbox" ng-model="names.Selected" ng-click="toggleSelection(tool)"/>{{tool}}</pre></div>
													
													<div class = "small-3 columns"><h5>Web Technologies</h5><pre ng-repeat="technology in techSkills.WebTechnologies"><input type="checkbox" ng-model="names.Selected" ng-click="toggleSelection(technology)"/>{{technology}}</pre></div>
													<div class = "small-3 columns"><h5>Operating Systems</h5><pre ng-repeat="os in techSkills.OperatingSystems"><input type="checkbox" ng-model="names.Selected" ng-click="toggleSelection(os)"/>{{os}}</pre></div>
												</fieldset>
											</div>	
							</fieldset>	
							
							<button class="button" ng-click = "retrivebySearch()">RetrieveSearchCriteria</button>
						</div>
						<div class="callout panel" ng-show="ViewAll">
						<table width="100%" >
								<tr><th>Firstname</th><th>Skillset</th><th>Contact</th></tr>
								<tr ng-repeat = "employee in Allemps"> 
									<td><button ng-click="selEmp(employee)">{{employee.emp.firstname}}</button></td>
									<td>{{employee.emp.skillset}}</td>
									<td>{{employee.emp.contact}}</td>
									<td><button class="button" ng-click="ViewResume(employee.emp.contact)">View Resume</button></td>
									<td><input type="file" id="updateresume" name="resume" class="button"/></td>
									<!--<td><button class="button" ng-click="deleteEmployee(emp.id)">Delete</button></td> -->
								</tr>
						</table>
						</div>
						
						<div ng-show="showempResume" class="callout panel">
						<object ng-show="content" data="{{content}}" type="application/pdf" style="width: 100%; height: 400px;"></object>
						</div>
						
						<div ng-show="ViewSelected" class="callout panel">
						<fieldset>
						<legend>Personal Details</legend>
							<table  width="100%">
								<tr><td>First Name</td><td>{{selemp.emp.firstname}}</td></tr>
								<tr><td>Last Name</td><td>{{selemp.emp.lastname}}</td></tr>
								<tr><td>email address</td><td>{{selemp.emp.email}}</td></tr>
								<tr><td>Current Experience</td><td>{{selemp.emp.currentexperience}}</td></tr>
								<tr><td>Total Experience</td><td>{{selemp.emp.totalexperience}}</td></tr>
							</table>
						</fieldset>
						
						<fieldset>
						<legend>Technical Skills and projects</legend>
							<div class="callout panel"><pre>Skill set :{{selemp.emp.skillset}}</pre>
								<fieldset ng-repeat="project in selemp.projects">
									<legend>{{project.projecttitle}}</legend>
									<table width="100%">
										<tr><td>Project Description</td><td>{{project.projectdescription}}</td></tr>
										<tr><td>Duration</td><td>{{project.projectduration}}</td></tr>
										<tr><td>Role</td><td>{{project.projectrole}}</td></tr>
									</table>
								</fieldset>
							</div>
						</fieldset>
						
							<div><button class="button" ng-click="restoreViewAll()">Back</button><button class="button" ng-click="editEmployee(selemp.emp.contact)">Edit</button></div>
							
						</div>
						<div class="callout panel" ng-show="editdiv">
									<form name="empeditform">
									<fieldset>
										<legend>Personal Details</legend>
											<div class="callout panel">
											
												<table width="100%">	
													 <tr><td><pre>First Name</pre></td><td><input type="textbox" ng-model="employee.emp.firstname" ng-required="true"></td></tr>
													 <tr><td><pre>Last Name</pre></td><td><input type="textbox" ng-model="employee.emp.lastname" ng-required="true"></td></tr>						
													 <tr><td><pre>Current Experience</pre></td><td><input type="textbox" ng-model="employee.emp.currentexperience" ng-required="true"></td></tr>
													 <tr><td><pre>Total Experience</pre></td><td><input type="textbox" ng-model="employee.emp.totalexperience" ng-required="true"></td></tr>
													 <tr><td><pre>Designation</pre></td><td><input type="textbox" ng-model="employee.emp.designation" ng-required="true"></td></tr>
													 <tr><td><pre>Qualification</pre></td><td><select ng-model ="employee.emp.qualification" ><option ng-repeat="qualification in qualifications">{{qualification}}</option></select> </td></tr>
													 <tr><td><pre>Contact</pre></td><td><input type="textbox" ng-model = "employee.emp.contact" ng-required="true"></td></tr>					
													 <tr><td><pre>mail</pre></td><td><input type="email" ng-model = "employee.emp.email" ng-required="true"></td></tr>
													 <tr><td><pre>Location</pre></td><td><input type="textbox" ng-model = "employee.emp.location" ng-required="true"></td></tr>
												</table>
											</div>
									</fieldset>
									
									<fieldset >
											<div id="editprojects-div">
											<div class="callout panel"  ng-repeat="project in employee.projects">
													<table width="100%">
														<tr><td><pre>project Title</pre></td><td><input type="textbox" ng-model ="project.projecttitle"></td></tr>
														<tr><td><pre>Duration</pre></td><td><input type="textbox" ng-model ="project.projectduration"></td></tr>
														<tr><td><pre>Project Description</pre></td><td><textarea  rows="3" columns="50" wrap="hard" ng-model ="project.projectdescription"></textarea></td></tr>
														<tr><td><pre>Role</pre></td><td><textarea  rows="3" columns="50" wrap="hard"  ng-model ="project.projectrole"></textarea></td></tr>
													</table>							
											</div>
											</div>
											<addeditprojectsdiv></addeditprojectsdiv>
											
									</fieldset>
									
									
									<fieldset>
										<legend>Techincal Skills</legend>
											<div class="callout panel">
												<fieldset>
													
													<div class = "small-3 columns"><h5>Languages</h5><pre ng-repeat="language in techSkills.Languages"><input type="checkbox"  ng-click="toggleSelection(language,skillset)" ng-checked="isAskill(language)"/>{{language}}</pre></div>
													
													<div class = "small-3 columns"><h5>Source control Tools</h5><pre ng-repeat="tool in techSkills.SouceControlTools"><input type="checkbox" ng-click="toggleSelection(tool,skillset)" ng-checked="isAskill(tool)"/>{{tool}}</pre></div>
													
													<div class = "small-3 columns"><h5>Web Technologies</h5><pre ng-repeat="technology in techSkills.WebTechnologies"><input type="checkbox"  ng-click="toggleSelection(technology,skillset)" ng-checked="isAskill(technology)"/>{{technology}}</pre></div>
													<div class = "small-3 columns"><h5>Operating Systems</h5><pre ng-repeat="os in techSkills.OperatingSystems"><input type="checkbox"  ng-click="toggleSelection(os,skillset)" ng-checked="isAskill(os)"/>{{os}}</pre></div>
												</fieldset>
												 
												<button class="button" ng-click="empeditform.$valid && addEmp(employee.emp,employee.projects,neweditprojects)">Submit</button>
											</div>	
									</fieldset>	
									</form>
								</div>
						
						
					</div>
			</div>	
		</div>
      <div class="tabs-panel" id="panel3v">
        <p> will be updated soon</p>
      </div>
      <div class="tabs-panel" id="panel4v">
			<p> will be updated soon</p>
      </div>
      <div class="tabs-panel" id="panel5v">
		<p> will be updated soon</p>
	</div>
      <div class="tabs-panel" id="panel6v">
         <p> will be updated soon</p>
      </div>
    </div>
  </div>
</div>
<script>
   $(document).ready(function() {
      $(document).foundation();
   })
</script>
</body>