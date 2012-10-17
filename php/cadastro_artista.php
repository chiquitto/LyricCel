<?php 
	include "menu.php";	
?>
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
	<title> Tcc </title>
		<form action="verifica_cadastro_artista.php" method="post">
		<table width="234" border="1" align="center">
		  <tr>
		    <td colspan="2"><div align="center"><strong>Cadastro de artista .</strong></div></td>
		    </tr>
		  <tr>
		    <td width="51"><div align="right"><strong>Nome</strong></div></td>
		    <td width="167">
			<label>
		      <input type="text" name="nome" />
		    </label></td>
		  </tr>

		    <td colspan="2">
				<div align="center">
			  		<input type="submit" name="entrar" value="Gravar" />
				</div>
			</td>
	      </tr>
		</table>
		</form>  
  </body>
</html>