<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="../parts/header.jsp">
	<jsp:param name="title" value="welcome!" />
</jsp:include>

<div class="container">
	<h3>${message}</h3>
	<form:form modelAttribute="postalForm">
		<div class="input-field col s12">
			<form:input path="prefecture_name" />
			<label for="prefecture_name">Name:</label>
		</div><!-- /.input-field -->
		
		<div class="row">
			<button class="btn waves-effect waves-light" type="submit" name="action">
				Submit <i class="material-icons right"></i>
			</button>
		</div><!-- /.row -->
	</form:form>

	<table class="bordered highlight">
		<thead>
			<tr>
				<th style="width:8em;">郵便番号</th>
				<th>住所</th>
				<th style="width:8em;"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${postals}" var="postal">
				<tr>
					<td><c:out value="${postal.formatCode}" /></td>
					<td>
						<c:out value="${postal.prefecture_name}" />
						<c:out value="${postal.address1}" />
						<c:out value="${postal.address2}" />
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/${postal.code}" class="btn blue waves-effect waves-light">
							Edit
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div><!-- /.container -->

<jsp:include page="../parts/footer.jsp" />