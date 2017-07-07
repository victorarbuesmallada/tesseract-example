package com.cascomio.tesseract.example

trait OCRProcessor {
  def process(config: Config): String
}
