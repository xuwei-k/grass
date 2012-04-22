package com.github.xuwei_k.grass

import sbt._,Keys._

object Plugin extends sbt.Plugin{
  case class GrassToken(w:List[String],f:List[String],v:List[String])
  
  lazy val grassSourceDirectory = SettingKey[File]("grass-source-directory") 
  lazy val grassSourceFiles = TaskKey[Seq[File]]("grass-source-files") 
  lazy val grassTokens = SettingKey[GrassToken]("grass-tokens") 
  lazy val grassRun = TaskKey[Unit]("grass-run") 

  val grassSettings:Seq[sbt.Project.Setting[_]] = Seq(
    (grassSourceDirectory in Compile) <<= (sourceDirectory in Compile){_ / "grass"},
    (grassSourceFiles in Compile) <<= (grassSourceDirectory in Compile).map{ _ ** "*.grass" get},
    watchSources in GlobalScope <++= grassSourceFiles in Compile,
    grassTokens := GrassToken(List("w"),List("W"),List("v")),
    grassRun <<= (
      grassSourceFiles in Compile,grassTokens
    ).map{case (files,GrassToken(w,f,v)) =>
      files.foreach{ file =>
        val g = new GrassParser(w,f,v)
        g.run(IO.readLines(file).mkString)
      }
    }
  )

}

