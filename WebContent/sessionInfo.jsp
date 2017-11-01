<h3>Session Information</h3>
<table border=1>
	<tr>
		<td>actual session object</td>
		<td>request.getSession(false)</td>
		<td><%=request.getSession(false) %></td>
	</tr>
		<tr>
		<td>actuall session id</td>
		<td>request.getSession(false).getId()</td>
		<td>
			<%
				if (request.getSession(false) != null) {
					out.println(request.getSession(false).getId());
				}else {
					out.println("no session object available!");
				}
			%>
		</td>
	</tr>
		<tr>
		<td>new session</td>
		<td>session.isNew()</td>
		<td>
			<%
				if (session != null) {
					out.println(session.isNew());
				}else {
					out.println("no session object available!");
				}
			%>		
		</td>
	</tr>
</table>