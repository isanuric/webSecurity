<jsp:include page="layout/HeadAndNavigator.jsp"></jsp:include> 
<title>Private Key</title>
<div class="column middle">
<h1>Private Key</h1>
A private key is a variable that is used with an algorithm to encrypt and decrypt code.
Quality encryption always follows a fundamental rule: the algorithm doesn't need to be kept secret, but the key does. 
Private keys play important roles in both symmetric and asymmetric cryptography.

<h3>Mode</h3>
Java platform supports five different modes. For example, you can allow the encryption of one block to be dependent on 
the encryption of the previous block, or you can make the encryption of one block independent of any other blocks.<br>

<p>&#9656; ECB (Electronic Code Book) </p>
<p>&#9656; CBC (Cipher Block Chaining) </p>
<p>&#9656; CFB (Cipher Feedback Mode) </p>
<p>&#9656; OFB (Output Feedback Mode) </p>
<p>&#9656; PCBC (Propagating Cipher Block Chaining)  </p>
</div>
</body>
</html>