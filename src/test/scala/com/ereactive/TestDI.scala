package com.ereactive

import com.typesafe.config.{Config, ConfigFactory}

object TestDI {

  implicit val config: Config = ConfigFactory.parseString(
    """
      |file-path : "./src/test/resources/data.csv"
    """.stripMargin
  )

  implicit val envConfig: EnvConfig[Map[String, List[String]], List[String]] = new EnvConfig[Map[String, List[String]], List[String]] {
    val c: Map[String, List[String]] = Map("file-path" -> List("test1", "test2", "test3"))
    val dataFile: List[String] = c.getOrElse("file-path", Nil)
  }

  implicit val testEnv = EnvConfig.apply

}
