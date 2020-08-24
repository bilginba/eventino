<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en-US">
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html">
<title>Event Creation</title>
<link rel="stylesheet" type="text/css" media="all"
	href="resources/css/create_event.css">
</head>
<body>
	<div id="wrapper">
		<h1>Create Your Event</h1>
		<form name="CreatEventForm" id="creat-event-form" method="POST"
			action="CreateEvent">
			<div class="col-2">
				<label> Name <input placeholder="What is your event name?"
					id="title" name="event_title" tabindex="1">
				</label>
			</div>
			<div class="col-2">
				<label> Date <input type="date"
					placeholder="When is your event? YYYY-MM-DD" id="time"
					name="event_time" tabindex="2">
				</label>
			</div>
			<div class="col-3">
				<label> Description <input
					placeholder="What is your event about?" id="textarea"
					name="event_desc" tabindex="3">
				</label>
			</div>
			<div class="col-3">
				<label> Address <input placeholder="Where is your event?"
					id="address" name="event_address" tabindex="4">
				</label>
			</div>
			<div class="col-3">
				<label> Type <select name="event_type" tabindex="5">
						<option>Conference</option>
						<option>Seminar</option>
						<option>Meeting</option>
						<option>Trade Show</option>
						<option>Networking</option>
						<option>Product Launch</option>
						<option>Party</option>
						<option>Trade Fair</option>
						<option>Award Ceremony</option>
						<option>Art</option>
				</select>
				</label>
			</div>
			<div class="col-4">
				<label> Publish Date <input type="date"
					placeholder="When do you want to publish your event?"
					id="publish_date" name="event_publish_date" tabindex="6">
				</label>
			</div>
			<div class="col-4">
				<label> Expire Date <input type="date"
					placeholder="When do you want to cancel your event?"
					id="expire_date" name="event_expire_date" tabindex="7">
				</label>
			</div>
			<div class="col-4">
				<label> Event Photo <input type="file"
					placeholder="Choose your event photo." name="event_photo"
					accept="image/gif, image/jpeg, image/png" tabindex="8">
				</label>
			</div>
			<input type="hidden" value="">
			<div class="col-submit">
				<button class="submitbtn">Create Event</button>
			</div>
		</form>
	</div>


</body>
</html>