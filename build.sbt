organization := "com.jjgp"
scalaVersion := "2.12.13"
name := "testing-spark"

val sparkVersion = "3.1.1"
val scalaTestVersion = "3.2.5"

libraryDependencies += "org.apache.spark" %% "spark-catalyst" % sparkVersion % "provided"
libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion % "provided"
libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVersion % "provided"

libraryDependencies += "org.scalatest" %% "scalatest" % scalaTestVersion % "test" 
libraryDependencies += "org.apache.spark" %% "spark-catalyst" % sparkVersion % "test" classifier "tests"
libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion % "test" classifier "tests"
libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVersion % "test" classifier "tests"
