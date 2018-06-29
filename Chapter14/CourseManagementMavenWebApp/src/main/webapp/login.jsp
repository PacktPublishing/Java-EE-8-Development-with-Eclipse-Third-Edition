<!DOCTYPE HTML>
<html>
<head>
<title>Admin Login</title>
</head>
<body>

	<form method=post action="j_security_check">
		<table>
			<tr>
				<td>User Name: </td>
				<td><input type="text" name="j_username"></td>
			</tr>
			<tr>
				<td>Password: </td>
				<td><input type="password" name="j_password"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>
</body>
</html>