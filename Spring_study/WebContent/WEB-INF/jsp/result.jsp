<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form has been processed</title>
</head>
<body>
<h1>Form has been processed now !!!!</h1>
<table>
<tr><td>Student Name :- </td><td>${ student1.studentName }</td></tr>
<tr><td>Student Hobby:-</td><td>${ student1.studentHobby }</td></tr>
<tr><td>Student Contact:-</td><td>${ student1.studentContact }</td></tr>
<tr><td>Student DOB:-</td><td>${ student1.studentDOB }</td></tr>
<tr><td>Student SkillSet:-</td><td>${ student1.skillSet }</td></tr>
<tr><td>Student Street:-</td><td>${ student1.address.street }</td></tr>
<tr><td>Student City:-</td><td>${ student1.address.city }</td></tr>
<tr><td>Student ZIP:-</td><td>${ student1.address.zip }</td></tr>
<tr><td>Student Country:-</td><td>${ student1.address.country }</td></tr>
</table>
</body>
</html>