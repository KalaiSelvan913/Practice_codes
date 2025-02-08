<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
 <!-- <script>
 
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
 -->		
		
	
 
<style>
* {
	box-sizing: border-box;
}

body {
	margin: 0;
	background-image:url("https://cdn.dribbble.com/users/707385/screenshots/4217461/wave_1.gif");
    background-repeat: no-repeat;
    background-size: cover;

}

/* Style the header */
.header {
	background-color: #f1f1f1;
	padding: 20px;
	text-align: center;
}

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
tr:nth-child(odd) {
    background-color: lightskyblue;
    }

   tr:nth-child(even) {
    background-color: lightgrey;
    }

    th {
       background-color: lightseagreen;
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
		<h1>Welcome to HTML Table Page</h1>
	</div>
 <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href=""><img alt="logo" src="https://media.glassdoor.com/sqll/2884826/fa-software-squarelogo-1630055961885.png" style="width:30px;"></a>
      <a class="navbar-brand" href="#" style="color:white;font-family: 'Merriweather', serif;">FA Software Service</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="index"><span class="glyphicon glyphicon-home"></span> HOME</a></li>
        <li><a href="creation"><span class="glyphicon glyphicon-list-alt"></span> CREATE</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-eye-open"></span> VIEW <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li class="active"><a href="html">HTML</a></li>
            <li><a href="view">JQUERY</a></li>
            <li><a href="datatable">AJAX</a></li>
            <li><a href="viewpdf">EXPORT</a></li>
          </ul>
        </li>
        <li><a href="edit"><span class="glyphicon glyphicon-edit"></span> EDIT</a></li>
      </ul>
    </div>
  </div>
</nav>
	<br>
	<br>
	<div class="container">
		<table id="example" class="table table-striped w-auto table-bordered table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Phone</th>
					<th>DOB</th>
					<th>Team</th>
					<th>Gender</th>
					<th>Company name</th>
					<th>previousExperience</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${data}" var="itr">
					<tr>
						<td>${itr.name}</td>
						<td>${itr.phone}</td>
						<td>${itr.dob}</td>
						<td>${itr.team}</td>
						<td>${itr.gender}</td>
						<td>${itr.companyName}</td>
						<td>${itr.pre_exp}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
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
	
	
</body>
</html>


