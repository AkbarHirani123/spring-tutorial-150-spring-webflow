<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="center">
	<h3>Send New Message:</h3>
</div>

<!-- comandName is the Bean -->
<sf:form method="post" commandName="message">

	<input type="hidden" name="_flowExecutionKey"
		value="${FlowExecutionKey}" />
	<input type="hidden" name="_eventId" value="send" />

	<table class="formtable">
		<tr>
			<td class="label">Your Name:</td>
			<td><sf:input class="control" path="name" name="name"
					type="text" value="${fromName}"/><br />
				<div class="error">
					<sf:errors path="name"></sf:errors>
				</div></td>
		</tr>
		<tr>
			<td class="label">Your Email:</td>
			<td><sf:input class="control" path="email" name="email"
					type="text" value="${fromEmail}"/><br />
				<div class="error">
					<sf:errors path="email"></sf:errors>
				</div></td>
		</tr>
		<tr>
			<td class="label">Subject:</td>
			<td><sf:input class="control" path="subject" type="text" /><br />
				<div class="error">
					<sf:errors path="subject"></sf:errors>
				</div></td>
		</tr>
		<tr>
			<td class="label">Content:</td>
			<td><sf:textarea class="control" path="content" type="text" /><br />
				<div class="error">
					<sf:errors path="content"></sf:errors>
				</div></td>
		</tr>
		<tr>
			<td class="label"></td>
			<td><input class="control" value="Send Message" type="submit" /></td>
		</tr>
	</table>

</sf:form>
