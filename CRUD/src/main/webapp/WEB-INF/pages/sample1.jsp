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
<style>
* {
	box-sizing: border-box;
}

body {
	margin: 0;
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


</style>
</head>
<body>

	<div class="header">
		<h1>Welcome to Creation Page</h1>
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
      <a class="navbar-brand" href="#" style="color:white;">FA Software Service</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="index"><span class="glyphicon glyphicon-home"></span> HOME</a></li>
        <li><a href="creation"><span class="glyphicon glyphicon-list-alt"></span> CREATE</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-eye-open"> VIEW <span class="caret"></span></a>
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
	<div class="container">
		<h2 style="font-family: 'Merriweather', serif;">Creation Form</h2>
		<form class="form-horizontal" action="/action">
			<div class="form-group">
				<label class="control-label col-sm-2" for="name">Name :</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="name" name="name"
						placeholder="Enter Name" required />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="phone">Phone
					Number :</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="phone"
						placeholder="Enter Phone Number" name="phone" required />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="companyName">Company
					Name :</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="companyName"
						placeholder="Enter Company Name" name="companyName" required />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="pre_exp">Previous
					Experience :</label>
				<div class="col-sm-4">
					<input type="number" class="form-control" id="pre_exp"
						placeholder="Enter Experience in year" name="exp" required />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="dob">Date of
					Birth :</label>
				<div class="col-sm-4">
					<input type="date" class="form-control" id="dob"
						placeholder="Enter DateOfBirth" name="dob" required /><i
						class="fas fa-calendar-alt"></i>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="team">Select Team
					:</label>
				<div class="col-sm-4">
					<select name="team" required>
						<option selected value="" disabled selected></option>
						<option value="RS">RS</option>
						<option value="GoPolicy">GoPolicy</option>
						<option value="LIC">LIC</option>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="gender">Select
					Gender :</label>
				<div class="col-sm-4">
					<input type="radio" name="gender" value="Male" required><label
						for="font"> Male</label> <input type="radio" name="gender"
						value="Female"><label for="font"> Female</label>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</form>
	</div>
	
</body>
</html>


