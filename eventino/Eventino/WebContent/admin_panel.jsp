<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.eventino.web.model.EventModel"%>
<%@page import="com.eventino.web.model.TicketModel"%>
<%@page import="com.eventino.web.model.TicketRequestModel"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Events</title>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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

<link type="text/css" rel="stylesheet"
	href="resources/css/admin_panel.css" />


<script>
	$(function() {
		$("#header").load("header.jsp");
		$("#footer").load("footer.jsp");
	});
</script>

</head>
<body>

	<div id="header"></div>
	<div class="span7">
		<div class="widget stacked widget-table action-table">
			<div class="widget-content">
				<form role="form" name="regForm" id="accept-form" action=""
					method="POST">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Event Name</th>
								<th>Student ID</th>
								<th class="td-actions"></th>
							</tr>
						</thead>
						<tbody>

							<%
								List<EventModel> rEvents = (ArrayList<EventModel>) request.getAttribute("ticketES");
								List<TicketRequestModel> rTickets = (ArrayList<TicketRequestModel>) request.getAttribute("ticketRS");

								if (!rEvents.isEmpty()) {
									if (!rTickets.isEmpty()) {
										for (int i = 0; i < rEvents.size(); i++) {
							%>
							<tr>
								<td>
									<%
										out.print(rEvents.get(i).getEvent_title());
									%>
								</td>
								<td>
									<%
										out.print(rTickets.get(i).getStudent_id());
									%>
								</td>
								</td>
								<td class="td-actions">
									<form role="form" name="RequestAnswer" id="RequestAnswer"
										method="POST" action="RequestAnswer">
										<div class="form-group">
											<fieldset>
												<input name="ticketID" type="hidden"
													value="${rTickets.get(i).getTicket_id()}">
										</div>
										<div class="form-group">
											<input name="studentID" type="hidden"
												value="${rTickets.get(i).getStudent_id()}">
										</div>
										<div class="form-group">
											<input name="ans" type="hidden"
												value="true">
										</div>
										<input type="submit" class="btn btn-primary btn-block btn-lg">
										</fieldset>
									</form>
									
									<form role="form" name="RequestAnswer" id="RequestAnswer"
										method="POST" action="RequestAnswer">
										<div class="form-group">
											<fieldset>
												<input name="ticketID" type="hidden"
													value="${rTickets.get(i).getTicket_id()}">
										</div>
										<div class="form-group">
											<input name="studentID" type="hidden"
												value="${rTickets.get(i).getStudent_id()}">
										</div>
										<div class="form-group">
											<input name="ans" type="hidden"
												value="false">
										</div>
										<input type="submit" class="btn btn-primary btn-block btn-lg">
										</fieldset>
									</form>
								</td>
							</tr>

							<%
								}
									}
								}
							%>


						</tbody>
					</table>
				</form>
			</div>
			<!-- /widget-content -->

		</div>
		<!-- /widget -->
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