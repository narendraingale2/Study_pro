<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
      
<!DOCTYPE html ">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Form</title>
</head>
<body>
<h1>This is student sumission form. Please fill it carefully</h1>


<form:form commandName="student" action="submitForm.html" method="post">
<c:if test="${!empty student}">
<table>
<tr>
        <td>
            <form:label path="userId">Student ID</form:label>
            <form:hidden path="userId" />
        </td>
        <td>
            <form:input path="userId" readonly="true" size="8"  disabled="true" />
            <form:hidden path="userId" />
        </td> 
    </tr>
<tr>
        <td><form:label path="studentName">Student Name</form:label></td>
        <td><form:input path="studentName" /></td>
    </tr>

<tr>
        <td><form:label path="studentHobby">Student Hobby</form:label></td>
        <td><form:input path="studentHobby" /></td>
    </tr>


<tr>
        <td><form:label path="studentContact">Student Contact :-</form:label></td>
        <td><form:input path="studentContact" /></td>
    </tr>

<tr>
        <td><form:label path="studentDOB">Student DOB :-</form:label></td>
        <td><form:input path="studentDOB" /></td>
    </tr>
<tr><td>Skillset1 :- </td><td>
<td>

<td>
</tr>

<tr><td>Skillset :- </td><td>


<select multiple name="skillSet">

  <option value="C">C</option>
  <option value="C++">C++</option>
  <option value="Java">Java</option>
  <option value="Python">Python</option>
</select></td></tr>
<tr><td colspan="2">Address</td></tr>
<tr>

<tr>
        <td><form:label path="address.street">Street :-</form:label></td>
        <td><form:input path="address.street" /></td>
    </tr>

<tr>
        <td><form:label path="address.city">City :-</form:label></td>
        <td><form:input path="address.city" /></td>
    </tr>


<tr>
        <td><form:label path="address.country">Country :-</form:label></td>
        <td><form:input path="address.country" /></td>
    </tr>


<tr>
        <td><form:label path="address.zip">Zip :-</form:label></td>
        <td><form:input path="address.zip" /></td>
    </tr>





<tr><td><input type="submit" value="Ok"></td></tr>
</table>

</c:if>
<c:if test="${empty student}">
<table>
<tr>
        <td>Student Name</td>
        <td><input type="text" name=studentName></td>
</tr>

<tr>
        <td>Student Hobby</td>
        <td><input type="text" name=studentHobby></td>
</tr>
<tr>
        <td>Student Contact</td>
        <td><input type="text" name=studentContact></td>
</tr>

<tr>
        <td>Student DOB</td>
        <td><input type="text" name=studentDOB></td>
</tr>
<tr><td>Skillset :- </td><td>
<select multiple name="skillSet">
  <option value="C">C</option>
  <option value="C++">C++</option>
  <option value="Java">Java</option>
  <option value="Python">Python</option>
</select></td></tr>
<tr><td colspan="2">Address</td></tr>
<tr>
        <td>Street</td>
        <td><input type="text" name=address.street></td>
</tr>
<tr>
        <td>City</td>
        <td><input type="text" name=address.City></td>
</tr>
<tr>
        <td>Country</td>
        <td><input type="text" name=address.country></td>
</tr>
<tr>
        <td>Zip</td>
        <td><input type="text" name=address.zip></td>
</tr>
<tr><td><input type="submit" value="Ok"></td></tr>
</table>
</c:if>

</form:form>
<hr/>
<div align="center">
            <h1>Student List</h1>
            <table border="1">
            <tr>
                <th>S.No.</th>
                <th>Student Name</th>
                <th>Student Hobby</th>
                <th>Student Contact</th>
                <th>Student DOB</th>
                <th>Student Skill Set</th>
                <th>Street</th>
                <th>City</th>
                <th>Edit</th>
 				<th>Delete</th>
                 </tr>
     
 <c:forEach items="${studentList}" var="student" varStatus="status">
   <tr>
   
  <td>${status.index + 1}</td>
                    <td>${student.studentName}</td>
                    <td>${student.studentHobby}</td>
                    <td>${student.studentContact}</td>
                    <td>${student.studentDOB}</td>
                    <td>${student.skillSet}</td>
                    <td>${student.address.street}</td>
                    <td>${student.address.city}</td>
                    <td><a href="<c:url value='/edit/${student.userId}' />" ><img border="0"  src="resources\images\edit.png" width="50" height="30"></a></td></td>
            		<td><a href="<c:url value='/remove/${student.userId}' />" ><img border="0"  src="resources\images\images.jpg" width="50" height="30"></a></td></a></td>
</c:forEach>        
            </table>
        </div>          
</body>
</html>