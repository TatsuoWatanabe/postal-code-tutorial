<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../parts/header.jsp" >
	<jsp:param name="title" value="welcome!" />
</jsp:include>

<div class="container">
	<h2>${message}</h2>
	<h6>${message2}</h6>
	
	<form:form modelAttribute="firstForm" class="col s12" >
		<div class="row">
			<div class="input-field col s6">
				<form:input path="id" />
				<label for="id">ID:</label>
			</div><!-- /.input-field -->
		</div><!-- /.row -->
		<div class="row">
			<div class="input-field col s12">
				<form:input path="name" />
				<label for="name">Name:</label>
			</div><!-- /.input-field -->
		</div><!-- /.row -->
		<div class="row">
			<form:checkboxes path="employees" items="${checkEmployees}" delimiter="<br/>" />
		</div><!-- /.row -->
		<div class="row">
			<button class="btn waves-effect waves-light" type="submit" name="action">
				Submit
				<i class="material-icons right"></i>
			</button>
		</div><!-- /.row -->
	</form:form>
</div><!-- /.container -->

<jsp:include page="../parts/footer.jsp" />
