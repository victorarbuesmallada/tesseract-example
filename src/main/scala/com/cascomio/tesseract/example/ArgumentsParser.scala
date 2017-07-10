package com.cascomio.tesseract.example

import scopt.OptionParser

object ArgumentsParser {
  private lazy val parser = createParser()
  private def createParser() : OptionParser[Config] = {
    new scopt.OptionParser[Config]("tesseract") {
      head("tesseract", "1.0.0")

      opt[String]('f',"file-path").action((f, config) => config.copy(filePath = f))
        .text("Filepath of the file to apply OCR over")
        .minOccurs(1)
        .maxOccurs(1)

      opt[String]('o',"file-output").action((o, config) => config.copy(fileOuput = o))
        .text("File output of the result of the OCR process")
        .maxOccurs(1)

      opt[Int]('d',"dpi").action((d, config) => config.copy(dpi = d))
        .text("Image resolution")
        .maxOccurs(1)

      opt[String]('l',"language").action((l, config) => config.copy(language = l))
        .text("OCR language")
        .maxOccurs(1)
    }
  }
  def buildConfig(args: Array[String]): Config = {
    parser.parse(args, Config()).get
  }
}
