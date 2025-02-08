<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Adding JQUERY CDN  -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<!-- Adding SweetAlert CDN -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<title>LOGIN FORM</title>

<script>
function login(){
	
	var user = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	
	$.ajax({
		
		url:"http://localhost:9090/loginValidation",
		data: {userName : user, password: password},
		type: "POST",
		datatype: "text",
		success: function(response){
			
			if(response == "login successfull"){
				
				window.location.replace("http://localhost:9090/showindex")
			}else{
				Swal.fire({
					  position: 'top-center',
					  icon: 'error',
					  title: 'Invalid Credential',
					  showConfirmButton: false,
					  timer: 1500
					})
			}
			
		},
		error: function(){
			alert("error");
		}
		
	});
	
}
</script>
<style type="text/css">
body {
  margin: 1.5em;
  padding: 0;
  font-family: sans-serif;
  background-color: #59ada5ad;
  background-size: cover;
  background-repeat: no-repeat;
  background-attachment: fixed;	
}

h1 {
  font-weight: bold;
  font-size: 3em;
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
}

span {
  color: rgb(141, 14, 130);
}

body {
	margin: 0;
	background-image:url("https://i.gifer.com/7xLv.gif");
    background-repeat: no-repeat;
    background-size: cover;

}

.login-box {
  width: 25em;
  height: 32em;
  background: rgb(230 247 8 / 51%);
  top: 50%;
  left: 50%;
  position: absolute;
  transform: translate(-50%, -50%);
  box-sizing: border-box;
  padding: 3em 3em;
  border-radius: 10%;
  box-shadow: 0 0 10px #ef2603;
}

.login-image {
  width: 7em;
  height: 7em;
  border-radius: 50%;
  position: absolute;
  top: -3.7em;
  left: calc(50% - 3.7em);
}

h3 {
  margin: 0 auto;
  padding: 0.5em 0;
  text-align: center;
  font-size: 2.5rem;
  font-family: 'Merriweather', serif;
}

.login-box p {
  margin: 0;
  padding: 1em 0;
  font-weight: bold;
}

.login-box input {
  width: 100%;
  margin-bottom: 2em;
}

