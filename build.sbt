name := "datastructure-algorithm"

version := "0.1"

scalaVersion := "2.13"

libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value
libraryDependencies += "org.scalactic"              %% "scalactic"      % "3.0.5"
libraryDependencies += "org.scalatest"              %% "scalatest"      % "3.0.5" % "test"
libraryDependencies += "org.jsoup"                  % "jsoup"           % "1.6.1"
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging"  % "3.9.0"
libraryDependencies += "ch.qos.logback"             % "logback-classic" % "1.2.3"
libraryDependencies += "commons-io"                 % "commons-io"      % "2.6"
libraryDependencies += "org.apache.commons"         % "commons-lang3"   % "3.7"
libraryDependencies += "org.apache.commons"         % "commons-text"    % "1.3"
libraryDependencies += "org.scalaj"                 %% "scalaj-http"    % "2.4.0"
libraryDependencies += "com.typesafe.play"          %% "play-json"      % "2.6.7"
