-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 01-Jun-2018 às 15:25
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
-- Database: `mydb_testes`
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
  `item_pauta_votada` tinyint(1) NOT NULL,
  `id_reuniao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `item_pauta`
--

INSERT INTO `item_pauta` (`id_item_pauta`, `desc_item_pauta`, `relator_id_relator`, `item_pauta_votada`, `id_reuniao`) VALUES
(1, 'Credenciamento de Juliano Kazienko ao PPGEE', 5, 0, 6),
(2, 'Alterações nas tabelas de ACG do curso de Engenharia Mecânica', 38, 0, 8),
(3, 'Perfil docente para concurso em Engenharia de Software', 27, 0, 10),
(4, 'Reapreciação do relatório de atividades 2015/1 de Divane Marcon como relatório semestra', 18, 0, 11),
(5, 'Reapreciação do relatório de atividades 2015/1 de Diego Kreutz como relatório semestral', 37, 0, 12),
(6, 'Solicitação de Horário Especial 2015/2 de Rodrigo Luiz Ludwig', 4, 0, 13),
(7, 'Alterações no PPC da Engenharia de Software', 23, 0, 14),
(8, 'Homologação de novas CCCGs do curso de Engenharia de Telecomunicações', 37, 0, 15),
(9, 'Criação de disciplinas do PPEng', 5, 0, 16),
(10, 'Solicitação de Horário Especial 2015/2 para Flávia Covalesky', 25, 0, 17),
(11, 'Solicitação de Horário Especial 2015/2 de Carlos Aita', 6, 0, 12),
(12, 'Inclusão de CCCGs no PPC do Curso de Engenharia Civi', 41, 0, 2),
(13, 'Alteração de Situação de CCCGs do PPC do Curso de Engenharia Civil', 29, 0, 3),
(14, 'Pedido de remoção do Prof. Ronaldo Larico Mamani do Campus Itaqui para o Campus Alegrete', 3, 0, 6),
(15, 'Pedido de redistribuição de Lucas Vaz Pires (STIC) para a FURG', 28, 0, 7),
(16, 'Solicitação de afastamento integral de Marlucy Farias Medeiros', 33, 0, 8),
(17, 'Homologação de nova CCCG da Engenharia Elétrica', 29, 0, 9),
(18, 'Oferta de libras II como CCCG', 31, 0, 10),
(19, 'Alterações nas referências da componente Al0105 - Microcontroladores', 9, 0, 11),
(20, 'Perfil docente para concurso em Engenharia de Software', 9, 0, 12),
(21, 'Credenciamento de Juliano Kazienko ao PPGEE', 5, 0, 13),
(22, 'Alterações nas tabelas de ACG do curso de Engenharia Mecânica', 38, 0, 14),
(23, 'Adicionar a Física como CCCG', 27, 0, 15),
(24, 'Reapreciação do relatório de atividades 2015/1 de Divane Marcon como relatório semestra', 18, 0, 16),
(25, 'Reapreciação do relatório de atividades 2015/1 de Diego Kreutz como relatório semestral', 37, 0, 17),
(26, 'Solicitação de Horário Especial 2015/2 de Rodrigo Luiz Ludwig', 4, 0, 2),
(27, 'Alterações no PPC da Engenharia de Software', 23, 0, 3),
(28, 'Homologação de novas CCCGs do curso de Engenharia de Telecomunicações', 37, 0, 6),
(29, 'Criação de disciplinas do PPEng', 5, 0, 7),
(30, 'Solicitação de Horário Especial 2015/2 para Flávia Covalesky', 25, 0, 8),
(31, 'Solicitação de Horário Especial 2015/2 de Carlos Aita', 6, 0, 9),
(32, 'Inclusão de CCCGs no PPC do Curso de Engenharia Civi', 41, 0, 10),
(33, 'Alteração de Situação de CCCGs do PPC do Curso de Engenharia Civil', 29, 0, 11),
(34, 'Pedido de remoção do Prof. Ronaldo Larico Mamani do Campus Itaqui para o Campus Alegrete', 3, 0, 12),
(35, 'Pedido de redistribuição de Lucas Vaz Pires (STIC) para a FURG', 28, 0, 13),
(36, 'Solicitação de afastamento integral de Marlucy Farias Medeiros', 33, 0, 14),
(37, 'Homologação de nova CCCG da Engenharia Elétrica', 29, 0, 15),
(38, 'Oferta de libras II como CCCG', 31, 0, 16),
(39, 'Alterações nas referências da componente Al0105 - Microcontroladores', 9, 0, 17),
(40, 'Perfil docente para concurso em Engenharia de Software', 9, 0, 2);

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
(5, 'Alisson Simonetti Milani'),
(6, 'Marcelo de Jesus Dias de Oliveira'),
(7, 'Télvio Rodrigues Liscano'),
(8, 'Marieli Witt Maijo'),
(9, 'José Warney Andrade Neves Filho'),
(10, 'Maria de Fátima Marchezan'),
(11, 'Vera Dorneles'),
(12, 'Aline Balladares'),
(13, 'Evelton Machado Ferreira'),
(14, 'Pierre Correa Martin'),
(15, 'Algacir José Rigon'),
(16, 'Carla Pohl Sehn'),
(17, 'Ana Cristina da Silva Rodrigues'),
(18, 'Mauricio Aires Vieira'),
(19, 'Diogo Gabriel Sperandio'),
(20, 'Sandro Silva da Cunha'),
(21, 'Douglas Mayer Bento'),
(22, 'Luis Hamilton Tarrago Pereira Júnior'),
(23, 'Ewerton da Silva Ferreira'),
(24, 'Mauricio Aires Vieira'),
(25, 'Nádia Fátima dos Santos Bucco'),
(26, 'Ricardo Howes Carpes'),
(27, 'Valéria Vinci Zinelli da Costa'),
(28, 'Sandro Burgos Casado Teixeira'),
(29, 'Ronei Pinto da Silva'),
(30, 'Mario Augusto de Freire Gonçalves'),
(31, 'Cláudia Maydana Mendes'),
(32, 'Thiago de Godoy Nepomuceno '),
(33, 'Lucas Monteiro de Freitas '),
(34, 'Arthur Trojahn Neto '),
(35, 'Lucas Gonçalves Abad'),
(36, 'Carlos Cardoso da Costa e Silva Júnior'),
(37, 'Cháriston André Dal Belo'),
(38, 'Rafael Vitória Schmidt '),
(39, 'Ana Cristina da Silva Rodrigues'),
(40, 'Thiago Antônio Beuron'),
(41, 'Guilherme Bolfe'),
(42, 'Filipe Garcia'),
(43, 'Giliardi Schimdt'),
(44, 'Victor Ribeiro');

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
(3, 'Adriana Gindri Salbego'),
(4, 'Felipe Eduardo Luedke'),
(5, 'Hélvio Rech'),
(6, 'Luis Hamilton Tarrago Pereira Júnior'),
(7, 'Rolando Larico Mamani'),
(8, 'Valéria Vinci Zinelli da Costa'),
(9, 'Cíntia Saydelles da Rosa'),
(10, 'Diogo Gabriel Sperandio'),
(11, ' Ivonir Petrarca dos Santos'),
(12, 'Jônatas Marques Caratti'),
(13, 'Nádia Rosana Fernandes de Oliveira'),
(14, 'Sandro da Silva Camargo'),
(15, 'Tanise Brandão Bussmann'),
(16, 'Algacir José Rigon'),
(17, 'Clever Martins Leitzke'),
(18, 'Diogo Gabriel Sperandio'),
(19, 'Nádia Fátima dos Santos Bucco'),
(20, 'Roberlaine Ribeiro Jorge'),
(21, 'Felipe Dernardin Costa'),
(22, 'Fernando Munhoz da Silveira'),
(23, 'Amanda Meincke Melo'),
(24, 'Aline Vieira de Mello'),
(25, 'Carlos Aurélio Dilli'),
(26, 'Marília Ferreira Tamiosso'),
(27, 'Giovani Guarienti Pozzebon'),
(28, 'Marcelo Hahn'),
(29, 'Tonilson de Souza Rozendo'),
(30, 'Maurício França'),
(31, 'João Pablo Silva da Silva'),
(32, 'Alice Fonseca Finger'),
(33, 'Marcos Vinício Thomas Heckler'),
(34, 'Fabiano Tondello Castoldi'),
(35, 'Luis Eduardo Kosteski'),
(36, 'Cesar Flaubiano da Cruz Cristaldo'),
(37, 'Eduardo Machado dos Santos'),
(38, 'Felipe Bovolini Grigoletto'),
(39, 'Djeisson Hoffmann Thomas'),
(40, 'Andréa Sabedra Bordin'),
(41, 'Djeisson Hoffmann Thomas'),
(42, 'Claudio Schepke');

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
(2, '23ª Reunião Extraordinária do CONSUNI – Bagé', 0),
(3, '22ª Reunião Extraordinária do CONSUNI – Bagé', 0),
(6, '79ª Reunião Ordinária do CONSUNI – Bagé', 0),
(7, '78ª Reunião Ordinária do CONSUNI – Bagé', 0),
(8, '20ª Reunião Extraordinária do CONSUNI – Bagé', 0),
(9, '77ª Reunião Ordinária do CONSUNI – Bagé', 0),
(10, '19ª Reunião Extraordinária do CONSUNI – Webconferência', 0),
(11, '76ª Reunião Ordinária do CONSUNI – Bagé', 0),
(12, '12ª Renião Ordinária do Conselho do Campus', 0),
(13, '11ª Renião Ordinária do Conselho do Campus', 0),
(14, '10ª Renião Ordinária do Conselho do Campus', 0),
(15, '9ª Renião Ordinária do Conselho do Campus', 0),
(16, '8ª Renião Ordinária do Conselho do Campus', 0),
(17, '7ª Renião Ordinária do Conselho do Campus', 0);

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
(1, 5, 17, 0),
(2, 6, 16, 0),
(3, 7, 15, 0),
(4, 8, 14, 0),
(5, 9, 13, 0),
(6, 10, 10, 0),
(7, 12, 8, 0),
(8, 13, 3, 0),
(9, 11, 2, 0),
(10, 14, 7, 0),
(11, 15, 9, 0),
(12, 16, 7, 0),
(13, 17, 6, 0),
(14, 18, 6, 0),
(15, 19, 7, 0),
(16, 20, 9, 0),
(17, 21, 11, 0),
(18, 22, 2, 0),
(19, 23, 3, 0),
(20, 40, 17, 0),
(21, 39, 16, 0),
(22, 38, 15, 0),
(23, 37, 15, 0),
(24, 36, 14, 0),
(25, 35, 13, 0),
(26, 34, 12, 0),
(27, 33, 10, 0),
(28, 32, 8, 0),
(29, 31, 3, 0),
(30, 31, 7, 0),
(31, 30, 17, 0),
(32, 29, 13, 0),
(33, 28, 9, 0),
(34, 27, 10, 0),
(35, 28, 2, 0),
(36, 43, 17, 0),
(37, 43, 15, 0),
(38, 42, 8, 0),
(39, 42, 6, 0),
(40, 41, 8, 0),
(41, 41, 13, 0),
(42, 44, 13, 0),
(43, 44, 2, 0);

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
  MODIFY `id_encaminhamento` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `item_pauta`
--
ALTER TABLE `item_pauta`
  MODIFY `id_item_pauta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT for table `membro`
--
ALTER TABLE `membro`
  MODIFY `id_membro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT for table `opcao_voto`
--
ALTER TABLE `opcao_voto`
  MODIFY `id_opcao_voto` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `relator`
--
ALTER TABLE `relator`
  MODIFY `id_relator` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT for table `reuniao`
--
ALTER TABLE `reuniao`
  MODIFY `id_reuniao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `reuniao_membro`
--
ALTER TABLE `reuniao_membro`
  MODIFY `id_reuniao_membro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `tipo_encaminhamento`
--
ALTER TABLE `tipo_encaminhamento`
  MODIFY `id_tipo_encaminhamento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

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
