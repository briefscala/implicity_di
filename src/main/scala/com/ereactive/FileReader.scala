package com.ereactive

import java.io.File

import com.typesafe.config.Config

import scala.io.Source

trait FileReader[F[_], T] {

  def readContent: F[T]

}

object FileReader {
  def apply(implicit env: EnvConfig[Config, File]): FileReader[Iterator, String] = new FileReader[Iterator, String] {
    def readContent: Iterator[String] = Source.fromFile(env.dataFile).getLines()
  }
}
