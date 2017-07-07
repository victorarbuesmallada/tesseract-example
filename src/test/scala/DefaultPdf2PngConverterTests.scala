import java.io.{File, FileFilter}

import com.cascomio.tesseract.example.{Config, DefaultPdf2PngConverter}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}

class DefaultPdf2PngConverterTests extends WordSpecLike
  with BeforeAndAfterAll
  with Matchers {
  "A pdf to png converter" should {
    "convert the provided file to png" in {
      val converter = new DefaultPdf2PngConverter
      val filePath = getClass.getResource("/menu.pdf").getPath
      val parentFilePath = new File(filePath).getParent
      val config = new Config(filePath, filePath)

      converter.convert(config)

      val createdFiles = new File(parentFilePath).listFiles(new FileFilter {
        override def accept(path: File): Boolean = {
          val pathname = path.getAbsolutePath
          pathname.startsWith(config.filePath) &&
            pathname.toLowerCase().endsWith("png")
        }
      })
      assert(createdFiles.size > 0, "No png files created")
    }
  }
}
