<?php 
	include "conecta.php";

	$x = strtr($_GET['x'], array('.lrc'=>'') );
	$x = explode('-', $x, 2);
	
	if ( count($x) == 2 ) {
		$artista = trim($x[0]);
		$musica = trim($x[1]);
		
		$sql = "Select
      m.descricao_mus letra
From musica m
Inner Join artista a
      On a.codigo_art = m.artista_mus
Where ( m.musica_mus = '$musica' ) And ( a.nome_art = '$artista' )
Limit 1";
	}
	else {
		$musica = trim($x[0]);
		
		$sql = "Select
      m.descricao_mus letra
From musica m
Where ( m.musica_mus = '$musica' )
Limit 1";
	}
	
	$qMus = mysql_query($sql);
	if( mysql_num_rows($qMus) == 1 ) {
		$rsMusica = mysql_fetch_assoc($qMus);
		
		header("Content-Type:text/plain");
		echo $rsMusica['letra'];
	}
	else {
		header("HTTP/1.0 404 Not Found", true, 404);
	}
?>