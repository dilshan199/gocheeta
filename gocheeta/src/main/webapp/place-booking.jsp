<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.gocheeta.web.model.Login" %>
<%

Login checkLogin = (Login) session.getAttribute("login");
if(checkLogin == null){
	response.sendRedirect("login.jsp");
}

%>    
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
		<link rel="stylesheet" href="css/default.css" type="text/css">
		<link rel="stylesheet" href="css/place-booking.css" type="text/css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
		<script type="text/javascript" src="plugins/jquery.validate.js"></script>
		<title>GoCheeta - Place Booking</title>
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
		<div class="container-fluid place-booking mt-5">
			<div class="row">
				<div class="container-fluid place-booking-inner">
					<div class="row">
						<form action="placebooking?type=submit" method="post" id="bookingForm">
							<ul class="progressbar" id="progressbar">
								<li class="active"><i class="bi bi-geo-alt"></i><br><br> <span>Pick Location</span></li>
								<li class=""><i class="bi bi-person"></i><br><br> <span>Basic Information</span></li>
								<li class=""><i class="bi bi-card-list"></i><br><br> <span>Booking Summary</span></li>
							</ul>
							<fieldset class="col-12">
								<div class="row mt-3">
									<div class="col-4 mb-3">
										<label for="branchId" class="form-label">Branch <span class="text-danger">*</span></label>
										<select class="form-select" name="branchId" id="branchId">
											<option>~~ Select Branch ~~</option>
											<tag:forEach var="branch" items="${branchList}">
												<option value="<tag:out value='${branch.branchId}'></tag:out>"><tag:out value="${branch.branchName}"></tag:out></option>
											</tag:forEach>
										</select>
									</div>
									<div class="col-4 mb-3">
										<label for="pickUp" class="form-label">Pick-Up Location <span class="text-danger">*</span></label>
										<select class="form-select" name="pickUp" id="pickUp">
					
										</select>
									</div>
									<div class="col-4 mb-3">
										<label for="dropLocation" class="form-label">Drop Location <span class="text-danger">*</span></label>
										<select class="form-select" name="dropLocation" id="dropLocation">
					
										</select>
									</div>
									<div class="col-5">
										<label for="pickUpDate" class="form-label">Pick-Up Date <span class="text-danger">*</span></label>
										<input type="datetime-local" name="pickUpDate" id="pickUpDate" class="form-control" value="" />
									</div>
								</div>
								<button type="button" name="next" class="btn action-btn next save-btn float-end" id="stepOne" value="Next">Next&nbsp;<i class="bi bi-chevron-double-right"></i></button>
							</fieldset>
							<fieldset class="col-12">
								<input type="hidden" name="cId" value="<tag:out value='${login.cId}'></tag:out>" />
								<div class="row mt-3">
									<div class="col-6 mb-3">
										<label for="fullName" class="form-label">Name with initial: </label>
										<input type="text" name="fullName" id="fullName" class="form-control" value="<tag:out value='${login.fullName}'></tag:out>" readonly />
									</div>
									<div class="col-6 mb-3">
										<label for="contactNo" class="form-label">Contact No: </label>
										<input type="tel" name="contactNo" id="contactNo" class="form-control" value="<tag:out value='${login.contactNo}'></tag:out>" readonly/>
									</div>
									<div class="col-6 mb-3">
										<label for="email" class="form-label">Email: </label>
										<input type="email" name="email" id="email" class="form-control" value="<tag:out value='${login.email}'></tag:out>" readonly/>
									</div>
									<input type="hidden" name="pricePerKm" id="pricePerKm" value="<tag:out value='${vehicle.pricePerKm}'></tag:out>" />
									<input type="hidden" name="destination" id="destination" value="" />
								</div>
								<button type="button" name="previous" class="btn action-btn prev btn-outline-secondary" value="Previous"><i class="bi bi-chevron-double-left"></i>&nbsp;Previous</button>
								<button type="button" name="next" class="btn action-btn next save-btn float-end" id="stepTwo" value="Next">Next&nbsp;<i class="bi bi-chevron-double-right"></i></button>
							</fieldset>
							<fieldset class="col-12 mt-3">
								<input type="hidden" name="driverId" value="<tag:out value='${vehicle.driverId}'></tag:out>" />
								<input type="hidden" name="vehicleId" value="<tag:out value='${vehicle.vehicleId}'></tag:out>" />
								<input type="hidden" name="price" id="price" value="" />
								<div class="row">
									<div class="fw-bold border-end border-2 border-white col-6 text-center p-2 table-head">Vehicle Details</div>
									<div class="fw-bold border-end border-2 border-white col-3 text-center p-2 table-head">Price Per Meter(LKR)</div>
									<div class="fw-bold border-end border-2 border-white col-3 text-center p-2 table-head">Total Price(LKR)</div>
								</div>
								<div class="row">
									<div class="border-end border-2 border-white col-6 p-2 table-body d-flex">
										<img alt="<tag:out value="${vehicle.vehicleName}"></tag:out>" src="../gocheeta-online-sys/images/taxi/<tag:out value="${vehicle.image}"></tag:out>" class="img-responsive d-block" width="150">
										<div class="deatils ms-2">
											<h6 class="fw-bold"><tag:out value="${vehicle.vehicleName}"></tag:out></h6>
											<p class="vehicle-no"><tag:out value="${vehicle.vehicleNo}"></tag:out></p>
											<p class="passenger">Max Passenger: <tag:out value="${vehicle.maxPassenger}"></tag:out></p>
											<p class="driver">Driver: <tag:out value="${vehicle.firstName}"></tag:out> <tag:out value="${vehicle.lastName}"></tag:out></p>
										</div>
									</div>
									<div class="border-end border-2 border-white col-3 text-end p-2 table-body">
										<tag:out value="${vehicle.pricePerKm}"></tag:out>
										<br>
										(<tag:out value="${vehicle.pricePerKm}"></tag:out> x <span id="des"></span>)
									</div>
									<div class="border-end border-2 border-white col-3 text-end p-2 table-body" id="totalPrice">
										0.00
									</div>
								</div>
								<div class="row">
									<div class="col-9 border-end border-top border-2 border-white text-end fw-bold table-body p-2">Total(LKR)</div>
									<div class="col-3 border-top border-2 border-white table-body p-2 text-end fw-bold" id="totalPrice2">0.00</div>
								</div>
								<button type="button" name="previous" class="btn action-btn prev btn-outline-secondary mt-3" value="Previous"><i class="bi bi-chevron-double-left"></i>&nbsp;Previous</button>
								<button type="submit" name="submit" value="Place Booking" class="action-btn btn mt-3 save-btn float-end"><i class="bi bi-cart3"></i>&nbsp;Place Booking</button>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="js/getDestination.js"></script>
		<script type="text/javascript" src="js/calculatePrice.js"></script>
		<script type="text/javascript" src="js/multiStepForm.js"></script>
	</body>
</html>