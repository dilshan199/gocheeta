<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
		<link rel="stylesheet" href="css/default.css" type="text/css">
		<link rel="stylesheet" href="css/vehicle.css" type="text/css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
		<script type="text/javascript" src="plugins/jquery.validate.js"></script>
		<title>GoCheeta - Select Vehicle</title>
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
		<div class="container-fluid mt-3 vehicle">
			<div class="row">
				<div class="container-fluid vehicle-inner">
					<div class="row">
						<tag:forEach var="vehicle" items="${vehicleList }">
							<div class="col-12 col-sm-12 col-md-4 col-lg-3 col-xl-3 p-2 vehicle-col">
								<div class="card border-0 shadow-sm">
  									<img src="../gocheeta-online-sys/images/taxi/<tag:out value='${vehicle.image}'></tag:out>" alt="<tag:out value='${vehicle.vehicleName}'></tag:out>">
  									<div class="card-body">
  										<span class="category"><tag:out value="${vehicle.category}"></tag:out></span>
    									<h6 class="card-title"><tag:out value="${vehicle.vehicleName}"></tag:out></h6>
    									<ul class="nav flex-column mt-3">
    										<li><strong><i class="bi bi-car-front-fill"></i>&nbsp;vehicle No: </strong><tag:out value="${vehicle.vehicleNo}"></tag:out></li>
    										<li><strong><i class="bi bi-person-workspace"></i>&nbsp;Driver Name: </strong><tag:out value="${vehicle.firstName}"></tag:out> <tag:out value="${vehicle.lastName}"></tag:out></li>
    										<li><strong><i class="bi bi-people-fill"></i>&nbsp;Max Passenger: </strong><tag:out value="${vehicle.maxPassenger}"></tag:out></li>
    										<li><strong><i class="bi bi-cash"></i>&nbsp;Price Per Meter: </strong> LKR<tag:out value="${vehicle.pricePerKm}"></tag:out></li>
    									</ul>
    									<tag:if test="${vehicle.vehicleStatus == 0}">
											<a href="placebooking?vehicleId=<tag:out value='${vehicle.vehicleId}'></tag:out>" class="btn mt-3 w-100 save-btn">Book Now</a>
										</tag:if>
										<tag:if test="${vehicle.vehicleStatus == 1}">
											<a class="btn w-100 bg-light w-100 mt-3">Not available</a>
										</tag:if>
  									</div>
								</div>
							</div>
						</tag:forEach>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>