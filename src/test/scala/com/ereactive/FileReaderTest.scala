package com.ereactive

import org.scalatest._

import TestDI._

class FileReaderTest extends FlatSpec with Matchers {

  val fileReader = new FileReader()

  behavior of "FileReader"

  it should "not be empty" in {

    fileReader.readContent.length should not be 0
  }

}
