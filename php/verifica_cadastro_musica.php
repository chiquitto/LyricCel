<?php 
	include "conecta.php";

   	$artista = $_POST['artista'];
   	$musica = $_POST['musica'];
	$descricao = mysql_escape_string($_POST['descricao']);
		
 	if (($artista == "") or ($musica == "") or ($descricao == ""))
	{
		echo "<script>alert('N�o deixe campos em branco!');javascript:history.back();
		</script>";
		exit;
	}
			
	else
	{
		$sql = "insert into musica values ('','$artista', '$musica', '$descricao')";
		if (!mysql_query($sql))
		{
			echo mysql_error();
			echo "<script>alert('Erro ao cadastrar m�sica!');javascript:history.back();
			</script>";
			exit;
		}
		else
		{
			echo "<script>alert('M�sica cadastrada com sucesso!');javascript:history.back();
			</script>";
			exit;			
		}
	}			
?>