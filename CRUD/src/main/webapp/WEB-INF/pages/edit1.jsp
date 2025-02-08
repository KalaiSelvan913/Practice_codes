<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>View Page With AJAX</title>
<!-- adding css -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
<!-- Adding JQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>

<!-- Adding Bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css">


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
						title : "Prev_Experience",
						"data" : "pre_exp"
					},
					
					{
						title : "Action",
						"data" : "pre_exp",
						
						"fnCreatedCell":function(data){
						
							$(data).html("<input type='button' value='Edit' class='btn btn-warning'data-toggle='modal' data-target='#myModal'>"+" "+"<input type='button' value='Delete' class='btn btn-danger delete'>");
							
						}
					   
					   
						
					},
					

					]
				});
				
				$('#example tbody').on('click', '.btn-warning', function () {
		              var name = $(this).closest('tr').find('td:eq(0)').text();
		              var phone = $(this).closest('tr').find('td:eq(1)').text();
		              var gender = $(this).closest('tr').find('td:eq(2)').text();
		              var team = $(this).closest('tr').find('td:eq(3)').text();
		              var date = $(this).closest('tr').find('td:eq(4)').text();
		              var companyName = $(this).closest('tr').find('td:eq(5)').text();
		              var experience = $(this).closest('tr').find('td:eq(6)').text();
		                         
		            
		              
		              document.getElementById('name').value = name;
		              document.getElementById('phone').value = phone;
		              document.getElementById('companyName').value = companyName;
		              document.getElementById('pre_exp').value = experience;
		              document.getElementById('dob').value = date;
		              document.getElementById('team').value = team;
		              
		              
		              if(gender =="Male"){

		            	  $('input[name=gender]:eq(0)').prop('checked', true);
		              }else{
		            	  $('input[name=gender]:eq(1)').prop('checked', true);
		              }
		             /*  document.getElementById('gender').value = gender; */
		              
		            /*   
		              $('#example tbody').on( 'click', '.btn-warning', function() {
	            	        var value = $("input[type=radio][name=gender]:checked").val();
	            	        if (value == "true") {
	            	            document.getElementById('true').value = gender;
	            	        }
	            	        else {
	            	            document.getElementById('false').value = gender;
	            	        }
	            	    }); */
		              
		              
		             
		            

		             
		              } );
				
				// Handle click on "Delete" button
				 $('#example tbody').on('click', '.delete', function () {
					  var name = $(this).closest('tr').find('td:eq(0)').text();
					  
					  
					  $.ajax({
						  
						  url:"http://localhost:9090/deleteByName",
						  data: {userName:name},
						  type: "GET",
						  dataType: "text",
						  success: function(response){
							  alert(response);
							  location.reload();
						  },
						  error: function(){
							  alert("error");
						  }
					  
					  });
					  
					     
		               
		            
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

h1 {
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

.dropdown {
  float: left;
  overflow: hidden;
}

.dropdown .dropbtn {
  font-size: 16px;  
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {
  background-color: #ddd;
}

.dropdown:hover .dropdown-content {
  display: block;
}

.dropdown:hover .dropbtn {
  background-color: #ddd;
  color:black;
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
		<h1>Welcome to View Page</h1>
	</div>

	<div class="topnav">
  <a href="index">Home</a>
  <a href="creation">Create</a>
  <a href="html">HTML</a>
  <a href="view">JQuery</a>
  <a href="datatable">AJAX</a>
  <a href="viewpdf">Export</a>
  <a href="edit">Edit</a>
</div>	<br>
	<br>
	<div class="bg-img">
	<table id="example" class="datatable">

	</table>
	
	 <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Edit Form</h4>
        </div>
        <div class="modal-body">
          <form class="form-horizontal" action="/edit1">
			<div class="form-group">
				<label class="control-label col-sm-4" for="name">Name :</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="name" name="name"
						placeholder="Enter Name" required />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-4" for="phone">Phone
					Number :</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="phone"
						placeholder="Enter Phone Number" name="phone" required />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-4" for="companyName">Company
					Name :</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="companyName"
						placeholder="Enter Company Name" name="companyName" required />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-4" for="pre_exp">Previous
					Experience :</label>
				<div class="col-sm-4">
					<input type="number" class="form-control" id="pre_exp"
						placeholder="Enter Experience in year" name="exp" required />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-4" for="dob">Date of
					Birth :</label>
				<div class="col-sm-4">
					<input type="date" class="form-control" id="dob"
						placeholder="Enter DateOfBirth" name="dob" required /><i
						class="fas fa-calendar-alt"></i>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-4" for="team">Select Team
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

			<div class="form-group">
				<label class="control-label col-sm-4" for="gender">Select
					Gender :</label>
				<div class="col-sm-4" >
					<input type="radio" name="gender" id="true" class="gender" value="Male" required><label
						for="font"> Male</label> <input type="radio" name="gender"
						value="Female" id="false" class="gender"><label for="font"> Female</label>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-success">Submit</button>
				</div>
			</div>
		</form>

        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  </div>
	
</body>
</html>


