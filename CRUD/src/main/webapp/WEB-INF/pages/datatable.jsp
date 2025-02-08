	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>View Page With AJAX</title>
<!-- Adding BootStrap CSS CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- Adding JQuery -->
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<!-- Adding BootStrap CDN -->
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 
<!-- adding css -->
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
<!-- Adding JQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>

<!-- Adding datatabel cdn -->
<script
	src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>

<!-- Adding SweetAlert -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<script type="text/javascript">
	/* $(document).on('click', '#getDataBtn', function(){ */
	$(document).ready(function() {
		$.ajax({
			url : "http://localhost:9090/getAllData",
			data : "",
			type : "GET",
			dataType : "json",
			success : function(response) {

				console.log(response);
				//$('#myrenewalview').html(table);
				var table = $('#example').DataTable({
					data : response,
					dom : 'Bfrtip',
					buttons : [ 'copy', 'csv', 'excel', 'pdf', 'print' ],

					columns : [ {
						title : "Name",
						"data" : "name"
					}, {
						title : "Phone",
						"data" : "phone"
					}, {
						title : "Gender",
						"data" : "gender"
					}, {
						title : "Team",
						"data" : "team"
					}, {
						title : "Date_Of_Birth",
						"data" : "dob"
					}, {
						title : "Companyname",
						"data" : "companyName"
					}, {
						title : "Previous_Experience",
						"data" : "pre_exp"
					},

					]
				});
				
				

			},
			error : function() {
				// alert("error");
				Swal.fire({
					icon : 'error',
					title : 'Error...',
					text : 'Error Occurs!',
				})
			}
		});

	});
</script>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
	box-sizing: border-box;
}

body {
	margin: 0;
	background-image:url("https://i.pinimg.com/originals/9b/8d/17/9b8d17f6347ad3d362b26455008ba95d.gif");
    background-repeat: no-repeat;
    background-size: cover;

}
table, th, td {
	border: 1px solid;
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
	display: block;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
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

html {
	scroll-behavior: smooth;
}

/* Change color on hover */
.topnav a:hover {
	background-color: #ddd;
	color: black;
}


.bg-img{
background-image:url("https://w0.peakpx.com/wallpaper/755/433/HD-wallpaper-clear-underwater-ocean-blue-background-nature.jpg");
background-position: center; /* Center the image */
background-repeat: no-repeat; /* Do not repeat the image */
background-size: cover; /* Resize the background image to cover the entire container*/
}
</style>
</head>
<body>

	<div class="header">
		<h1>Welcome to AJAX Page</h1>
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
            <li><a href="html">HTML</a></li>
            <li><a href="view">JQUERY</a></li>
            <li class="active"><a href="datatable">AJAX</a></li>
            <li><a href="viewpdf">EXPORT</a></li>
          </ul>
        </li>
        <li><a href="edit"><span class="glyphicon glyphicon-edit"></span> EDIT</a></li>
      </ul>
    </div>
  </div>
</nav>	<br>
	<br>
	
	<table id="example" class="table table-striped w-auto table-bordered table-hover">

	</table>
	
</body>
</html>


