package com.cascomio.tesseract.example

object Startup extends App {
  val ocrProcessor = new DefaultOCRProcessor
  val pdf2PngConverter = new DefaultPdf2PngConverter //TODO: DI
  val config = ArgumentsParser.buildConfig(args)
  pdf2PngConverter.convert(config)
  ocrProcessor.process(config)
}
