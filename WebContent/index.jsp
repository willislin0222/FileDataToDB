<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/document/importexcel" enctype="multipart/form-data">
       <table>
           <tr>
               <td><label>NO：</label></td>
               <td><input type="file" name="fileexcel"></td>
           </tr>
           <tr>
               <td><input type="submit" value="匯入EXCEL"></td>
           </tr>
       </table>
    </form>
    
    	<form method="post" action="${pageContext.request.contextPath}/document/importCSV" enctype="multipart/form-data">
       <table>
           <tr>
               <td><label>NO：</label></td>
               <td><input type="file" name="filecsv"></td>
           </tr>
           <tr>
               <td><input type="submit" value="匯入CSV"></td>
           </tr>
       </table>
    </form>
</body>
</html>