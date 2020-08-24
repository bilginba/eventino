<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.eventino.web.model.EventModel"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Events</title>

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


<script src="resources/js/all_events.js"></script>
<link type="text/css" rel="stylesheet"
	href="resources/css/all_events.css" />

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
	<div class="event-box">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 my-3">
					<div class="pull-right">
						<div class="btn-group">
							<button class="btn btn-info" id="list">List View</button>
							<button class="btn btn-danger" id="grid">Grid View</button>
						</div>
					</div>
				</div>
			</div>
			<div id="products" class="row view-group">




				<%
					List<EventModel> eventList = (ArrayList<EventModel>) request.getAttribute("events");
					if (!eventList.isEmpty()) {
						for (EventModel event : eventList) {
				%>


				<div class="item col-xs-4 col-lg-4">
					<div class="thumbnail card">
						<div class="img-event">
							<img class="group list-group-image img-fluid"
								src="<%out.print(event.getEvent_photo());%>" alt="" />
						</div>
						<div class="caption card-body">
							<h4 class="group card-title inner list-group-item-heading">
								<%
									out.print(event.getEvent_title());
								%>
							</h4>
							<p class="group inner list-group-item-text">
								<%
									out.print(event.getEvent_desc());
								%>
							</p>
							<div class="row">
								<div class="col-xs-12 col-md-6">
									<p class="lead">
										<%
											out.print(event.getEvent_time());
										%>
									</p>
								</div>
								<div class="col-xs-12 col-md-6">
									<form class="form-inline" action="Event" method="POST">
									
										<div class="form-group">
											<input type="hidden" name="eventID" value="<%out.print(event.getEvent_id());%>">
										</div>

										<button type="submit" class="btn-join" value="Event">Detail</button>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>

				<%
					}
					}
				%>
			</div>
		</div>
	</div>
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