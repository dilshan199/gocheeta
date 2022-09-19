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
		<link rel="stylesheet" href="css/profile.css" type="text/css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
		<title>GoCheeta - Driver Panel</title>
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
								<tag:if test="${dl.nic != null}">
									<li class="nav-item"><a href="driverlogout" class="nav-link"><i class="bi bi-box-arrow-left"></i>&nbsp;Logout</a></li>
								</tag:if>
								<tag:if test="${dl.nic == null}">
									<li class="nav-item"><a href="driver-login.jsp" class="nav-link"><i class="bi bi-person-circle"></i>&nbsp;Driver's Login</a></li>
								</tag:if>
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
        									<li class="nav-item"><a class="nav-link disabled" href="profile">My Account</a></li>
        									<li class="nav-item"><a class="nav-link" href="#">Contact</a></li>
     									</ul>
    								</div>
  								</div>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="container-fluid profile mt-5">
			<div class="row">
				<div class="container-fluid profile-inner">
					<div class="row">
						<div class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6 p-2">
							<div class="card">
  								<div class="card-header">
    								<i class="bi bi-car-front"></i>&nbsp;Booking Deatils
  								</div>
  								<div class="card-body">
    								<div class="row">
    									<div class="col-6 border-end border-bottom border-white border-2 bg-light p-2 fw-bold">Pick-up Location</div>
    									<div class="col-6 p-2 border-bottom border-white border-2"><tag:out value="${booking.pickUp}"></tag:out></div>
    								</div>
    								<div class="row">
    									<div class="col-6 border-end border-bottom border-white border-2 bg-light p-2 fw-bold">Drop Location</div>
    									<div class="col-6 p-2 border-bottom border-white border-2"><tag:out value="${booking.dropLocation}"></tag:out></div>
    								</div>
    								<div class="row">
    									<div class="col-6 border-end border-bottom border-white border-2 bg-light p-2 fw-bold">Pick-up Date</div>
    									<div class="col-6 p-2 border-bottom border-white border-2"><tag:out value="${booking.pickUpDate}"></tag:out></div>
    								</div>
    								<div class="row">
    									<div class="col-6 border-end border-bottom border-white border-2 bg-light p-2 fw-bold">Price(LKR)</div>
    									<div class="col-6 p-2 border-bottom border-white border-2"><tag:out value="${booking.price}"></tag:out></div>
    								</div>
    								<div class="row">
    									<div class="col-6 border-end border-bottom border-white border-2 bg-light p-2 fw-bold">Status</div>
    									<div class="col-6 p-2 border-bottom border-white border-2">
    										<tag:if test="${booking.bookingStatus == 0}">
    											<span class="badge bg-warning rounded-1">Not Confirmed</span>
    										</tag:if>
    										<tag:if test="${booking.bookingStatus == 1}">
    											<span class="badge bg-success rounded-1">Confirmed</span>
    										</tag:if>
    										<tag:if test="${booking.bookingStatus == 2}">
    											<span class="badge bg-info rounded-1">Completed</span>
    										</tag:if>
    										<tag:if test="${booking.bookingStatus == 3}">
    											<span class="badge bg-danger rounded-1">Cancel</span>
    										</tag:if>
    									</div>
    								</div>
  								</div>
							</div>
						</div>
						<div class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6 p-2">
							<div class="card">
  								<div class="card-header">
    								<i class="bi bi-person"></i>&nbsp;Customer Information
  								</div>
  								<div class="card-body">
    								<div class="row">
    									<div class="col-6 border-end border-bottom border-white border-2 bg-light p-2 fw-bold">Customer Name</div>
    									<div class="col-6 p-2 border-bottom border-white border-2"><tag:out value="${booking.fullName}"></tag:out></div>
    								</div>
    								<div class="row">
    									<div class="col-6 border-end border-bottom border-white border-2 bg-light p-2 fw-bold">Contact No</div>
    									<div class="col-6 p-2 border-bottom border-white border-2"><tag:out value="${booking.contactNo}"></tag:out></div>
    								</div>
  								</div>
							</div>
							<div class="card mt-3">
  								<div class="card-header">
    								<i class="bi bi-pencil-square"></i>&nbsp;Action
  								</div>
  								<div class="card-body d-flex">
    								<form action="confirm?type=confirm">
    									<input type="hidden" name="bookingId" value="<tag:out value='${booking.bookingId}'></tag:out>" />
    									<input type="hidden" name="vehicleStatus" value="1" />
    									<input type="hidden" name="vehicleId" value="<tag:out value='${booking.vehicleId}'></tag:out>" />
    									<button type="submit" name="confirm" value="Confirm" class="btn bg-warning btn-sm me-3"><i class="bi bi-check-circle"></i>&nbsp;Confirm</button>
    								</form>
    								<form action="complete?type=complete">
    									<input type="hidden" name="bookingId" value="<tag:out value='${booking.bookingId}'></tag:out>" />
    									<input type="hidden" name="vehicleStatus" value="0" />
    									<input type="hidden" name="vehicleId" value="<tag:out value='${booking.vehicleId}'></tag:out>" />
    									<button type="submit" name="complete" value="Complete" class="btn bg-success btn-sm text-white me-3"><i class="bi bi-card-list"></i>&nbsp;Complete</button>
    								</form>
    								<form action="cancel?type=cancel">
    									<input type="hidden" name="bookingId" value="<tag:out value='${booking.bookingId}'></tag:out>" />
    									<input type="hidden" name="vehicleStatus" value="0" />
    									<input type="hidden" name="vehicleId" value="<tag:out value='${booking.vehicleId}'></tag:out>" />
    									<button type="submit" name="cancel" value="Cancel" class="btn bg-danger btn-sm text-white"><i class="bi bi-x-circle"></i>&nbsp;Cancel</button>
    								</form>
  								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>