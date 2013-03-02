<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="top.jsp"/>

<div class="container-fluid">

	<jsp:include page="header.jsp"/>

    <div class="row-fluid">

        <jsp:include page="left.jsp"/>

        <!-- Body start -->		
		<div class="span10 body-container">

			<div class="row-fluid">
				<section class="utopia-widget">
					<div class="utopia-widget-title">
						<img src="Back-Office/assets/paragraph_justify.png" class="utopia-widget-icon">
						<span>Artistes</span>
					</div>
		
					<div class="utopia-widget-content">
		
						<div class="row-fluid">
							<div>
								<label>
									<a class="btn" href="./Back-Office/artiste.action"> <i
									class="icon-plus icon-white"></i> Ajouter
									</a>
								</label>								
							</div>
						</div>
						
						<div class="row-fluid">
							<form:form commandName="adminForm" action="adminArtiste.action"
								method="POST">
								<form:errors path="*" />
								<table class="table table-striped table-bordered">
			
									<thead>
										<tr>
											<th><input class="utopia-check-all" type="checkbox"></th>
											<th>Nom</th>
											<th>Bio</th>
											<th>Actions</th>
										</tr>
									</thead>
			
									<tbody>							
										<c:forEach var="a" items="${artistes}">
											<c:set var="shortbio" value="${fn:substring(a.bio, 0, 100)}" />
											<tr>
												<td><input class="chkbox" type="checkbox" name="checkboxes" value="${a.id}"></td>
												<td>${a.nom}</td>
												<td>
													<c:choose>
														<c:when test="${fn:length(a.bio)>100}">
														${shortbio}...
														</c:when>
														<c:otherwise>
														${a.bio}
														</c:otherwise>
													</c:choose>											
												</td>
												<td><a href="artiste.action?idA=${a.id}" class="btn edit">
														<img src="Back-Office/assets/pencil.png" alt="Edit">
													</a>
													<a data-toggle="modal" data-target="#imageModal${a.id}" class="btn addpic">
														<img src="Back-Office/assets/camera.png" alt="Add pic">
													</a>
													<div id="imageModal${a.id}" class="modal hide fade">
														<div class="modal-body">
															<img src="photoArtiste.action?id=${a.id}">
														</div>
													</div>									
												</td>
											</tr>
										</c:forEach>			
									</tbody>
								</table>
			
								<a class="btn btn-danger" href="javascript:adminForm.submit();"> 
									<i class="icon-trash icon-white"></i> Supprimer
								</a>
								
								</form:form>
							</div>
					</div>
				</section>
			</div>
		</div>
	
        <!-- Body end -->

    	</div>
</div><!-- Maincontent end -->
<jsp:include page="bottom.jsp"/>
