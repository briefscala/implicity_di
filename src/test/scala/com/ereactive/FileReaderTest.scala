package com.ereactive

import org.scalatest._

import TestDI._

class FileReaderTest extends FlatSpec with Matchers {

  behavior of "FileReader"

  it should "not be empty" in {

    implicitly[FileReader[Seq, String]].

      readContent.length should not be 0
  }

}
