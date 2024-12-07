<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Spring Boot Project</title>
    <style>
        .navbar{
            background-color: black;
            border-radius: 30px;
            
        }
        .navbar ul{
            overflow: auto;
        }
        .navbar li{
            float:left;
            list-style: none; 
            margin: 13px 20px;
            
        }
        .navbar li a{
            padding: 3px 3px;
            text-decoration: none;
            color: white;
        }
        .navbar li a:hover{
            color: red
        }
        .search{
            float: right;
            color: white;
            padding: 12px 75px;
        }
        .navbar input{
            border: 2px solid black;
            border-radius: 14px;
            padding: 3px 17px;
            width: 129px;
        }
        .button {
  background-color: black;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
input[type=text],input[type=password],input[type=number],input[type=email],
select,input[type=date],input[type=file],textarea
{
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

label 
{
  padding: 12px 12px 12px 0;
  display: inline-block;
  font-weight: bold;
}

    </style>
</head>

<body>

<%@ include file="hotelnavbar.jsp" %>

<h3 align=center><u>Add Hotels</u></h3>

<br>

<form action="inserthotel" method="post" enctype="multipart/form-data">

<table align=center>

<tr>
<td><label>Category</label></td>
<td>
<select name="category" required="required">
<option value="">---Select---</option>
<option value="Villa">Villa</option>
<option value="Full-Service Hotels">Full-Service Hotels</option>
<option value="Boutique Hotels">Boutique Hotels</option>
<option value="Budget-Friendly Hotels">Budget-Friendly Hotels</option>
<option value="Luxury Hotels">Luxury Hotels</option>
<option value="Resort Hotels">Resort Hotels</option>

</select>
</td>
</tr>

<tr><td></td></tr>

<tr>
<td><label>Hotel Name</label></td>
<td><input type="text" name="hotelname" required="required"/></td>
</tr>

<tr><td></td></tr>

<tr>
<td><label>Description</label></td>
<td>
<textarea name="description"></textarea>
</td>
</tr>

<tr><td></td></tr>

<tr>
<td><label>Hotel Location</label></td>
<td><input type="text" name="location" required="required"/></td>
</tr>

<tr><td></td></tr>

<tr>
<td><label>Price</label></td>
<td><input type="number" name="price" required="required" step="0.01" /></td>
</tr>

<tr><td></td></tr>

<tr>
    <td><label>Rating</label></td>
    <td>
        <select name="rating" required="required">
            <option value="" disabled selected>Select Rating</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
        </select>
    </td>
</tr>

<tr><td></td></tr>

<tr>
<td><label>Image</label></td>
<td><input type="file" name="hotelimage" required="required"/></td>
</tr>

<tr><td></td></tr>
<tr><td></td></tr>

<tr align=center>
<td colspan=2><input type="submit" value="Add" class="button"></td>
</tr>

</table>

</form>
    
    
</body>

</html>
