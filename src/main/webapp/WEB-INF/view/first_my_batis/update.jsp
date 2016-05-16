<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="../parts/header.jsp">
	<jsp:param name="title" value="welcome!" />
</jsp:include>

<div class="container">
	<div class="row"></div>
	<a href="${pageContext.request.contextPath}/first_my_batis" class="btn green waves-effect waves-light">
		 <i class="large material-icons" style="transform: scaleX(-1);">trending_flat</i>
	</a>
	
	<h1>${message}</h1>
	Nameを更新してください。
	<form:form modelAttribute="testForm" action="${pageContext.request.contextPath}/first_my_batis/update" method="put" data-url-onsuccess="${pageContext.request.contextPath}/first_my_batis">
		<div class="input-field col s12">
			<form:input path="id" value="${test.id}" readonly="true" />
			<label for="id">ID:</label>
		</div><!-- /.input-field -->
		<div class="input-field col s12">
			<form:input path="name" value="${test.name}" />
			<label for="name">Name:</label>
		</div><!-- /.input-field -->
		
		<button class="btn waves-effect waves-light" type="submit">
			Submit <i class="material-icons right"></i>
		</button>
	</form:form>
</div><!-- /.container -->

<script>
$(function() {
	$('#testForm').submit(function(e) {
		e.preventDefault();
		var $form = $(e.target);
		$.ajax($form.attr('action'), {
			method: 'put',
			data  : $form.serialize()
		}).done(function(data) {
			location.href = $form.data('url-onsuccess');
		});
	});
});
</script>

<jsp:include page="../parts/footer.jsp" />