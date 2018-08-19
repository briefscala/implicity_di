package com.ereactive

object TestDI {

  implicit val envConfig: EnvConfig[Seq[String], Iterator[String]] = new EnvConfig[Seq[String], Iterator[String]] {
    val c: Seq[String] = Seq("test1", "test2", "test3")
    val dataFile: Iterator[String] =  c.toIterator
  }

  implicit def testReader(implicit env: EnvConfig[Seq[String], Iterator[String]]): FileReader[Seq, String] = new FileReader[Seq, String] {
    override def readContent: Seq[String] = env.dataFile.toSeq
  }

}
