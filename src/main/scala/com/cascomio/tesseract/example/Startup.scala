package com.cascomio.tesseract.example

object Startup extends App {
  try {
    System.load("/usr/local/lib/liblept.so.5")
    System.loadLibrary("tesseract")
  } catch {
    case _ => System.out.println("couldn't load library")
  } finally {
    val ocrProcessor = new DefaultOCRProcessor
    val pdf2PngConverter = new DefaultPdf2PngConverter //TODO: DI
    val config = ArgumentsParser.buildConfig(args)
    pdf2PngConverter.convert(config)
    ocrProcessor.process(config)
  }
}
