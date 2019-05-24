-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 19-Maio-2018 às 03:05
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
  `item_pauta_votada` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `item_pauta`
--

INSERT INTO `item_pauta` (`id_item_pauta`, `desc_item_pauta`, `relator_id_relator`, `item_pauta_votada`) VALUES
(1, 'Adicionar Física como CCCG do curso', 1, 0),
(2, 'Qual o perfil do substituto do Kepler ', 2, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `membro`
--

CREATE TABLE `membro` (
  `id_membro` int(11) NOT NULL,
  `nome_membro` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Extraindo dados da tabela `membro`
--

INSERT INTO `membro` (`id_membro`, `nome_membro`) VALUES
(1, 'Guilherme Bolfe'),
(2, 'Victor Ribeiro'),
(3, 'Filipe Garcia'),
(4, 'Giliardi Schimdt');

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
(1, 'João Pablo'),
(2, 'Fabio Basso');

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
(1, '23ª Reunião Extraordinária do CONSUNI – Bagé ', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `reuniao_membro`
--

CREATE TABLE `reuniao_membro` (
  `id_reuniao_membro` int(11) NOT NULL,
  `id_membro` int(11) NOT NULL,
  `id_reuniao` int(11) NOT NULL,
  `registrado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Extraindo dados da tabela `reuniao_membro`
--

INSERT INTO `reuniao_membro` (`id_reuniao_membro`, `id_membro`, `id_reuniao`, `registrado`) VALUES
(1, 1, 1, 0),
(2, 3, 1, 0),
(3, 4, 1, 0),
(4, 2, 1, 0);

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
  ADD KEY `idTipoEncaminhamento` (`idTipoEncaminhamento`),
  ADD KEY `fk_encaminhamento_item_pauta1_idx` (`item_pauta_id_item_pauta`);

--
-- Indexes for table `item_pauta`
--
ALTER TABLE `item_pauta`
  ADD PRIMARY KEY (`id_item_pauta`),
  ADD KEY `fk_item_pauta_relator1_idx` (`relator_id_relator`);

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
-- Indexes for table `reuniao`
--
ALTER TABLE `reuniao`
  ADD PRIMARY KEY (`id_reuniao`);

--
-- Indexes for table `reuniao_membro`
--
ALTER TABLE `reuniao_membro`
  ADD PRIMARY KEY (`id_reuniao_membro`),
  ADD KEY `id_membro` (`id_membro`),
  ADD KEY `id_reuniao` (`id_reuniao`);

--
-- Indexes for table `tipo_encaminhamento`
--
ALTER TABLE `tipo_encaminhamento`
  ADD PRIMARY KEY (`id_tipo_encaminhamento`);

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
  MODIFY `id_encaminhamento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `item_pauta`
--
ALTER TABLE `item_pauta`
  MODIFY `id_item_pauta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `membro`
--
ALTER TABLE `membro`
  MODIFY `id_membro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `opcao_voto`
--
ALTER TABLE `opcao_voto`
  MODIFY `id_opcao_voto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=67;

--
-- AUTO_INCREMENT for table `relator`
--
ALTER TABLE `relator`
  MODIFY `id_relator` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `reuniao`
--
ALTER TABLE `reuniao`
  MODIFY `id_reuniao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `reuniao_membro`
--
ALTER TABLE `reuniao_membro`
  MODIFY `id_reuniao_membro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tipo_encaminhamento`
--
ALTER TABLE `tipo_encaminhamento`
  MODIFY `id_tipo_encaminhamento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `voto`
--
ALTER TABLE `voto`
  MODIFY `id_voto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

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
-- Limitadores para a tabela `opcao_voto`
--
ALTER TABLE `opcao_voto`
  ADD CONSTRAINT `fk_encaminhamento_opcao_voto_encaminhamento1` FOREIGN KEY (`id_encaminhamento`) REFERENCES `encaminhamento` (`id_encaminhamento`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `reuniao_membro`
--
ALTER TABLE `reuniao_membro`
  ADD CONSTRAINT `reuniao_membro_ibfk_2` FOREIGN KEY (`id_membro`) REFERENCES `membro` (`id_membro`),
  ADD CONSTRAINT `reuniao_membro_ibfk_3` FOREIGN KEY (`id_reuniao`) REFERENCES `reuniao` (`id_reuniao`);

--
-- Limitadores para a tabela `voto`
--
ALTER TABLE `voto`
  ADD CONSTRAINT `voto_ibfk_1` FOREIGN KEY (`id_opcao_voto`) REFERENCES `opcao_voto` (`id_opcao_voto`),
  ADD CONSTRAINT `voto_ibfk_2` FOREIGN KEY (`id_membro`) REFERENCES `membro` (`id_membro`),
  ADD CONSTRAINT `voto_ibfk_3` FOREIGN KEY (`id_encaminhamento`) REFERENCES `encaminhamento` (`id_encaminhamento`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
