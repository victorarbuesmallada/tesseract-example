name := "tesseract-example"

version := "1.0.0"

scalaVersion := "2.12.1"
val ScalaTestVersion = "3.0.1"
val ScalaMockVersion = "3.5.0"
val PdfBoxVersion = "2.0.6"
val Tess4jVersion = "3.4.0"
val ScoptVersion = "3.6.0"

scalacOptions += "-target:jvm-1.7"

resolvers ++= Seq("Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  "Java.net Maven2 Repository" at "http://download.java.net/maven/2/",
  Resolver.bintrayRepo("hseeberger", "maven"))

libraryDependencies ++= {
  Seq(
    "net.sourceforge.tess4j" % "tess4j" % Tess4jVersion,
    "com.github.scopt" %% "scopt" % ScoptVersion,
    "org.apache.pdfbox" % "pdfbox" % PdfBoxVersion,
    "org.apache.pdfbox" % "pdfbox-tools" % PdfBoxVersion,
    "org.scalactic" %% "scalactic" % ScalaTestVersion % Test,
    "org.scalatest" %% "scalatest" % ScalaTestVersion % Test,
    "org.scalamock" %% "scalamock-scalatest-support" % ScalaMockVersion % Test
  )
}

mainClass in (Compile, run) := Some("com.cascomio.tesseract.example.Startup")

mainClass in (Compile, packageBin) := Some("com.cascomio.tesseract.example.Startup")
