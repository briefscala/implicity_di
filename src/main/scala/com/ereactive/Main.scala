package com.ereactive

import java.io.File

import com.typesafe.config.{Config, ConfigFactory}

object Main {
  def main(args: Array[String]): Unit = {

    implicit val config: Config = ConfigFactory.load()

    implicit val env: EnvConfig[Config, File] = EnvConfig.apply

    val fileReader = new FileReader()

    fileReader.readContent.foreach(println)

  }

}
