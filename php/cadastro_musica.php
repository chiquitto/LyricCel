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
  <form action="verifica_cadastro_musica.php" method="post">
		<table width="234" border="1" align="center">
		  <tr>
		    <td colspan="2"><div align="center"><strong>Cadastro de m&uacute;sica .</strong></div></td>
	      </tr>
		  <tr>
		    <td width="51"><div align="right"><strong>Artista</strong></div></td>
		    <td width="167">
			<label>
			  <select name="artista"  class="caixa2">
				<?php
				  include "conecta.php";
				  $sql = "select * from artista order by nome_art";
				  $result = mysql_query($sql);
				  while ($row = mysql_fetch_array($result)) {
				  $cod = $row["codigo_art"];
				  $artista = $row["nome_art"];
				  echo "<option value='$cod'>$artista</option>";
				  }
				?>
			  </select>
		    </label></td>
		  </tr>
		  <tr>
		    <td width="51"><div align="right"><strong>M&uacute;sica</strong></div></td>
		    <td width="167">
			<label>
		      <input type="text" name="musica" />
		    </label></td>
		  </tr>
		  <tr>
		    <td><div align="right"><strong>Descri&ccedil;&atilde;o</strong></div></td>
		    <td>
			<label>
		      <textarea name="descricao">Letra da musica aqui</textarea>
		    </label></td>
		  </tr>
		  <tr>
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