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
      assert(words.contains("aglierini, fagioli & pancetta 8 zucchini fritti 6"))
      assert(words.contains("tortelli burrata (v) 13 fagiolini partenopea 6"))
      assert(words.contains("roast king prawns salmoriglio 18.5 bergamot babé 7"))
      assert(words.contains("aubergine parmigiana (v) 10"))
      assert(words.contains("seabream, courgette & salsa verde 17.5"))
    }
  }
}
