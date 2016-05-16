<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="../parts/header.jsp">
	<jsp:param name="title" value="welcome!" />
</jsp:include>

<div class="container">
	<h1>${message}</h1>
	<form:form modelAttribute="testForm">
		<c:choose>
			<c:when test="${tests == null}">
				<h4>${test.name}</h4>
			</c:when>
			<c:otherwise>
				<div class="input-field col s12">
					<form:input path="name" />
					<label for="name">Name:</label>
				</div><!-- /.input-field -->
				
				<div class="row">
					<button class="btn waves-effect waves-light" type="submit" name="action">
						Submit <i class="material-icons right"></i>
					</button>
				</div><!-- /.row -->
			</c:otherwise>
		</c:choose>
	</form:form>

	<table class="bordered highlight">
		<thead>
			<tr>
				<th style="width:2em;"></th>
				<th></th>
				<th style="width:4em;"></th>
				<th style="width:4em;"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${tests}" var="test">
				<tr>
					<td><c:out value="${test.id}" />:</td>
					<td><c:out value="${test.name}" /></td>
					<td>
						<a href="${pageContext.request.contextPath}/first_my_batis/update/${test.id}" class="btn blue waves-effect waves-light">
							Edit
						</a>
					</td>
					<td>
						<button type="button" data-id="${test.id}" class="btn btn-delete red waves-effect waves-light" name="action">
							Delete
						</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div><!-- /.container -->

<script>
$(function() {
	$('.btn-delete').click(function(e) {
		var $btn = $(e.target);
		var id   = $btn.data('id');
		$.ajax('first_my_batis/delete/' + id, {
			method: 'delete'
		}).done(function(data) {
			location.reload();
		});
	});
});
</script>

<jsp:include page="../parts/footer.jsp" />