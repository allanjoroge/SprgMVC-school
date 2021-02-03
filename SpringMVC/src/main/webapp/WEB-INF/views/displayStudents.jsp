<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<style>
#customers {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 80%;
	margin-left: auto;
	margin-right: auto;
}

#customers td{
border: 1px thin #ddd;
	padding: 8px;
}
#customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#customers tr:nth-child(odd) {
	background-color: #f2f2f2;
}

#customers tr:hover {
	background-color: LightSkyBlue;
}

#customers th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: LightGray;
	color: #6d6d6d;
}
</style>
</head>
<body>

	<table id="customers">

		<caption>
			<h2>STUDENTS</h2>
		</caption>
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Username</th>
			<th>Manage</th>
		</tr>
		<c:forEach var="student" items="${studentList}">

			<c:url var="updateStudent" value="/edit">
				<c:param name="id" value="${student.id}" />
			</c:url>

			<tr>
				<td><c:out value="${student.id}" /></td>
				<td><c:out value="${student.firstName}" /></td>
				<td><c:out value="${student.lastName}" /></td>
				<td><c:out value="${student.username}" /></td>
				<td><a href="${updateStudent}"> EDIT</a> | <a
					href="/mvc/delete/${student.id}"
					onclick="if (!(confirm('are you sure you want to delete this student?'))) return false">DELETE</a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
