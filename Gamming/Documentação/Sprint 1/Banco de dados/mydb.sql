-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 04-Maio-2018 às 04:55
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
  `idTipoEncaminhamento` int(11) NOT NULL,
  `segundoTurno` tinyint(1) NOT NULL,
  `item_pauta_id_item_pauta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `encaminhamento`
--

INSERT INTO `encaminhamento` (`id_encaminhamento`, `idTipoEncaminhamento`, `segundoTurno`, `item_pauta_id_item_pauta`) VALUES
(1, 1, 0, 1),
(2, 2, 1, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `item_pauta`
--

CREATE TABLE `item_pauta` (
  `id_item_pauta` int(11) NOT NULL,
  `desc_item_pauta` varchar(200) NOT NULL,
  `relator_id_relator` int(11) NOT NULL,
  `item_pauta_possui_encaminhamento` tinyint(1) NOT NULL,
  `item_pauta_votada` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `item_pauta`
--

INSERT INTO `item_pauta` (`id_item_pauta`, `desc_item_pauta`, `relator_id_relator`, `item_pauta_possui_encaminhamento`, `item_pauta_votada`) VALUES
(1, 'Adicionar Física como CCCG do curso', 1, 0, 0),
(2, 'Qual o perfil do substituto do Kepler ', 2, 0, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `item_pauta_membro`
--

CREATE TABLE `item_pauta_membro` (
  `id_item_pauta_membro` int(11) NOT NULL,
  `id_item_pauta` int(11) NOT NULL,
  `id_membro` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `membro`
--

CREATE TABLE `membro` (
  `id_membro` int(11) NOT NULL,
  `nome_membro` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `opcao_voto`
--

CREATE TABLE `opcao_voto` (
  `id_opcao_voto` int(11) NOT NULL,
  `id_encaminhamento` int(11) NOT NULL,
  `desc_opcao_voto` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `opcao_voto`
--

INSERT INTO `opcao_voto` (`id_opcao_voto`, `id_encaminhamento`, `desc_opcao_voto`) VALUES
(1, 1, 'Favorável'),
(2, 1, 'Contrário'),
(3, 1, 'Obstenção'),
(4, 2, 'AI'),
(5, 2, 'UP'),
(6, 2, 'TG');

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
(1, 'João Pablo'),
(2, 'Fabio Basso');

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

--
-- Indexes for dumped tables
--

--
-- Indexes for table `encaminhamento`
--
ALTER TABLE `encaminhamento`
  ADD PRIMARY KEY (`id_encaminhamento`),
  ADD KEY `idTipoEncaminhamento` (`idTipoEncaminhamento`),
  ADD KEY `fk_encaminhamento_item_pauta1_idx` (`item_pauta_id_item_pauta`);

--
-- Indexes for table `item_pauta`
--
ALTER TABLE `item_pauta`
  ADD PRIMARY KEY (`id_item_pauta`),
  ADD KEY `fk_item_pauta_relator1_idx` (`relator_id_relator`);

--
-- Indexes for table `item_pauta_membro`
--
ALTER TABLE `item_pauta_membro`
  ADD PRIMARY KEY (`id_item_pauta_membro`),
  ADD KEY `id_item_pauta` (`id_item_pauta`),
  ADD KEY `id_membro` (`id_membro`);

--
-- Indexes for table `membro`
--
ALTER TABLE `membro`
  ADD PRIMARY KEY (`id_membro`);

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
-- Indexes for table `tipo_encaminhamento`
--
ALTER TABLE `tipo_encaminhamento`
  ADD PRIMARY KEY (`id_tipo_encaminhamento`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `encaminhamento`
--
ALTER TABLE `encaminhamento`
  MODIFY `id_encaminhamento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `item_pauta`
--
ALTER TABLE `item_pauta`
  MODIFY `id_item_pauta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `item_pauta_membro`
--
ALTER TABLE `item_pauta_membro`
  MODIFY `id_item_pauta_membro` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `membro`
--
ALTER TABLE `membro`
  MODIFY `id_membro` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `opcao_voto`
--
ALTER TABLE `opcao_voto`
  MODIFY `id_opcao_voto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `relator`
--
ALTER TABLE `relator`
  MODIFY `id_relator` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tipo_encaminhamento`
--
ALTER TABLE `tipo_encaminhamento`
  MODIFY `id_tipo_encaminhamento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `encaminhamento`
--
ALTER TABLE `encaminhamento`
  ADD CONSTRAINT `fk_encaminhamento_customizado_item_pauta` FOREIGN KEY (`idTipoEncaminhamento`) REFERENCES `tipo_encaminhamento` (`id_tipo_encaminhamento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_encaminhamento_item_pauta1` FOREIGN KEY (`item_pauta_id_item_pauta`) REFERENCES `item_pauta` (`id_item_pauta`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `item_pauta`
--
ALTER TABLE `item_pauta`
  ADD CONSTRAINT `fk_item_pauta_relator1` FOREIGN KEY (`relator_id_relator`) REFERENCES `relator` (`id_relator`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `item_pauta_membro`
--
ALTER TABLE `item_pauta_membro`
  ADD CONSTRAINT `item_pauta_membro_ibfk_1` FOREIGN KEY (`id_item_pauta`) REFERENCES `item_pauta` (`id_item_pauta`),
  ADD CONSTRAINT `item_pauta_membro_ibfk_2` FOREIGN KEY (`id_membro`) REFERENCES `membro` (`id_membro`);

--
-- Limitadores para a tabela `opcao_voto`
--
ALTER TABLE `opcao_voto`
  ADD CONSTRAINT `fk_encaminhamento_opcao_voto_encaminhamento1` FOREIGN KEY (`id_encaminhamento`) REFERENCES `encaminhamento` (`id_encaminhamento`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
