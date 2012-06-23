//
// プロジェクト情報
//

name := "finagle-experiment"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.9.1"


//
// 依存性
//

libraryDependencies ++= Seq(
	"com.twitter" % "util-core_2.9.1" % "3.0.0",
	"com.twitter" % "finagle-core_2.9.1" % "3.0.0",
	"com.twitter" % "finagle-http_2.9.1" % "3.0.0"
)

resolvers ++= Seq(
	"Twitter Scala Library Repositories" at "http://maven.twttr.com/"
)
