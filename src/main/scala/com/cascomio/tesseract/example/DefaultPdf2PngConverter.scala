package com.cascomio.tesseract.example

import java.io.File

import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.rendering.{ImageType, PDFRenderer}
import org.apache.pdfbox.tools.imageio.ImageIOUtil

class DefaultPdf2PngConverter extends Pdf2PngConverter {
  override def convert(config: Config): Unit ={
    val document = PDDocument.load(new File(config.filePath))
    val pdfRenderer = new PDFRenderer(document)
    (0 to document.getNumberOfPages() - 1).foreach(i =>
    {
      val bim = pdfRenderer.renderImageWithDPI(i, config.dpi, ImageType.RGB)
      ImageIOUtil.writeImage(bim, config.fileOuput + "-" + (i+1) + ".png", config.dpi)
    })
    document.close();
  }
}
