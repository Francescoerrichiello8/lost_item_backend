-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Mag 21, 2025 alle 09:44
-- Versione del server: 10.4.32-MariaDB
-- Versione PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lost_items`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `lost_items`
--

CREATE TABLE `lost_items` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` text DEFAULT NULL,
  `lost_date` date DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `found` tinyint(1) NOT NULL,
  `found_date` date DEFAULT NULL,
  `found_location` varchar(255) DEFAULT NULL,
  `note` text DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `lost_items`
--

INSERT INTO `lost_items` (`id`, `name`, `description`, `lost_date`, `location`, `found`, `found_date`, `found_location`, `note`, `created_at`, `updated_at`) VALUES
(1, 'Portafoglio', 'Portafoglio nero in pelle con documenti e carte', '2025-05-01', 'Stazione Centrale', 1, '2010-10-10', 'samminiato', '', '2025-05-01 08:00:00', '2025-05-16 13:24:41'),
(2, 'Ombrello', 'Ombrello rosso pieghevole', '2025-05-02', 'Biblioteca Comunale', 1, '2025-05-04', 'Ufficio Oggetti Smarriti', '', '2025-05-02 09:00:00', '2025-05-04 10:00:00'),
(4, 'Zaino', 'Zaino Eastpak nero con libri scolastici', '2025-05-01', 'Liceo Classico', 1, '1111-11-11', 'sammi', '', '2025-05-01 10:15:00', '2025-05-16 12:54:15'),
(6, 'Occhiali', 'Occhiali da vista con montatura blu', '2025-05-03', 'Tram linea 9', 1, '2025-05-03', 'Deposito ATM', '', '2025-05-03 15:00:00', '2025-05-03 17:00:00'),
(7, 'Cappello', 'Cappello di lana grigio', '2025-05-02', 'Università - Aula 3', 1, '2010-10-10', 'sammi', '', '2025-05-02 14:30:00', '2025-05-16 13:20:14'),
(10, 'AirPods', 'Auricolari Apple in custodia bianca', '2025-05-03', 'Treno Milano-Bergamo', 1, '2010-10-10', 'sammi', '', '2025-05-03 16:00:00', '2025-05-16 13:17:44'),
(11, 'Sciarpa', 'Sciarpa rossa di lana', '2025-05-01', 'Cinema Odeon', 1, '2010-10-10', 'sammi', '', '2025-05-01 19:00:00', '2025-05-16 13:05:00'),
(12, 'Taccuino', 'Taccuino nero Moleskine con appunti', '2025-05-04', 'Coworking Space', 1, '2025-05-05', 'Reception', '', '2025-05-04 13:00:00', '2025-05-05 08:00:00'),
(13, 'Anello', 'Anello d’argento con incisione', '2025-05-02', 'Toilette centro commerciale', 1, '2010-10-10', 'sammi', '', '2025-05-02 11:30:00', '2025-05-16 13:17:24'),
(14, 'Carta d’identità', 'Documento intestato a Maria Rossi', '2025-05-03', 'Fermata bus Largo Cairoli', 1, '2025-05-04', 'Questura', '', '2025-05-03 06:50:00', '2025-05-04 10:00:00'),
(15, 'Caricabatterie', 'Caricatore Samsung tipo C', '2025-05-06', 'Sala studio universitaria', 1, '1111-11-11', 'sammi', '', '2025-05-06 07:00:00', '2025-05-16 12:55:44'),
(16, 'Giacca', 'Giacca blu con cappuccio, taglia L', '2025-05-05', 'Biblioteca Centrale', 1, '1111-11-11', 'sammi', '', '2025-05-05 16:00:00', '2025-05-16 12:56:08'),
(17, 'Zaino rosso', 'Zaino dimenticato sul treno', NULL, 'Stazione Termini', 1, '2010-10-10', 'sammi', '', '2025-05-01 15:00:00', '2025-05-16 13:22:29');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `lost_items`
--
ALTER TABLE `lost_items`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `lost_items`
--
ALTER TABLE `lost_items`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
