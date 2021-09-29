-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.7.35-log - MySQL Community Server (GPL)
-- Операционная система:         Win64
-- HeidiSQL Версия:              11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Дамп структуры для таблица foodtracker.food
CREATE TABLE IF NOT EXISTS `food` (
  `idFood` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `calories` double DEFAULT NULL,
  `weight` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idFood`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы foodtracker.food: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
/*!40000 ALTER TABLE `food` ENABLE KEYS */;

-- Дамп структуры для таблица foodtracker.meal
CREATE TABLE IF NOT EXISTS `meal` (
  `idMeal` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `calories` double DEFAULT NULL,
  PRIMARY KEY (`idMeal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы foodtracker.meal: ~4 rows (приблизительно)
/*!40000 ALTER TABLE `meal` DISABLE KEYS */;
INSERT INTO `meal` (`idMeal`, `date`, `time`, `weight`, `calories`) VALUES
	(1, '1999-05-05', '20:50:00', 1000, 1000),
	(3, '1998-12-31', '23:10:00', 550, 234),
	(5, '2021-01-01', '01:01:00', 1, 1),
	(25, '2000-12-10', '20:25:00', 500, 500);
/*!40000 ALTER TABLE `meal` ENABLE KEYS */;

-- Дамп структуры для таблица foodtracker.programms
CREATE TABLE IF NOT EXISTS `programms` (
  `idProgramms` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `calories` double DEFAULT NULL,
  `User_idUser` int(11) NOT NULL,
  PRIMARY KEY (`idProgramms`,`User_idUser`),
  KEY `fk_Programms_User_idx` (`User_idUser`),
  CONSTRAINT `fk_Programms_User` FOREIGN KEY (`User_idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы foodtracker.programms: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `programms` DISABLE KEYS */;
/*!40000 ALTER TABLE `programms` ENABLE KEYS */;

-- Дамп структуры для таблица foodtracker.restrisctions
CREATE TABLE IF NOT EXISTS `restrisctions` (
  `name` varchar(45) DEFAULT NULL,
  `Programms_idProgramms` int(11) NOT NULL,
  `Programms_User_idUser` int(11) NOT NULL,
  PRIMARY KEY (`Programms_idProgramms`,`Programms_User_idUser`),
  CONSTRAINT `fk_Restrisctions_Programms1` FOREIGN KEY (`Programms_idProgramms`, `Programms_User_idUser`) REFERENCES `programms` (`idProgramms`, `User_idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы foodtracker.restrisctions: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `restrisctions` DISABLE KEYS */;
/*!40000 ALTER TABLE `restrisctions` ENABLE KEYS */;

-- Дамп структуры для таблица foodtracker.user
CREATE TABLE IF NOT EXISTS `user` (
  `idUser` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `login` int(11) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы foodtracker.user: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
