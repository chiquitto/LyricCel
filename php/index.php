<html"><style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
  <body>
	<title> Login Tcc </title>
		<form action="verifica_login.php" method="post">
		<table width="234" border="1" align="center">
		  <tr>
		    <td colspan="2"><div align="center"><strong>Login.</strong></div></td>
		    </tr>
		  <tr>
		    <td width="51"><div align="right"><strong>E-mail</strong></div></td>
		    <td width="167">
			<label>
		      <input type="text" name="email" />
		    </label></td>
		  </tr>
		  <tr>
		    <td><div align="right"><strong>Senha</strong></div></td>
		    <td>
			<label>
		      <input type="password" name="senha" />
		    </label></td>
		  </tr>
		  <tr>
		    <td colspan="2">
				<div align="center">
			  		<input type="submit" name="entrar" value="Entrar" />
			        <a href="cadastro_usuario.php"> Não sou cadastrado. </a>	        
				</div>
			</td>
	      </tr>
		</table>
		</form>  
  </body>
</html>