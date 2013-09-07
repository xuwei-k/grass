sbtPlugin := true

name := "grass"

organization := "com.github.xuwei_k"

version := "0.1.0-SNAPSHOT"

scalacOptions := Seq("-deprecation", "-unchecked")

ScriptedPlugin.scriptedSettings

ScriptedPlugin.scriptedBufferLog := false

scriptedLaunchOpts ++= sys.process.javaVmArguments.filter(
  a => Seq("-Xmx","-Xms","-XX").exists(a.startsWith)
)

watchSources <++= (ScriptedPlugin.sbtTestDirectory).map{ dir => (dir ***).get }

publishTo := sys.env.get("MAVEN_DIRECTORY").map{ dir =>
  Resolver.file("gh-pages",file(dir))(Patterns(true, Resolver.mavenStyleBasePattern))
}
