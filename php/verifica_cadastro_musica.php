<?php 
	include "conecta.php";

   	$artista = $_POST['artista'];
   	$musica = $_POST['musica'];
	$descricao = mysql_escape_string($_POST['descricao']);
		
 	if (($artista == "") or ($musica == "") or ($descricao == ""))
	{
		echo "<script>alert('Não deixe campos em branco!');javascript:history.back();
		</script>";
		exit;
	}
			
	else
	{
		$sql = "insert into musica values ('','$artista', '$musica', '$descricao')";
		if (!mysql_query($sql))
		{
			echo mysql_error();
			echo "<script>alert('Erro ao cadastrar música!');javascript:history.back();
			</script>";
			exit;
		}
		else
		{
			echo "<script>alert('Música cadastrada com sucesso!');javascript:history.back();
			</script>";
			exit;			
		}
	}			
?>