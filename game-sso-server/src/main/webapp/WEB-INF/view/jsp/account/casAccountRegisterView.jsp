<jsp:directive.include file="includes/top.jsp" />


<div class="box fl-panel" id="register">
	<form:form method="post" id="reg1" cssClass="fm-v clearfix"
		commandName="reg" action="/cas/account/postReg.html">

		<form:errors path="*" id="msg" cssClass="errors" element="div" />
		<h2>
			<spring:message code="screen.welcome.instructions" />
		</h2>

		<div class="row fl-controls-left">
			<form:label path="account">Account</form:label>
			<form:input path="account" />
		</div>

		<div class="row fl-controls-left">
			<form:label path="password">Password</form:label>
			<form:password path="password" />
		</div>
		<div class="row fl-controls-left">
			<input type="submit" value="Register" />
		</div>
		<div class="row fl-controls-left">
			<form:checkbox path="seviceAgreement" value="1"/>
			
			<form:label path="seviceAgreement">Agree </form:label><a href="/cas/account/serviceAgreement.html">The Service Agreement</a>
		</div>
		
	</form:form>

</div>
<jsp:directive.include file="includes/bottom.jsp" />
