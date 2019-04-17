<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String s=request.getParameter("q");
String l1,l2,l3,l4;
l1="bar_code_39_type?value="+s;
l2="Create_Bar_Code_With_Parameter?value="+s;
l3="qr_code?value="+s;
l4="upc?value="+s;
%>
<table id="tab">
        <tr>
        <th>TYPE</th>
        <th>BAR CODE</th>
        </tr>
<tr>
<td>Type-39</td>
<td>
<br>
<img alt="barcode=<%=s%>" src="<%=l1%>" ><br>
<br>
</td>
</tr>  
<tr>
<td>Type-128</td>
<td>
<br>
<img alt="barcode=<%=s%>" src="<%=l2%>" ><br><br>
</td>
</tr>  

<tr>
<td>QR-Code</td>
<td>
<br>

<img alt="barcode" src="<%=l3%>" ><br>
</td>
</tr>  

<tr>
<td>UPC-A</td>
<td>
<br>

<img alt="barcode" src="<%=l4%>" ><br>
</td>
</tr>       
        </table>



</body>
</html>