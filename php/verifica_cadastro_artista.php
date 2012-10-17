<?php 
	include "conecta.php";

   	$nome = $_POST['nome'];
		
 	if (($nome == ""))
	{
		echo "<script>alert('Não deixe campos em branco!');javascript:history.back();
		</script>";
		exit;
	}
			
	else
	{
		$sql = "insert into artista values ('','$nome')";
		if (!mysql_query($sql))
		{
			echo "<script>alert('Erro ao cadastrar artista!');javascript:history.back();
			</script>";
			exit;
		}
		else
		{
			echo "<script>alert('Artista cadastrado com sucesso!');javascript:history.back();
			</script>";
			exit;			
		}
	}			
?>