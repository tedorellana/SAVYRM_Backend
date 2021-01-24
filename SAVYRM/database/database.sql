CREATE DATABASE  IF NOT EXISTS `savyrm` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `savyrm`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: savyrm
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `almacen`
--

DROP TABLE IF EXISTS `almacen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `almacen` (
  `idAlmacen` int NOT NULL,
  `nombreAlmacen` varchar(75) NOT NULL,
  `direccion` varchar(250) NOT NULL,
  `capacidad` double DEFAULT NULL,
  PRIMARY KEY (`idAlmacen`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `almacen`
--

LOCK TABLES `almacen` WRITE;
/*!40000 ALTER TABLE `almacen` DISABLE KEYS */;
INSERT INTO `almacen` VALUES (4,'Tienda Principal','Ovalos Santa Anita',NULL),(5,'Almacen Principal','Avenida La Molina 1045',NULL),(6,'Almacen Secundario','Centro de Lima',NULL),(7,'Almacen la Molina','Los Fresno 555',1644),(8,'Almacen Santa Anita','Ov Santa Anita',8560);
/*!40000 ALTER TABLE `almacen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formula`
--

DROP TABLE IF EXISTS `formula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `formula` (
  `idFormula` int NOT NULL,
  `nombreFormula` varchar(250) DEFAULT NULL,
  `detalleFormula` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`idFormula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formula`
--

LOCK TABLES `formula` WRITE;
/*!40000 ALTER TABLE `formula` DISABLE KEYS */;
INSERT INTO `formula` VALUES (1,'nombreFormula',NULL),(4,'Propenlicol Formula Base',NULL),(6,'listo1 Formula Base',NULL),(8,'Propenlicol Formula Base',NULL),(9,'Propenlicol Formula Base',NULL),(10,'gggg Formula Base',NULL),(11,'asdasd Formula Base',NULL),(12,'asdasd Formula Base',NULL),(13,'Shampoo de Pera Formula Base',NULL),(14,'asdasd Formula Base',NULL),(15,'asdasd Formula Base',NULL),(16,'asdasd Formula Base',NULL),(17,'Shampoo de Pera Formula Base',NULL),(19,'Shampoo de Pera Formula Base',NULL),(20,'Tensoactivos Formula Base',NULL),(21,'asdas Formula Base',NULL),(22,'asdasd Formula Base',NULL),(23,'producto de prueba Formula Base',NULL),(24,'producto de prueba Formula Base',NULL),(25,'Shampoo de Albaca Formula Base',NULL),(26,'Perfume Channel Formula Base',NULL),(31,'Propenlicol Formula Base',NULL),(32,'Perfume Lacoste Formula Base',NULL),(33,'Perfume Lacoste Formula Base',NULL),(34,'Colonia Lacoste 1 - Preparada Formula Base',NULL),(35,'Colonia Aroma Lacoste2 Formula Base',NULL);
/*!40000 ALTER TABLE `formula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `indicacion`
--

DROP TABLE IF EXISTS `indicacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `indicacion` (
  `idIndicacion` int NOT NULL,
  `ordenIndicacion` int NOT NULL,
  `detalleIndicacion` varchar(250) NOT NULL,
  `fk_idPreparacionIndicacion` int NOT NULL,
  PRIMARY KEY (`idIndicacion`),
  KEY `FK_Indicacion_Preparacion` (`fk_idPreparacionIndicacion`),
  CONSTRAINT `FK_Indicacion_Preparacion` FOREIGN KEY (`fk_idPreparacionIndicacion`) REFERENCES `preparacion` (`idPreparacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `indicacion`
--

LOCK TABLES `indicacion` WRITE;
/*!40000 ALTER TABLE `indicacion` DISABLE KEYS */;
INSERT INTO `indicacion` VALUES (13,1,'tens',15),(14,1,'aaasda',16),(15,1,'1111',16),(16,1,'aaa',17),(17,1,'ddd',17),(18,1,'batir bien',18),(19,1,'cerrar',18),(20,1,'abrir',18),(21,1,'batir bien',19),(22,1,'cerrar',19),(23,1,'agregar',20),(38,1,'primero',26),(39,2,'tercero',26),(40,2,'asdasd',26),(43,1,'Agregar Propenicol y batir',28),(44,2,'empaquetar',28),(45,1,'Agregar la Colonia base',29),(46,2,'agregar alcohol',29),(47,3,'homogenizar la mezcla',29),(48,4,'dejar reposar durante 15 minutos en un envase cerrado',29),(49,1,'Incluir Colonia base en un envase',30),(50,2,'incluir alcohol en el envase',30),(51,3,'homogeneizar la mezcla',30),(52,4,'embotellar y mantener a una temperatura menor a 10grados por media hora',30);
/*!40000 ALTER TABLE `indicacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `log` (
  `idLog` int NOT NULL,
  `Componente` varchar(75) DEFAULT NULL,
  `Servicio` varchar(75) DEFAULT NULL,
  `fecha` datetime(6) NOT NULL,
  `detalle` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lote`
--

DROP TABLE IF EXISTS `lote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lote` (
  `idLote` int NOT NULL,
  `codigoLote` varchar(75) NOT NULL,
  `costoLote` double DEFAULT NULL,
  `cantidadUnidadesLote` double NOT NULL,
  `fechaCaducidadLote` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`idLote`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lote`
--

LOCK TABLES `lote` WRITE;
/*!40000 ALTER TABLE `lote` DISABLE KEYS */;
INSERT INTO `lote` VALUES (1,'Lote1',890,850,'2017-06-28 20:30:54.143000'),(2,'Lote05072017',4500,900,'2021-06-28 20:30:54.143000');
/*!40000 ALTER TABLE `lote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `idPersona` int NOT NULL AUTO_INCREMENT,
  `nombrePersona` varchar(50) NOT NULL,
  `apellidoPaternoPersona` varchar(75) DEFAULT NULL,
  `apellidoMaternoPersona` varchar(75) DEFAULT NULL,
  `documentoIdentidadPersona` varchar(75) NOT NULL,
  `numeroDocumentoPersona` varchar(75) NOT NULL,
  `numeroTelefonoPersona` varchar(75) DEFAULT NULL,
  `correoPersona` varchar(150) NOT NULL,
  `direccionPersona` varchar(250) NOT NULL,
  `fk_idTipoPersona` int NOT NULL,
  PRIMARY KEY (`idPersona`),
  KEY `FK_Persona_TipoPersona` (`fk_idTipoPersona`),
  CONSTRAINT `FK_Persona_TipoPersona` FOREIGN KEY (`fk_idTipoPersona`) REFERENCES `tipopersona` (`idTipoPersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'Ted','Orellana','Rojas','DNI','71926746','941766670','tedorellana@gmail.com','Prolonfación los puquina 115  - Salamanca de Monterrico',1),(2,'Antony','Villar','Cristobal','DNI','71527712','987261221','antony@gmail.com','Urbanizacón Proceres 116 - Chorrillos',1),(3,'Juan','Rojas','Rojas','DNI','29312212','908899172','juanjuan@hotmail.com','Prolongacion Atenea 432 - Chorillos',1),(4,'Ruby','Arce','Figueroa','DNI','21312312','976255121','figueroaarce@gmail.com','Puquinas 114 - Ate',1);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `precio`
--

DROP TABLE IF EXISTS `precio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `precio` (
  `idPrecio` int NOT NULL,
  `unitarioPrecio` double DEFAULT NULL,
  `fechaInicioPrecio` datetime(6) NOT NULL,
  `fechaFinPrecio` datetime(6) DEFAULT NULL,
  `mayoriaPrecio` double DEFAULT NULL,
  `vigentePrecio` tinyint(1) NOT NULL,
  `cantidadMayoriaPrecio` double DEFAULT NULL,
  `fk_idProducto` int DEFAULT NULL,
  PRIMARY KEY (`idPrecio`),
  KEY `FK_Precio_Producto` (`fk_idProducto`),
  CONSTRAINT `FK_Precio_Producto` FOREIGN KEY (`fk_idProducto`) REFERENCES `producto` (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `precio`
--

LOCK TABLES `precio` WRITE;
/*!40000 ALTER TABLE `precio` DISABLE KEYS */;
INSERT INTO `precio` VALUES (1,78,'2017-06-25 17:14:14.590000',NULL,NULL,0,NULL,2),(2,45,'2017-06-25 17:21:57.857000',NULL,NULL,0,NULL,2),(3,85,'2017-06-25 17:22:08.530000',NULL,NULL,0,NULL,2),(4,12,'2017-06-25 17:25:41.550000',NULL,NULL,0,NULL,2),(5,33,'2017-06-25 17:25:51.560000',NULL,NULL,0,NULL,2),(6,333,'2017-06-25 17:26:40.767000',NULL,NULL,0,NULL,2),(7,11,'2017-06-25 17:28:02.703000',NULL,NULL,0,NULL,2),(8,44,'2017-06-25 17:28:42.910000',NULL,NULL,0,NULL,2),(9,17,'2017-06-25 17:30:00.310000',NULL,NULL,0,NULL,2),(10,16.5,'2017-06-25 17:30:09.677000',NULL,NULL,0,NULL,2),(11,14,'2017-06-25 17:32:09.427000',NULL,NULL,1,NULL,33),(12,45,'2017-06-25 20:53:23.517000',NULL,NULL,1,NULL,17),(13,15,'2017-07-02 15:31:14.417000',NULL,NULL,1,NULL,9),(14,35,'2017-07-05 19:58:38.547000',NULL,NULL,1,NULL,37),(15,10,'2017-07-05 19:58:48.210000',NULL,NULL,1,NULL,36),(16,10,'2017-07-05 19:59:06.017000',NULL,NULL,1,NULL,35),(17,15,'2017-07-05 20:24:24.187000',NULL,NULL,0,NULL,38),(18,18,'2017-07-05 20:24:29.510000',NULL,NULL,0,NULL,38),(19,25,'2017-07-05 20:24:33.597000',NULL,NULL,1,NULL,38),(20,123,'2018-03-15 19:00:01.500000',NULL,NULL,1,NULL,2);
/*!40000 ALTER TABLE `precio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preparacion`
--

DROP TABLE IF EXISTS `preparacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `preparacion` (
  `idPreparacion` int NOT NULL,
  `nombrePreparacion` varchar(250) DEFAULT NULL,
  `fechaCreacionPreparacion` datetime(6) NOT NULL,
  `detalleAdicionalPreparacion` longtext NOT NULL,
  `fk_idProducto` int NOT NULL,
  PRIMARY KEY (`idPreparacion`),
  KEY `FK_Preparacion_Producto` (`fk_idProducto`),
  CONSTRAINT `FK_Preparacion_Producto` FOREIGN KEY (`fk_idProducto`) REFERENCES `producto` (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preparacion`
--

LOCK TABLES `preparacion` WRITE;
/*!40000 ALTER TABLE `preparacion` DISABLE KEYS */;
INSERT INTO `preparacion` VALUES (6,'1','2017-06-19 03:22:40.000000','asda',1),(15,'Tensoactivos Preparación','2017-06-19 03:35:19.000000','',21),(16,'asdas Preparación','2017-06-19 03:36:39.000000','',29),(17,'asdasd Preparación','2017-06-19 03:39:08.000000','',28),(18,'producto de prueba Preparación','2017-06-19 20:29:17.503000','no hay detalles',32),(19,'producto de prueba Preparación','2017-06-19 20:29:17.503000','no hay detalles',32),(20,'Shampoo de Albaca Preparación','2017-06-21 00:34:29.873000','',33),(26,'Perfume Channel Preparación','2017-06-21 01:53:23.033000','',3),(28,'Perfume Lacoste Preparación','2017-06-25 21:03:53.870000','',2),(29,'Colonia Lacoste 1 - Preparada Preparación','2017-07-05 19:56:13.150000','',37),(30,'Colonia Aroma Lacoste2 Preparación','2017-07-05 20:23:11.580000','',38);
/*!40000 ALTER TABLE `preparacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `idProducto` int NOT NULL AUTO_INCREMENT,
  `nombreProducto` varchar(75) NOT NULL,
  `codigoProducto` varchar(75) NOT NULL,
  `estadoProducto` tinyint(1) DEFAULT NULL,
  `fk_idUnidadMedida` int DEFAULT NULL,
  `fk_idTIpoProducto` int NOT NULL,
  PRIMARY KEY (`idProducto`),
  KEY `FK_Producto_TipoProducto` (`fk_idTIpoProducto`),
  KEY `FK_Producto_UnidadMedida` (`fk_idUnidadMedida`),
  CONSTRAINT `FK_Producto_TipoProducto` FOREIGN KEY (`fk_idTIpoProducto`) REFERENCES `tipoproducto` (`idTipoProducto`),
  CONSTRAINT `FK_Producto_UnidadMedida` FOREIGN KEY (`fk_idUnidadMedida`) REFERENCES `unidadmedida` (`idUnidadMedida`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'','hola',0,1,1),(2,'Perfume Lacoste','Perfume Lacoste',1,1,1),(3,'Perfume Channel','Perfume Channel',1,1,1),(4,'Shampoo de Coco','Shampoo de Coco',0,1,1),(5,'Shampoo de Pera','Shampoo de Pera',1,1,1),(6,'asdasd','asdasd',1,1,1),(7,'rfefefef','rfefefef',1,1,1),(8,'1111qqq','1111qqq',0,1,1),(9,'Propenlicol','56',1,1,3),(10,'asssss','asssss',1,1,1),(11,'listo1','yyy',1,1,2),(12,'hlola','hlola',1,1,1),(13,'rrrr','rrrr',0,1,1),(14,'asdas','asdas',0,1,1),(15,'','',0,1,1),(16,'','',1,1,1),(17,'Jabon liquido de pera','asdas',1,1,1),(18,'asdas','asdas',1,1,1),(19,'Prodcuto','Prodcuto',1,2,2),(20,'asdasd','asdasd',1,1,1),(21,'Tensoactivos','Tensoactivos',1,2,1),(22,'gggg','gggg',1,1,1),(26,'a','a',0,1,1),(27,'asssss','asssss',1,1,1),(28,'asdasd','asdasd',1,1,1),(29,'asdas','asdas',1,1,2),(30,'Hola','Hola',0,2,2),(31,'111','assss',0,1,1),(32,'producto de prueba','producto de prueba',1,2,1),(33,'Shampoo de Albaca','Shampoo de Albaca',1,1,1),(34,'Shampoo A','Shampoo A',1,1,1),(35,'Colonia Aroma Lacoste1 Base','Colonia Aroma Lacoste1 Base',1,1,2),(36,'Alcohol','Alcohol',1,1,3),(37,'Colonia Lacoste 1 - Preparada','Colonia Lacoste 1 - Preparada',1,1,1),(38,'Colonia Aroma Lacoste2','Colonia Aroma Lacoste2',1,1,1),(39,'produtco 3','produtco 3',1,2,1),(40,'Vitamina E Aceite','Vitamina E Aceite',1,1,1),(41,'Vitamina E Crema','Vitamina E Crema',1,2,1),(42,'Perfume de Limón','Perfume de Limón',1,1,1);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productoformula`
--

DROP TABLE IF EXISTS `productoformula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productoformula` (
  `idProductoFormula` int NOT NULL,
  `fk_idProductoElaborado` int NOT NULL,
  `fk_idProductoInsumo` int NOT NULL,
  `fk_idFormula` int NOT NULL,
  `porcentaje` double NOT NULL,
  `cantidad` double DEFAULT NULL,
  PRIMARY KEY (`idProductoFormula`),
  KEY `FK_ProductoFormula_Formula` (`fk_idFormula`),
  KEY `FK_ProductoFormula_Producto` (`fk_idProductoElaborado`),
  KEY `FK_ProductoFormula_Producto1` (`fk_idProductoInsumo`),
  CONSTRAINT `FK_ProductoFormula_Formula` FOREIGN KEY (`fk_idFormula`) REFERENCES `formula` (`idFormula`),
  CONSTRAINT `FK_ProductoFormula_Producto` FOREIGN KEY (`fk_idProductoElaborado`) REFERENCES `producto` (`idProducto`),
  CONSTRAINT `FK_ProductoFormula_Producto1` FOREIGN KEY (`fk_idProductoInsumo`) REFERENCES `producto` (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productoformula`
--

LOCK TABLES `productoformula` WRITE;
/*!40000 ALTER TABLE `productoformula` DISABLE KEYS */;
INSERT INTO `productoformula` VALUES (3,22,11,6,33,NULL),(4,22,14,6,12,NULL),(5,22,9,6,1,NULL),(12,22,11,10,10,NULL),(13,22,9,10,85,NULL),(14,6,9,11,12,NULL),(15,6,9,12,12,NULL),(17,6,9,14,12,NULL),(18,6,9,15,12,NULL),(19,6,9,16,44,NULL),(25,21,11,20,100,NULL),(26,29,9,21,12,NULL),(27,28,9,22,12,NULL),(28,32,9,23,10,NULL),(29,32,11,23,25,NULL),(30,32,9,24,10,NULL),(31,32,11,24,25,NULL),(32,32,9,24,12,NULL),(33,32,11,24,12,NULL),(34,33,9,25,100,NULL),(45,3,9,31,12,NULL),(46,3,11,31,23,NULL),(49,2,11,33,23,NULL),(50,2,9,33,55,NULL),(51,37,35,34,60,NULL),(52,37,36,34,40,NULL),(53,38,35,35,75,NULL),(54,38,36,35,25,NULL);
/*!40000 ALTER TABLE `productoformula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productoseccion`
--

DROP TABLE IF EXISTS `productoseccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productoseccion` (
  `idProductoSeccion` int NOT NULL,
  `fk_idProducto` int NOT NULL,
  `fk_idSeccion` int NOT NULL,
  `fk_idLote` int NOT NULL,
  `cantidadProductoSeccion` double NOT NULL,
  `fechaIngreso` datetime(6) NOT NULL,
  PRIMARY KEY (`idProductoSeccion`),
  KEY `FK_ProductoSeccion_Lote` (`fk_idLote`),
  KEY `FK_ProductoSeccion_Producto` (`fk_idProducto`),
  KEY `FK_ProductoSeccion_Seccion` (`fk_idSeccion`),
  CONSTRAINT `FK_ProductoSeccion_Lote` FOREIGN KEY (`fk_idLote`) REFERENCES `lote` (`idLote`),
  CONSTRAINT `FK_ProductoSeccion_Producto` FOREIGN KEY (`fk_idProducto`) REFERENCES `producto` (`idProducto`),
  CONSTRAINT `FK_ProductoSeccion_Seccion` FOREIGN KEY (`fk_idSeccion`) REFERENCES `seccion` (`idSeccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productoseccion`
--

LOCK TABLES `productoseccion` WRITE;
/*!40000 ALTER TABLE `productoseccion` DISABLE KEYS */;
INSERT INTO `productoseccion` VALUES (3,2,1,1,0,'2017-06-28 20:30:54.143000'),(4,5,1,1,45,'2017-06-28 20:40:20.163000'),(5,9,1,1,0,'2017-07-02 22:33:55.867000'),(6,37,1,2,55,'2017-07-05 20:01:59.417000'),(7,36,1,1,162,'2017-07-05 20:02:10.850000'),(8,38,1,2,0,'2017-07-05 20:25:17.027000');
/*!40000 ALTER TABLE `productoseccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seccion`
--

DROP TABLE IF EXISTS `seccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seccion` (
  `idSeccion` int NOT NULL,
  `codigoSeccion` varchar(75) NOT NULL,
  `capacidadSeccion` double DEFAULT NULL,
  `detalle` varchar(250) DEFAULT NULL,
  `fk_idAlmacen` int NOT NULL,
  PRIMARY KEY (`idSeccion`),
  KEY `FK_Seccion_Almacen` (`fk_idAlmacen`),
  CONSTRAINT `FK_Seccion_Almacen` FOREIGN KEY (`fk_idAlmacen`) REFERENCES `almacen` (`idAlmacen`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seccion`
--

LOCK TABLES `seccion` WRITE;
/*!40000 ALTER TABLE `seccion` DISABLE KEYS */;
INSERT INTO `seccion` VALUES (1,'Tie261498461451460',NULL,'Sección de la tienda principal',4),(5,'Alm261498461809969',NULL,'Seccion Productos Finales',5),(6,'Alm261498461872639',NULL,'Insumos Primarios',6),(7,'Alm261498461889529',NULL,'Productos Pre-Elaborados',6),(8,'Tie1231212312312',123,'1asdasds',4),(9,'Tie1231212312312',123,'1asdasds',4),(10,'12132asdas',123123,'zsdas',4);
/*!40000 ALTER TABLE `seccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicio`
--

DROP TABLE IF EXISTS `servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicio` (
  `idServicio` int NOT NULL AUTO_INCREMENT,
  `horaInicioServicio` datetime(6) NOT NULL,
  `horaFinServicio` datetime(6) NOT NULL,
  `horaEdicionServicio` datetime(6) DEFAULT NULL,
  `idPersonaAtendidaServicio` int NOT NULL,
  `idPersonaEmpleado` int DEFAULT NULL,
  `fk_idTipoServicio` int NOT NULL,
  PRIMARY KEY (`idServicio`),
  KEY `FK_Servicio_Persona` (`idPersonaAtendidaServicio`),
  KEY `FK_Servicio_Persona1` (`idPersonaEmpleado`),
  KEY `FK_Servicio_TipoServicio` (`fk_idTipoServicio`),
  CONSTRAINT `FK_Servicio_Persona` FOREIGN KEY (`idPersonaAtendidaServicio`) REFERENCES `persona` (`idPersona`),
  CONSTRAINT `FK_Servicio_Persona1` FOREIGN KEY (`idPersonaEmpleado`) REFERENCES `persona` (`idPersona`),
  CONSTRAINT `FK_Servicio_TipoServicio` FOREIGN KEY (`fk_idTipoServicio`) REFERENCES `tiposervicio` (`idTipoServicio`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicio`
--

LOCK TABLES `servicio` WRITE;
/*!40000 ALTER TABLE `servicio` DISABLE KEYS */;
INSERT INTO `servicio` VALUES (1,'2017-07-02 22:04:47.153000','2017-07-02 22:04:55.753000',NULL,1,1,2),(2,'2017-07-05 20:02:35.723000','2017-07-05 20:03:27.307000',NULL,1,1,2),(3,'2017-07-05 20:05:58.230000','2017-07-05 20:06:12.317000',NULL,1,1,2),(4,'2017-07-05 20:25:34.663000','2017-07-05 20:26:05.617000',NULL,1,1,2),(5,'2017-07-05 20:25:34.663000','2017-07-05 20:25:34.663000',NULL,1,1,2),(6,'2017-07-05 20:25:34.663000','2017-07-05 20:25:34.663000',NULL,1,1,2),(7,'2017-07-05 20:25:34.663000','2017-07-05 20:25:34.663000',NULL,1,1,2),(8,'2017-07-05 20:25:34.663000','2017-07-05 20:25:34.663000',NULL,1,1,2),(9,'2017-07-05 20:25:34.663000','2017-07-05 20:25:34.663000',NULL,1,1,2),(10,'2017-07-05 20:25:34.663000','2017-07-05 20:25:34.663000',NULL,1,1,2),(11,'2017-07-05 20:25:34.663000','2017-07-05 20:25:34.663000',NULL,1,1,2),(12,'2017-07-05 20:25:34.663000','2017-07-05 20:25:34.663000',NULL,1,1,2),(13,'2017-07-05 20:25:34.663000','2017-07-05 20:25:34.663000',NULL,1,1,1),(14,'2020-10-17 00:00:00.000000','2017-07-05 20:25:34.663000',NULL,1,1,1),(15,'2020-10-17 12:46:12.000000','2017-07-05 20:25:34.663000',NULL,1,1,1),(16,'2020-10-17 12:49:54.000000','2017-07-05 20:25:34.663000',NULL,1,1,1),(17,'2020-10-17 12:53:09.000000','2017-07-05 20:25:34.663000',NULL,1,1,1),(18,'2020-10-17 12:53:49.000000','2017-07-05 20:25:34.663000',NULL,1,1,1),(19,'2020-10-17 12:54:36.000000','2017-07-05 20:25:34.663000',NULL,1,1,1),(20,'2020-10-17 12:54:50.000000','2017-07-05 20:25:34.663000',NULL,1,1,1),(21,'2020-10-17 12:58:36.000000','2017-07-05 20:25:34.663000',NULL,1,1,1),(22,'2020-10-17 13:11:30.000000','2017-07-05 20:25:34.663000',NULL,1,1,1),(23,'2020-10-17 13:14:33.000000','2017-07-05 20:25:34.663000',NULL,1,1,1),(24,'2020-10-17 13:14:44.000000','2017-07-05 20:25:34.663000',NULL,1,1,1),(25,'2020-10-17 13:20:41.000000','2020-09-06 13:20:30.000000',NULL,1,1,1),(26,'2020-09-06 13:20:30.000000','2020-10-17 13:21:55.000000',NULL,1,1,1),(27,'2020-09-06 13:20:30.000000','2020-10-17 14:04:45.000000',NULL,1,1,1),(28,'2020-09-06 13:20:30.000000','2020-10-17 14:07:22.000000',NULL,1,1,1),(29,'2020-09-06 13:20:30.000000','2020-10-17 14:20:33.000000',NULL,1,1,1),(30,'2020-09-06 13:20:30.000000','2020-10-17 14:21:54.000000',NULL,1,1,1),(31,'2020-09-06 14:43:23.000000','2020-10-17 14:43:41.000000',NULL,1,1,1),(32,'2020-09-06 14:48:01.000000','2020-10-17 15:14:23.000000',NULL,1,1,1),(33,'2020-09-06 17:58:39.000000','2020-10-24 17:59:10.000000',NULL,1,1,2),(34,'2020-09-06 18:48:18.000000','2020-10-24 18:48:25.000000',NULL,1,1,2),(35,'2020-09-06 18:49:53.000000','2020-10-24 18:49:59.000000',NULL,1,1,2),(36,'2020-09-06 18:50:12.000000','2020-10-24 18:50:16.000000',NULL,1,1,2),(37,'2020-09-06 18:50:12.000000','2020-10-24 18:50:21.000000',NULL,1,1,2),(38,'2020-09-06 18:50:23.000000','2020-10-24 18:50:30.000000',NULL,1,1,2),(39,'2020-09-06 20:25:45.000000','2020-10-24 20:25:56.000000',NULL,1,1,2),(40,'2020-09-06 20:42:23.000000','2020-10-24 20:42:33.000000',NULL,1,1,2),(41,'2020-10-06 21:36:50.000000','2020-10-24 21:36:54.000000',NULL,1,1,2),(42,'2020-10-01 12:14:10.000000','2020-10-25 12:14:22.000000',NULL,1,1,2),(43,'2020-10-01 12:21:20.000000','2020-10-25 12:21:28.000000',NULL,1,1,2),(44,'2020-10-01 12:24:40.000000','2020-10-25 12:24:52.000000',NULL,1,1,2),(45,'2020-10-01 12:28:34.000000','2020-10-25 12:28:46.000000',NULL,1,1,2),(46,'2020-10-01 12:31:51.000000','2020-10-25 12:32:02.000000',NULL,1,1,2),(47,'2020-10-25 12:34:10.000000','2020-10-25 12:34:23.000000',NULL,1,1,2),(48,'2020-10-25 12:45:05.000000','2020-10-25 12:45:26.000000',NULL,1,1,2),(49,'2020-10-25 12:48:54.000000','2020-10-25 12:49:07.000000',NULL,1,1,2),(50,'2020-10-25 12:52:51.000000','2020-10-25 12:53:00.000000',NULL,1,1,2),(51,'2020-10-25 12:57:16.000000','2020-10-25 12:57:23.000000',NULL,1,1,2),(52,'2020-10-25 12:57:26.000000','2020-10-25 12:57:33.000000',NULL,1,1,2),(53,'2020-10-25 13:13:39.000000','2020-10-25 13:15:09.000000',NULL,1,1,2),(54,'2020-10-25 13:16:25.000000','2020-10-25 13:18:01.000000',NULL,1,1,2),(55,'2020-11-08 08:22:25.000000','2020-11-08 08:22:36.000000',NULL,1,1,2),(56,'2020-11-23 23:31:10.000000','2020-11-23 23:46:30.000000',NULL,1,1,2),(57,'2020-11-29 12:50:44.000000','2020-11-29 12:52:56.000000',NULL,1,1,2),(58,'2020-11-29 12:53:51.000000','2020-11-29 12:54:18.000000',NULL,1,1,2),(59,'2020-12-13 02:19:05.000000','2020-12-13 02:19:08.000000',NULL,1,1,2),(60,'2021-01-07 00:42:25.000000','2021-01-07 00:42:37.000000',NULL,1,1,2),(62,'2021-01-17 09:06:13.000000','2021-01-17 09:06:52.000000',NULL,1,1,2),(67,'2021-01-17 22:14:38.000000','2021-01-17 22:14:58.000000',NULL,1,1,2),(68,'2021-01-17 22:15:16.000000','2021-01-17 22:15:21.000000',NULL,1,1,2),(69,'2021-01-23 23:07:13.000000','2021-01-23 23:07:26.000000',NULL,1,1,2),(70,'2021-01-23 23:14:00.000000','2021-01-23 23:14:06.000000',NULL,1,1,2),(71,'2021-01-23 23:14:23.000000','2021-01-23 23:14:48.000000',NULL,1,1,2),(72,'2021-01-24 01:25:47.000000','2021-01-24 01:26:00.000000',NULL,1,1,2),(73,'2021-01-24 01:26:28.000000','2021-01-24 01:26:51.000000',NULL,1,1,2),(74,'2021-01-24 01:29:44.000000','2021-01-24 01:31:02.000000',NULL,1,3,2),(75,'2021-01-24 01:33:09.000000','2021-01-24 01:33:30.000000',NULL,2,1,2);
/*!40000 ALTER TABLE `servicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicioproducto`
--

DROP TABLE IF EXISTS `servicioproducto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicioproducto` (
  `idServicioProductoSeccion` int NOT NULL AUTO_INCREMENT,
  `fk_idServicio` int NOT NULL,
  `fk_idProductoSeccion` int DEFAULT NULL,
  `costoTotal` double DEFAULT NULL,
  `cantidadServicioProducto` double DEFAULT NULL,
  `entregado` tinyint DEFAULT NULL,
  `fechaEntrega` datetime DEFAULT NULL,
  `fechaEntregaPrevista` datetime DEFAULT NULL,
  PRIMARY KEY (`idServicioProductoSeccion`),
  KEY `FK_ServicioProducto_ProductoSeccion` (`fk_idProductoSeccion`),
  KEY `FK_ServicioProducto_Servicio` (`fk_idServicio`),
  CONSTRAINT `FK_ServicioProducto_ProductoSeccion` FOREIGN KEY (`fk_idProductoSeccion`) REFERENCES `productoseccion` (`idProductoSeccion`),
  CONSTRAINT `FK_ServicioProducto_Servicio` FOREIGN KEY (`fk_idServicio`) REFERENCES `servicio` (`idServicio`)
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicioproducto`
--

LOCK TABLES `servicioproducto` WRITE;
/*!40000 ALTER TABLE `servicioproducto` DISABLE KEYS */;
INSERT INTO `servicioproducto` VALUES (1,1,3,181.5,11,1,'2021-01-15 01:36:58',NULL),(2,2,7,20,2,1,'2021-01-15 01:41:40',NULL),(3,2,6,175,5,1,'2021-01-15 01:44:38',NULL),(4,3,3,16.5,1,0,NULL,NULL),(5,4,7,110,11,0,NULL,NULL),(6,4,8,1100,44,0,NULL,NULL),(7,6,5,100,1,0,NULL,NULL),(8,6,5,100,1,0,NULL,NULL),(9,7,5,100,1,0,NULL,NULL),(10,7,5,100,1,0,NULL,NULL),(11,7,7,100,1,0,NULL,NULL),(12,8,5,100,1,0,NULL,NULL),(13,8,5,100,1,0,NULL,NULL),(14,8,7,100,1,0,NULL,NULL),(15,9,5,100,1,0,NULL,NULL),(16,9,5,100,1,0,NULL,NULL),(17,9,7,100,1,0,NULL,NULL),(18,9,3,100,1,0,NULL,NULL),(19,10,5,100,1,0,NULL,NULL),(20,11,5,100,1,0,NULL,NULL),(21,12,5,100,1,0,NULL,NULL),(22,13,5,100,1,0,NULL,NULL),(23,14,5,100,1,0,NULL,NULL),(24,15,5,100,1,0,NULL,NULL),(25,18,5,100,1,0,NULL,NULL),(26,19,5,100,1,0,NULL,NULL),(27,20,5,100,1,0,NULL,NULL),(28,21,5,100,1,0,NULL,NULL),(29,25,7,100,1,0,NULL,NULL),(30,26,7,100,1,0,NULL,NULL),(31,27,7,100,1,0,NULL,NULL),(32,28,7,100,1,0,NULL,NULL),(33,29,7,100,1,0,NULL,NULL),(34,29,6,100,1,0,NULL,NULL),(35,30,7,100,1,0,NULL,NULL),(36,30,6,100,1,0,NULL,NULL),(37,31,5,0,1,0,NULL,NULL),(38,32,5,0,1,0,NULL,NULL),(39,32,3,0,1,1,NULL,NULL),(40,33,5,0,1,0,NULL,NULL),(41,33,5,0,1,0,NULL,NULL),(42,33,8,0,1,0,NULL,NULL),(43,34,6,0,1,0,NULL,NULL),(44,35,5,0,1,1,NULL,NULL),(45,38,5,0,1,1,NULL,NULL),(46,38,6,0,1,1,NULL,NULL),(47,39,5,0,1,1,NULL,NULL),(48,40,7,0,1,1,NULL,NULL),(49,40,3,0,1,1,NULL,NULL),(50,41,5,0,1,1,NULL,NULL),(51,42,5,0,1,1,NULL,NULL),(52,43,5,0,1,1,NULL,NULL),(53,44,5,0,1,0,NULL,NULL),(54,44,6,0,1,1,NULL,NULL),(55,45,5,15,1,0,NULL,NULL),(56,45,8,25,1,0,NULL,NULL),(57,45,3,123,1,1,NULL,NULL),(58,46,5,15,1,0,'2020-10-00 12:31:52',NULL),(59,46,6,35,1,1,'2020-10-03 12:31:56',NULL),(60,47,5,15,1,0,'2020-10-25 12:34:17',NULL),(61,47,6,35,1,1,'2020-10-28 12:34:19',NULL),(62,47,7,10,1,1,'2020-10-28 12:34:20',NULL),(63,48,8,225,3,0,'2020-10-25 12:45:11',NULL),(64,48,3,123,1,1,'2020-10-28 12:45:19',NULL),(65,49,3,123,1,1,'2020-10-28 12:48:57',NULL),(66,50,8,25,1,0,'2020-10-28 12:52:53',NULL),(67,50,7,10,1,1,'2020-10-25 12:52:56',NULL),(68,51,5,13500,30,1,'2020-10-25 12:57:16',NULL),(69,52,5,15,1,0,'2020-10-28 12:57:29',NULL),(70,53,6,560,4,1,'2020-10-25 13:14:28',NULL),(71,53,7,250,5,1,'2020-10-25 13:14:52',NULL),(72,54,5,135,3,0,'2020-10-28 13:16:29',NULL),(73,54,7,490,7,1,'2020-10-25 13:17:49',NULL),(74,55,6,35,1,1,'2020-11-08 08:22:31',NULL),(75,56,5,15,1,0,'2020-11-26 23:41:09',NULL),(76,56,7,10,1,1,'2020-11-23 23:44:11',NULL),(77,57,6,315,3,1,'2020-11-29 12:52:37',NULL),(78,57,7,160,4,1,'2020-11-29 12:52:44',NULL),(79,58,5,15,1,0,'2020-12-02 12:53:55',NULL),(80,58,6,35,1,1,'2020-11-29 12:54:07',NULL),(81,58,3,123,1,0,'2020-12-02 12:54:12',NULL),(82,62,5,240,4,1,'2021-01-23 23:21:06',NULL),(83,62,6,5040,12,1,'2021-01-17 09:06:41',NULL),(84,67,5,15,1,1,'2021-01-23 23:19:50',NULL),(85,68,5,1500,10,1,'2021-01-23 22:06:19',NULL),(86,69,5,15,1,1,'2021-01-23 23:11:45','2021-01-24 23:07:45'),(87,69,7,1440,12,1,'2021-01-23 23:07:22',NULL),(88,70,5,15,1,1,'2021-01-23 23:19:24','2021-01-26 23:14:03'),(89,71,5,2160,12,1,'2021-01-23 23:15:01','2021-01-26 23:14:26'),(90,72,5,15,1,0,NULL,'2021-01-27 01:25:56'),(91,72,7,10,1,1,'2021-01-24 01:25:59',NULL),(92,73,5,2160,12,0,NULL,'2021-01-27 01:26:32'),(93,73,6,5040,12,1,'2021-01-24 01:26:38',NULL),(94,74,5,2160,12,0,NULL,'2021-01-27 01:30:55'),(95,74,6,5040,12,1,'2021-01-24 01:31:00',NULL),(96,75,5,2160,12,1,'2021-01-24 01:35:10','2021-01-27 01:33:15'),(97,75,7,490,7,1,'2021-01-24 01:33:23',NULL);
/*!40000 ALTER TABLE `servicioproducto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipopersona`
--

DROP TABLE IF EXISTS `tipopersona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipopersona` (
  `idTipoPersona` int NOT NULL,
  `nombreTipoPersona` varchar(75) NOT NULL,
  PRIMARY KEY (`idTipoPersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipopersona`
--

LOCK TABLES `tipopersona` WRITE;
/*!40000 ALTER TABLE `tipopersona` DISABLE KEYS */;
INSERT INTO `tipopersona` VALUES (1,'Natural'),(2,'Jurídica');
/*!40000 ALTER TABLE `tipopersona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoproducto`
--

DROP TABLE IF EXISTS `tipoproducto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipoproducto` (
  `idTipoProducto` int NOT NULL,
  `nombreTipoProducto` varchar(75) NOT NULL,
  PRIMARY KEY (`idTipoProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoproducto`
--

LOCK TABLES `tipoproducto` WRITE;
/*!40000 ALTER TABLE `tipoproducto` DISABLE KEYS */;
INSERT INTO `tipoproducto` VALUES (1,'Final'),(2,'Pre-Elaborado'),(3,'Primario');
/*!40000 ALTER TABLE `tipoproducto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiposervicio`
--

DROP TABLE IF EXISTS `tiposervicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tiposervicio` (
  `idTipoServicio` int NOT NULL,
  `nombreTipoServicio` varchar(75) NOT NULL,
  PRIMARY KEY (`idTipoServicio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiposervicio`
--

LOCK TABLES `tiposervicio` WRITE;
/*!40000 ALTER TABLE `tiposervicio` DISABLE KEYS */;
INSERT INTO `tiposervicio` VALUES (1,'Asesoría'),(2,'Venta');
/*!40000 ALTER TABLE `tiposervicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipousuario`
--

DROP TABLE IF EXISTS `tipousuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipousuario` (
  `idTipoUsuario` int NOT NULL AUTO_INCREMENT,
  `nombreTipoUsuario` varchar(75) NOT NULL,
  PRIMARY KEY (`idTipoUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipousuario`
--

LOCK TABLES `tipousuario` WRITE;
/*!40000 ALTER TABLE `tipousuario` DISABLE KEYS */;
INSERT INTO `tipousuario` VALUES (1,'Administrador'),(2,'Vendedor'),(3,'Encargado Almacen'),(4,'Encargado Preparacion'),(5,'Empleado'),(6,'Cliente');
/*!40000 ALTER TABLE `tipousuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidadmedida`
--

DROP TABLE IF EXISTS `unidadmedida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unidadmedida` (
  `idUnidadMedida` int NOT NULL,
  `nombre` varchar(75) NOT NULL,
  `tipo` tinyint(1) NOT NULL,
  `abreviacion` varchar(75) NOT NULL,
  `fk_idUnidadmedida` int DEFAULT NULL,
  PRIMARY KEY (`idUnidadMedida`),
  KEY `FK_UnidadMedida_UnidadMedida` (`fk_idUnidadmedida`),
  CONSTRAINT `FK_UnidadMedida_UnidadMedida` FOREIGN KEY (`fk_idUnidadmedida`) REFERENCES `unidadmedida` (`idUnidadMedida`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidadmedida`
--

LOCK TABLES `unidadmedida` WRITE;
/*!40000 ALTER TABLE `unidadmedida` DISABLE KEYS */;
INSERT INTO `unidadmedida` VALUES (1,'Litros',0,'Lt             ',NULL),(2,'Kilogramos',0,'Kg             ',NULL);
/*!40000 ALTER TABLE `unidadmedida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `nombreUsuario` varchar(75) NOT NULL,
  `contrasenhaUsuario` varchar(75) NOT NULL,
  `fk_idPersona` int NOT NULL,
  `fk_idTipoUsuario` int NOT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `FK_Usuario_Persona` (`fk_idPersona`),
  KEY `FK_Usuario_Tipo_Usuario` (`fk_idTipoUsuario`),
  CONSTRAINT `FK_Usuario_Persona` FOREIGN KEY (`fk_idPersona`) REFERENCES `persona` (`idPersona`),
  CONSTRAINT `FK_Usuario_Tipo_Usuario` FOREIGN KEY (`fk_idTipoUsuario`) REFERENCES `tipousuario` (`idTipoUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'adminSAVYRM','admin1234ADMIN',1,1),(2,'cliente1','admin1234ADMIN',2,6),(3,'cleinte2','admin1234ADMIN',3,6),(4,'cliente3','admin1234ADMIN',4,6);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'savyrm'
--

--
-- Dumping routines for database 'savyrm'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-24  1:46:13
