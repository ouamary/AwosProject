<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="top.jsp"/>

<div class="container-fluid">

    <div class="row-fluid">
        <div class="span12">
            <div class="utopia-login-message">
                <h1>AWOS Music</h1>
                <p>Connectez-vous pour accéder au tableau de bord</p>
            </div>
        </div>
    </div>

	<div class="row-fluid">

        <div class="span12">

            <div class="row-fluid">

                <div class="span6">
                    <div class="utopia-login-info">
                        <img src="./assets/login.png" alt="image">
                    </div>

                </div>

                <div class="span6">
                    <div class="utopia-login">
                        <h1>Identification</h1>
                        <c:if test="${not empty param.login_error}">
							<div class="alert alert-error">
					            <a class="close" data-dismiss="alert" href="#">×</a>
					            <h4 class="alert-heading">Oops!</h4>
					            Vos identifiants sont incorrects. Merci de réessayer.
							</div>
				     	</c:if>
                        <form class="utopia" name="f" action="<c:url value="/Back-Office/j_spring_security_check"/>" method="post">
                            <label>Nom d'utilisateur:</label>
							<input class="span12 utopia-fluid-input validate[required]" type="text" name="j_username" value="<c:if test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>">
							
                            <label>Mot de passe</label>
                            <input type="password" name="j_password" class="span12 utopia-fluid-input validate[required]">

                            <ul class="utopia-login-action">
                                <li>
                                    <input type="submit" class="btn span4" value="Se connecter">
                                    <input type="reset" class="btn span4">
                                </li>
                            </ul>

                            <label><a href="">Mot de passe oublié?</a></label>
                        </form>
                    </div>
                </div>

            </div>

        </div>
    </div>
</div> <!-- end of container -->

<jsp:include page="bottom.jsp"/>