<!DOCTYPE html>
<html lang="en">
<head>
<title>Creation Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Adding BootStrap CSS CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- Adding JQuery -->
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<!-- Adding BootStrap CDN -->
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 
 
<!-- Adding SweetAlert CDN -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

 <script>
 
 function create(){
	 
	 var name = document.getElementById("name").value; 
	 var phone = document.getElementById("phone").value;
	 var companyName = document.getElementById("companyName").value;
	 var experience = document.getElementById("pre_exp").value;
	 var dob = document.getElementById("dob").value;
	 var team = document.getElementById("team").value;
	 var gendercheck = document.querySelector('input[name="gender"]:checked'); 
	 var gender = gendercheck.value;
	 var encodeValue = document.getElementById("textarea").value; 
	 
	 $.ajax({
			
			url:"http://localhost:9090/action",
			data: {name : name, phone : phone, companyName : companyName, experience : experience, dob : dob, team : team, gender : gender, base64value : encodeValue},
			type: "POST",
			datatype: "text",
			success: function(response){
				
				location.reload();
				
				Swal.fire({
					  position: 'top-center',
					  icon: 'success',
					  title: 'Your work has been saved',
					  showConfirmButton: false,
					  timer: 1500
					})
					
					
				
			},
			error: function(){
				alert("error");
			}
			
		});
	 
 }
 
 </script>
		
		
	
 
<style>
* {
	box-sizing: border-box;
}

body {
	margin: 0;
	position: padding-top;
}

/* Style the header */


.header {
	background-color: #f1f1f1;
	padding: 20px;
	text-align: center;
	background-image:
		url("https://media.istockphoto.com/photos/black-office-desk-header-picture-id653167452?k=20&m=653167452&s=612x612&w=0&h=Y7bEF9gfbV-jvZLwDKyQfp7cJdx_VIsTN9G18_O7fu4=");
	background-position: center;
}


/* Style the top navigation bar */
.topnav {
	overflow: hidden;
	background-color: #333;
}

/* Style the topnav links */
.topnav a {
	float: left;
	font-size: 16px; color : white; text-align : center; padding : 14px
	16px;
	text-decoration: none;
	color: white;
	text-align: center;
	padding: 14px 16px;
}
a{
	color:white;
}

.sticky-top{
position: sticky;
}

h1 {
	font-family: 'Merriweather', serif;
	font-weight: bold;
	color: white;
}
li{
color:white;}
/* Change color on hover */
.topnav a:hover {
	background-color: #ddd;
	color: black;
}

img{
    max-width:450px;
    max-height:450px;
}

</style>
</head>
<body>

	<div class="header">
		<h1>Welcome to Creation Page</h1>
	</div>
 <nav id="navbar_top" class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">	
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href=""><img alt="logo" src="https://media.glassdoor.com/sqll/2884826/fa-software-squarelogo-1630055961885.png" style="width:30px;"></a>
      <a class="navbar-brand" href="#" style="color:white; font-family: 'Merriweather', serif;">FA Software Service</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="index"><span class="glyphicon glyphicon-home"></span> HOME</a></li>
        <li class="active"><a href="creation"><span class="glyphicon glyphicon-list-alt"></span> CREATE</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-eye-open"></span> VIEW <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="html">HTML</a></li>
            <li><a href="view">JQUERY</a></li>
            <li><a href="datatable">AJAX</a></li>
            <li><a href="datatable">EXPORT</a></li>
          </ul>
        </li>
        <li><a href="edit"><span class="glyphicon glyphicon-edit"></span> EDIT</a></li>
      </ul>
    </div>
  </div>
