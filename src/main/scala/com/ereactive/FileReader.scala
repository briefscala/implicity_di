package com.ereactive

import java.io.File

import com.typesafe.config.Config

import scala.io.Source

class FileReader()(implicit env: EnvConfig[Config, File]) {

  def readContent: Iterator[String] = Source.fromFile(env.dataFile).getLines()

}
