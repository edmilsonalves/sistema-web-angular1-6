<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<table id="cliente-table" class="table table-bordered table-striped">
	<thead>
		<tr>
			<th id="id"><spring:message code="label.codigo" /></th>
			<th><spring:message code="label.nomecliente" /></th>
			<th class="no-sort"><spring:message code="label.telefoneMA" />
			</th>
			<th class="no-sort"><spring:message code="label.enderecoMA" />
			</th>
		</tr>
	</thead>
</table>

<div class="box-footer">
	<div class="btn-group mr-2" role="group" aria-label="Second group">
		<a class="fontSize" href="dashboard.html"> Paine de Controle </a>
	</div>
</div>