<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
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
		<script type="text/javascript" src="plugins/jquery.validate.js"></script>
		<title>GoCheeta - My Account</title>
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
		<div class="container-fluid profile mt-5">
			<div class="row">
				<div class="container-fluid profile-inner">
					<div class="row">
						<div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 profile-col">
							<div class="d-flex align-items-start">
  								<div class="nav flex-column nav-pills me-3" id="v-pills-tab" role="tablist" aria-orientation="vertical">
    								<button class="nav-link active" id="v-pills-home-tab" data-bs-toggle="pill" data-bs-target="#v-pills-home" type="button" role="tab" aria-controls="v-pills-home" aria-selected="true">Profile</button>
    								<button class="nav-link" id="v-pills-profile-tab" data-bs-toggle="pill" data-bs-target="#v-pills-profile" type="button" role="tab" aria-controls="v-pills-profile" aria-selected="false">History</button>
  								</div>
  								<div class="tab-content col-9" id="v-pills-tabContent">
    								<div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab" tabindex="0">
    									<div class="row">
    										<div class="col-6">
    											<div class="form-group mb-3">
    												<label for="fullName">Name with initial</label>
    												<input type="text" class="form-control" readonly value="<tag:out value='${login.fullName}'></tag:out>" />
    											</div>
    										</div>
    										<div class="col-6">
    											<div class="form-group mb-3">
    												<label for="contactNo">Contact No</label>
    												<input type="tel" class="form-control" readonly value="<tag:out value='${login.contactNo}'></tag:out>" />
    											</div>
    										</div>
    										<div class="col-6">
    											<div class="form-group mb-3">
    												<label for="email">Email</label>
    												<input type="email" class="form-control" readonly value="<tag:out value='${login.email}'></tag:out>" />
    											</div>
    										</div>
    										<div class="col-6">
    											<div class="form-group mb-3">
    												<label for="userName">Username</label>
    												<input type="text" class="form-control" readonly value="<tag:out value='${login.userName}'></tag:out>" />
    											</div>
    										</div>
    									</div>
    								</div>
    								<div class="tab-pane fade" id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-profile-tab" tabindex="0">
    									<div class="alert alert-warning p-2 mb-3">
    										<p><Strong>Note: </Strong>If you want to cancel booking please contact you driver.</p>
    									</div>
    									<tag:choose>
    										<tag:when test="${listSize > 0}">
    											<table class="table table-sm table-bordered table-striped">
    												<thead>
    													<tr>
    														<th>Booking ID</th>
    														<th>Pick Up Location</th>
    														<th>Drop Location</th>
    														<th>Price(LKR)</th>
    														<th>Booking Date</th>
    														<th>Contact No</th>
    														<th>Write Feedback</th>
    														<th>Status</th>
    													</tr>
    												</thead>
    												<tbody>
    													<tag:forEach var="booking" items="${bookingList}">
    														<tr>
    															<td><tag:out value="${booking.bookingId}"></tag:out></td>
    															<td><tag:out value="${booking.pickUp}"></tag:out></td>
    															<td><tag:out value="${booking.dropLocation}"></tag:out></td>
    															<td class="text-end"><tag:out value="${booking.price}"></tag:out></td>
    															<td><tag:out value="${booking.bookingDate}"></tag:out></td>
    															<td><tag:out value="${booking.contactNo}"></tag:out></td>
    															<td>
    																<tag:if test="${booking.feedbackStatus == 0}">
    																	<a href="feedback?bookingId=<tag:out value='${booking.bookingId}'></tag:out>" class="btn btn-outline-secondary btn-sm">Write Feedback</a>
    																</tag:if>
    															</td>
    															<td class="text-center">
    																<tag:if test="${booking.bookingStatus == 0}">
    																	<span class="badge bg-warning rounded-1">Not Confirmed</span>
    																</tag:if>
    																<tag:if test="${booking.bookingStatus == 1}">
    																	<span class="badge bg-success rounded-1">Confirmed</span>
    																</tag:if>
    																<tag:if test="${booking.bookingStatus == 2}">
    																	<span class="badge bg-info rounded-1">Not Complete</span>
    																</tag:if>
    																<tag:if test="${booking.bookingStatus == 3}">
    																	<span class="badge bg-danger rounded-1">cancel</span>
    																</tag:if>
    															</td>
    														</tr>
    													</tag:forEach>
    												</tbody>
    											</table>
    										</tag:when>
    										<tag:when test="${listSize == 0}">
    											<div class="message-section">
    												<img alt="empty icon" src="images/e.png" class="img-responsive d-block mx-auto" width="300">
    												<p class="mt-3 text-muted text-center" style="font-size: 14px;">No any bookings</p>
    											</div>
    										</tag:when>
    									</tag:choose>
    								</div>
  								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>