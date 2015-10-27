-- phpMyAdmin SQL Dump
-- version 2.8.2.4
-- http://www.phpmyadmin.net
-- 
-- Servidor: localhost:3306
-- Tempo de Geração: Abr 25, 2010 as 08:20 PM
-- Versão do Servidor: 5.0.37
-- Versão do PHP: 5.0.5
-- 
-- Banco de Dados: `tcc_chiquitto`
-- 

-- --------------------------------------------------------

-- 
-- Estrutura da tabela `artista`
-- 

CREATE TABLE `artista` (
  `codigo_art` int(11) NOT NULL auto_increment,
  `nome_art` varchar(50) default NULL,
  PRIMARY KEY  (`codigo_art`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

-- 
-- Extraindo dados da tabela `artista`
-- 

INSERT INTO `artista` (`codigo_art`, `nome_art`) VALUES (1, 'Avantasia'),
(2, 'Katy Perry'),
(3, 'Stratovarius');

-- --------------------------------------------------------

-- 
-- Estrutura da tabela `musica`
-- 

CREATE TABLE `musica` (
  `codigo_mus` int(11) NOT NULL auto_increment,
  `artista_mus` varchar(50) default NULL,
  `musica_mus` varchar(50) default NULL,
  `descricao_mus` text,
  PRIMARY KEY  (`codigo_mus`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

-- 
-- Extraindo dados da tabela `musica`
-- 

INSERT INTO `musica` (`codigo_mus`, `artista_mus`, `musica_mus`, `descricao_mus`) VALUES (1, '1', 'Inside', '[encoding:gb2312]\r\n[ti:Inside]\r\n[ar:Avantasia]\r\n[al:The Metal Opera ¢ñ]\r\n[by:Â}ï|Ä§¢ó]\r\n[00:00.00]Inside\r\n[00:00.00]Performed by Avantasia\r\n[00:00.00]\r\n[00:00.35][Elderane]\r\n[00:00.35]We''re the little creatures\r\n[00:03.51]deep inside your mind.\r\n[00:06.74][Regrin]\r\n[00:06.74]Some call us their fantasy\r\n[00:09.79]but some to never find.\r\n[00:13.11][Elderane]\r\n[00:13.11]We can teach philosophy\r\n[00:16.04]but still we must commend...\r\n\r\n\r\n[00:19.16][Regrin]\r\n[00:19.16]The state of our existence\r\n[00:22.26]right into your hand\r\n[00:25.73]Welcome to this place in here come overstep all your fears...\r\n\r\n\r\n[00:33.15][Gabriel]\r\n[00:33.15]Where have you all been once\r\n[00:36.02]when I was alone?\r\n[00:39.39]When I was a hero in their crazy wicked show\r\n[00:45.74]you''ve sent no little spark\r\n[00:47.75]into my darkened view of life.\r\n[00:52.33]Did not make me ask for what is wrong\r\n[00:56.68]and what is right.\r\n[00:58.40]And still I regret to be here.\r\n[01:05.05]I''m dreaming of Anna in tears.\r\n[01:12.79]\r\n[01:14.99]Inside - so deep inside\r\n[01:21.01]you will die if I don''t dream anymore?\r\n[01:27.65]Inside - so deep inside\r\n[01:33.67]you will die if I don''t dream anymore?\r\n[01:40.52]Inside - so deep inside\r\n[01:46.56]you will die if I don''t dream anymore?\r\n[01:53.30]Inside - so deep inside\r\n[01:59.21]you will die if I don''t dream anymore?\r\n[02:14.88]dream anymore?\r\n[02:20.31]¡«The End¡«'),
(2, '2', 'I Kissed a Girl', '[ar:Katy Perry]\r\n[ti:I Kissed a Girl]\r\n[00:00.78]Artist: Katy Perry\r\n[00:01.54]Album: \r\n[00:02.35]Title: I Kissed A Girl\r\n[00:03.32]By: Hilleri94\r\n[00:04.21]Offset: 0\r\n[00:04.95]This was never the way I planned\r\n[00:09.00]Not my intention\r\n[00:12.18]I got so brave, drink in hand\r\n[00:16.43]Lost my discretion\r\n[00:19.25]It''s not what, I''m used to\r\n[00:23.07]Just wanna try you on\r\n[00:26.84]I''m curious for you\r\n[00:30.37]Caught my attention\r\n[00:33.90]\r\n[00:34.25]I kissed a girl and I liked it\r\n[00:38.12]The taste of her cherry chapstick\r\n[00:41.85]I kissed a girl just to try it\r\n[00:45.70]I hope my boyfriend don''t mind it\r\n[00:49.03]It felt so wrong\r\n[00:51.31]It felt so right\r\n[00:53.17]Don''t mean I''m in love tonight\r\n[00:56.59]I kissed a girl and I liked it\r\n[01:02.00]I liked it\r\n[01:04.25]\r\n[01:07.96]No, I don''t even know your name\r\n[01:12.26]It doesn''t matter, \r\n[01:15.21]You''re my experimental game\r\n[01:19.54]Just human nature, \r\n[01:22.45]It''s not what, \r\n[01:24.71]Good girls do\r\n[01:26.70]Not how they should behave\r\n[01:30.31]My head gets so confused\r\n[01:34.39]Hard to obey\r\n[01:37.39]\r\n[01:37.56]I kissed a girl and I liked it\r\n[01:41.35]The taste of her cherry chap stick\r\n[01:44.87]I kissed a girl just to try it\r\n[01:48.59]I hope my boyfriend don''t mind it\r\n[01:52.04]It felt so wrong\r\n[01:54.21]It felt so right\r\n[01:56.14]Don''t mean I''m in love tonight\r\n[02:00.04]I kissed a girl and I liked it\r\n[02:03.87]I liked it, \r\n[02:06.96]\r\n[02:07.56]Us girls we are so magical\r\n[02:10.87]Soft skin, red lips, so kissable\r\n[02:14.82]Hard to resist so touchable\r\n[02:18.40]Too good to deny it\r\n[02:22.14]Ain''t no big deal, it''s innocent\r\n[02:28.00]\r\n[02:29.31]I kissed a girl and I liked it\r\n[02:33.31]The taste of her cherry chap stick\r\n[02:37.23]I kissed a girl just to try it\r\n[02:40.50]I hope my boyfriend don''t mind it\r\n[02:43.98]It felt so wrong\r\n[02:46.09]It felt so right\r\n[02:48.07]Don''t mean I''m in love tonight\r\n[02:51.59]I kissed a girl and I liked it\r\n[02:57.53]I liked it\r\n'),
(3, '3', 'Hunting High And Low', '[ti:Hunting High And Low]\r\n[ar:Stratovarius]\r\n[al:Infinite]\r\n[by:JAF 2004 noendloop@yahoo.es]\r\n\r\nArtist: Stratovarius\r\nAlbum: Infinite\r\nTitle: Hunting high and low\r\n[00:00]\r\n[00:26]I feel the wind in my hair\r\n[00:31]And it''s whispering, telling me things,\r\n[00:35]Of the storm that is gathering near\r\n[00:41]Full of power I''m spreading my wings\r\n[00:45]\r\n[00:45]Now I''m leaving my worries behind\r\n[00:51]Feel the freedom of body and mind\r\n[00:56]I have started my journey, I''m drifting away with the wind\r\n[01:04]I go\r\n[01:06]\r\n[01:06]I am Hunting High and Low\r\n[01:11]Diving from the sky above\r\n[01:13]Looking for, more and more, once again\r\n[01:17]I''m Hunting High and Low\r\n[01:21]Sometimes I may win sometimes I''ll lose\r\n[01:25]It''s just a game that I play\r\n[01:27]\r\n[01:37]After the storm there''s a calm\r\n[01:42]Through the clouds shines a ray of the sun\r\n[01:47]I am carried from all of my harm\r\n[01:52]There is no-one that I can''t outrun\r\n[01:56.50]\r\n[01:57]Now I''m leaving my worries behind\r\n[02:03]Feel the freedom of body and mind\r\n[02:08]I have started my journey, I''m drifting away with the wind\r\n[02:16]I go\r\n[02:17.50]\r\n[02:18]I am Hunting High and Low\r\n[02:22]Diving from the sky above\r\n[02:25]Looking for, more and more, once again\r\n[02:29]I''m Hunting High and Low\r\n[02:33]Sometimes I may win sometimes I''ll lose\r\n[02:37]It''s just a game that I play\r\n[02:39]\r\n[02:59]I''m Hunting High and Low\r\n[03:03]Diving from the sky above\r\n[03:06]Looking for, more and more, once again.\r\n[03:09]I''m Hunting High and Low\r\n[03:13]Sometimes I may win sometimes I''ll lose\r\n[03:17]It''s just a game that I play\r\n[03:20]I''m Hunting High and Low\r\n[03:23]Diving from the sky above\r\n[03:26]Looking for, more and more, once again.\r\n[03:30]I''m Hunting High and Low\r\n[03:34]Sometimes I may win sometimes I''ll lose\r\n[03:38]It''s just a game that I play\r\n[03:41]I''m Hunting High and Low\r\n[03:50]I''m Hunting High and Low\r\n');

-- --------------------------------------------------------

-- 
-- Estrutura da tabela `usuario`
-- 

CREATE TABLE `usuario` (
  `codigo_usu` int(11) NOT NULL auto_increment,
  `nome_usu` varchar(50) default NULL,
  `email_usu` varchar(50) default NULL,
  `senha_usu` char(6) default NULL,
  PRIMARY KEY  (`codigo_usu`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

-- 
-- Extraindo dados da tabela `usuario`
-- 

INSERT INTO `usuario` (`codigo_usu`, `nome_usu`, `email_usu`, `senha_usu`) VALUES (1, 'admin', 'admin@admin.com.br', 'qwe1@3');