</nav>
	<br>
	<br>
	<div class="row">
  <div class="col-12 col-md-7">
	<div class="container-md-6">
	
		     	
    
		<form class="form-horizontal" >
		
			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-10">
					<h2  style="font-family: 'Merriweather', serif; color:green;"><mark>Creation Form</mark></h2>
				</div>
				</div>
				<br>
			<div class="form-group">
				<label class="control-label col-sm-5" for="name">Name :</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="name" name="name"
						placeholder="Enter Name" required />
				</div>
			</div>
			<br>
			<div class="form-group">
				<label class="control-label col-sm-5" for="phone">Phone
					Number :</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="phone"
						placeholder="Enter Phone Number" name="phone" required />
				</div>
			</div>
			<br>
			<div class="form-group">
				<label class="control-label col-sm-5" for="companyName">Company
					Name :</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="companyName"
						placeholder="Enter Company Name" name="companyName" required />
				</div>
			</div>
			<br>

			<div class="form-group">
				<label class="control-label col-sm-5" for="pre_exp">Previous
					Experience :</label>
				<div class="col-sm-4">
					<input type="number" class="form-control" id="pre_exp"
						placeholder="Enter Experience in year" name="exp" required />
				</div>
			</div>
			<br>

			<div class="form-group">
				<label class="control-label col-sm-5" for="dob">Date of
					Birth :</label>
				<div class="col-sm-4">
					<input type="date" class="form-control" id="dob"
						placeholder="Enter DateOfBirth" name="dob" required /><i
						class="fas fa-calendar-alt"></i>
				</div>
			</div>
			<br>

			<div class="form-group">
				<label class="control-label col-sm-5" for="team">Select Team
					:</label>
				<div class="col-sm-4">
					<select name="team" id="team" required>
						<option selected value="" disabled selected></option>
						<option value="RS">RS</option>
						<option value="GoPolicy">GoPolicy</option>
						<option value="LIC">LIC</option>
					</select>
				</div>
			</div>
			<br>

			<div class="form-group">
				<label class="control-label col-sm-5" for="gender">Select
					Gender :</label>
				<div class="col-sm-4">
					<input type="radio" name="gender" class="gender" value="Male" required><label
						for="font"> Male</label> <input type="radio" class="gender" name="gender"
						value="Female"><label for="font"> Female</label>
				</div>
			</div>
			<br>
			
			<div class="form-group">
				<label class="control-label col-sm-5" for="file">Choose the File :</label>
				<div class="col-sm-4">
					<input type="file" class="form-control" id="file" onclick="readFile()" name="file"
						 required />
				</div>
			</div>
			<br>
			
			<div class="form-group">
				<div class="col-sm-4">
					<textarea id="textarea" name="textarea" rows="" cols="" hidden></textarea>
				</div>
			</div>
			<br>
			
			 <div class="form-group">
				<label class="control-label col-sm-5" for="img">Selected Image :</label>
				<div class="col-sm-4">
					<img id="img">
				</div>
			</div> 
			<br> 
			 
			 
			 <br>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-10">
					<button type="button" onclick="create()" class="btn btn-success">Submit</button>
				</div>
			</div>
		</form>
	</div>
	</div>
	<div class="col-4">
	<br>
	<br><br><br><br><br>
	
		<div class="container-sm">
				<form action="/upload" >
			
					<label class="control-label col-sm-5" for="img">Upload XSLX File</label><br>	

					<span class="glyphicon glyphicon-open"></span><input type="file"  id="filexlsx" name="filexlsx" accept=".csv, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel" />
					<br>
					<button class="btn-primary"type ="submit">Upload</button>
				</form>
		</div>
	</div>
	</div>
	
	
	 <script>
 
 
 function readFile() {
	  
	  if (this.files && this.files[0]) {
	    
	    var FR= new FileReader();
	    
	    FR.addEventListener("load", function(e) {
	       document.getElementById("img").src       = e.target.result; 
	      document.getElementById("textarea").innerHTML = e.target.result;
	    }); 
	    
	    FR.readAsDataURL( this.files[0] );
	  }
	  
		}

		document.getElementById("file").addEventListener("change", readFile);
		
	</script> 
	<script>
	document.addEventListener("DOMContentLoaded", function(){
  window.addEventListener('scroll', function() {
      if (window.scrollY > 50) {
        document.getElementById('navbar_top').classList.add('fixed-top');
        // add padding top to show content behind navbar
        navbar_height = document.querySelector('.navbar').offsetHeight;
        document.body.style.paddingTop = navbar_height + 'px';
      } else {
        document.getElementById('navbar_top').classList.remove('fixed-top');
         // remove padding top from body
        document.body.style.paddingTop = '0';
      } 
  });
}); 
	</script>
	
	
</body>
</html>


