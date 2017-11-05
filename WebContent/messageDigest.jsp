<jsp:include page="layout/HeadAndNavigator.jsp"></jsp:include> 
	<title>Message Digest</title>
	    <div class="column middle">
		    <h1>Message Digest</h1>
		    <p>A message digest is a function that ensures the integrity of a message.
		     Message digests take a message as input and generate a block of bits, 
		     usually several hundred bits long, that represents the fingerprint of 
		     the message. A small change in the message 
		     creates a noticeable change in the fingerprint.</p>
	
			<form action="startServlet" method="post">
			<table  width: 56px">
			  <tr>
			    <td>Enter plain text:</td>
			    <td>
			    		<input type="text" id="plainTextId"  name="plainText" value=""><br>
			    </td>
			  </tr>
			  <tr>
			  	<td></td>
			    <td>
			   	 	<input type="submit" value="Create " >
			   	 	<input type="submit" name="refresh" value="Refresh"><br><br>
			    </td>
			  </tr>
			</table>
				
				
			</form>

			Your Plain Text: 	<input name="result" readonly value=${requestScope.plainText}></input><br>
			Message Digest: <input name="result" readonly value=${result}></input> <br>

		 </div>
	</body>
</html>