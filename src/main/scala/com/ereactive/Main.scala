package com.ereactive

import com.typesafe.config.{Config, ConfigFactory}

object Main {
  def main(args: Array[String]): Unit = {

    implicit val config: Config = ConfigFactory.load()

    val fileReader = FileReader.apply

    fileReader.readContent.foreach(println)

  }

}
