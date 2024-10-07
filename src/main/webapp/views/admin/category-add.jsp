<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/7/2024
  Time: 10:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<form action="<c:url value='/admin/category/insert'></c:url>" method="post"
      enctype="multipart/form-data">
    <label for="fname">Category name:</label><br>
    <input type="text" id="categoryname" name="categoryname"><br>
    <label for="lname">Images:</label><br>
    <img height="150" width="200" src="" id="imagess" />
    <input type="file" onchange="chooseFile(this)" id="images" name="images">
    <p>Status:</p>
    <input type="radio" id="ston" name="status" value="1" checked>
    <label for="html">Đang hoạt động</label><br>
    <input type="radio" id="stoff" name="status" value="0" >
    <label for="css">Khóa</label><br>
    <input type="submit" value="insert">
</form>
