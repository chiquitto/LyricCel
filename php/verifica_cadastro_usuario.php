<?php 
	include "conecta.php";

   	$nome = $_POST['nome'];
   	$email = $_POST['email'];
	$senha = $_POST['senha'];
		
 	if (($nome == "") or ($email == "") or ($senha == ""))
	{
		echo "<script>alert('N�o deixe campos em branco!');javascript:history.back();
		</script>";
		exit;
	}
			
	else
	{
		$sql = "insert into usuario values ('','$nome', '$email', '$senha')";
		if (!mysql_query($sql))
		{
			echo "<script>alert('Erro ao cadastrar usu�rio!');javascript:history.back();
			</script>";
			exit;
		}
		else
		{
			echo "<script>alert('Usu�rio cadastrado com sucesso!');javascript:history.back();
			</script>";
			exit;			
		}
	}			
?>