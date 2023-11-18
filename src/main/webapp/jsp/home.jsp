<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<!-- Basic -->

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Mobile Metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Site Metas -->
<title>Hoang Kim Mobile</title>
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

<!-- Font Awesome CSS links -->
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

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="navbar-menu">
					<ul class="nav navbar-nav mr-auto" data-in="fadeInDown"
						data-out="fadeOutUp">
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath }/ListServlet">Home</a></li>
						<li class="dropdown"><a href="#"
							class="nav-link dropdown-toggle arrow" data-toggle="dropdown">Products
								<i class="fa fa-caret-down"></i>
						</a>
							<ul class="dropdown-menu" style="background-color: white;">
								<li><a
									href="${pageContext.request.contextPath }/SearchServlet?name=iphone&action=getcategory">Iphone</a></li>
								<li><a
									href="${pageContext.request.contextPath }/SearchServlet?name=samsung&action=getcategory">Samsung</a></li>
							</ul></li>
						<li class="nav-item"><a class="nav-link" href="#">About
								Us</a></li>
					</ul>
					<c:choose>
						<c:when test="${sessionScope.isLoggedIn eq 'true' }">
							<ul class="nav navbar-nav ml-auto" data-in="fadeInDown"
								data-out="fadeOutUp">
								<li class="dropdown"><a href="#"
									class="nav-link dropdown-toggle arrow" data-toggle="dropdown">${sessionScope.account.name}
										<i class="fa fa-caret-down"></i>
								</a>
									<ul class="dropdown-menu" style="background-color: white;">
										<li><a
											href="${pageContext.request.contextPath }/SaveProfileServlet">Profile</a></li>
										<li><a
											href="${pageContext.request.contextPath }/LogoutServlet">Sign
												Out</a></li>
									</ul></li>
							</ul>
						</c:when>
						<c:otherwise>
							<ul class="nav navbar-nav mr-auto" data-in="fadeInDown"
								data-out="fadeOutUp">
								<li class="nav-item"><a
									href="${pageContext.request.contextPath }/LoginServlet"> <i
										class="fa fa-sign-in"></i> Sign In
								</a></li>
								<li class="nav-item"><a
									href="${pageContext.request.contextPath }/RegisterServlet">
										<i class="fa fa-user-plus"></i> Sign Up
								</a></li>
							</ul>
						</c:otherwise>
					</c:choose>
				</div>
				<!-- /.navbar-collapse -->
				<!-- Start Atribute Navigation -->
				<div class="attr-nav">
					<ul>
						<li class="side-menu"><a
							href="${pageContext.request.contextPath }/jsp/cart.jsp"> <i
								class="fa fa-shopping-bag"></i> <span class="badge">${applicationScope.cart.items.size()}</span>
								<p>My Cart</p>
						</a></li>
					</ul>
				</div>
				<!-- End Atribute Navigation -->
			</div>
		</nav>
		<!-- End Navigation -->
	</header>
	<!-- End Main Top -->

	<!-- Start Slider -->
	<div id="carouselExampleIndicators" class="carousel slide"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" data-slide-to="0"
				class="active"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img class="d-block w-100" src="../image/banner1.jpg" alt="Banner 1">
			</div>
			<div class="carousel-item">
				<img class="d-block w-100" src="../image/banner2.jpg" alt="Banner 2">
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleIndicators"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
	<!-- End Slider -->

	<!-- Start Shop Page  -->
	<div class="shop-box-inner">
		<div class="container">
			<div class="row">
				<div
					class="col-xl-9 col-lg-9 col-sm-12 col-xs-12 shop-content-right">
					<div class="right-product-box">
						<div class="product-item-filter row">
							<div class="col-12 text-center text-sm-left">
								<div class="search-product">
									<form method="get"
										action="${pageContext.request.contextPath }/SearchServlet">
										<input type="hidden" name="action" value="search"> <input
											class="form-control" placeholder="Search here..." type="text"
											name="name" value="${words}">
										<button type="submit">
											<i class="fa fa-search"></i>
										</button>
									</form>
								</div>
							</div>
						</div>

						<c:choose>
							<c:when test="${param.page eq 'home' }">
								<c:set var="Products" value="${ProductHome }"></c:set>
							</c:when>
							<c:when test="${param.page eq 'search' }">
								<c:set var="Products" value="${ProductSearch }"></c:set>
							</c:when>
						</c:choose>

						<c:choose>
							<c:when test="${not empty Products }">
								<c:set var="tablewidth" value="3"></c:set>
								<c:set var="currency" value="$" />
								<table class="responsive-table">
									<c:forEach var="prod" items="${Products}" varStatus="status">
										<c:if test="${status.index % tablewidth == 0 }">
											<tr>
										</c:if>
										<td><a
											href="<c:url value="/jsp/product-detail.jsp?productID=${prod.id}"/>">
												<div class="products-single fix" style="padding: 5%">
													<div class="box-img-hover">
														<img src="${prod.src}" class="img-fluid" alt="Image">
													</div>
													<div class="why-text">
														<h4>${fn:toUpperCase(prod.type)}</h4>
														<h4>${prod.getName() }</h4>
														<h5>${currency}${prod.price }</h5>
													</div>
												</div>
										</a></td>

									</c:forEach>
								</table>
								<c:choose>
									<c:when test="${param.page eq 'home' }">
										<c:set var="totalPages" value="${totalPageHome}"></c:set>
										<c:set var="currentPage" value="${currentPageHome }"></c:set>
										<c:set var="startPage" value="${startPageHome }"></c:set>
										<c:set var="endPage" value="${endPageHome }"></c:set>
									</c:when>
									<c:when test="${param.page eq 'search' }">
										<c:set var="totalPages" value="${totalPageSearch}"></c:set>
										<c:set var="currentPage" value="${currentPageSearch }"></c:set>
										<c:set var="startPage" value="${startPageSearch }"></c:set>
										<c:set var="endPage" value="${endPageSearch }"></c:set>
									</c:when>
								</c:choose>
								<c:set var="PRODUCTS_PER_PAGE" value="${products_per_page}"></c:set>
								<c:if test="${param.page eq 'home' }">
									<c:set var="pattern" value="/ListServlet?"></c:set>
								</c:if>
								<c:if test="${param.page eq 'search' }">
									<c:set var="pattern"
										value="/SearchServlet?name=${name }&action=${action }&"></c:set>
								</c:if>
								<c:if test="${currentPage > 1 }">
									<a
										href="<c:url value="${pattern }currentPage=${currentPage - 1}"/>">Previous</a>
								</c:if>

								<c:if test="${startPage > 2 }">
									<a href="<c:url value="${pattern }currentPage=1"/>">1</a>
									<span>...</span>
								</c:if>

								<c:forEach var="pageNumber" begin="${startPage }"
									end="${endPage}">
									<c:choose>
										<c:when test="${pageNumber == currentPage }">
											<strong>${pageNumber}</strong>
										</c:when>
										<c:otherwise>
											<a
												href="<c:url value="${pattern }currentPage=${pageNumber}"/>">${pageNumber}</a>
										</c:otherwise>
									</c:choose>
								</c:forEach>

								<c:if test="${endPage < totalPages}">
									<span>...</span>
									<a
										href="<c:url value="${pattern }currentPage=${totalPages }"/>">${totalPages }</a>
								</c:if>

								<c:if test="${currentPage < totalPages }">
									<a
										href="<c:url value="${pattern }currentPage=${currentPage + 1}"/>">Next</a>
								</c:if>
							</c:when>

							<c:otherwise>
								<h2>There are no products</h2>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<div class="col-xl-3 col-lg-3 col-sm-12 col-xs-12 sidebar-shop-left">
					<div class="product-categori">
						<div class="filter-sidebar-left">
							<div class="title-left">
								<h3>Beautiful Smartphone Model</h3>
							</div>
							<div
								class="list-group list-group-collapse list-group-sm list-group-tree"
								id="list-group-men" data-children=".sub-men">
								<div class="list-group-collapse sub-men">
									<div class="collapse show" id="sub-men1"
										data-parent="#list-group-men">
										<div class="list-group">
											<img src="../ads/iphone1.jpg" alt="ads">
										</div>
										<div class="list-group">
											<img src="../ads/iphone2.jpg" alt="ads">
										</div>
										<div class="list-group">
											<img src="../ads/iphone3.jpg" alt="ads">
										</div>
										<div class="list-group">
											<img src="../ads/iphone4.jpg" alt="ads">
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Shop Page -->

	<!-- Start Footer  -->
	<footer>
		<div class="footer-main">
			<div class="container">
				<div class="row">
					<div class="col-lg-4 col-md-12 col-sm-12">
						<div class="footer-top-box">
							<h3>Contact Us</h3>
							<ul class="list-time">
								<li><i class="fa fa-map-marker"></i> Address: 214 Nguyen
									Thai Hoc, Ngo May, Quy Nhon, Binh Dinh</li>
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
							<form id="register-offer" class="newsletter-box" method="post"
								action="${pageContext.request.contextPath }/SaveEmailOfferServlet">
								<div class="form-group">
									<input id="email-offer" class="" type="email" name="email" 
										placeholder="Email Address*" onchange="changeEmailOfferBorderColor()"/> <i class="fa fa-envelope"></i>
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
										class="fa fa-google-plus" aria-hidden="true"></i></a></li>
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
	<script src="../js/offer.js"></script>
</body>

</html>