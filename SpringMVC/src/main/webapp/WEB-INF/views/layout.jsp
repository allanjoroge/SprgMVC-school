<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
	<table border="0" cellpadding="0" cellspacing="0" align="center"
		width="100%" height="100%">
		<tr>
			<td style="background-color: LightGray; padding: 20px;" align="left" colspan="2" >
				<div class="header">
					<tiles:insertAttribute name="header" />
				</div>
			</td>
		</tr>
		<tr>
			<td
				style="text-align: top; padding: 15px; vertical-align: top; background-color: LightSkyBlue;">
				<div class="menu">
					<tiles:insertAttribute name="menu" />
				</div>
			</td>
		</tr>
		<tr>
			<td
				style="text-align: top; vertical-align: top; background-color: white;">
				<div class="container">
					<tiles:insertAttribute name="body" />
				</div>
			</td>
		</tr>
		<tr>

			<td style="background-color: LightGray; position: fixed; left: 0; padding: 5px; bottom: 0; width: 100%;" colspan="2">  
				<div class="footer">
					<tiles:insertAttribute name="footer" />
				</div>
			</td>
		</tr>
	</table>
</body>
</html>