<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">

<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/cosmo/bootstrap.min.css" />
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

    <!--Need to add Header and Footer for admin(Maybe Custom Tags)-->

	<div>
		<tr>
			<div class="col-sm-5" align="center">
				<div class="panel-body" align="center">
					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th>Rental ID</th>
								<th>Rental Name</th>
								<th>Rental Status</th>
								<th>Rental Model</th>
								<th>Edit</th>
								<th>Delete</th>
							</tr>
						</thead>
						<tbody>
							<tr th:each="rental : ${listrental}">
								<td th:text="${rental.v_id}">Rental ID</td>
								<td th:text="${rental.v_name}">Rental Name</td>
								<td th:text="${rental.v_status}">Rental Status</td>
								<td th:text="${rental.v_model}">Rental Model</td>
								<td><a th:href="@{'/edit/' + ${rental.v_id}}">Edit</a></td>
								<td><a th:href="@{'/delete/' + ${rental.v_id}}">Delete</a>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</tr>
		<tr>
			<div align="left">
				<h3>
					<button th:href="@{'/new'}">Add new</button>
				</h3>
			</div>
		</tr>
	</div>
</body>
</html>