<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %> 
<html lang="en">
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
		<link rel="stylesheet" href="css/default.css" type="text/css">
		<link rel="stylesheet" href="css/index.css" type="text/css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css">
    	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.theme.default.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.2.1/owl.carousel.js"></script>
		<title>GoCheeta - Cab Service</title>
	</head>	
	<body>
		<div class="container-fluid topbar">
			<div class="row">
				<div class="container-fluid topbar-inner">
					<div class="row">
						<div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 topbar-content">
							<ul class="nav float-end">
								<li class="nav-item"><a href="tel: +94000000000" class="nav-link"><i class="bi bi-phone"></i>&nbsp;Hot Line: +94 00 00 00 000</a></li>
								<li class="nav-item"><a href="mailto: sample@gmail.com" class="nav-link"><i class="bi bi-envelope"></i>&nbsp;sample@gmail.com</a></li>
								<li class="nav-item"><a href="driver-login.jsp" class="nav-link"><i class="bi bi-person-circle"></i>&nbsp;Driver's Login</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="container-fluid header shadow-sm">
			<div class="row">
				<div class="conainer-fluid header-inner">
					<div class="row">
						<div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 header-content">
							<nav class="navbar navbar-expand-lg bg-white">
  								<div class="container-fluid">
    								<a class="navbar-brand" href="index">
    									<h3 class="text-center p-3">GoCheeta</h3>
										<p class="text-end">Cab Service</p>
    								</a>
    								<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      									<span class="navbar-toggler-icon"></span>
    								</button>
    								<div class="collapse navbar-collapse" id="navbarSupportedContent">
      									<ul class="navbar-nav ms-auto mb-2 me-3 mb-lg-0">
        									<li class="nav-item"><a class="nav-link active" aria-current="page" href="index">Home</a></li>
        									<li class="nav-item"><a class="nav-link" href="#">About Us</a></li>
        									<li class="nav-item"><a class="nav-link" href="#">Vehicles</a></li>
        									<tag:if test="${login.userName != null}">
        										<li class="nav-item"><a class="nav-link" href="profile">My Account</a></li>
        									</tag:if>
        									<tag:if test="${login.userName == null}">
        										<li class="nav-item"><a class="nav-link disabled" href="profile">My Account</a></li>
        									</tag:if>
        									<li class="nav-item"><a class="nav-link" href="#">Contact</a></li>
     									</ul>
     									<tag:if test="${login.userName != null}">
     										<a href="logout" class="nav-link sign-link rounded-pill"><i class="bi bi-box-arrow-left"></i>&nbsp;Sign Out</a>
     									</tag:if>
     									<tag:if test="${login.userName == null}">
     										<a href="login.jsp" class="nav-link sign-link rounded-pill"><i class="bi bi-person-fill"></i>&nbsp;Sign In</a>
     									</tag:if>
    								</div>
  								</div>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="container-fluid slideshow">
			<div class="row">
				<div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 slideshow-content p-0">
					<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="true">
  						<div class="carousel-indicators">
    						<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    						<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
    						<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
  						</div>
  						<div class="carousel-inner">
    						<div class="carousel-item active">
      							<img src="images/banner-1.jpg" class="d-block w-100" alt="Slideshow 1">
    						</div>
    						<div class="carousel-item">
      							<img src="images/banner-1.jpg" class="d-block w-100" alt="Slideshow 2">
    						</div>
    						<div class="carousel-item">
      							<img src="images/banner-1.jpg" class="d-block w-100" alt="Slideshow 3">
    						</div>
  						</div>
  						<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
    						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
    						<span class="visually-hidden">Previous</span>
  						</button>
  						<button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
    						<span class="carousel-control-next-icon" aria-hidden="true"></span>
    						<span class="visually-hidden">Next</span>
  						</button>
					</div>
				</div>
			</div>
		</div>
		<div class="container-fluid category mt-5">
			<div class="row">
				<div class="container-fluid category-inner">
					<div class="row">
						<div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 category-header">
							<h4>Category Explorer</h4>
						</div>
						<tag:forEach var="category" items="${catList}">
							<div class="col-12 col-sm-12 col-md-6 col-lg-3 col-xl-3 category-col p-2 mt-3">
								<a href="vehicle?catId=<tag:out value='${category.catId}'></tag:out>" class="rounded-2 btn w-100"><tag:out value="${category.category}"></tag:out></a>
							</div>
						</tag:forEach>
					</div>
				</div>
			</div>
		</div>
		<div class="container-fluid feedback mt-5">
			<div class="row">
				<div class="container-fluid feedback-inner">
					<div class="row">
						<div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
							<div class="feedback-header">
								<h4>Customer Reviews</h4>
							</div>
							<div class="feedback-slider owl-carousel mt-5">
								<tag:forEach var="feedback" items="${feedbackList}">
									<div class="feedback-slider-col">
										<div class="feedback-slider-item shadow">
											<h6><tag:out value="${feedback.fullName}"></tag:out></h6>
											<span><tag:out value="${feedback.pickUp}"></tag:out> - <tag:out value="${feedback.dropLocation}"></tag:out></span>
											<p><tag:out value="${feedback.message}"></tag:out></p>
										</div>
									</div>
								</tag:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="js/multiSlider.js"></script>
	</body>
</html>
