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
					<a class="navbar-brand" href="${pageContext.request.contextPath }/ListServlet"><img
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
							href="${pageContext.request.contextPath }/jsp/cart.jsp">Return
								Cart</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<!-- End Navigation -->
	</header>
	<!-- End Main Top -->
	<!-- Start Cart  -->
	<div class="cart-box-main">
		<div class="container">
			<div class="row">
				<div class="col-sm-12 col-lg-6 mb-3">
					<div class="checkout-address">
						<div class="title-left">
							<h3>Billing address</h3>
						</div>
						<form class="needs-validation" method="post" id="form-order"
							action="${pageContext.request.contextPath }/PayServlet">
							<div class="mb-3">
								<label for="customer-name">Full Name *</label>
								<div class="">
									<input type="text" name="name" class="form-control"
										id="customer-name" placeholder=""
										onchange="changeNameBorderColor()">
								</div>
							</div>
							<div class="mb-3">
								<label for="address">Address *</label> 
								<input type="text"
									class="form-control" id="customer-address" name="address"
									placeholder="" onchange="changeAddressBorderColor()">
							</div>
							<div class="mb-3">
								<label for="number-phone">Number Phone *</label> 
								<input
									type="text" class="form-control" id="number-phone" name="phone"
									placeholder="" onchange="changeNumberphoneBorderColor()">
								<span id="error-phone"></span>
							</div>
							<div class="mb-3">
								<label for="discount-code">Discount Code *</label> <input
									type="email" class="form-control" id="discount-code"
									name="discount" placeholder="">
							</div>
							<div class="shopping-box">
								<button class="btn hvr-hover" type="submit"
									onclick="order(event)">Place Order</button>
								<span id="error"></span>
							</div>
						</form>
					</div>
				</div>
				<div class="col-sm-12 col-lg-6 mb-3">
					<div class="row">
						<div class="col-md-12 col-lg-12">
							<div class="odr-box">
								<div class="title-left">
									<h3>Shopping cart</h3>
								</div>
								<c:set var="currency" value="$" />
								<c:forEach var="product" items="${cart.items}">
									<div class="rounded p-2 bg-light">
										<div class="media mb-2 border-bottom">
											<div class="media-body">
												${product.name}
												<div class="small text-muted">
													Price: ${currency}${product.price} <span class="mx-2">|</span>
													Quantity: ${product.number} <span class="mx-2">|</span>
													Subtotal: ${currency}${product.amount}
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
						<div class="col-md-12 col-lg-12">
							<div class="order-box">
								<div class="d-flex gr-total">
									<h5>Total</h5>
									<div class="ml-auto h5">${currency}${cart.totalAmount}</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Cart -->
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
	<script src="../js/order.js"></script>
	<script src="../js/offer.js"></script>
</body>

</html>