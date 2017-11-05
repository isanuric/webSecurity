<title>Message Digest</title>
</head>
<body>
<jsp:include page="layout/HeadAndNavigator.jsp"></jsp:include> 
	<% System.out.println("jsp9"); %>
    <div class="column middle">
	    <h1>Message Digest</h1>
	    <p>A message digest is a function that ensures the integrity of a message.
	     Message digests take a message as input and generate a block of bits, 
	     usually several hundred bits long, that represents the fingerprint of 
	     the message. A small change in the message 
	     creates a noticeable change in the fingerprint.</p>

		<form action="startServlet" method="post">
			Enter plain text: <input type="text" id="plainTextId"  name="plainText"><br>
			<input type="submit" value="create" ><br>
		</form>
		
		plain text: 	<input name="result" readonly value=${plainText} ></input><br>
		cipher text: <input name="result" readonly value=${result}></input> <br>


	 </div>
</body>
</html>