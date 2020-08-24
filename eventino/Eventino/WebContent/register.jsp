<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Eventino</title>

<!------ Bootstrap ---------->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


<!------ Include the above in your HEAD tag ---------->

<link href="https://fonts.googleapis.com/css?family=Open+Sans"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Kaushan+Script"
	rel="stylesheet">
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.0/animate.css" />
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css"
	media="screen">
<script
	src="//cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>

<link type="text/css" rel="stylesheet" href="resources/css/style.css" />

<link type="text/css" rel="stylesheet" href="resources/css/register.css" />
<script src="resources/js/register.js"></script>


<script src="https://code.jquery.com/jquery-3.3.1.js"
	integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	crossorigin="anonymous">
	
</script>
<script>
	$(function() {
		$("#header").load("header.jsp");
		$("#footer").load("footer.jsp");
	});
</script>

</head>

<body>
	<div id="header"></div>

	<div class="form-container">

		<div class="row">
			<div
				class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
				<form role="form" name="regForm" id="register-form"
					action="Register" method="POST">
					<br> <br>  <br>
					<hr class="colorgraph">
					<div class="form-group">
						<input type="text" name="username" id="username"
							class="form-control input-lg" placeholder="Username" tabindex="1">
					</div>
					<div class="form-group">
						<input type="email" name="email" id="email"
							class="form-control input-lg" placeholder="Email Address"
							tabindex="2">
					</div>
					<div class="form-group">
						<input type="text" name="phone" id="phone"
							class="form-control input-lg" placeholder="Phone" tabindex="3">
					</div>
					<div class="form-group">
						<div class="dropdown">
							<select name="account-type"
								class="dropdown-select-version select" tabindex="4">
								<option disabled="disabled" selected="selected">Account
									Type</option>
								<option>Participant</option>
								<option>Advertiser</option>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-6 col-md-6">
							<div class="form-group">
								<input type="password" name="password" id="password"
									class="form-control input-lg" placeholder="Password"
									tabindex="5">
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-6">
							<div class="form-group">
								<input type="password" name="password_confirmation"
									id="password_confirmation" class="form-control input-lg"
									placeholder="Confirm Password" tabindex="6">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-4 col-sm-3 col-md-3">
							<span class="button-checkbox">
								<button type="button" class="btn" data-color="info" tabindex="7">I
									Agree</button> <input type="checkbox" name="t_and_c" id="t_and_c"
								class="hidden" value="1">
							</span>
						</div>
						<div class="col-xs-8 col-sm-9 col-md-9">
							By clicking <strong class="label label-primary">Register</strong>,
							you agree to the <a href="#" data-toggle="modal"
								data-target="#t_and_c_m">Terms and Conditions</a> set out by
							this site, including our Cookie Use.
						</div>
					</div>
					

					<hr class="colorgraph">
					<div class="row">
					<div class="col-xs-12 col-md-6">
						<input type="submit" value="Register"
							class="btn btn-primary btn-block btn-lg" tabindex="7">
					</div>
					<div class="col-xs-6 col-sm-6 col-md-6">
						<a href="login.jsp" class="btn btn-lg btn-success btn-block" tabindex="7">Login</a>
					</div>
					</div>
				</form>
			</div>
		</div>
		<!-- Modal -->
		<div class="modal fade" id="t_and_c_m" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel">Terms & Conditions</h4>
					</div>
					<div class="modal-body">
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Similique, itaque, modi, aliquam nostrum at sapiente consequuntur
							natus odio reiciendis perferendis rem nisi tempore possimus ipsa
							porro delectus quidem dolorem ad.</p>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Similique, itaque, modi, aliquam nostrum at sapiente consequuntur
							natus odio reiciendis perferendis rem nisi tempore possimus ipsa
							porro delectus quidem dolorem ad.</p>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Similique, itaque, modi, aliquam nostrum at sapiente consequuntur
							natus odio reiciendis perferendis rem nisi tempore possimus ipsa
							porro delectus quidem dolorem ad.</p>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Similique, itaque, modi, aliquam nostrum at sapiente consequuntur
							natus odio reiciendis perferendis rem nisi tempore possimus ipsa
							porro delectus quidem dolorem ad.</p>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Similique, itaque, modi, aliquam nostrum at sapiente consequuntur
							natus odio reiciendis perferendis rem nisi tempore possimus ipsa
							porro delectus quidem dolorem ad.</p>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Similique, itaque, modi, aliquam nostrum at sapiente consequuntur
							natus odio reiciendis perferendis rem nisi tempore possimus ipsa
							porro delectus quidem dolorem ad.</p>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Similique, itaque, modi, aliquam nostrum at sapiente consequuntur
							natus odio reiciendis perferendis rem nisi tempore possimus ipsa
							porro delectus quidem dolorem ad.</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal">I
							Agree</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
	</div>
</body>
</html>
