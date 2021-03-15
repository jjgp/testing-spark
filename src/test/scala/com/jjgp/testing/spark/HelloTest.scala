package com.jjgp.testing.spark

import org.apache.spark.sql.test.SharedSparkSession
import org.apache.spark.sql.QueryTest

class HelloSpec extends QueryTest with SharedSparkSession {
  import testImplicits._

  test("*") {
    val df = Seq(
      "a", "b", "c"
    ).toDF("Column")
    val expectedAnswer = Seq(
      "a", "b", "c"
    ).toDF("Column")

    df.show(false)

    checkAnswer(df, expectedAnswer)
  }
}