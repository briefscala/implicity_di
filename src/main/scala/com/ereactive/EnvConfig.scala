package com.ereactive

import java.io.File

import com.typesafe.config.Config

trait EnvConfig[T, P] {
  val c: T
  val dataFile: P

}


object EnvConfig {
  def apply(implicit config: Config): EnvConfig[Config, File] = new EnvConfig[Config, File] {
    val c: Config = config
    val dataFile: File = new File(config.getString("file-path"))
  }
}