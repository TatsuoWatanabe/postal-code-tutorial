<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../parts/header.jsp" >
	<jsp:param name="title" value="${title}" />
</jsp:include>

<div class="container">
	<h1><c:out value="${title}"></c:out></h1>
	
	<p>
		<c:out value="${message}"></c:out>
	</p>
	
	<form:form modelAttribute="employeeListForm" class="col s12">
		<table>
			<tbody>
				<tr>
					<td class="input-field">
						<form:label  path="name" cssErrorClass="invalid">名前</form:label>
						<form:input  path="name" cssErrorClass="invalid" />
						<form:errors path="name" class="red-text" />
					</td>
				</tr>
				<tr>
					<td class="input-field">
						<form:label  path="age" cssErrorClass="invalid">年齢</form:label>
						<form:input  path="age" cssErrorClass="invalid" />
						<form:errors path="age" class="red-text" />
					</td>
				</tr>
				<tr>
					<td class="input-field">
						<form:label    path="memo" cssErrorClass="invalid">メモ</form:label>
						<form:textarea path="memo" class="materialize-textarea" cssErrorClass="materialize-textarea invalid" cols="20" row="5" />
						<form:errors   path="memo" class="red-text" />
					</td>
				</tr>
			</tbody>
		</table>
		<div class="row">
			<button class="btn waves-effect waves-light" type="submit" name="action">
				Submit
				<i class="material-icons right"></i>
			</button>
		</div><!-- /.row -->
	</form:form>
	
	<c:if test="${not empty employeeList}">
		<table class="bordered striped highlight">
			<tbody>
				<tr>
					<th>社員名</th>
					<th>年齢</th>
					<th>メモ</th>
				</tr>
				<c:forEach var="employee" items="${employeeList}">
					<tr>
						<td><c:out value="${employee.name}"></c:out></td>
						<td><c:out value="${employee.age}"></c:out></td>
						<td><c:out value="${employee.memo}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</div><!-- /.container -->

<jsp:include page="../parts/footer.jsp" />
