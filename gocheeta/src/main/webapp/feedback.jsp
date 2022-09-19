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
		<link rel="stylesheet" href="css/register.css" type="text/css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
		<title>GoCheeta - Feedback</title>
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
		<div class="container-fluid register mt-5">
			<div class="row">
				<div class="container-fluid register-inner">
					<div class="row">
						<div class="col-12 col-sm-12 col-md-8 col-lg-8 col-xl-8">
							<img alt="Feedback image" src="images/feedback.png" class="img-responsive d-block mx-auto" width="300">
						</div>
						<div class="col-12 col-sm-12 col-md4 col-lg-4 col-xl-4">
							<tag:choose>
								<tag:when test="${successMessage != null}">
									<div class="alert success-message p-1">
										<p class="m-1"><strong><i class="bi bi-check-circle-fill"></i>&nbsp;Successfully</strong> <tag:out value="${successMessage}"></tag:out></p>
									</div>
								</tag:when>
								<tag:when test="${errorMessage != null}">
									<div class="alert error-message p-1">
										<p class="m-1"><strong><i class="bi bi-x-circle-fill"></i>&nbsp;Sorry</strong> <tag:out value="${errorMessage}"></tag:out></p>
									</div>
								</tag:when>
							</tag:choose>
							<form action="feedback?type=submit" method="post" class="mt-3">
								<div class="form-group mb-2">
									<label for="fullName" class="form-label">Customer Name <span class="text-danger">*</span></label>
									<input type="text" name="cId" value="<tag:out value='${login.cId}'></tag:out>" />
									<input type="text" name="fullName" id="fullName" class="form-control" autocomplete="off" value="<tag:out value='${login.fullName}'></tag:out>" />
								</div>
								<div class="form-group mb-2">
									<label for="message" class="form-label">Message <span class="text-danger">*</span></label>
									<textarea rows="5" cols="35" class="form-control" name="message" id="message"></textarea>
									<input type="text" name="bookingId" value="<tag:out value='${feedback.bookingId}'></tag:out>>" />
									<span class="text-danger" style="font-size: 14px;font-weight: 400;"><tag:out value="${messageError}"></tag:out></span>
								</div>
								<div class="form-group">
									<button type="submit" name="submit" value="Send Feedback" class="btn w-100 save-btn"><i class="bi bi-send"></i>&nbsp;Send Feedback</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>