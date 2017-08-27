<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Upload File Demo</title>
<body>
	 Upload File Demo<br/><br/>
	<form action="outfits/restwb/upload" method="post" enctype="multipart/form-data">
 		 File : <input type="file" name="filename" size="50" />
	  <br/>
 	   <input type="submit" value="Upload" />
	</form>
 </body>
</html> 