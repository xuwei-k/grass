sbtPlugin := true

name := "grass"

organization := "com.github.xuwei_k"

version := "0.1.0-SNAPSHOT"

scalacOptions := Seq("-deprecation", "-unchecked")

ScriptedPlugin.scriptedSettings

ScriptedPlugin.scriptedBufferLog := false

watchSources <++= (ScriptedPlugin.sbtTestDirectory).map{ dir => (dir ***).get }
