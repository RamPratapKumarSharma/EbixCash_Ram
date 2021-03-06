<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String string = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Input Validation</title>
<style type="text/css">
* {
	margin: 0;
	box-sizing: border-box;
}

body {
	background-color: #6a9ac4;
}

#contact {
	background-color: #6a9ac4;
	display: flex;
	justify-content: center;
	align-items: center;
}

.contact-box {
	width: clamp(100px, 90%, 1000px);
	margin: 80px 50px;
	display: flex;
	flex-wrap: wrap;
}

/* for message and button design */
.contact-links, .contact-form-wrapper {
	margin-top: 50px;
	width: 50%;
	padding: 8% 5% 10% 5%;
}

/* for enter hear back ground design */
.contact-links {
	background-color: #1f2e43;
	background: radial-gradient(circle at 55% 92%, #426691 0 12%, transparent 12.2%),
		radial-gradient(circle at 94% 72%, #426691 0 10%, transparent 10.2%),
		radial-gradient(circle at 20% max(78%, 350px), #263a53 0 7%,
		transparent 7.2%),
		radial-gradient(circle at 0% 0%, #263a53 0 40%, transparent 40.2%),
		#1f2e43;
	border-radius: 10px 0 0 10px;
}

/* input field back ground design */
.contact-form-wrapper {
	background-color: #ffffff8f;
	border-radius: 0 10px 10px 0;
}

/* for enter hear text h2 heading */
h2 {
	font-family: 'Arimo', sans-serif;
	color: #fff;
	font-size: clamp(30px, 6vw, 60px);
	letter-spacing: 2px;
	text-align: center;
	transform: scale(.95, 1);
}

.form-item {
	position: relative;
}

/*   for font style all ui */
label, input, textarea {
	font-family: 'Poppins', sans-serif;
}

/* for message text alignment in input field */
label {
	position: absolute;
	top: 10px;
	left: 2%;
	color: #999;
	font-size: clamp(14px, 1.5vw, 18px);
	pointer-events: none;
	user-select: none;
}

/* for message Box */
input, textarea {
	width: 100%;
	outline: 0;
	border: 1px solid #ccc;
	border-radius: 4px;
	margin-bottom: 20px;
	padding: 12px;
	font-size: clamp(15px, 1.5vw, 18px);
}

.submit-btn:hover {
	transform: scale(1.1, 1.1);
}

.submit-btn:active {
	transform: scale(1.1, 1.1);
	filter: sepia(0.5);
}

/*  Message text in user input */
input:focus+label, input:valid+label, textarea:focus+label, textarea:valid+label
	{
	font-size: clamp(13px, 1.3vw, 16px);
	color: #777;
	top: -20px;
	transition: all .225s ease;
}

/*  For Button Style */
.submit-btn {
	background-color: #fd917e;
	filter: drop-shadow(2px 2px 3px #0003);
	color: #fff;
	font-family: "Poppins", sans-serif;
	font-size: clamp(16px, 1.6vw, 18px);
	display: block;
	padding: 12px 20px;
	margin: 2px auto;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	user-select: none;
	transition: 0.2s;
	'
}

.cent {
	text-align: center;
	font-size: 40px;
	margin-top: 50px;
	text-align: center;
	color: #fff;
	text-shadow: -5px 5px 2px #546E7A;
}
}
</style>
</head>
<body>
	<%
	if (string != null && !string.isEmpty()) {
	%>
	<marquee behavior="scroll" direction="up" scrollamount="4">
		<h3 class="cent"><%=string%></h3>
	</marquee>
	<%
	}
	%>
	<section id="contact">
		<div class="contact-box">
			<div class="contact-links">
				<h2>Enter Hear</h2>
			</div>
			<div class="contact-form-wrapper">
				<form action="/user_input_validation/User" method="post">
					<div class="form-item">
						<textarea class="" name="data" required></textarea>
						<label>Message:</label>
					</div>
					<button class="submit-btn">Send</button>
				</form>
			</div>
		</div>
	</section>
</body>
</html>