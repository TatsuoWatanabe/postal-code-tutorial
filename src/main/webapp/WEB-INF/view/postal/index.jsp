<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn"   uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="titleString" value="PostalCodeTutorial" />
<c:set var="notFoundMsg" value="ご希望のデータが見つかりませんでしたか? 抽出条件を変更して、再度検索してみてください。" />

<jsp:include page="../parts/header.jsp">
	<jsp:param name="title" value="${titleString}" />
</jsp:include>

<div class="container">
	<h3>${titleString}</h3>
	<form:form modelAttribute="postalForm" method="get">
		<div class="row">
			<div class="input-field col s3">
				<form:input path="code" />
				<label for="code">〒</label>
			</div><!-- /.input-field -->
			<div class="input-field col s3">
				<form:select path="prefecture_code" multiple="false">
					<form:option value="" label="" />
					<form:options 
						items="${prefectures}"
						itemValue="code"
						itemLabel="prefectureName"
					/>
				</form:select>

				<label>都道府県</label>
			</div><!-- /.input-field -->
		</div><!-- /.row -->
		<div class="row">
			<div class="input-field col s12">
				<form:input path="address1" />
				<label for="address1">住所</label>
			</div><!-- /.input-field -->
		</div><!-- /.row -->
		<div class="row">
			<div class="input-field col s4">
				<button class="btn waves-effect waves-light" type="submit">Search</button>
			</div><!-- /.input-field -->
			<div class="input-field col s8 right-align">
				<a href="${pageContext.request.contextPath}" class="btn red waves-effect waves-light">Reset</a>
			</div><!-- /.input-field -->
		</div><!-- /.row -->
	</form:form>

	<jsp:include page="../parts/limitedRowsResult.jsp">
		<jsp:param name="rows"        value="${fn:length(postals)}" />
		<jsp:param name="foundRows"   value="${totalPostals}" />
		<jsp:param name="notFoundMsg" value="${notFoundMsg}" />
	</jsp:include>
	
	<table class="bordered highlight">
		<thead>
			<tr>
				<th style="width:2em;"></th>
				<th style="width:8em;">郵便番号</th>
				<th>住所</th>
				<th style="width:8em;"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${postals}" var="postal" varStatus="status">
				<tr>
					<td>${status.index+1}.</td>
					<td>〒 <c:out value="${postal.formatCode}" /></td>
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
			<c:if test="${fn:length(postals) == 0}">
				<tr><td colspan="4">${notFoundMsg}</td></tr>
			</c:if>
		</tbody>
	</table>
	<jsp:include page="../parts/limitedRowsResult.jsp">
		<jsp:param name="rows"        value="${fn:length(postals)}" />
		<jsp:param name="foundRows"   value="${totalPostals}" />
		<jsp:param name="notFoundMsg" value="${notFoundMsg}" />
	</jsp:include>
</div><!-- /.container -->

<script>
$(function() {
	$('select').material_select();
});
</script>

<jsp:include page="../parts/footer.jsp" />