<html>
<head>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.0.1/css/foundation.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.0.1/js/vendor/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.0.1/js/foundation.min.js"></script>
	<!--   <script src="/resumeprocessing/resources/js/angular.min.js"></script> -->
	
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="/resumeprocessing/resources/js/appJS/Interviewerapp.js"></script>
	<script src="/resumeprocessing/resources/js/Controller/interviewerController.js"></script>
	<script src="/resumeprocessing/resources/js/Service/interviewerService.js"></script>

</head>
<body ng-app="interviewerApp">
<div class="large-12 columns">
<center><h3>Employee Interview App</h3></center>
</div>
<div class="large-12 columns" ng-controller="utilController as ctrl" ng-init="init()">
  <div class="medium-3 columns">
    <ul class="tabs vertical" id="example-vert-tabs" data-tabs>
      <li class="tabs-title is-active"><a href="#panel1v" aria-selected="true">New Interviewer Details</a></li>
      <li class="tabs-title"><a href="#panel2v">Retrieve Interviewers</a></li>
      <li class="tabs-title"><a href="#panel3v">Edit Interviewer</a></li>
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
													 <tr><td><pre>First Name</pre></td><td><input type="textbox" ng-model="interviewer.firstname" ng-required = "true"></td></tr>
													 <tr><td><pre>Last Name</pre></td><td><input type="textbox" ng-model="interviewer.lastname" ng-required = "true"></td></tr>	
													 <tr><td><pre>Role</pre></td><td><input type="textbox" ng-model="interviewer.role" ng-required = "true"></td></tr>						
													 <tr><td><pre>Contact</pre></td><td><input type="textbox" ng-model = "interviewer.contact" ng-required = "true"></td></tr>
													 <tr><td><pre>QuicklookId</pre></td><td><input type="textbox" ng-model = "interviewer.quicklookid" ng-required = "true"></td></tr>					
													 <tr><td><pre>mail</pre></td><td><input type="email" ng-model = "interviewer.mail" ng-required = "true"></td></tr>
												</table>
											</div>
									</fieldset>
									
									<fieldset>
										<legend>Expertese Techincal Skills</legend>
											<div class="callout panel">
												<fieldset>
													
													<div class = "small-3 columns"><h5>Languages</h5><pre ng-repeat="language in techSkills.Languages"><input type="checkbox"  ng-click="toggleSelection(language)"/>{{language}}</pre></div>													
													<div class = "small-3 columns"><h5>Source control Tools</h5><pre ng-repeat="tool in techSkills.SouceControlTools"><input type="checkbox" ng-click="toggleSelection(tool)"/>{{tool}}</pre></div>
													<div class = "small-3 columns"><h5>Web Technologies</h5><pre ng-repeat="technology in techSkills.WebTechnologies"><input type="checkbox"  ng-click="toggleSelection(technology)"/>{{technology}}</pre></div>
													<div class = "small-3 columns"><h5>Operating Systems</h5><pre ng-repeat="os in techSkills.OperatingSystems"><input type="checkbox"  ng-click="toggleSelection(os)"/>{{os}}</pre></div>
												</fieldset>
												 <!-- <input type="file" id="resume" name="resume"/> -->
												<button class="button" ng-click="empform.$valid && addInterviewer(interviewer)">Submit</button>
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
						<button class="button" ng-click="dispAllInterviewers()">Retrieve All Interviewers</button>
						<button class="button" ng-click="searchdiv()">Search</button>
						<div class="callout panel" ng-show="showsearchdiv">
						
							<table width="60%">
							<tr>
							<td><input type="text"  ng-model="param"></td>
							<td>
								<select ng-model="searchCriteria" ng-change="CheckforSkills()">
									<option>search By Name</option>
									<option>search By Expertese</option>
									<option>search By Quicklook id</option>
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
								<tr><th>Firstname</th><th>Expertese</th><th>Quicklook id</th></tr>
								<tr ng-repeat = "interviewer in AllInterviewers"> 
									<td><button ng-click="DetailInterviewer(interviewer)">{{interviewer.firstname}}</button></td>
									<td>{{interviewer.expertese}}</td>
									<td>{{interviewer.quicklookid}}</td>
									<!--  <td><button class="button" ng-click="ViewResume(employee.emp.contact)">View Resume</button></td>-->
									<!--  <td><input type="file" id="updateresume" name="resume" class="button"/></td>-->
									<!--<td><button class="button" ng-click="deleteEmployee(emp.id)">Delete</button></td> -->
								</tr>
						</table>
						</div>
						
						<div ng-show="ViewSelected" class="callout panel">
						<fieldset>
						<legend>Personal Details</legend>
							<table  width="100%">
								<tr><td>First Name</td><td>{{selInterviewer.firstname}}</td></tr>
								<tr><td>Last Name</td><td>{{selInterviewer.lastname}}</td></tr>
								<tr><td>email address</td><td>{{selInterviewer.mail}}</td></tr>
								<tr><td>Current Experience</td><td>{{selInterviewer.contact}}</td></tr>
								<tr><td>Total Experience</td><td>{{selInterviewer.totalexperience}}</td></tr>
								<tr><td>Quicklook id</td><td>{{selInterviewer.quicklookid}}</td></tr>
							</table>
						</fieldset>
						
						<fieldset>
						<legend>Expertese Technical Skills</legend>
							<div class="callout panel"><pre>Skill set :{{selInterviewer.expertese}}</pre>
								
							</div>
						</fieldset>
						
							<div><button class="button" ng-click="restoreViewAll()">Back</button><button class="button" ng-click="editEmployee(selemp.emp.contact)">Edit</button></div>
							
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
</html>