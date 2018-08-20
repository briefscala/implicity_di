package com.ereactive

object TestDI {

  implicit def testReader(implicit env: EnvConfig[Seq[String], Iterator[String]])
  : FileReader[Seq, String] =
    new FileReader[Seq, String] {
      def readContent: Seq[String] = env.dataFile.toSeq
    }
}
