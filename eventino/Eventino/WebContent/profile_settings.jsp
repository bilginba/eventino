<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.eventino.web.model.ParticipantModel"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.eventino.web.model.AdvertiserModel"%>
<!doctype html>
<html lang="en-US">
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html">
<title>My Profile</title>
<link rel="stylesheet" type="text/css" media="all"
	href="resources/css/create_event.css">
</head>
<body>
	<%
		if (session.getAttribute("username") == null) {}
		else{
			if (session.getAttribute("user-type").equals("Participant")) {
	%>

	<div id="wrapper">
		<h1>My Profile</h1>
		<form name="CreatEventForm" id="creat-event-form" method="POST"
			action="SetParticipantProfile">
			<div class="col-2">
				<label> Name <input id="name" name="name" tabindex="1" value="${participantModel.getParticipant_name()}">
				</label>
			</div>
			<div class="col-2">
				<label> Surname <input placeholder="What is your surname?"
					id="surname" name="surname" tabindex="1" value="${participantModel.getSurname()}">
				</label>
			</div>
			<div class="col-3">
				<label> Date of Birth <input type="text"
					placeholder="YYYY-MM-DD" title="YYYY-MM-DD"
					pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))"
					id="date_of_birth" name="date_of_birth" tabindex="2" value="${participantModel.getBirthdate()}">
				</label>
			</div>
			<div class="col-4">
				<label> Gender <select name="gender" tabindex="2">
						<option value="${participantModel.getGender()}" selected="${participantModel.getGender()}">${participantModel.getGender()}</option>
						<option value="Male">Male</option>
						<option value="Female">Female</option>
				</select>
				</label>
			</div>
			<div class="col-4">
				<label> Nationality <select name="nationality" tabindex="3">
						<option selected="${participantModel.getNationality()}" value="${participantModel.getNationality()}">${participantModel.getNationality()}</option>
						<option value="afghan">Afghan</option>
						<option value="albanian">Albanian</option>
						<option value="algerian">Algerian</option>
						<option value="american">American</option>
						<option value="andorran">Andorran</option>
						<option value="angolan">Angolan</option>
						<option value="antiguans">Antiguans</option>
						<option value="argentinean">Argentinean</option>
						<option value="armenian">Armenian</option>
						<option value="australian">Australian</option>
						<option value="austrian">Austrian</option>
						<option value="azerbaijani">Azerbaijani</option>
						<option value="bahamian">Bahamian</option>
						<option value="bahraini">Bahraini</option>
						<option value="bangladeshi">Bangladeshi</option>
						<option value="barbadian">Barbadian</option>
						<option value="barbudans">Barbudans</option>
						<option value="batswana">Batswana</option>
						<option value="belarusian">Belarusian</option>
						<option value="belgian">Belgian</option>
						<option value="belizean">Belizean</option>
						<option value="beninese">Beninese</option>
						<option value="bhutanese">Bhutanese</option>
						<option value="bolivian">Bolivian</option>
						<option value="bosnian">Bosnian</option>
						<option value="brazilian">Brazilian</option>
						<option value="british">British</option>
						<option value="bruneian">Bruneian</option>
						<option value="bulgarian">Bulgarian</option>
						<option value="burkinabe">Burkinabe</option>
						<option value="burmese">Burmese</option>
						<option value="burundian">Burundian</option>
						<option value="cambodian">Cambodian</option>
						<option value="cameroonian">Cameroonian</option>
						<option value="canadian">Canadian</option>
						<option value="cape verdean">Cape Verdean</option>
						<option value="central african">Central African</option>
						<option value="chadian">Chadian</option>
						<option value="chilean">Chilean</option>
						<option value="chinese">Chinese</option>
						<option value="colombian">Colombian</option>
						<option value="comoran">Comoran</option>
						<option value="congolese">Congolese</option>
						<option value="costa rican">Costa Rican</option>
						<option value="croatian">Croatian</option>
						<option value="cuban">Cuban</option>
						<option value="cypriot">Cypriot</option>
						<option value="czech">Czech</option>
						<option value="danish">Danish</option>
						<option value="djibouti">Djibouti</option>
						<option value="dominican">Dominican</option>
						<option value="dutch">Dutch</option>
						<option value="east timorese">East Timorese</option>
						<option value="ecuadorean">Ecuadorean</option>
						<option value="egyptian">Egyptian</option>
						<option value="emirian">Emirian</option>
						<option value="equatorial guinean">Equatorial Guinean</option>
						<option value="eritrean">Eritrean</option>
						<option value="estonian">Estonian</option>
						<option value="ethiopian">Ethiopian</option>
						<option value="fijian">Fijian</option>
						<option value="filipino">Filipino</option>
						<option value="finnish">Finnish</option>
						<option value="french">French</option>
						<option value="gabonese">Gabonese</option>
						<option value="gambian">Gambian</option>
						<option value="georgian">Georgian</option>
						<option value="german">German</option>
						<option value="ghanaian">Ghanaian</option>
						<option value="greek">Greek</option>
						<option value="grenadian">Grenadian</option>
						<option value="guatemalan">Guatemalan</option>
						<option value="guinea-bissauan">Guinea-Bissauan</option>
						<option value="guinean">Guinean</option>
						<option value="guyanese">Guyanese</option>
						<option value="haitian">Haitian</option>
						<option value="herzegovinian">Herzegovinian</option>
						<option value="honduran">Honduran</option>
						<option value="hungarian">Hungarian</option>
						<option value="icelander">Icelander</option>
						<option value="indian">Indian</option>
						<option value="indonesian">Indonesian</option>
						<option value="iranian">Iranian</option>
						<option value="iraqi">Iraqi</option>
						<option value="irish">Irish</option>
						<option value="israeli">Israeli</option>
						<option value="italian">Italian</option>
						<option value="ivorian">Ivorian</option>
						<option value="jamaican">Jamaican</option>
						<option value="japanese">Japanese</option>
						<option value="jordanian">Jordanian</option>
						<option value="kazakhstani">Kazakhstani</option>
						<option value="kenyan">Kenyan</option>
						<option value="kittian and nevisian">Kittian and Nevisian</option>
						<option value="kuwaiti">Kuwaiti</option>
						<option value="kyrgyz">Kyrgyz</option>
						<option value="laotian">Laotian</option>
						<option value="latvian">Latvian</option>
						<option value="lebanese">Lebanese</option>
						<option value="liberian">Liberian</option>
						<option value="libyan">Libyan</option>
						<option value="liechtensteiner">Liechtensteiner</option>
						<option value="lithuanian">Lithuanian</option>
						<option value="luxembourger">Luxembourger</option>
						<option value="macedonian">Macedonian</option>
						<option value="malagasy">Malagasy</option>
						<option value="malawian">Malawian</option>
						<option value="malaysian">Malaysian</option>
						<option value="maldivan">Maldivan</option>
						<option value="malian">Malian</option>
						<option value="maltese">Maltese</option>
						<option value="marshallese">Marshallese</option>
						<option value="mauritanian">Mauritanian</option>
						<option value="mauritian">Mauritian</option>
						<option value="mexican">Mexican</option>
						<option value="micronesian">Micronesian</option>
						<option value="moldovan">Moldovan</option>
						<option value="monacan">Monacan</option>
						<option value="mongolian">Mongolian</option>
						<option value="moroccan">Moroccan</option>
						<option value="mosotho">Mosotho</option>
						<option value="motswana">Motswana</option>
						<option value="mozambican">Mozambican</option>
						<option value="namibian">Namibian</option>
						<option value="nauruan">Nauruan</option>
						<option value="nepalese">Nepalese</option>
						<option value="new zealander">New Zealander</option>
						<option value="ni-vanuatu">Ni-Vanuatu</option>
						<option value="nicaraguan">Nicaraguan</option>
						<option value="nigerien">Nigerien</option>
						<option value="north korean">North Korean</option>
						<option value="northern irish">Northern Irish</option>
						<option value="norwegian">Norwegian</option>
						<option value="omani">Omani</option>
						<option value="pakistani">Pakistani</option>
						<option value="palauan">Palauan</option>
						<option value="panamanian">Panamanian</option>
						<option value="papua new guinean">Papua New Guinean</option>
						<option value="paraguayan">Paraguayan</option>
						<option value="peruvian">Peruvian</option>
						<option value="polish">Polish</option>
						<option value="portuguese">Portuguese</option>
						<option value="qatari">Qatari</option>
						<option value="romanian">Romanian</option>
						<option value="russian">Russian</option>
						<option value="rwandan">Rwandan</option>
						<option value="saint lucian">Saint Lucian</option>
						<option value="salvadoran">Salvadoran</option>
						<option value="samoan">Samoan</option>
						<option value="san marinese">San Marinese</option>
						<option value="sao tomean">Sao Tomean</option>
						<option value="saudi">Saudi</option>
						<option value="scottish">Scottish</option>
						<option value="senegalese">Senegalese</option>
						<option value="serbian">Serbian</option>
						<option value="seychellois">Seychellois</option>
						<option value="sierra leonean">Sierra Leonean</option>
						<option value="singaporean">Singaporean</option>
						<option value="slovakian">Slovakian</option>
						<option value="slovenian">Slovenian</option>
						<option value="solomon islander">Solomon Islander</option>
						<option value="somali">Somali</option>
						<option value="south african">South African</option>
						<option value="south korean">South Korean</option>
						<option value="spanish">Spanish</option>
						<option value="sri lankan">Sri Lankan</option>
						<option value="sudanese">Sudanese</option>
						<option value="surinamer">Surinamer</option>
						<option value="swazi">Swazi</option>
						<option value="swedish">Swedish</option>
						<option value="swiss">Swiss</option>
						<option value="syrian">Syrian</option>
						<option value="taiwanese">Taiwanese</option>
						<option value="tajik">Tajik</option>
						<option value="tanzanian">Tanzanian</option>
						<option value="thai">Thai</option>
						<option value="togolese">Togolese</option>
						<option value="tongan">Tongan</option>
						<option value="trinidadian or tobagonian">Trinidadian or
							Tobagonian</option>
						<option value="tunisian">Tunisian</option>
						<option value="turkish">Turkish</option>
						<option value="tuvaluan">Tuvaluan</option>
						<option value="ugandan">Ugandan</option>
						<option value="ukrainian">Ukrainian</option>
						<option value="uruguayan">Uruguayan</option>
						<option value="uzbekistani">Uzbekistani</option>
						<option value="venezuelan">Venezuelan</option>
						<option value="vietnamese">Vietnamese</option>
						<option value="welsh">Welsh</option>
						<option value="yemenite">Yemenite</option>
						<option value="zambian">Zambian</option>
						<option value="zimbabwean">Zimbabwean</option>
				</select>
				</label>
			</div>
			<div class="col-4">
				<label> Job Title <input placeholder="What is your job?"
					id="job_title" name="job_title" tabindex="3" value="${participantModel.getJob_title()}">
				</label>
			</div>
			<div class="col-4">
				<label> Foreign Languages <input
					placeholder="What foreign languages do you speak?"
					id="foreign_languages" name="foreign_languages" tabindex="3" value="${participantModel.getForeign_languages()}">
				</label>
			</div>
			<div class="col-5">
				<label> Certificates <input
					placeholder="Which certificates do you have?" id="certificates"
					name="certificates" tabindex="4" value="${participantModel.getCertificates()}">
				</label>
			</div>
			<div class="col-4">
				<label> Profile Picture <input type="file"
					placeholder="Choose your Profile Picture." name="profile_picture"
					accept="image/gif, image/jpeg, image/png, image/jpg" tabindex="4" value="${participantModel.getProfile_picture()}">
				</label>
			</div>
			<div class="col-4">
				<label> Are you a student? <select name="student_type">
						<option selected="${participantModel.getParticipant_type()}" value="${participantModel.getParticipant_type()}">${participantModel.getParticipant_type()}</option>
						<option value="Student">Student</option>
						<option value="Non-Student">Non-student</option>
				</select>
				</label>
			</div>
			<div class="col-submit">
				<button class="submitbtn">Update Information</button>
			</div>
		</form>
	</div>
	<%
		} else if (session.getAttribute("user-type").equals("Advertiser")) {
	%>
	<div id="wrapper">
		<form name="CreatEventForm" id="creat-event-form" method="POST"
			action="SetAdvertiserProfile">
			<div class="col-2">
				<label> Name <input placeholder="Corporation/Community name"
					id="name" name="advertiser_name" tabindex="1" value="${advertiserModel.getAdvertiser_name()}">
				</label>
			</div>
			<div class="col-2">
				<label> Description <input
					placeholder="Introduce your corporation/community" id="surname"
					name="description" tabindex="2" value="${advertiserModel.getAdvertiser_description()}">
				</label>
			</div>
			<div class="col-4">
				<label> Advertiser Type <select name="advertiser_type"
					tabindex="3">
						<option value="${advertiserModel.getAdvertiser_type()}" selected="${advertiserModel.getAdvertiser_type()}">${advertiserModel.getAdvertiser_type()}</option>
						<option value="Community">Community</option>
						<option value="Corporation">Corporation</option>
				</select>
				</label>
			</div>
			<div class="col-4">
				<label> Logo <input type="file"
					placeholder="Choose your logo." name="logo"
					accept="image/gif, image/jpeg, image/png, image/jpg" value="${advertiserModel.getLogo()}">
				</label>
			</div>
			<div class="col-submit">
				<button class="submitbtn">Update Information</button>
			</div>
		</form>
	</div>
	<%
		}
		}
	%>

</body>
</html>
