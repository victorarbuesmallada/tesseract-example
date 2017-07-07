import java.io.File

import com.cascomio.tesseract.example.{Config, DefaultOCRProcessor, OCRProcessor}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}

class DefaultOCRProcessorTests extends WordSpecLike
  with BeforeAndAfterAll
  with Matchers {
  "A png image" should {
    "be OCR'd to an acceptable text output" in {
      val processor = new DefaultOCRProcessor
      val filePath = getClass.getResource("/menu2.pdf").getPath
      val config = new Config(filePath, filePath)

      val words = processor.process(config)

      assert(words.length > 0)
    }
  }
}
