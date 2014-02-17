<jsp:directive.include file="includes/top.jsp" />


<div class="box fl-panel" id="register">
	<form:form method="post" id="reg1" cssClass="fm-v clearfix" commandName="reg" action="/cas/account/postReg.html">
		<form:label path="account">Account</form:label><form:input path="account" />
		<form:label path="password">Password</form:label><form:input path="password" />
		<form:label path="passwordConfirmed">Password Confirmed</form:label><form:input path="passwordConfirmed" />
		
		 <input type="submit" value="Register"/>
		 
	</form:form>

</div>
<jsp:directive.include file="includes/bottom.jsp" />
