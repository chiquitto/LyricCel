<?php 
	include "conecta.php";

   	$email = $_POST['email'];
	$senha = $_POST['senha'];
		
 	if (($email == "") or ($senha == ""))
	{
		echo "<script>alert('Não deixe campos em branco!');javascript:history.back();
		</script>";
		exit;
	}
			
	else
	{   
		$sql = "select * from usuario where email_usu = '$email'";
 		$result = mysql_query($sql);
		$row = mysql_fetch_array($result);

		$pwd = $row["senha_usu"];
		if ($pwd != $senha)
		{
			echo "<Script>alert('A senha não confere ou login não existe');
			javascript:history.back();</script>";
			exit;
		}
		else
		{

			session_register("s_codigo");					
			session_register("s_email");
			session_register("s_nome");
			$s_codigo = $row["codigo_usu"];
			$s_email = $row["email_usu"];
			$s_nome = $row["nome_usu"];

			header("Location: menu.php");
	    }
	}			
?>