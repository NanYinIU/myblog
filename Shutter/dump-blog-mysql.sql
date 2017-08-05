-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: blog
-- ------------------------------------------------------
-- Server version	5.7.18-0ubuntu0.17.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `paper`
--

DROP TABLE IF EXISTS `paper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paper` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `b_name` varchar(100) DEFAULT NULL,
  `b_time` datetime DEFAULT NULL,
  `content` text,
  `mark` int(11) DEFAULT NULL,
  `image_route` varchar(100) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paper`
--

LOCK TABLES `paper` WRITE;
/*!40000 ALTER TABLE `paper` DISABLE KEYS */;
INSERT INTO `paper` VALUES (20,'静态与动态代理以及动态代理代码实现','2017-08-05 21:21:17','## 静态与动态代理以及动态代理代码实现\n#### 一.什么是代理？\n为某个对象创建一个代理。以控制这个对象的访问 。代理类与实现对象类有着同一个接口或者一个父类，代理类负责请求的预处理、过滤、将请求分派给委托类处理、以及委托类执行完请求后的后续处理。\n##### 代理模式类图\n![这里写图片描述](http://img.blog.csdn.net/20170729235116809?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvR0dYX0c=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)\n\n#### 二.静态代理与动态代理的区别\n\n静态代理 所谓的静态代理程序运行前就存在代理类的字节码，也就是说代理类与实体类的关系在程序运行前就已经确定了。\n动态代理 动态代理代理类的源码在程序运行期间才会创建 是通过jvm反射机制创建的就是说代理类与实体类的关系在程序运行时候才确定\n\n#### 三.动态代理代码实现\n##### 首先定义要使用proxy的一个接口\n\n```java\npublic interface HelloWorld {\n    void hello(String str);\n}\n```\n###### 然后定义接口的实现类\n\n```java\npublic class HelloWorldImpl implements HelloWorld{\n    public void hello(String str) {\n        System.out.println(\"hello:\"+str);\n    }\n}\n```\n#####  建立一个动态代理类 也就是要为我们的HelloWorld实现的代理方法\n\n```java\npublic class DynamicProxyTest implements InvocationHandler {\n//    要实现动态代理需要实现InvocationHandler接口\n    private Object HelloWorld;\n\n    public DynamicProxyTest(Object helloWorld) {\n        HelloWorld = helloWorld;\n    }\n	 /*\n	   当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用（关键）\n	 */\n    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {\n        System.out.println(\"hello start===========\");\n        method.invoke(HelloWorld,args);\n     /*\n	    method 的invoke方法的参数：\n        obj - the object the underlying method is invoked from 需要代理的object\n        args - the arguments used for the method call   方法参数\n     */\n        System.out.println(\"hello end==============\");\n        return null;\n    }\n}\n```\n##### Main客户端代码\n\n```java\npublic class Main {\n    public static void main(String[] args) {\n//        代理的对象\n        HelloWorld helloWorld = new HelloWorldImpl();\n//        代理处理方法\n        InvocationHandler handler = new DynamicProxyTest(helloWorld);\n\n        /* newProxyInstance 返回值含义\n         * returns an instance of a proxy class for the specified interfaces\n         * that dispatches method invocations to the specified invocation\n         * handler. 返回一个代理对象类型\n         */\n        HelloWorld h = (HelloWorld) Proxy.newProxyInstance(helloWorld.getClass().getClassLoader(),helloWorld.getClass().getInterfaces(),handler);\n        /*\n         public static Object newProxyInstance(ClassLoader loader,\n                                          Class<?>[] interfaces,\n                                          InvocationHandler h)\nnewProxyInstance 的第一个参数 loader - the class loader to define the proxy class，第二个参数 interfaces - the list of interfaces for the proxy class to implement 代理类去实现的接口列表，第三个参数 h  - the invocation handler to dispatch method invocations to 将方法调用分派到 DynamicProxyTest\n         */\n        h.hello(\"java\");\n        //调用HelloWord的方法\n    }\n}\n```\n##### 实验结果\n------------hello start------------\nhello:java\n------------hello  end------------\n\nProcess finished with exit code 0',1,NULL,'Java');
/*!40000 ALTER TABLE `paper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ressource`
--

DROP TABLE IF EXISTS `ressource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ressource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `source` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ressource`
--

LOCK TABLES `ressource` WRITE;
/*!40000 ALTER TABLE `ressource` DISABLE KEYS */;
INSERT INTO `ressource` VALUES (1,'蜘蛛侠三',1,'/','百度网盘'),(2,'蜘蛛侠二',1,'/','迅雷'),(5,'你妹字数',1,'//','贴吧');
/*!40000 ALTER TABLE `ressource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `work` varchar(100) DEFAULT NULL,
  `moredetail` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'nanyin','Z2d4MTk5NTA5MTk=',23,'1995-09-19','1977713379@qq.com','北京','stu',' ');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'blog'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-05 23:44:12
