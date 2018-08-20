package com.ereactive

import org.scalatest._

class FileReaderTest extends FlatSpec with Matchers {
  import TestDI._

  /**
    * this contrived implementation of a EnvConfig is needed here to show
    * that we can invoke a different implementation of FileReader implicitly
    *
    * If this implicit value of EnvConfig wasn't in scope out test FileReader
    * instance couldn't be found.
    */
  implicit val envConfig: EnvConfig[Seq[String], Iterator[String]] =
    new EnvConfig[Seq[String], Iterator[String]] {
      val c: Seq[String] = Seq("test1", "test2", "test3")
      val dataFile: Iterator[String] =  c.toIterator
    }

  behavior of "FileReader"

  it should "not be empty" in {

    implicitly[FileReader[Seq, String]].

      readContent.nonEmpty shouldBe true
  }

}
