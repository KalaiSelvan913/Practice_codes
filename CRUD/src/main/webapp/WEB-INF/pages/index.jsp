<!DOCTYPE html>
<html lang="en">
<head>
<title>Home Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Adding BootStrap CSS CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- Adding JQUERY CDN  -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<!-- Adding BootStrap CDN -->
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- Adding SweetAlert CDN -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<script type="text/javascript">
$( document ).ready(function() {
	/* Swal.fire({
		  position: 'top-center',
		  icon: 'success',
		  title: 'Login Succesfully',
		  showConfirmButton: false,
		  timer: 1500
		}) */
});
</script>
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
  background-image:url("https://media.istockphoto.com/photos/black-office-desk-header-picture-id653167452?k=20&m=653167452&s=612x612&w=0&h=Y7bEF9gfbV-jvZLwDKyQfp7cJdx_VIsTN9G18_O7fu4=");
  background-position:center;
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
container{
 position:absolute;
}

.bg-img{
background-image:url("https://web.liferay.com/web/pages-fa-software-services-private-limited/profile?p_p_id=2_WAR_osbcorpprofileportlet&p_p_lifecycle=2&p_p_state=normal&p_p_mode=view&p_p_resource_id=serveMedia&p_p_cacheability=cacheLevelPage&p_p_col_id=column-1&p_p_col_count=1&_2_WAR_osbcorpprofileportlet_assetAttachmentId=188137595");
min-height: 500px;
backgroun-position:center;
 background-repeat: no-repeat;	
 background-size: cover;
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


</style>
</head>
<body>

<div class="header">
  <h1>Welcome to Home Page</h1>
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
        <li class="active"><a href="index"><span class="glyphicon glyphicon-home"></span> HOME</a></li>
        <li><a href="creation"><span class="glyphicon glyphicon-list-alt"></span> CREATE</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-eye-open"> VIEW <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="html">HTML</a></li>
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

<div class= "bg-img">


</div>


</body>
</html>


