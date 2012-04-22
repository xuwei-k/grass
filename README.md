# sbt grass plugin

http://www.blue.sky.or.jp/grass

http://d.hatena.ne.jp/yuroyoro/20110601/1306908421

https://github.com/yuroyoro/ProgramGenerator/blob/ac72f2352befade4143d9cef8e1f69258648fcdd/Grass/Grass.scala

add following line to `project/project/plugins.scala`

```scala
import sbt._

object Plugins extends Build {
  lazy val root = Project("root", file(".")) dependsOn(
    uri("git://github.com/xuwei-k/grass.git")
  )
}
```

Then, add the following in your `build.sbt`

```scala
grassSettings
```

[sample project](https://github.com/xuwei-k/grass/tree/master/src/sbt-test/grass/angel)

