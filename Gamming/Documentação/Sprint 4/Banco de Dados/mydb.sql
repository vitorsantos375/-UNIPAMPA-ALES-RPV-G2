-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 24-Jun-2018 às 16:59
-- Versão do servidor: 10.1.31-MariaDB
-- PHP Version: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mydb`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `encaminhamento`
--

CREATE TABLE `encaminhamento` (
  `id_encaminhamento` int(11) NOT NULL,
  `id_TipoEncaminhamento` int(11) NOT NULL,
  `segundo_Turno` tinyint(1) NOT NULL,
  `item_pauta_id_item_pauta` int(11) NOT NULL,
  `id_reuniao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `item_pauta`
--

CREATE TABLE `item_pauta` (
  `id_item_pauta` int(11) NOT NULL,
  `desc_item_pauta` varchar(200) NOT NULL,
  `relator_id_relator` int(11) NOT NULL,
  `item_pauta_votada` tinyint(1) NOT NULL,
  `id_reuniao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `item_pauta`
--

INSERT INTO `item_pauta` (`id_item_pauta`, `desc_item_pauta`, `relator_id_relator`, `item_pauta_votada`, `id_reuniao`) VALUES
(1, 'Criação de disciplinas do PPEng', 1, 0, 1),
(2, 'Perfil docente para concurso em Engenharia de Software', 2, 0, 2),
(3, 'Alteração de Situação de CCCGs do PPC do Curso de Engenharia Civil', 3, 0, 1),
(4, 'Alterações nas referências da componente Al0105 - Microcontroladores', 4, 0, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `opcao_voto`
--

CREATE TABLE `opcao_voto` (
  `id_opcao_voto` int(11) NOT NULL,
  `id_encaminhamento` int(11) NOT NULL,
  `desc_opcao_voto` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `relator`
--

CREATE TABLE `relator` (
  `id_relator` int(11) NOT NULL,
  `nome_relator` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `relator`
--

INSERT INTO `relator` (`id_relator`, `nome_relator`) VALUES
(1, 'Adriana Gindri Salbego'),
(2, 'Felipe Eduardo Luedke'),
(3, 'Hélvio Rech'),
(4, 'Luis Hamilton Tarrago Pereira Júnior');

-- --------------------------------------------------------

--
-- Estrutura da tabela `reuniao`
--

CREATE TABLE `reuniao` (
  `id_reuniao` int(11) NOT NULL,
  `descricao_reuniao` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `reuniao_aberta` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Extraindo dados da tabela `reuniao`
--

INSERT INTO `reuniao` (`id_reuniao`, `descricao_reuniao`, `reuniao_aberta`) VALUES
(1, '23ª Reunião Extraordinária do CONSUNI – Bagé', 0),
(2, '22ª Reunião Extraordinária do CONSUNI – Bagé', 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipo_encaminhamento`
--

CREATE TABLE `tipo_encaminhamento` (
  `id_tipo_encaminhamento` int(11) NOT NULL,
  `descricao` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tipo_encaminhamento`
--

INSERT INTO `tipo_encaminhamento` (`id_tipo_encaminhamento`, `descricao`) VALUES
(1, 'Simples'),
(2, 'Customizado');

-- --------------------------------------------------------

--
-- Estrutura da tabela `user_reuniao`
--

CREATE TABLE `user_reuniao` (
  `id_user_reuniao` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_reuniao` int(11) NOT NULL,
  `secretario` tinyint(1) NOT NULL,
  `moderador` tinyint(1) NOT NULL,
  `membro` tinyint(1) NOT NULL,
  `registrado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Extraindo dados da tabela `user_reuniao`
--

INSERT INTO `user_reuniao` (`id_user_reuniao`, `id_user`, `id_reuniao`, `secretario`, `moderador`, `membro`, `registrado`) VALUES
(1, 1, 1, 1, 1, 1, 0),
(2, 4, 2, 1, 1, 1, 0),
(3, 1, 2, 0, 0, 1, 0),
(4, 4, 1, 0, 0, 1, 0),
(5, 2, 1, 0, 0, 1, 0),
(6, 2, 2, 0, 0, 1, 0),
(7, 3, 1, 0, 0, 1, 0),
(8, 3, 2, 0, 0, 1, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `id_user` int(11) NOT NULL,
  `nome_user` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id_user`, `nome_user`) VALUES
(1, 'Guilherme Bolfe'),
(2, 'Filipe Garcia'),
(3, 'Victor Ribeiro'),
(4, 'Giliardi Schmidt');

-- --------------------------------------------------------

--
-- Estrutura da tabela `voto`
--

CREATE TABLE `voto` (
  `id_voto` int(11) NOT NULL,
  `id_membro` int(11) NOT NULL,
  `id_opcao_voto` int(11) NOT NULL,
  `id_encaminhamento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `encaminhamento`
--
ALTER TABLE `encaminhamento`
  ADD PRIMARY KEY (`id_encaminhamento`),
  ADD KEY `idTipoEncaminhamento` (`id_TipoEncaminhamento`),
  ADD KEY `fk_encaminhamento_item_pauta1_idx` (`item_pauta_id_item_pauta`);

--
-- Indexes for table `item_pauta`
--
ALTER TABLE `item_pauta`
  ADD PRIMARY KEY (`id_item_pauta`),
  ADD KEY `fk_item_pauta_relator1_idx` (`relator_id_relator`),
  ADD KEY `id_reuniao` (`id_reuniao`);

--
-- Indexes for table `opcao_voto`
--
ALTER TABLE `opcao_voto`
  ADD PRIMARY KEY (`id_opcao_voto`),
  ADD KEY `fk_encaminhamento_opcao_voto_encaminhamento1_idx` (`id_encaminhamento`);

--
-- Indexes for table `relator`
--
ALTER TABLE `relator`
  ADD PRIMARY KEY (`id_relator`);

--
-- Indexes for table `reuniao`
--
ALTER TABLE `reuniao`
  ADD PRIMARY KEY (`id_reuniao`);

--
-- Indexes for table `tipo_encaminhamento`
--
ALTER TABLE `tipo_encaminhamento`
  ADD PRIMARY KEY (`id_tipo_encaminhamento`);

--
-- Indexes for table `user_reuniao`
--
ALTER TABLE `user_reuniao`
  ADD PRIMARY KEY (`id_user_reuniao`),
  ADD KEY `id_membro` (`id_user`),
  ADD KEY `id_reuniao` (`id_reuniao`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_user`);

--
-- Indexes for table `voto`
--
ALTER TABLE `voto`
  ADD PRIMARY KEY (`id_voto`),
  ADD KEY `id_opcao_voto` (`id_opcao_voto`),
  ADD KEY `id_membro` (`id_membro`),
  ADD KEY `id_encaminhamento` (`id_encaminhamento`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `encaminhamento`
--
ALTER TABLE `encaminhamento`
  MODIFY `id_encaminhamento` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `item_pauta`
--
ALTER TABLE `item_pauta`
  MODIFY `id_item_pauta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `opcao_voto`
--
ALTER TABLE `opcao_voto`
  MODIFY `id_opcao_voto` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `relator`
--
ALTER TABLE `relator`
  MODIFY `id_relator` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `reuniao`
--
ALTER TABLE `reuniao`
  MODIFY `id_reuniao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tipo_encaminhamento`
--
ALTER TABLE `tipo_encaminhamento`
  MODIFY `id_tipo_encaminhamento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user_reuniao`
--
ALTER TABLE `user_reuniao`
  MODIFY `id_user_reuniao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `voto`
--
ALTER TABLE `voto`
  MODIFY `id_voto` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `encaminhamento`
--
ALTER TABLE `encaminhamento`
  ADD CONSTRAINT `fk_encaminhamento_customizado_item_pauta` FOREIGN KEY (`id_TipoEncaminhamento`) REFERENCES `tipo_encaminhamento` (`id_tipo_encaminhamento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_encaminhamento_item_pauta1` FOREIGN KEY (`item_pauta_id_item_pauta`) REFERENCES `item_pauta` (`id_item_pauta`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `item_pauta`
--
ALTER TABLE `item_pauta`
  ADD CONSTRAINT `fk_item_pauta_relator1` FOREIGN KEY (`relator_id_relator`) REFERENCES `relator` (`id_relator`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `item_pauta_ibfk_1` FOREIGN KEY (`id_reuniao`) REFERENCES `reuniao` (`id_reuniao`);

--
-- Limitadores para a tabela `opcao_voto`
--
ALTER TABLE `opcao_voto`
  ADD CONSTRAINT `fk_encaminhamento_opcao_voto_encaminhamento1` FOREIGN KEY (`id_encaminhamento`) REFERENCES `encaminhamento` (`id_encaminhamento`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `user_reuniao`
--
ALTER TABLE `user_reuniao`
  ADD CONSTRAINT `reuniao_membro_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `usuario` (`id_user`),
  ADD CONSTRAINT `reuniao_membro_ibfk_3` FOREIGN KEY (`id_reuniao`) REFERENCES `reuniao` (`id_reuniao`);

--
-- Limitadores para a tabela `voto`
--
ALTER TABLE `voto`
  ADD CONSTRAINT `voto_ibfk_1` FOREIGN KEY (`id_opcao_voto`) REFERENCES `opcao_voto` (`id_opcao_voto`),
  ADD CONSTRAINT `voto_ibfk_2` FOREIGN KEY (`id_membro`) REFERENCES `usuario` (`id_user`),
  ADD CONSTRAINT `voto_ibfk_3` FOREIGN KEY (`id_encaminhamento`) REFERENCES `encaminhamento` (`id_encaminhamento`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
