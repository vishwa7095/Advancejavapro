<%@page import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title> Edit Products</title>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" >
	<!-- This is java Script validation code Location -->
	<script src="product.js"></script>
</head>
<body>
<div class="container mt-5 text-center">
	<h2 class="text-center font-italic mb-1">EDIT PRODUCT DATA...</h2>
	<form method="post" action="UpdateServlet"
	enctype="multipart/form-data" onsubmit="return validateform()">

<div class="form-group">
		<label class="font-italic font-weight-bold" for="proId">Product ID</label>
<input type="text" class="form-control-sm" id="proId" name="proId"  value="${existingproduct.proId}"  required>
</div>

<div class="form-group">
		<label class="font-italic font-weight-bold"
		for="proName">Product Name</label>
<input type="text" class="form-control-sm" id="proName" name="proName" value="${existingproduct.proName}" required>
</div>

<div class="form-group">
		<label class="font-italic font-weight-bold"
		for="proPrice">Product Price</label>
<input type="number" class="form-control-sm" id="proPrice" name="proPrice" value="${existingproduct.proPrice}" required>
</div>

     <div class="form-group">
		<label class="font-italic font-weight-bold"
		for="proBrand">Product Brand</label>
<input type="text" class="form-control-sm" id="proBrand" name="proBrand" value="${existingproduct.proBrand}" required>
</div>
		<div class="form-group">
		<label class="font-italic font-weight-bold"
		for="product MadeIN">Product madeIN</label>
     <input type="text" class="form-control-sm" id="proMadeIn" name="proMadeIn" value="${existingproduct.proMadeIn}" required>
</div>

<div class="form-group">
		<label class="font-italic font-weight-bold"
		for="MFG date">Product MFG Date</label>
      <input type="date" class="form-control-sm" id="proMfgDate" name="proMfgDate" value="${existingproduct.proMfgDate}" required>
</div>

<div class="form-group">
		<label class="font-italic font-weight-bold"
		for="EXP date">Product EXP Date</label>
    <input type="date" class="form-control-sm" id="proExpDate" name="proExpDate" value="${existingproduct.proExpDate}" required>
</div>

	 
    <label class="font-italic font-weight-bold" for="proImage">Current Product Image:</label>
    <img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(existingproduct.proImage)}" Style="max-width:100px; max-height:100px;" alt="current product image">
   <input type="hidden" id="existingimage" name="existingimage" value="${Base64.getEncoder().encodeToString(existingproduct.proImage)}">
</div>
	  
	
	<!--Display new  Image -->
	<div class="form-group">
    <label class="font-italic font-weight-bold" for="newproImage"> New Product Image:</label>
	    <input type="file" class="form-control-file-sm" id="newProImage" name="newProImage"  accept="image/*"  >
	</div>
 

<div>
	<input type="submit" class="btn btn-success" value="update">
</div>

</form>
</div>
</body>
</html>