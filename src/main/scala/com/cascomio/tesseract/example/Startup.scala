package com.cascomio.tesseract.example

object Startup extends App {
  try {
    System.load("/usr/local/lib/liblept.so.5")
    System.loadLibrary("tesseract")
  } catch {
    case ex: Exception => System.out.println(ex.getMessage())
  }
  val ocrProcessor = new DefaultOCRProcessor
  val pdf2PngConverter = new DefaultPdf2PngConverter //TODO: DI
  val config = ArgumentsParser.buildConfig(args)
  pdf2PngConverter.convert(config)
  val words = ocrProcessor.process(config)
}