.login-box input[type="button"]{
 background-color: #ff33cc;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

.login-box input[type="text"],
input[type="password"] {
  border: none;
  border-bottom: 1.2px solid rgb(141, 14, 130);
  background: transparent;
  outline: none;
  height: 2em;
  color: rgb(141, 14, 130);
  font-size: 16px;
}

.login-box input[type="submit"] {
  border: none;
  outline: none;
  height: 2.5em;
  background: rgb(141, 14, 130);
  color: white;
  font-size: 1em;
  border-radius: 1.5rem;
}

.login-box input[type="submit"]:hover {
  cursor: pointer;
  background: rgb(221, 75, 209);
  color: white;
}

.login-box a {
  text-decoration: none;
  font-size: 0.75em;
  line-height: 1.7em;
  color: rgb(53, 51, 58);
  display: flex;
  flex-direction: vertical;
}

.login-box a:hover {
  color: rgb(141, 14, 130);
}
.center {
  display: block;
  margin-left: auto;
  margin-right: auto;
  
}
</style>
</head>
<body>

 <div class="login-box">
 	<img alt="" src="data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAoHCBAREBcTERUXFxEXFxQUGhgaGhgZIRkYGhsaGB0aHBwaLCwjGhwrIBcZJDgmKy0vMjIyGiI4PTgwPCwxMi8BCwsLDw4PHRERHDEoIyg7LzExMTE0MTMxMTEzLzExOi8vMTM8MTExMTEvMTExMTExMTExOjExMTExMToxMTExMf/AABEIANAA8gMBIgACEQEDEQH/xAAcAAACAgMBAQAAAAAAAAAAAAAABwYIAQQFAwL/xABJEAABAwIBAw0MCAYDAQEAAAABAAIDBBEFBhIhBxMXMTJBUVNhcYGSkxQVFiI1VHKRsbPR0jRSc3SCg6GyI0JiosHhJDNjQ+L/xAAZAQACAwEAAAAAAAAAAAAAAAAABAECAwX/xAAqEQACAQIFBAIDAAMBAAAAAAAAAQIDEQQSITFRExRBYVKBIjJxkbHwI//aAAwDAQACEQMRAD8Aiq22YXUuAIglIIBBEbyCDtEG2kLUKf8AgP0OD7GH9jV1sRXdK1kYQjmEb3pq/N5uyk+CO9NX5vN2UnwVgkWS3fS4LdP2V9701fm83ZSfBHemr83m7KT4KwVkWR30uA6fsr73pq/N5uyk+CO9NX5vN2UnwVgkI76XAdP2V9701fm83ZSfBHemr83m7KT4KwVkWR30uA6fsr73pq/N5uyk+CO9NX5vN2UnwVgrIsjvpcB0/ZX3vTV+bzdlJ8Ed6avzebspPgrBIR30uA6fsr73pq/N5uyk+CO9NX5vN2UnwVgrIsjvpcB0/ZX3vTV+bzdlJ8Ed6avzebspPgrBWRZHfS4Dp+yvvemr83m7KT4I701fm83ZSfBWCsiyO+lwHT9lfe9NX5vN2UnwR3pq/N5uyk+CsEhHfS4Dp+yvvemr83m7KT4I701fm83ZSfBWCsiyO+lwHT9lfe9NX5vN2UnwR3pq/N5uyk+CsFZFkd9LgOn7K+96avzebspPgjvTV+bzdlJ8FYKyLI76XAdP2V970Vfm83ZSfBaSscq6Tbt3pO9qYw9d1W7rYrKOUeuTHk+l+7U/u2oRkx5Ppfu1P7tqFzXuaiHKb2J5QPw/DaSRjBIXthjsSW2GtF19Ho/qlCU7osHp6ygpmVDc9jYoXiznNs7WwL3aRvEp/FtJxb2M6d9bEQ2Tp/Nmdd3wRsnT+bx9d3wXUr9TWmdcwSyRu3g60jfVod/coJlBk7UUDw2UAsdfMkbpa629p0tdbePReyimsPPRLUluaJPsnT+bs67vgjZOn83Z13fBQBYebA8y37alwUzyGBsnTebx9d3wRsnTebx9d3wUgj1PsNLQc2TSAf8AsK+9jzDfqydo5J58P8WXtPkjmydP5vH13fBGydP5vH13fBSF2p5hvBIPzD/lfDtTnDiNBlHKHj/IKnPhviybSODsnT+bx9d3wRsnT+bx9d3wW7X6mcWYTTzPD94S5rmnkuwAt57HmS8xCilp5HRTMLHt2weDeIO0QeELWnHD1P1X+yrc1uTbZOm83Z13fBSXIzKmTETKHxtj1sRkZri6+fn8I0bj9Um0xNSPd1Xo0/tlUYihTjTbS1CEm2MxCELnGwIQhAGEIXHypxPuSillB8cNzWem7xW+om/MChK7sgF3lJlpWCslbTylkLHFjQGsN8zxXOu4G93A9FlNshcafWUedI7OmY5zHnQL/wAzTYaNogdBSWCmGpries1utOPiTNzPxtu5v6Zw6QulWoRVL8VqjGM3m1HAhCFzTYEIQgAQhCAMKuc27d6TvarGFVzm3bvSd7U9gt5fRlU8D1yY8n0v3an921CMmPJ9L92p/dtQlHuXEOU/8B+hwfYxfsakAVYDAfocH2MX7Gp7HbRKU/JvqLao0DX4ZITtsdE9vIdca39rnDpUpUb1QPJc/wCX71iRpfvH+o0lsJRYftHmKysP2jzFdxixY2Hct5h7F6Lzh3LeYexei4DGgQhCAMKNZZZOtroDmgCoYCY3cPCwngP6GxUlQpjJxd0Q1cri9pBIIIIJBB2wRoIPKmHqR7uq9Gn9sq0NUvBxBUNqGCzJr53JI3b6w084K6GpHu6r0af2yrpVZqdByX/amUVaVhloQhcw2BCEIAwljqq4nnSR0rToaNdf6Ru1g6BnH8QTLleGtLibAAkngA0kpBYxXuq6qSaxJkec0b+buWN57ABNYSnmnd+DOo9LGgvSnmdE9r2Gz2Oa9p5Wm4/UL7rKV8Mj4niz2OLXDlHBwjfXguro0YlhMMrG1EEczNy9jXDkuNI5wdHQttQLUsxPPgfTuPjRuzm+g/T+jg7rBT1cOpDJNoZi7q5lCEKhIIQhAGCq5zbt3pO9qsYVXObdu9J3tT2C3l9GVTwPXJjyfS/dqf3bUIyY8n0v3an921CUe5cQ5T/wH6HB9jF+xqQBT/wH6HB9jF+xqex20SlPydBRvVA8lz/l+9YpIo3qgeS5/wAv3rEjS/df1Gj2EosP2jzFZWH7R5iu4LFjYdy3mHsXovOHct5h7F6LgMaBCEIAwhKDVIxBzsRLGPcBHGxhAJHjG8h2t+z2+pMLIwk4bTkkk63tnTvlazouMFO+5VSu7G1jmDQ1sWtTZ2aHB4LTYgi42+Yla+T+TdPQF5hz/wCJmB2c6+4zrW0D6xXbQs80suW+hNluZQhCgkEIQgCJ6omJ6xQuY02fMdaHonS89UEfiCgGQGGd0YgwkXji/jO527gc+cQfwlbWqTievV2tNPiQtzPxus5x/aPwlSvUxw3WaMzOHjzOuPs2Xa39c4/iCfX/AJ0L+WZftMjuqjhmt1LKho8WVua702WFzztzeoVB07st8M7qoJABeRg11npMuSByluc3pSRW2EqZoW4K1FZndyMxPuavjeTZjzrT/RfYA9Ds09BTyVcCnrknifddDFKTd+bmP9NniuPTa/MQsMbT1Ui1N+DtoQhImoIQhAGCq5zbt3pO9qsYVXObdu9J3tT2C3l9GVTwPXJjyfS/dqf3bUIyY8n0v3an921CUe5cQ5T/AMB+hwfYxfsakAU/8B+hwfYxfsansdtEpT8nQUb1QPJc/wCX71ikijeqB5Ln/L96xI0v3X9Ro9hKLD9o8xWUOFwQu4LFi4dw30R7F6KAR6pdOGgaxLoAG2z4r62TafiJfWz4rjPD1Pib548k9WniNfHTwvmlNmMBJ5eADhJOgDlUGqdU5tjrVM48Be8AepoPtULx7KGprnAzOGY03axuhreW2+eUq9PCTk/y0RDqLwaNdVPmmklfu5HueeTON7DkG10J1ZE+Taf7P/JSNTyyJ8m0/wBn/kpjGq0EkVp7neQhC5xsCEIQBhaeK1zaenkmduWMc7nIGgdJsOlbigGqpieZBHTNOmR2e/0GbQPO6x/AVenDPNRIk7K4uqeKWqqGsveWaSxP9T3XLuYXJ6E/aSnZFGyNgsxjWsaORosPYlfqX4ZrlU+ocPFibmt9N9x+jc7rBNdMYud5KK8Faa0uCQ+VOGdy1skQFmZ2ez0H+MLc1y38KfCXmqphmdHHVNGlh1t/ou0tJ5nXH41XCTy1LchNXQs0wNSrE82WSlcdDxrrPSbZrhzluafwFL9buD15pqmOdv8AI8OPK3acOlpI6V0a9PPBoxi7O5YNC84ntc0OabtIDgeEHSCvRcUZBCEIAwVXObdu9J3tVjCq5zbt3pO9qewW8voyqeB65MeT6X7tT+7ahGTHk+l+7U/u2oSj3LiHKf8AgP0OD7GL9jUgCn/gP0OD7GL9jU9jtolKfk6CjeqB5Ln/AC/esUkUb1QPJc/5fvWJGl+6/qNHsJRDjYXQsP2jzFdwWGYzUyiIB7pfpAO4b8Vk6mEe9Uv6jfip/DuW8w9i9Fx3iKvyN8kRZz6mDwLxVLSeB0ZH6hx9ih2M4JU0Tw2dmbfcvBu13M7/AAbHkT9XPxnDI6uB8Mg8Vw0Hfa7+Vw5QdKvTxc0/y1RDprwIBPLInybT/Z/5KSNRC6KRzHiz2Ocxw4HNJaf1Cd2RPk2n+z/yVvjf0RWnud5CELnGwIQhAGEisrsU7qrpJAbxg62z0GaARyE3d+JNfLPFO5aCR7TaRw1tnDnv0XHKBnO/CktQa0JY9evrIe0vsLnMBuQByjR0p7Bw3mZzfgcmQ2GdzUEYItJJ/Ffzv0gHmbmjoUiuoeNUXDv/AF7P/aNkbDv/AF6n+0vKnUlJtxZZSSJitDG8PbU00kLv/owtB4HbbT0EA9CjuyNh3/r2f+0bImHf+vU/2oVGondRYZkKN7HNcWuFnNJaRwEGxHrC+V1sp6qCasklp87W5LPIcM0h5HjaOUi/SuSuxF3SbF2OPU6xPX6BrHHx4TrZ9HbYebNNvwlSxJ7U3xPWa7W3HxJm5n4x4zD+4fiThXJxNPJUfvUYg7oyhCFgWMFVzm3bvSd7VYwquc27d6TvansFvL6MqngeuTHk+l+7U/u2oRkx5Ppfu1P7tqEo9y4hyn/gP0OD7GL9jUgCn/gP0OD7GL9jU9jtolKfk6CjeqB5Ln/L96xSRRvVA8lz/l+9Ykaf7r+o0ewlFh+0eYrKw/aPMV3BYsbDuW8w9i9F5w7lvMPYvRcBjQIQhACX1RaMQ4k8jakYyXpN2H9WE9KZWRPkyn+z/wAlbtdhFLO4OnhjkcBmgvY1xA27XO9pK2qenZEwMja1rGizWtAAA4ABtLepWzwjDgoo2bZ7oQhYFwQheFTO2KN0jzZjGue48AaLn2IAWGqliWfUR0zT4sbc93pv2geZv71xsByQqq6EyxGNrA4sGeXC5FrkWB0abdBXIxCrfUTySuBL5Hl1tvdHQ0cwsOhPTAcOFLSxQjbYwBx4XnS49LiSujUm6FOMY7mKWaTbFrsbV/GQ9Z/yo2Nq/jIes/5U20Jfu6pfIhSbG1fxkPWf8qNjav4yHrP+VNtCO7qhkQm8RyDraeF8rnRubG0vIa5xNht2u0bQ09CiisXKwOaWuF2kEEch0EJAYvQGmqJIHbcb3NHK3baelpB6U1ha7ndS3KTjbY1oZXRva9hs9jmvaeBzTcH1hP8AwmubUU8czdp7Gv5iRpHQbjoVfU0NSvE8+GSmcdMbs9voP2x0Ov1lGNp3jm4Cm9bDAQhC5psYKrnNu3ek72qxhVc5t270ne1PYLeX0ZVPA9cmPJ9L92p/dtQjJjyfS/dqf3bUJR7lxDlWAwH6HB9jF+xqr+VYDAfocH2MX7Gp7HbRKU/JvqNaoHkuf8v3rFJVGtUHyXP+X71iRp/vH+o0lsJVYftHmKysP2jzFdwWLGw7lvMPYvReUO4bzD2L1XAY0CEIQAIQhAAhCEAYUL1TMT1mjELT48zs0+g2znes5o6Spokll1iwqq55abxx/wAJnLmnxj0uJ6AExhaeeovWpWbsj5yGoO6MQiBF2xkzO5mWzf7yxO9LrUmoxmTznbLmRDkzRnu9ee31JioxU81S3BEFZGUIQly4IQhAGErNVPDcyaOpaPFkbmO9NmlpPKWm34E01H8tsM7poJWgXewa6z0mabDlLc5v4lrQnkmmVkroSC7eR+J9y18bybMcdbf6L9F+g5ruhcRBC7E4qUWmLp2LHoXDyQxTuqhjkJvIBrb/AE2aCTz6HfiXcXCaabTGk7gq5zbt3pO9qsYq5zbt3pO9qewW8voyqeB65MeT6X7tT+7ahGTHk+l+7U/u2oSj3LiHKsBgP0OD7GL9jVX8po5T4vPSYVRvgk1tzhCwmzTdusl1vGB32hP4uLk4xRnTdrsnqg+qbi0bKXuUOBlkcwlo22sa4PueC5aAOHTwKAT5V4hILOqn25HBn7LLkvmziXOddx0kk3JPKTtqlLCNSUpPYmU7qyMIIWM8cI9aM8cI9a6BkOrI7KGKrp2NLgKhjQ17SbElotnAb7Ta/JeykyreHi97i/OupSZTV0X/AF1MgA3i/PHqfcLnVMHreLNVU5H4srk5NVT5qGCWR2c98THOdoFyRt6NC6qRas7GplCEIAwsErl5S1T4aGeWN2a9kT3NdoNiBt6dCStdj9XPolqHvaf5c6zeq2w/RbUaDqbMpKWUYWWmWjImOp6R4dM4EOkabiMbRAO+/m2udK1Yz28IRnjhHrXTo0o0lZGMpXGNqaY7TxRupZHCN5kMjC42D84NGbc/zDN2t++jaTJBVcM9vCFu0ONVMGiGeRg4A826p0fol6uEzScosvGdtGWDWUv9TjHqqrkmbPLrgY2MtuGCxJcDuQOAKfpCcHCWVmqd1cyhCFUkwvKeZkbS57g1gFy5xAAHKSlJlPlXXx1k8TKgsjZI5rQAwWA3r2v+qi9XiEsxvNK+Q/1vLvVc6E1TwkpJNso5pGa7W9ek1rTFrkmYdq7M45v9tlrrGeOEetGeOEetdRaIwJLkZlKaGUiS5p5LZ4GktI0B4G/o0Eb4twBOKjrIpow+JzXsdpDmm4/1zKvGeOEetbFHiEsLs6KV0bt8seW357baVr4ZVHmTsy8Z20LEKuc27d6Tvampqb41UVbJtfkMmYYw0kN0XDr7kC+0NtKubdu9J3tWeFi4SlF+i03dJj1yY8n0v3an921CMmPJ9L92p/dtQknuXEOU/sDaDRwXF/4MP7GpAqS0+W+IxRtYx7AxjWsb/DadDRYfoF0sTRlUtlMoSS3HPrbfqj1BGtt+qPUEnPD7E+NZ2bEeH2J8azs2JXtKpfPEcett+qPUEa236o9QSc8PsT41nZsR4fYnxrOzYjs6oZ4jj1tv1R6gjW2/VHqCTnh9ifGs7NiPD7E+NZ2bEdnVDPEcoFtpZSZ8PsT4xnZsR4fYnxjOzYo7Kr6J6iHMhJnw+xPjGdmxHh9ifGM7NiOyq+g6iHKQvnW2/VHqCTnh9ifGs7NiPD7E+NZ2bEdnV9BniOPW2/VHqCNbb9UeoJOeH2J8azs2I8PsT41nZsU9nVIzxHHrbfqj1BGtt+qPUEnPD7E+NZ2bEeH2J8azs2I7OqGeI5GtA2gAvpJnw+xPjGdmxHh9ifGM7NiOzq+ieohzISZ8PsT4xnZsR4fYnxjOzYo7Kr6DqIcett4B6gjW2/VHqCTnh9ifGs7NiPD7E+NZ2bFPaVfQZ4jj1tv1R6gjW2/VHqCTnh9ifGs7NiPD7E+NZ2bEdnVIzxHHrbfqj1BGtt+qPUEnPD7E+NZ2bEeH2J8azs2I7OqGeI4wwDaAHMq7Tbt3pO9qk3h9iXGM7NijDjc3O+bpnDUZQbzFZyT2Htkx5Ppfu1P7tqEZMeT6X7tT+7ahc57mhwNjWh4ybrM+VGxrQ8ZN1mfKpshW69T5MMkeCE7GtDxk3WZ8qNjWh4ybrM+VTZRDLXFq6iYJ4nxa05zYwx0bi4OIcSc7Os7cnRYW5VMatSTspEOMV4PDY1oeMm6zPlRsa0PGTdZnyrewxuKzwRympgZrjGyZvcznZocLgX10X0HgWvTYhiTcTjpZnRPidG6UvZG5hLACNouOac/NG/oPKrdSpr+WwWXB47GtDxk3WZ8qNjWh4ybrM+VdzKmGN1HK+QvAjY+QFj3sN2tJG4IztNtBuFydTSFwoNce4uMkj3Akk6G2j3+VjkKrUy5szDKr2seOxrQ8ZN1mfKjY1oeMm6zPlU2Qqdep8mTkjwQnY1oeMm6zPlRsa0PGTdZnyqbIR16nyYZI8EJ2NaHjJusz5UbGtDxk3WZ8qmyEdep8mGSPBCdjWh4ybrM+VGxrQ/Xm6zPlU2UPwbKo1WKS07CO52xuzDYeM9jmhzr8BzjbkF99TGrVkm03oQ4xR47GtDxk3WZ8qNjWh4ybrM+VTVQzVKYxlGZs6RsucxjC2R7Rtkm7Qc0+LnabX2uBTGtUk1HM9QcUlex87GtDxk3WZ8qNjWh4ybrM+Vd/JimMVDAx1y7W2udfSc53jHb5XFddQ61RO2Zk5VwQnY1oeMm6zPlRsa0PGTdZnyqbIUdep8mGSPBCdjWh4ybrM+VGxrQ8ZN1mfKpshHXqfJhkjwQnY1oeMm6zPlRsa0PGTdZnyqbIR16nyYZI8EJ2NaHjJusz5UbGtDxk3WZ8q7mU1LE+mkklLwI45Hgse9hFm3v4pAduRoN1xtTGF4onSPJcZJHEEknxWgM3/wCoOV+rUy5szIyq9rHxsa0PGTdZnyo2NaHjJusz5VNkKnXqfJk5I8GtQUrYIY4Wk5sbGRi+3ZrQ0X5dCFtIWRYEIQgDCXOqnUB76anzg0Oc57idAbciNrjyWMnqTGS5qP8AlZSNG2yBrf7GF/75QOha0P2zcJsrPax2cXyvo4KctppWSTZoZExhzvGtmtLraA0aFJI6dt2ve1pmDMwvzRexsXAHeBLQbcgXPxzBWVRhJDQYpo5SSNJa3SWgjh0epdlUk1ZW+yVciWqVWa1hz23sZXMjHNfPd/awjpXayeo9Yo4YjoLY2A+kRd36kqK5ffx62hpBpDpNceP6S4Nv1Wyqeq8tIRXN2Qt2QbKLHMRpKqBt4HRTSZrWNa8utnNbYuJ2znjSAByKU45W9z0sswtdkb3C+0XAeKD02URxU905QQR7bIGB55HWL/aYlvap1XreHFm/JIxnQLvP7P1Vsqbirb7hfdnTyQr56miZNPm57y8+KM0ZocWjRp+rfpXdXPwSj1ilhi32RsYecNFz67roLGTWZ2JWxlCFr1dSyGJ8khzWMaXuPAALlQScbKWpe/Mo4TaaouHOH/zhH/ZJyGxzRyu5FFe5mUeUMLGNDYnxtaAODW3MH90YXawnDKyYurdf1mSoa0hhjY8xxC5Yy5OjQQ48pK4OV0E1NX0c8suunPaM7MayzWSNJHi7dw8pmmldxT8P/JSXIzUv9UuXXJaSmDXOz5C9zW6SdLWAAHRchz9tMBQEf8nKQ77aaL9Q35pv7VnR0k3wmyXtY2MqK3FqaA1LHwsjaWgxBueQHENF3u0ONyL2A6dtSfBK01FLFM5ua6SNjyOAuF9HIozqn1Du5oqdm7mla23CG/8A6LF38QPcmHSa1oMNO4M5Cxlm+wIavFaatgt2cs43PV1b6ahLWRxG0tQ5uf42kZkbbgE3BFzo8U6Nq/lT4xVQ4q2ileJo5I88PzGscw2cbHN0EeId7+YdPM1P4qwUP/HbA1r5HuMj3PcbizP+toG0G/X033lJcIyeZBM+pkkdNVP0OkcALDR4rGjQ0aAN/aVp5Ytr6+wV2fGUmUHcpZDEzXKuU5scd7DSbZzzvNv67HasSNeuGJU9M+ofUxvkjY6R0etWjIaM5zQQc/avY30m2hcXBDr+UNRI/TrTHtYODNLYxboL+suxqjVmtYa8Xs6RzIh0nPcOqxyMiUoxXm1/sL6Nm1kbitRWUpnnDAXSPDQwEAMbYb5JJuHLWrMenmqzR0GZns0yzPGc2McDWgjPdvaTa+jeJG9g8JpMMjFvGjgzyP680vd/cSo/qVxXp5pnG8kktnHfNmh2npe49Ki0fylbbYNdEeWXktdTUea+ZksMpETyYwxzf5vFzTYghjgbjf8AVLMmaPWKGCK1i2NhcP6nDOd/cSotqhfx6qipBpD5M54/pLmsv1dc9Snyib/CK5uwW7BZQhZFgQhCABCEIA068z5o1gRl19OuFwFvwgkm9lEMGyaxCmrJKoyU73y54eDrg3Tg85tho0gaOBTpCsptJpeSGrmVhZQqkkMx7J+sfiMVbSuiJYwNzZS8AbsHcg3BDzwaVKqQSiMa6WGT+YsBa2/ICSdq2+thfDxcEA2JBFxvcqs5OVk/BCViG4hk9XsxJ1bRvh8doa5shcLDNa0jxQbjxGnbGkLl5QUs1TiNJSyyCSQHXpQ1uaxjLg2DdJvmscLuJJzhtXspBgWE4jSRyMNQya5ux0uuEsO/fSSQdBtcWseFbmBYCKZ8k0rzLVy6XykW0fUYP5WCw9Q4ABrns73vZWRGW53kIQsCxhRHKbB8RrRrYfAynDs7N8cl+abtzzba0A2G/wBClyFMXZ3RDVzVodezP44YJL/yFxbbe3WlRXKzJ2uxAtGdAyONzi2xkLjew0m1hoA0BTRCmMnF3QNX0NHCxUCMCpLDINF486zgANJDto3voXHybyflpqmpqJXNc+d+c3Nv4rS5zrG45Wj8KkyFGZq6XkLESytwCqqZ6eemfGHQm+bJnAXzmuB8UG+5AI0c670dPJJA6OqLHF7XNcIw5rc1wsQM4knQTp/Rb6FLk2kuAsQbB8ExTDi+OmdBLTudnN1wva5p2r2aDvWvvaN5SLDcOka8zVDxJUObmeKC1kbL3zWNNzpIF3HSbDasAuuhEpt6sErEMxDJ6rixA1tA6MukGbIyUuANwL2LQdBzWnkI372XnlNkxW18LC+WMTNdcRjObE1pFjY2LnP/AKiNrQANJM3QpVWSaflBlRzcMiqdaLasxOcRa0bXAWtY3LjpvzBRnB8AxHD5HspXQPpnuzhrpeHM3r2aNJsANvTYbSnCFCm1f2FiDYnkxXGuiq4ZY5JGAZ2u5zQD4wIY1oNmWcbC9xt3JN1MaVsoYNdLTJ/MWAtF77wJJ2tG2thCHNyST8AlYyhCFUkEIQgD/9k="
 	width=60 height=60 class="center">
    <h3>Login</h3>
    <form class="login-form">
      <p>Username</p>
      <input type="text" name="username" placeholder="Enter your username..." id="username" required>
      <p>Password</p>
      <input type="password" name="password" placeholder="Enter your password..." id="password" required>
      <input type="button" id="button" name=""  class="sub btn btn-primary text-dark" onclick="login()" value="Login">
    </form>
  </div> 
 
  
</body>
</html>