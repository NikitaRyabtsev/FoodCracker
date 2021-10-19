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
  `idFood` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `calories` double DEFAULT NULL,
  `proteins` double DEFAULT NULL,
  `fats` double DEFAULT NULL,
  `carbohydrates` double DEFAULT NULL,
  PRIMARY KEY (`idFood`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы foodtracker.food: ~100 rows (приблизительно)
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
INSERT INTO `food` (`idFood`, `name`, `calories`, `proteins`, `fats`, `carbohydrates`) VALUES
	(1, 'Гречневая каша', 137, 12.29, 1.33, 57.57),
	(2, 'Кукурузные хлопья', 372, 6.5, 2.9, 83.8),
	(3, 'Манная каша', 77, 2.5, 0.3, 16.4),
	(4, 'Овсяная каша', 93, 3.2, 1.8, 15.4),
	(5, 'Перловая каша', 102, 3.2, 0.5, 22.7),
	(6, 'Пшенная каша', 92, 3, 0.8, 17.2),
	(7, 'Рисовая каша', 79, 1.5, 0.2, 17.3),
	(8, 'Ячневая каша', 84, 1.4, 0.3, 18.7),
	(9, 'Булгур', 342, 12.29, 1.33, 57.57),
	(10, 'Масло оливковое', 898, 0, 99.8, 0),
	(11, 'Масло подсолнечное', 748, 0, 99.99, 0),
	(12, 'Масло сливочное 82.5%', 748, 0.5, 82.5, 0.8),
	(13, 'Масло сливочное 72.5%', 661, 0.8, 72.5, 1.3),
	(14, 'Яйцо куриное', 153, 12.7, 11.1, 0.6),
	(15, 'Яйцо перепилиное', 170, 11.9, 13.3, 0.8),
	(16, 'Абрикосы', 44, 0.7, 0, 10.1),
	(17, 'Ананас', 49, 0.3, 0, 11.9),
	(18, 'Апельсин', 38, 0.8, 0, 8.6),
	(19, 'Бананы', 87, 1.7, 0, 22.1),
	(20, 'Брусника', 42, 0.6, 0, 8.8),
	(21, 'Виноград', 73, 0.5, 0, 17.8),
	(22, 'Вишня', 46, 0.9, 0, 11.1),
	(23, 'Гранат', 53, 0.9, 0, 11.9),
	(24, 'Грейпфрут', 37, 0.8, 0, 7.5),
	(25, 'Груша', 41, 0.5, 0, 10.6),
	(26, 'Дыня', 34, 0.8, 0.3, 7.3),
	(27, 'Ежевика', 31, 1.9, 0, 5.1),
	(28, 'Инжир', 57, 0.9, 0, 13.7),
	(29, 'Киви', 46, 1, 0.7, 9.7),
	(30, 'Клубника', 30, 0.6, 0.4, 7),
	(31, 'Клюква', 27, 0.7, 0, 4.9),
	(32, 'Крыжовник', 43, 0.8, 0, 9.7),
	(33, 'Лимон', 30, 0.9, 0, 3.3),
	(34, 'Малина', 43, 0.7, 0, 9.2),
	(35, 'Хурма', 61, 0.7, 0, 15.7),
	(36, 'Черешная', 54, 1.3, 0, 12.5),
	(37, 'Черника', 41, 1.2, 0, 8.8),
	(38, 'Яблоки', 48, 0.5, 0, 11.4),
	(39, 'Баклажаны', 22, 0.6, 0.1, 7.5),
	(40, 'Кабачки', 39, 0.8, 0.3, 5.9),
	(41, 'Капуста цветная', 30, 2.7, 0, 5.2),
	(42, 'Капуста брокколи', 28, 3, 0.4, 5.2),
	(43, 'Капуста пекинская', 12, 1.2, 0.2, 3.2),
	(44, 'Картофель отварной', 80, 2, 0.3, 16.5),
	(45, 'Картофель жареный', 198, 2.6, 9.7, 23.5),
	(46, 'Лук зеленый', 21, 1.4, 0, 4.2),
	(47, 'Лук репчатый', 41, 1.6, 0, 9.3),
	(48, 'Морковь', 29, 1.3, 0.1, 6.3),
	(49, 'Огурцы', 12, 0.7, 0, 3.1),
	(50, 'Перец сладки', 25, 1.2, 0, 5),
	(51, 'Пертушка', 45, 3.8, 0, 8),
	(52, 'Помидоры', 15, 0.7, 0, 4.1),
	(53, 'Помидоры вяленые', 258, 14.1, 3, 43.5),
	(54, 'Укроп', 38, 2.5, 0.5, 4.1),
	(55, 'Редис', 22, 1.5, 0, 4.2),
	(56, 'Редька', 33, 1.7, 0, 7.1),
	(57, 'Салат', 15, 1.6, 0, 2.1),
	(58, 'Свекла', 46, 1.7, 0, 10.5),
	(59, 'Соя(зерно)', 364, 34.9, 17.3, 17.3),
	(60, 'Фасоль отварная', 123, 7.8, 0.5, 21.5),
	(61, 'Фасоль стручковая', 23, 2.5, 0.3, 3),
	(62, 'Хрен', 70, 2.6, 0, 16.1),
	(63, 'Чеснок', 103, 6.6, 0, 21.1),
	(64, 'Белые грибы(свежие)', 32, 3.3, 1.5, 2.4),
	(65, 'Белые грибы(сушеные)', 277, 23.8, 6.8, 30.2),
	(66, 'Лисички свежие', 22, 1.5, 1, 2.4),
	(67, 'Маслята свежие', 12, 2.5, 0.7, 1.5),
	(68, 'Опята свежие', 25, 2.4, 1, 2.5),
	(69, 'Сыроежки свежие', 15, 1.6, 0.8, 1.7),
	(70, 'Шампиньоны свежие', 29, 4.3, 0.9, 1.4),
	(71, 'Майонез 67%', 624, 3.3, 67, 2.4),
	(72, 'Томатный острый', 99, 2.5, 0, 21.2),
	(73, 'Соевый', 50.66, 6, 0, 6.66),
	(74, 'Горчица', 417.5, 5, 40, 10),
	(75, 'Горбуша', 151, 21.2, 7.1, 0),
	(76, 'Кальмар', 77, 18.2, 0.2, 0),
	(77, 'Карась', 84, 17.5, 1.6, 0),
	(78, 'Карп', 95, 16, 3.5, 0),
	(79, 'Кета', 138, 22.1, 5.8, 0),
	(80, 'Килька малосольная', 140, 17.1, 7.6, 0),
	(81, 'Крабовое мясо', 67, 16, 0.9, 0),
	(82, 'Крабовые палочки', 73, 17.9, 2.1, 0),
	(83, 'Креветка', 85, 18, 0.9, 0),
	(84, 'Лещ', 109, 17.2, 4.2, 0),
	(85, 'Лосось', 200, 19.2, 13.8, 0),
	(86, 'Минтай', 67, 15.7, 0.6, 0),
	(87, 'Мойва', 159, 13.1, 11.7, 0),
	(88, 'Морская капуста', 25, 0.9, 0.2, 3),
	(89, 'Окунь морской', 123, 17.4, 5.5, 0),
	(90, 'Окунь речной', 80, 18.3, 0.7, 0),
	(91, 'Осьминог', 74, 18.5, 0, 0),
	(92, 'Плотва', 108, 18.5, 0.4, 0),
	(93, 'Раки вареные', 96, 20.3, 1.2, 1.1),
	(94, 'Сайра', 257, 18.3, 20.5, 0),
	(95, 'Сельдь', 88, 17.5, 2, 0),
	(96, 'Сельдь атлантическая', 145, 1.7, 8.5, 0),
	(97, 'Сельдь тихоокенская', 224, 17.4, 17.1, 0),
	(98, 'Семга', 222, 20.9, 15.3, 0),
	(99, 'Скумбрия', 158, 18, 9.5, 0),
	(100, 'Сом', 141, 16.7, 8.4, 0);
/*!40000 ALTER TABLE `food` ENABLE KEYS */;

-- Дамп структуры для таблица foodtracker.food_has_meal
CREATE TABLE IF NOT EXISTS `food_has_meal` (
  `food_idFood` int(11) NOT NULL,
  `meal_idMeal` int(11) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `fk_food_has_meal_meal1_idx` (`meal_idMeal`),
  KEY `fk_food_has_meal_food1_idx` (`food_idFood`),
  CONSTRAINT `fk_food_has_meal_food1` FOREIGN KEY (`food_idFood`) REFERENCES `food` (`idFood`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_food_has_meal_meal1` FOREIGN KEY (`meal_idMeal`) REFERENCES `meal` (`idMeal`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы foodtracker.food_has_meal: ~55 rows (приблизительно)
/*!40000 ALTER TABLE `food_has_meal` DISABLE KEYS */;
INSERT INTO `food_has_meal` (`food_idFood`, `meal_idMeal`, `id`) VALUES
	(1, 4, 1),
	(1, 4, 2),
	(1, 1, 3),
	(2, 2, 4),
	(34, 3, 5),
	(65, 4, 6),
	(75, 5, 7),
	(2, 6, 8),
	(34, 7, 9),
	(43, 8, 10),
	(54, 9, 11),
	(75, 5, 12),
	(24, 1, 13),
	(53, 3, 14),
	(23, 4, 15),
	(23, 6, 16),
	(53, 5, 17),
	(23, 4, 18),
	(12, 3, 19),
	(32, 6, 20),
	(23, 4, 21),
	(12, 6, 22),
	(4, 3, 23),
	(63, 5, 24),
	(43, 12, 25),
	(43, 14, 26),
	(4, 15, 27),
	(43, 17, 28),
	(4, 25, 29),
	(2, 3, 30),
	(32, 23, 31),
	(53, 27, 32),
	(35, 26, 33),
	(34, 24, 34),
	(12, 23, 35),
	(32, 4, 36),
	(54, 23, 37),
	(43, 12, 38),
	(2, 14, 39),
	(3, 13, 40),
	(43, 12, 41),
	(3, 20, 42),
	(21, 10, 43),
	(99, 10, 44),
	(35, 12, 45),
	(100, 14, 46),
	(23, 15, 47),
	(1, 1, 48),
	(4, 1, 49),
	(4, 2, 50),
	(4, 2, 51),
	(4, 1, 52),
	(2, 4, 53),
	(2, 4, 54),
	(2, 4, 55);
/*!40000 ALTER TABLE `food_has_meal` ENABLE KEYS */;

-- Дамп структуры для таблица foodtracker.meal
CREATE TABLE IF NOT EXISTS `meal` (
  `idMeal` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `calories` double DEFAULT NULL,
  `user_idUser` int(11) NOT NULL,
  PRIMARY KEY (`idMeal`),
  KEY `user_idUser_idx` (`user_idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы foodtracker.meal: ~29 rows (приблизительно)
/*!40000 ALTER TABLE `meal` DISABLE KEYS */;
INSERT INTO `meal` (`idMeal`, `date`, `time`, `weight`, `calories`, `user_idUser`) VALUES
	(1, '2000-10-17', '05:35:00', 45, 5454, 1),
	(2, '2000-10-17', '05:35:00', 45, 5454, 4),
	(3, '2000-10-17', '03:23:00', 32, 3232, 4),
	(4, '2000-10-17', '11:01:00', 111, 1111, 4),
	(5, '2000-10-17', '03:23:00', 32, 32, 2),
	(6, '2000-10-17', '03:02:00', 32, 32, 2),
	(7, '2000-10-17', '04:35:00', 54, 54, 2),
	(8, '2000-10-17', '04:43:00', 534, 534, 3),
	(9, '2000-10-17', '04:03:00', 43, 43, 3),
	(10, '2000-10-17', '03:02:00', 32, 3223, 3),
	(11, '2000-10-18', '05:04:00', 54, 45, 4),
	(12, '2000-10-19', '05:04:00', 54, 45, 5),
	(13, '2000-10-19', '05:04:00', 54, 45, 5),
	(14, '2000-10-19', '06:45:00', 645, 654, 6),
	(15, '2000-10-19', '11:11:00', 111, 111, 6),
	(16, '2000-10-19', '11:11:00', 111, 111, 1),
	(17, '2000-10-19', '05:54:00', 54, 45, 2),
	(18, '2000-10-19', '00:03:00', 1, 1, 3),
	(19, '2000-10-19', '17:11:00', 2323, 2332, 4),
	(20, '2000-10-19', '23:43:00', 23543, 3553, 5),
	(21, '2000-10-19', '12:12:00', 123, 123, 6),
	(22, '2000-10-19', '22:02:00', 222, 2222, 6),
	(23, '2000-10-19', '22:22:00', 2222, 222, 7),
	(24, '2000-10-19', '03:33:00', 333, 333, 8),
	(25, '2000-10-19', '03:33:00', 333, 3333, 8),
	(26, '2000-10-19', '03:33:00', 333, 333, 9),
	(27, '2000-10-19', '20:15:00', 123, 13, 9),
	(50, '2021-10-19', '18:05:00', 100, NULL, 0),
	(51, '2021-10-19', '12:00:00', 50, NULL, 4);
/*!40000 ALTER TABLE `meal` ENABLE KEYS */;

-- Дамп структуры для таблица foodtracker.user
CREATE TABLE IF NOT EXISTS `user` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `secondName` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `sex` varchar(45) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `dateOfBirth` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  `block` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idUser`),
  UNIQUE KEY `password_UNIQUE` (`password`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы foodtracker.user: ~9 rows (приблизительно)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`idUser`, `login`, `password`, `name`, `secondName`, `email`, `sex`, `weight`, `dateOfBirth`, `role`, `block`) VALUES
	(1, '123', '123', 'Anton', 'Kulak', 'anton@mail.ru', 'male', 75, '2000-03-21', 'user', 'unblock'),
	(2, '1234', '1234', 'Anton', 'Gevon', 'antonGevon@gmail.com', 'male', 69, '1999-12-23', 'user', 'block'),
	(3, '12345', '12345', 'Nika', 'Ryabtseva', '123nikacool123@gmail.com', 'female', 50, '2000-06-12', 'user', 'block'),
	(4, 'admin', 'admin', 'Nikita', 'Ryabtsev', '123nikitacool123@gmail.com', 'male', 73, '2000-07-13', 'admin', 'unblock'),
	(5, '123456', '123456', 'Mich', 'Ural', 'michUral@yandex.by', 'male', 75, '1995-11-11', 'user', 'unblock'),
	(6, '321', '321', 'Nikita', 'Omelyashko', 'NikOmel@mail.ru', 'male', 60, '2000-12-10', 'user', 'unblock'),
	(7, '4321', '4321', 'Darya', 'Heineken', 'daryaHeineken@mail.ru', 'female', 48, '1999-12-13', 'user', 'unblock'),
	(8, '54321', '54321', 'Kostya', 'Juk', 'kostyaJuk@outlook.com', 'male', 35, '1983-01-02', 'user', 'unblock'),
	(9, '654321', '654321', 'Mike', 'Mikevoch', 'mikyMekovich@yandex.ru', 'male', 120, '1950-03-12', 'user', 'unblock');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Дамп структуры для таблица foodtracker.user_weight
CREATE TABLE IF NOT EXISTS `user_weight` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `weight` double DEFAULT NULL,
  `date` date DEFAULT NULL,
  `user_idUser` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_userWeight_user1_idx` (`user_idUser`),
  CONSTRAINT `fk_userWeight_user1` FOREIGN KEY (`user_idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы foodtracker.user_weight: ~16 rows (приблизительно)
/*!40000 ALTER TABLE `user_weight` DISABLE KEYS */;
INSERT INTO `user_weight` (`id`, `weight`, `date`, `user_idUser`) VALUES
	(1, 70, '2021-10-19', 4),
	(2, 65, '2021-10-20', 4),
	(3, 55, '2021-10-19', 2),
	(4, 65, '2021-10-19', 2),
	(5, 50, '2021-10-19', 3),
	(6, 75, '2021-10-19', 1),
	(7, 75, '2021-10-19', 1),
	(9, 75, '2021-10-19', 1),
	(10, 75, '2021-10-19', 1),
	(11, 75, '2021-10-19', 1),
	(12, 75, '2021-10-19', 1),
	(16, 50, '2021-10-19', 3),
	(17, 50, '2021-10-19', 3),
	(18, 50, '2021-10-19', 3),
	(48, 74, '2021-10-19', 1),
	(49, 59, '2021-10-19', 6);
/*!40000 ALTER TABLE `user_weight` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
