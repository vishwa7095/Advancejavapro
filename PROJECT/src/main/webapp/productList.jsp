
<%@page import="com.Sathya.ProductServlet.ProjectDao" import="java.util.Base64"%>
<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Product List</title>
</head>
<body>

<h1 class="text-center text-success">LIST OF AVAILABLE PRODUCTS</h1>

<div>
<a class="btn btn-success" href="add-product.html">Add Product</a>
</div>
<div>
<input type="text" placeholder="Search...">
</div>
<div>
<c:if  test="${saveResult==1}"><h1  class="text-center text-success">Data inserted successfully...</h1></c:if>
</div>
<div>
<c:if  test="${deleteresult==1}"><h1  class="text-center text-success">Data deleted successfully...</h1></c:if>
</div>
<div>
<c:if  test="${deleteresult==0}"><h1  class="text-center text-danger">Data deleted fail....</h1></c:if>
</div>
<div>
<c:if  test="${updateresult==1}"><h1  class="text-center text-success">Data updated successfully...</h1></c:if>
</div>
<div>
<c:if  test="${updateresult==0}"><h1  class="text-center text-success">Data updated fail...</h1></c:if>
</div>
<table class="table table-bordered table-striped">
<thead class="thead-dark">
       <tr>
           <th>ProductID</th>
           <th>ProductName</th>
           <th>ProductCost</th>
           <th>Brand</th>
           <th>Made IN</th>
           <th>Manufacturing date</th>
           <th>ExpiryDate</th>
           <th>Image</th>
           <th>AUDIO</th>
           <th>VIDEO</th>
           <th>ACTIONS</th>
       </tr>
</thead>
<tbody >
       <c:forEach var="product" items="<%=new ProjectDao().findAll()%>">
            <tr>
                <td>${product.proId}</td>
                <td>${product.proName}</td>
                <td>${product.proPrice}</td>
                <td>${product.proBrand}</td>
                <td>${product.proMadeIn}</td>
                <td>${product.proMfgDate}</td>
                <td>${product.proExpDate}</td>
                
                <td><img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(product.proImage)}" Style="max-width:100px; max-height:100px;"></td>
   
 
 <td> 
    <audio controls><source src="data:audio/jpeg;base64,${Base64.getEncoder().encodeToString(product.proAudio)}" type="audio/mp3" >
    </audio>
</td>
<td>
   
    <video controls width="320" height="240"><source src="data:video/jpeg;base64,${Base64.getEncoder().encodeToString(product.proVideo)}" type="video/mp4"> 
    </video>
</td>
 
 
                
                    <td>
                 	<a class="btn btn-primary" href="./DeleteProductServlet?proId=${product.proId}">DELETE</a>
                	<a class="btn btn-primary" href="./EditServlet?proId=${product.proId}">EDIT</a>
                </td>
            </tr>
            
		</c:forEach>
</tbody>
</table>
</body>
</html>