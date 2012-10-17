<?php
	mysql_connect('localhost', 'root', '');
  mysql_select_db('lyriccel');
  
	/*if (!mysql_select_db("tcc"))
	{
		echo "Não conectado";
	}
	else
	{
		$sql = "CREATE TABLE `artista` (
		`codigo_art` INT AUTO_INCREMENT PRIMARY KEY,
		`nome_art` VARCHAR(50))";		
		mysql_query($sql);
	
		$sql = "CREATE TABLE `musica` (
		`codigo_mus` INT AUTO_INCREMENT PRIMARY KEY,
		`artista_mus` VARCHAR(50),
		`musica_mus` VARCHAR(50),
		`descricao_mus` TEXT)";		
		mysql_query($sql);

		$sql = "CREATE TABLE `usuario` (
		`codigo_usu` INT AUTO_INCREMENT PRIMARY KEY,
		`nome_usu` VARCHAR(50),		
		`email_usu` VARCHAR(50),		
		`senha_usu` CHAR(6))";				
		mysql_query($sql);
	}*/
?>
