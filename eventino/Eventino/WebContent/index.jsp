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
<link type="text/css" rel="stylesheet" href="resources/css/pricing.css" />
<link type="text/css" rel="stylesheet" href="resources/css/notice.css" />

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

	<%
		/*
		<div class="container">
		<div class="row">
		<br><br>
			<div class="error-notice">
		     <div class="oaerror danger">
		<strong>Error</strong> - You provided a wrong username/password
		     </div>
		     <div class="oaerror warning">
		<strong>Error</strong> - You left a field Blank
		     </div>
		     <div class="oaerror info">
		<strong>Error</strong> - Please Select a Different Username
		     </div>
		     <div class="oaerror success">
		<strong>Yeppi</strong> - You are successfully registered. Please login.
		     </div>
		   </div>
		</div>
		</div>*/
	%>
	
	<%
				if (request.getAttribute("error") != null) {
			%>
			<div class="note" id="note">
				<div class="row">
					<div class="error-notice">
						<div class="oaerror warning">
							<strong>Sorry -</strong> ${error}
						</div>
					</div>
				</div>
			</div>


			<%
				}
			%>

			<%
				if (request.getAttribute("success") != null) {
			%>
			<div class="note" id="note">
				<div class="row">
					<div class="error-notice">
						<div class="oaerror success">
							<strong>Congratulations -</strong> ${success}
						</div>
					</div>
				</div>
			</div>
			<%
				}
			%>

	<header class="masthead text-white ">
		<div class="overlay"></div>
		<div class="container slider-top-text">
			<div class="row">
				<div class="col-md-12 text-center">
					<h3 class="my-heading">
						EVENT<span class="bg-main">INO</span>
					</h3>
					<p class="myp-slider text-center">"Success is most often
						achieved by those who don't know that failure is inevitable." -
						Coco</p>
					<a class="btn btn-primary btn-join" href="/Eventino/Events">FIND
						AN EVENT</a>

				</div>
				<div class="col-md-12 text-center mt-5">
					<div class="scroll-down">
						<a class="btn btn-default btn-scroll floating-arrow"
							href="#gobottom" id="bottom"><i class="fa fa-angle-down"></i></a>
					</div>
				</div>
			</div>
		</div>
	</header>

	<section class="testimonials" id="gobottom">
		<div class="container">
			<div class="row">
				<div class="col-md-4 mb-3 wow bounceInUp" data-wow-duration="1.4s">
					<div class="big-img">
						<img src="resources/img/preview_1.jpg" class="img-fluid">
					</div>
				</div>
				<div class="col-md-8">
					<div class="inner-section wow fadeInUp">
						<h3>
							<span class="bg-main">Don't Miss an Event Near to You</span>
						</h3>
						<br>
						<p class="text-justify">Here you can reach various kind of
							events. Conferences, Seminars, Workshops, Concerts and more. Stay
							tuned with us and live your life as you want. Develop your
							skills, go to classical music concerto or go to the concert of
							your favorite singer</p>

						<div class="linear-grid">
							<div class="row">
								<div class="col-sm-6 col-md-3 mb-2 wow bounceInUp"
									data-wow-duration="1.4s">
									<img src="resources/img/preview_2.jpg" class="img-thumbnail">
								</div>
								<div class=" col-sm-6 col-md-3 mb-2 wow bounceInUp"
									data-wow-duration="1.4s">
									<img src="resources/img/preview_3.jpg" class="img-thumbnail">
								</div>
								<div class="col-sm-6 col-md-3 mb-2 wow bounceInUp"
									data-wow-duration="1.4s">
									<img src="resources/img/preview_4.jpg" class="img-thumbnail">
								</div>
								<div class="col-sm-6 col-md-3 mb-2 wow bounceInUp"
									data-wow-duration="1.4s">
									<img src="resources/img/preview_5.jpg" class="img-thumbnail">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section class="testimonials mybg-events">

		<div class="container">

			<div class="row">
				<div class="col-md-12 wow fadeInUp">
					<h3 class="title-heading text-center">Students, We are Here
						for You!</h3>
				</div>
			</div>
			<div class="row wow slideInLeft" data-wow-duration="3s">
				<div class="col-md-4 mb-3">
					<div class="big-img2">
						<img src="resources/img/student_1.jpg" class="img-fluid">
					</div>

				</div>
				<div class="col-md-8">
					<div class="inner-section">
						<div class="my-grid">
							<div class="row">
								<div class="col-sm-6 col-md-4 mb-3">

									<img src="resources/img/student_2.jpg" class="img-fluid">

								</div>
								<div class="col-sm-6 col-md-8 mb-3 ">

									<img src="resources/img/student_3.jpg" class="img-fluid">

								</div>

								<div class="col-md-8 mb-3">
									<div class="text-block">
										<h5 class="events-heading">Do you want to go to an event
											without paying money?</h5>
										<p class="myp-font">Then you are in the right place. After
											each event we store a fair amount of money and let students
											have the chance to use this money to buy tickets. We do
											raffles and buy tickets for some lucky students.</p>
									</div>
								</div>
								<div class=" col-md-4 ">

									<img src="resources/img/student_4.jpg" class="img-fluid">

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section class="testimonials text-center">
		<div class="container">
			<div class="row">
				<div class="col-md-8 mx-auto wow fadeInUp">
					<h3 class="text-center font-weight-bold">
						SHARE WITH EVENT<span class="bg-main">INO</span>
					</h3>
					<p class=" text-center">Share Upcoming Events with Your
						Friends. Don't Let Them Miss This Opportunity...</p>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6 col-md-4 col-lg-3 mt-4 wow bounceInUp"
					data-wow-duration="1.4s">
					<div class="card">
						<img class="card-img-top" src="resources/img/event_1.jpg">
						<div class="card-block">

							<h4 class="card-title text-center">ANIMAL RIGHTS CONFERENCE</h4>

							<div class="card-text text-center">
								<div class="social-icons">
									<a href="#" class="btn btn-circle my-social-btn fb"><i
										class="fa fa-facebook"></i></a> <a href="#"
										class="btn btn-circle my-social-btn twitter"><i
										class="fa fa-twitter"></i></a> <a href="#"
										class="btn btn-circle my-social-btn google"><i
										class="fa fa-google"></i></a>
								</div>
							</div>
						</div>
						<div class="card-footer text-center">
							<small>Participate in this awareness-raising event.</small>

						</div>
					</div>
				</div>
				<div class="col-sm-6 col-md-4 col-lg-3 mt-4 wow bounceInUp"
					data-wow-duration="1.4s">
					<div class="card">
						<img class="card-img-top" src="resources/img/event_2.jpg">
						<div class="card-block">

							<h4 class="card-title text-center">BEATLES CONCERT</h4>

							<div class="card-text text-center">
								<div class="social-icons">
									<a href="#" class="btn btn-circle my-social-btn fb"><i
										class="fa fa-facebook"></i></a> <a href="#"
										class="btn btn-circle my-social-btn twitter"><i
										class="fa fa-twitter"></i></a> <a href="#"
										class="btn btn-circle my-social-btn google"><i
										class="fa fa-google"></i></a>
								</div>
							</div>
						</div>
						<div class="card-footer text-center">
							<small>Take part in the re-awakening of a legend by the
								new generation</small>

						</div>
					</div>
				</div>
				<div class="col-sm-6 col-md-4 col-lg-3 mt-4 wow bounceInUp"
					data-wow-duration="1.4s">
					<div class="card">
						<img class="card-img-top" src="resources/img/event_3.jpg">
						<div class="card-block">

							<h4 class="card-title text-center">ARTIFICIAL INTELLIGENCE
								SEMINAR</h4>

							<div class="card-text text-center">
								<div class="social-icons">
									<a href="#" class="btn btn-circle my-social-btn fb"><i
										class="fa fa-facebook"></i></a> <a href="#"
										class="btn btn-circle my-social-btn twitter"><i
										class="fa fa-twitter"></i></a> <a href="#"
										class="btn btn-circle my-social-btn google"><i
										class="fa fa-google"></i></a>
								</div>
							</div>
						</div>
						<div class="card-footer text-center">
							<small>Go deep into artificial intelligence and question
								mechanization. </small>

						</div>
					</div>
				</div>
				<div class="col-sm-6 col-md-4 col-lg-3 mt-4 wow bounceInUp"
					data-wow-duration="1.4s">
					<div class="card">
						<img class="card-img-top" src="resources/img/guitar_master.jpg">
						<div class="card-block">

							<h4 class="card-title text-center">FELIPETONOS</h4>

							<div class="card-text text-center">
								<div class="social-icons">
									<a href="#" class="btn btn-circle my-social-btn fb"><i
										class="fa fa-facebook"></i></a> <a href="#"
										class="btn btn-circle my-social-btn twitter"><i
										class="fa fa-twitter"></i></a> <a href="#"
										class="btn btn-circle my-social-btn google"><i
										class="fa fa-google"></i></a>
								</div>
							</div>
						</div>
						<div class="card-footer text-center">
							<small>This music band is the jewel of this generation.
								Join this concert and let these young talents enchant you. </small>

						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section class="testimonials text-center mybg-music">
		<div class="container">
			<div class="row">
				<div class="col-md-12 wow fadeInUp">
					<h3 class="title-heading text-center font-weight-bold">BUILD
						YOUR CAREER!</h3>
					<p class="myp text-center">Build your career with workshops,
						conferences, seminars, etc. Attend some events that companies
						held. Get to know environment and people. Expand your network!</p>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6 col-md-4 col-lg-2 mt-4 gal-item wow bounceInUp"
					data-wow-duration="1.4s">
					<div class="music-gal item box">
						<a
							href="https://images.pexels.com/photos/761963/pexels-photo-761963.jpeg?auto=compress&cs=tinysrgb&h=650&w=940"
							class="fancybox" rel="ligthbox"> <img class="img-fluid"
							src="resources/img/career_1.jpg">
						</a>
					</div>
				</div>
				<div class="col-sm-6 col-md-4 col-lg-2 mt-4 gal-item wow bounceInUp"
					data-wow-duration="1.4s">
					<div class="music-gal item box">
						<a
							href="https://images.pexels.com/photos/838696/pexels-photo-838696.jpeg?auto=compress&cs=tinysrgb&h=650&w=940"
							class="fancybox" rel="ligthbox"> <img class="img-fluid"
							src="resources/img/career_2.jpg">
						</a>
					</div>
				</div>
				<div class="col-sm-6 col-md-4 col-lg-2 mt-4 gal-item wow bounceInUp"
					data-wow-duration="1.4s">
					<div class="music-gal item box">
						<a
							href="https://images.pexels.com/photos/1047930/pexels-photo-1047930.jpeg?auto=compress&cs=tinysrgb&h=650&w=940"
							class="fancybox" rel="ligthbox"> <img class="img-fluid"
							src="resources/img/career_3.jpg">
						</a>
					</div>
				</div>
				<div class="col-sm-6 col-md-4 col-lg-2 mt-4 gal-item wow bounceInUp"
					data-wow-duration="1.4s">
					<div class="music-gal item box">
						<a
							href="https://images.pexels.com/photos/164693/pexels-photo-164693.jpeg?auto=compress&cs=tinysrgb&h=650&w=940"
							class="fancybox" rel="ligthbox"> <img class="img-fluid"
							src="resources/img/career_4.jpg">
						</a>
					</div>
				</div>
				<div class="col-sm-6 col-md-4 col-lg-2 mt-4 gal-item wow bounceInUp"
					data-wow-duration="1.4s">
					<div class="music-gal item box">
						<a
							href="https://images.pexels.com/photos/876713/pexels-photo-876713.jpeg?auto=compress&cs=tinysrgb&h=650&w=940"
							class="fancybox" rel="ligthbox"> <img class="img-fluid"
							src="resources/img/career_5.jpg">
						</a>
					</div>
				</div>
				<div class="col-sm-6 col-md-4 col-lg-2 mt-4 gal-item wow bounceInUp"
					data-wow-duration="1.4s">
					<div class="music-gal item box">
						<a
							href="https://images.pexels.com/photos/258732/pexels-photo-258732.jpeg?auto=compress&cs=tinysrgb&h=650&w=940"
							class="fancybox" rel="ligthbox"> <img class="img-fluid"
							src="resources/img/career_6.jpg">
						</a>
					</div>
				</div>


			</div>
		</div>
	</section>

	<section class="testimonials bg-light" id="marketplace">
		<div class="container mb-5 mt-5">
			<div class="pricing card-deck flex-column flex-md-row mb-3">
				<div class="card card-pricing text-center px-3 mb-4">
					<span
						class="h6 w-60 mx-auto px-4 py-1 rounded-bottom bg-primary text-white shadow-sm">Starter</span>
					<div class="bg-transparent card-header pt-4 border-0">
						<h1 class="h1 font-weight-normal text-primary text-center mb-0"
							data-pricing-value="15">
							$<span class="price">10</span><span class="h6 text-muted ml-2"></span>
						</h1>
					</div>
					<div class="card-body pt-0">
						<ul class="list-unstyled mb-4">
							<li>Publish 1 Event</li>
							<li>Publish an Event up to 1 month</li>
							<li>No Support</li>
						</ul>
						<%
							if (session.getAttribute("username") == null) {
						%>
						<button type="button" class="btn btn-outline-secondary mb-3"
							disabled>Order now</button>
						<%
							} else {
								if (session.getAttribute("user-type").equals("Advertiser")) {
						%>
						<form role="form" name="buyEvent" id="BuyEvent" method="POST"
							action="BuyEvent">
							<input type="hidden" name="price" id="price" value=10>
							<button type="submit" class="btn btn-outline-secondary mb-3">Order
								now</button>
						</form>
						<%
							}
							}
						%>
					</div>
				</div>
				<div class="card card-pricing popular shadow text-center px-3 mb-4">
					<span
						class="h6 w-60 mx-auto px-4 py-1 rounded-bottom bg-primary text-white shadow-sm">Professional</span>
					<div class="bg-transparent card-header pt-4 border-0">
						<h1 class="h1 font-weight-normal text-primary text-center mb-0"
							data-pricing-value="30">
							$<span class="price">18</span><span class="h6 text-muted ml-2"></span>
						</h1>
					</div>
					<div class="card-body pt-0">
						<ul class="list-unstyled mb-4">
							<li>Publish 1 Events</li>
							<li>Publish Events up to 3 months</li>
							<li>Limited Support</li>
						</ul>
						<%
							if (session.getAttribute("username") == null) {
						%>
						<button type="button" class="btn btn-outline-secondary mb-3"
							disabled>Order now</button>
						<%
							} else {
								if (session.getAttribute("user-type").equals("Advertiser")) {
						%>
						<form role="form" name="buyEvent" id="BuyEvent" method="POST"
							action="BuyEvent">
							<input type="hidden" name="price" id="price" value=10>
							<button type="submit" class="btn btn-outline-secondary mb-3">Order
								now</button>
						</form>
						<%
							}
							}
						%>
					</div>
				</div>
				<div class="card card-pricing text-center px-3 mb-4">
					<span
						class="h6 w-60 mx-auto px-4 py-1 rounded-bottom bg-primary text-white shadow-sm">Business</span>
					<div class="bg-transparent card-header pt-4 border-0">
						<h1 class="h1 font-weight-normal text-primary text-center mb-0"
							data-pricing-value="45">
							$<span class="price">35</span><span class="h6 text-muted ml-2"></span>
						</h1>
					</div>
					<div class="card-body pt-0">
						<ul class="list-unstyled mb-4">
							<li>Publish 1 Events</li>
							<li>Publish Events up to 6 months</li>
							<li>UnlimitedSupport</li>
						</ul>
						<%
							if (session.getAttribute("username") == null) {
						%>
						<button type="button" class="btn btn-outline-secondary mb-3"
							disabled>Order now</button>
						<%
							} else {
								if (session.getAttribute("user-type").equals("Advertiser")) {
						%>
						<form role="form" name="buyEvent" id="BuyEvent" method="POST"
							action="BuyEvent">
							<input type="hidden" name="price" id="price" value=10>
							<button type="submit" class="btn btn-outline-secondary mb-3">Order
								now</button>
						</form>
						<%
							}
							}
						%>
					</div>
				</div>
			</div>
		</div>
	</section>


	<div id="footer"></div>


	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/wow/1.1.2/wow.min.js"></script>
	<script>
		new WOW().init();
	</script>
	<script>
		$(window).scroll(function() {

			var topWindow = $(window).scrollTop();
			var topWindow = topWindow * 1.5;
			var windowHeight = $(window).height();
			var position = topWindow / windowHeight;
			position = 1 - position;

			$('#bottom').css('opacity', position);

		});

		function openNav() {
			document.getElementById("mySidenav").style.width = "250px";
			document.getElementById("main").style.display = "0";
			document.body.style.backgroundColor = "white";
		}

		function closeNav() {
			document.getElementById("mySidenav").style.width = "0";
			document.getElementById("main").style.marginRight = "0";
			document.body.style.backgroundColor = "white";
		}

		$(window).on("scroll", function() {
			if ($(this).scrollTop() > 10) {
				$("nav.navbar").addClass("mybg-dark");
				$("nav.navbar").addClass("navbar-shrink");

			} else {
				$("nav.navbar").removeClass("mybg-dark");
				$("nav.navbar").removeClass("navbar-shrink");

			}

		});

		$(function() {
			$('#bottom')
					.click(
							function() {
								if (location.pathname.replace(/^\//, '') == this.pathname
										.replace(/^\//, '')
										&& location.hostname == this.hostname) {
									var target = $(this.hash);
									target = target.length ? target
											: $('[name=' + this.hash.slice(1)
													+ ']');
									if (target.length) {
										$('html,body').animate({
											scrollTop : target.offset().top
										}, 500);
										return false;
									}
								}
							});
		});
	</script>
	<script>
		$(document).ready(function() {
			$(".fancybox").fancybox({
				openEffect : "none",
				closeEffect : "none"
			});
		});
	</script>
</body>
</html>
