<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<title>Login</title>
</head>
<body>
	
	<div class="pt-5">
		<div class="global-container">
			<div class="card login-form">
				<div class="card-body">
					<h2 class="card-title text-center font-weight-bold">Login</h2>
					<hr width="1%">
					<img class="img img-fluid rounded mx-auto d-block" src="https://cdn-icons-png.flaticon.com/512/149/149071.png" height="70%" width="70%"></img>
					<div class="card-text">
						<form action="LoginServlet" method=post>
							<div class="form-group">
								<label for="exampleInputEmail1"> Enter Email ID </label> <input
									type="email" class="form-control form-control-sm"
									name=email aria-describedby="emailHelp">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Enter Password </label> 
								<!-- <a
									href="#" style="float: right; font-size: 12px;"> Forgot
									password? </a> -->
									 <input type="password"
									class="form-control form-control-sm" name=password>
							</div>
							<button type="submit" class="btn btn-primary btn-block">
								Sign in</button>

							<div class="sign-up">
								Don't have an account? <a href="register.jsp"> Create One </a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
</div>
		
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
</body>
</html>