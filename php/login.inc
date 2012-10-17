<?
	session_start();
	if(!session_is_registered("s_email"))
	{
		header("Location: index.php");
	}
?>