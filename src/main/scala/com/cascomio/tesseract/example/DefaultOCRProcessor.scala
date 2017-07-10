package com.cascomio.tesseract.example

import java.io._

import net.sourceforge.tess4j.{ITesseract, Tesseract}

class DefaultOCRProcessor extends OCRProcessor {
  private lazy val tesseract: ITesseract = buildTesseract()

  private def buildTesseract(): ITesseract = {
    val tesseract = new Tesseract
    val tessdataPrefix =System.getenv("TESSDATA_PREFIX")
    val path = if(tessdataPrefix == null || tessdataPrefix.length == 0)
                  new File("src/main/resources").getAbsolutePath
               else
                  tessdataPrefix
    tesseract.setDatapath(path)
    tesseract
  }

  override def process(config: Config): String = {
    tesseract.setLanguage(config.language)
    val inputFile = new File(config.filePath)
    val parentFolder = new File(inputFile.getParent)
    val imageFiles = parentFolder.listFiles(new FileFilter {
      override def accept(f: File): Boolean = {
        val path = f.getAbsolutePath
        path.startsWith(config.filePath) &&
          path.toLowerCase().endsWith("png")
      }
    })
    val words = imageFiles.foldLeft("")((acc, f) => {
      acc + " " + tesseract.doOCR(f)
    })

    val writer = new FileOutputStream(config.fileOuput)
    val printStream = new PrintStream(writer)
    printStream.print(words)

    imageFiles.foreach(_.delete)

    words
  }
}
