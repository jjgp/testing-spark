package com.jjgp.testing.spark

import org.apache.spark.sql.{QueryTest, Row}
import org.apache.spark.sql.test.SharedSparkSession

case class Book(title: String, author: String)
case class Publisher(title: String, publisher: String)
case class BookAndPublisher(title: String, author: String, publisher: String)

class ExamplesQueryTest extends QueryTest with SharedSparkSession {
  import testImplicits._

  test("a simple join") {
    val ab = Seq(("a", "b")).toDF("a", "b")
    val bc = Seq(("b", "c")).toDF("b", "c")

    val df = ab.join(bc, "b")
    val expectedAnswer = Row("b", "a", "c") :: Nil
    checkAnswer(df, expectedAnswer)
  }

  test("using case classes as rows") {
    val books = Seq(Book("foo", "bar")).toDF
    val publisher = Seq(Publisher("foo", "bar")).toDF

    val df = books.join(publisher, "title")
    val expectedAnswer = Seq(BookAndPublisher("foo", "bar", "bar")).toDF
    checkAnswer(df, expectedAnswer)
  }

  test("using case classes for nested fields") {
    
  }
}