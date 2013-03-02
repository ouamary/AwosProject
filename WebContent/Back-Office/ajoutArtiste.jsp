<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="top.jsp"/>

<div class="container-fluid">

	<jsp:include page="header.jsp"/>

    <div class="row-fluid">

        <jsp:include page="left.jsp"/>

        <!-- Body start -->
		<div class="span10">
			<a href="${boActionURL}admin/artiste" class="btn">Lien</a>

			<section id="formElement" class="utopia-widget utopia-form-box section">
			    <div class="utopia-widget-title">
			        <img src="Back-Office/assets/software24.png" class="utopia-widget-icon">
			        <span>Ajouter un artiste</span>
			    </div>
			
			    <div class="row-fluid">
			        <div class="utopia-widget-content">
			            <div class="span6 utopia-form-freeSpace">
			            	<form:form enctype="multipart/form-data" class="form-horizontal" commandName="artiste" action="artiste.action" method="POST">
			            		<form:errors path="*" />
			                	<fieldset>
			                		<form:hidden path="id" />
			                		<form:hidden path="version" />
			                		               						
			                		<c:choose>
			                			<c:when test="${edit==1}">
			                				<div class="control-group">
					                            <label class="control-label"></label>
					
					                            <div class="controls">
					                                <c:choose>
														<c:when test="${empty artiste.getPhotoType()}">
															<img src="http://placehold.it/150/f1f1f1/6d6d6d&text=++++:)" />													
														</c:when>
														<c:otherwise>
															<img src="photoArtiste.action?id=${artiste.getId()}">
														</c:otherwise>
													</c:choose>
				                           		</div>
							                </div>
			                			
			                				<div class="control-group">
					                        	<label class="control-label" for="input04">Photo</label>
					                        	
					                        	<div class="controls">
					                                <span class="btn btn-success fileinput-button">
					                                    <i class="icon-plus icon-white"></i>
					                                    <span>Modifier</span>
					                                    <input id="input04" type="file" name="fichier">
					                                </span>
				                           		</div>
				                           	</div>
			                				<div class="control-group">
					                            <label class="control-label" for="input02">ID</label>
					
					                            <div class="controls">
					                                <input readonly="readonly" id="input02" class="span10" value="${artiste.getId()}"/>
				                           		</div>
					                        </div>
					                        <div class="control-group">
					                            <label class="control-label" for="input03">Version</label>
					
					                            <div class="controls">
					                                <input readonly="readonly" id="input03" class="span10" value="${artiste.getVersion()}"/>
					                            </div>
					                        </div>					                        				                        			                			
			                			</c:when>
			                		</c:choose>			                		
			                        <div class="control-group">
			                            <label class="control-label" for="input01">Nom</label>
			
			                            <div class="controls">
			                                <form:input id="input01" class="span10" path="nom"/>
			                            </div>
			                        </div>
			                        <div class="control-group">
			                            <label class="control-label" for="textarea">Bio</label>
			
			                            <div class="controls">
			                            	<form:textarea id="textarea" class="span10" rows="3" path="bio"/>
			                            </div>
			                        </div>			                        
			                        <!--<div class="control-group error">
			                            <label class="control-label" for="inputError">Input with error</label>
			
			                            <div class="controls">
			                                <input id="inputError" class="span10" type="text">
			                                <span class="help-inline">Please correct the error</span>
			                            </div>
			                        </div>-->
			                        <div class="row-fluid">
			                        	<div class="span4 offset7">
			                        		<a class="btn btn-success" href="javascript:artiste.submit();"> <i
											class="icon-ok icon-white"></i> Valider
											</a>
											<a class="btn btn-danger" href="Back-Office/adminArtiste.action"> <i
											class="icon-remove icon-white"></i> Annuler
											</a>
			                        	</div>				                    
									</div>              		
								</fieldset>								
			                </form:form>
			            </div>
			
			            <!--<div class="span6 utopia-form-freeSpace">
			                <form class="form-horizontal">
			                    <fieldset>
			                        <div class="control-group">
			                            <label class="control-label" for="select01">Select list</label>
			
			                            <div class="controls">
			                                <select id="select01" class="span6">
			                                    <option>something</option>
			                                    <option>2</option>
			                                    <option>3</option>
			                                    <option>4</option>
			                                    <option>5</option>
			                                </select>
			                            </div>
			                        </div>
			                        <div class="control-group">
			                            <label class="control-label" for="optionsCheckbox">Checkbox</label>
			
			                            <div class="controls">
			                                <label class="checkbox">
			                                    <input id="optionsCheckbox" type="checkbox" value="option1">
			                                    Option one is this and that—be sure to include why it's great
			                                </label>
			                            </div>
			                        </div>
			                        <div class="control-group">
			                            <label class="control-label">Radio buttons</label>
			
			                            <div class="controls">
			                                <label class="radio">
			                                    <p>
			                                        <input id="optionsRadios1" type="radio" checked="" value="option1" name="optionsRadios">
			                                        Option one is this and that—be sure to include why it's great
			                                    </p>
			                                </label>
			                                <label class="radio">
			                                    <p>
			                                        <input id="optionsRadios2" type="radio" value="option2" name="optionsRadios">
			                                        Option two can is something else and selecting it will deselect option one
			                                    </p>
			                                </label>
			                            </div>
			                        </div>
			                        <div class="control-group">
			                            <label class="control-label"><p>checkboxes</p></label>
			
			                            <div class="controls">
			                                <label class="checkbox inline">
			                                    <input id="inlineCheckbox1" type="checkbox" value="option1">
			                                    1
			                                </label>
			                                <label class="checkbox inline">
			                                    <input id="inlineCheckbox2" type="checkbox" value="option2">
			                                    2
			                                </label>
			                                <label class="checkbox inline">
			                                    <input id="inlineCheckbox3" type="checkbox" value="option3">
			                                    3
			                                </label>
			                            </div>
			                        </div>
			                        <div class="control-group">
			                            <label class="control-label" for="textarea">Textarea</label>
			
			                            <div class="controls">
			                                <textarea id="textarea" class="span8" rows="3"></textarea>
			                            </div>
			                        </div>
			                    </fieldset>
			                </form>
			            </div>-->
			
			        </div>
			    </div>
			</section>
			
			<!-- Body end -->
    	</div>
	</div>
    <!-- Maincontent end -->

</div> <!-- end of container -->

<jsp:include page="bottom.jsp"/>