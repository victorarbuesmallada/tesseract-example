package com.cascomio.tesseract.example

object Startup extends App {
  System.load("/usr/local/lib/libtesseract.so")
  //System.loadLibrary("tesseract")
  val ocrProcessor = new DefaultOCRProcessor
  val pdf2PngConverter = new DefaultPdf2PngConverter //TODO: DI
  val config = ArgumentsParser.buildConfig(args)
  pdf2PngConverter.convert(config)
  val words = ocrProcessor.process(config)
}
