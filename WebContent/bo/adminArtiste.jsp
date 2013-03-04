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
						<img src="${boAssetsURL}paragraph_justify.png" class="utopia-widget-icon">
						<span>Artistes</span>
					</div>
		
					<div class="utopia-widget-content">
		
						<div class="row-fluid">
							<div>
								<label>
									<a class="btn" href="${boActionURL}artiste"> <i
									class="icon-plus icon-white"></i> Ajouter
									</a>
								</label>								
							</div>
						</div>
						
						<div class="row-fluid">
							<form:form commandName="adminForm" action="${boActionURL}admin/artiste"
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
										<c:forEach var="a" items="${artistes.getPageList()}">
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
												<td><a href="${boActionURL}artiste/${a.id}" class="btn edit">
														<img src="${boAssetsURL}pencil.png" alt="Edit">
													</a>
													<c:if test="${not empty a.photo || a.photo != null}">
														<a data-toggle="modal" data-target="#imageModal${a.id}" class="btn addpic">
															<img src="${boAssetsURL}camera.png" alt="Add pic">
														</a>
													</c:if>
													<div id="imageModal${a.id}" class="modal hide fade">
														<div class="modal-body">
															<img src="${boActionURL}photo/artiste/${a.id}">
														</div>
													</div>									
												</td>
											</tr>
										</c:forEach>			
									</tbody>
								</table>
								
								<div class="row-fluid">
									<div class="span6 utopia-table-action">
										<a class="btn btn-danger" href="javascript:adminForm.submit();"> 
											<i class="icon-trash icon-white"></i> Supprimer
										</a>
									</div>
									<div class="span6 utopia-table-action pagination pagination-right">
										<ul>
											<c:if test="${!artistes.isFirstPage()}">
												<li>
													<a href="${boActionURL}admin/artiste/1"><i class="icon-fast-backward"></i></a>
												</li>
												<li>
													<a href="${boActionURL}admin/artiste/${artistes.getPage()}"><i class="icon-backward"></i></a>
												</li>
											</c:if>
											<c:forEach var="i" begin="1" end="${artistes.getPageCount()}" step="1">
												<li class="<c:if test="${i == artistes.getPage()+1}">active</c:if>">
													<a href="${boActionURL}admin/artiste/${i}">${i}</a>
												</li>
											</c:forEach>
											<c:if test="${!artistes.isLastPage()}">
												<li>
													<a href="${boActionURL}admin/artiste/${artistes.getPage()+2}"><i class="icon-forward"></i></a>
												</li>
												<li>
													<a href="${boActionURL}admin/artiste/${artistes.getPageCount()}"><i class="icon-fast-forward"></i></a>
												</li>												
											</c:if>									
										</ul>
									</div>								
								</div>
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
