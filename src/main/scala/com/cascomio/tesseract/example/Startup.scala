package com.cascomio.tesseract.example

import net.sourceforge.tess4j.Tesseract

object Startup extends App {
  val tesseract = new Tesseract
  args.foreach(println)
}
