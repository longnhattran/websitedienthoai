<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html lang="en">
<!-- Basic -->

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Mobile Metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Site Metas -->
<title>HOANG KIM MOBILE</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">

<!-- Site Icons -->
<link rel="shortcut icon" href="../image/favicon-phone.png"
	type="image/x-icon">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="../css/bootstrap.min.css">
<!-- Site CSS -->
<link rel="stylesheet" href="../css/style.css">
<!-- Responsive CSS -->
<link rel="stylesheet" href="../css/responsive.css">
<!-- Custom CSS -->
<link rel="stylesheet" href="../css/custom.css">

<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
	<!-- Start Main Top -->
	<header class="main-header">
		<!-- Start Navigation -->
		<nav
			class="navbar navbar-expand-lg navbar-light bg-light navbar-default bootsnav">
			<div class="container">
				<!-- Start Header Navigation -->
				<div class="navbar-header">
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbar-menu" aria-controls="navbars-rs-food"
						aria-expanded="false" aria-label="Toggle navigation">
						<i class="fa fa-bars"></i>
					</button>
					<a class="navbar-brand"
						href="${pageContext.request.contextPath }/ListServlet"><img
						src="../image/smartphone-logo.png" class="logo" alt=""><br />
						<h1>
							<b>HOANG KIM MOBILE</b>
						</h1></a>
				</div>
				<!-- End Header Navigation -->

				<div class="collapse navbar-collapse" id="navbar-menu">
					<ul class="nav navbar-nav ml-auto" data-in="fadeInDown"
						data-out="fadeOutUp">
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath }/ListServlet">Return
								Home</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<!-- End Navigation -->
	</header>
	<!-- End Main Top -->
	
	<!-- Start Contact Us  -->
	<div class="contact-box-main">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-sm-12">
					<div class="contact-form-right">
						<c:if test="${not empty success  }">
							<h3 style="color: green">${success }</h3>
						</c:if>
						<h2>SIGN IN</h2>
						<c:if test="${not empty error  }">
							<p style="color: red">${error }</p>
						</c:if>
						<form id="form-login" method="POST" action="${pageContext.request.contextPath }/LoginServlet">
							<input id="hidden" type="hidden" name="action" value="" />
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<input type="text" class="form-control" id="email" name="email"
											placeholder="Your Email" onchange="changeEmailBorderColor()"
											value="${sessionScope.account.email }">
									</div>
								</div>
								<div class="col-md-12">
									<div class="form-group">
										<input type="password" placeholder="Your Password"
											id="password" class="form-control" name="password" onchange="changePasswordBorderColor()"
											value="${sessionScope.account.pwd }">
									</div>
								</div>
								<div class="col-md-12">
									<input type="checkbox" id="remember-me" name="remember-me">
									<label for="remember-me">Remember me</label>
								</div>
								<div class="col-lg-12">
									<a style="text-decoration: none; color: blue" href="${pageContext.request.contextPath}/ForgotPasswordServlet"
										class="forgot-password-link">Forgot Password?</a>
								</div>
								<div class="col-lg-12">
									<p>
										You don't have account? <a
											style="text-decoration: none; color: blue"
											class="register-link" href="${pageContext.request.contextPath}/jsp/register.jsp">Register</a>
									</p>
								</div>
								<div class="col-md-12">
									<div class="submit-button text-center">
									<button type="submit" class="btn hvr-hover" onclick="login(event)">Sign In</button>
									<span id="error"></span>
										<div class="clearfix"></div>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Contact Us  -->

	<!-- Start Footer  -->
	<footer>
		<div class="footer-main">
			<div class="container">
				<div class="row">
					<div class="col-lg-4 col-md-12 col-sm-12">
						<div class="footer-top-box">
							<h3>Contact us</h3>
							<ul class="list-time">
								<li><i class="fa fa-map-marker"></i> Address: 214
									Nguyen Thai Hoc, Ngo May, Quy Nhon, Binh Dinh</li>
								<li><i class="fa fa-phone-square"></i> Phone: <a
									href="tel:+84 123456789">0123456789</a></li>
								<li><i class="fa fa-envelope"></i> Email: <a
									href="mailto:contactinfo@gmail.com">contactinfo@gmail.com</a></li>
							</ul>
						</div>
					</div>
					<div class="col-lg-4 col-md-12 col-sm-12">
						<div class="footer-top-box">
							<h3>Latest Offers</h3>
							<form id="register-offer" class="newsletter-box" method="post" action="${pageContext.request.contextPath }/SaveEmailOfferServlet">
								<div class="form-group">
									<input class="" type="email" name="email" id="email-offer" onchange="changeEmailOfferBorderColor()"
										placeholder="Email Address*" /> <i class="fa fa-envelope"></i>
								</div>
								<button class="btn hvr-hover" type="submit" onclick="registerOffer(event)">Register</button>
							</form>
						</div>
					</div>
					<div class="col-lg-4 col-md-12 col-sm-12">
						<div class="footer-top-box">
							<h3>Social Media</h3>
							<ul>
								<li><a href="#" class="social"><i
										class="fa fa-facebook" aria-hidden="true"></i></a></li>
								<li><a href="#" class="social"><i class="fa fa-twitter"
										aria-hidden="true"></i></a></li>
								<li><a href="#" class="social"><i
										class="fa fa-linkedin" aria-hidden="true"></i></a></li>
								<li><a href="#" class="social"><i
										class="fa fa-google-plus" aria-hidden="true"></i></a></li>
								<li><a href="#" class="social"><i class="fa fa-rss"
										aria-hidden="true"></i></a></li>
								<li><a href="#" class="social"><i
										class="fa fa-pinterest-p" aria-hidden="true"></i></a></li>
								<li><a href="#" class="social"><i
										class="fa fa-whatsapp" aria-hidden="true"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!-- End Footer  -->

	<!-- Start copyright  -->
	<div class="footer-copyright">
		<p class="footer-company">All Rights Reserved. &copy; 2023</p>
	</div>
	<!-- End copyright  -->

	<a href="#" id="back-to-top" title="Back to top" style="display: none;">&uarr;</a>

	<!-- ALL JS FILES -->
	<script src="../js/jquery-3.2.1.min.js"></script>
	<script src="../js/popper.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<!-- ALL PLUGINS -->
	<script src="../js/jquery.superslides.min.js"></script>
	<script src="../js/bootstrap-select.js"></script>
	<script src="../js/inewsticker.js"></script>
	<script src="../js/bootsnav.js"></script>
	<script src="../js/images-loded.min.js"></script>
	<script src="../js/isotope.min.js"></script>
	<script src="../js/owl.carousel.min.js"></script>
	<script src="../js/baguetteBox.min.js"></script>
	<!-- <script src="../js/form-validator.min.js"></script> -->
	<script src="../js/contact-form-script.js"></script>
	<script src="../js/custom.js"></script>
	<script src="../js/login.js"></script>
	<script src="../js/offer.js"></script>
</body>

</html>