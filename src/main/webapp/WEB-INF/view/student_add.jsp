<!DOCTYPE html>

  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Edit Student</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    
<script type="text/javascript">
/*var token = $('#_csrf').attr('content');
var header = $('#_csrf_header').attr('content');
$(document).delegate('#submitButton', 'click', function(event) {
	event.preventDefault();
	
	$.ajax({
        url:'/save-student',
        contentType: "application/json",
        type: "POST",
        data: JSON.stringify({acqId : 0}),
        dataType: 'json',
        beforeSend: function (request) {
            request.setRequestHeader(header, token);
        }, success: function (result) {
            alert("submited");
        },
       error: function(data) {
            
            // Some error in ajax call
            alert("some Error");
        }
    });
});*/





$(() => {
    // function will get executed 
    // on click of submit button
    $("#submitButton").click(function(e) {


      
        alert("kin");
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/save-student",
            data: $("#formId").serialize(),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function(data) {
                
                // Ajax call completed successfully
                alert("Form Submited Successfully");
            },
            error: function(data) {
                 
                // Some error in ajax call
                alert("some Error");
            }
        });

    
        
    });
});

 </script>
</head>

<body>
    <div class="container my-5">
        <h3>Edit Student</h3>
        <div class="card">
            <div class="card-body">
                <div class="col-md-10">
                    <form:form 
                        method="post" modelAttribute="studentFormVlaidator" id="formId" name="formId">
                        
                        <div class="row">
                            <div class="form-group col-md-8">
                                <label for="name" class="col-form-label">Name</label>
                                <form:input type="text" class="form-control" id="name"
                                    path="name" placeholder="Enter Name" />
                                     <form:errors path="name" />
                            </div>
                            <div class="form-group col-md-8">
                                <label for="name" class="col-form-label">Roll No.</label>
                                <form:input type="text" class="form-control" id="rollNo"
                                    path="rollNo" placeholder="Enter Roll No." />
                                    <form:errors path="rollNo" />
                            </div>
                            <div class="form-group col-md-8">
                                <label for="emailId" class="col-form-label">Email</label>
                                <form:input type="text" class="form-control" id="emailId"
                                    path="emailId" placeholder="Email Id" />
                                    <form:errors path="emailId" />
                            </div>
                            
                          
                             <div class="form-group col-md-8">
                                <label for="country" class="col-form-label">Country</label>
                                 <select name="countryId" path="countryId" id="countryId">
                                <option value="">Select Country</option>
    <c:forEach items="${countries}" var="country">
        <option value="${country.key}">${country.value}</option>
    </c:forEach>
    </select>
                              
                            </div>
                            
                            
                            <div class="col-md-6">
                                <input type="submit" id="submitButton" class="btn btn-primary" value="Submit">
                            </div>

                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>