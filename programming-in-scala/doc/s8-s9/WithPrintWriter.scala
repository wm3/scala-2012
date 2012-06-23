import java.io.File
import java.io.PrintWriter

object WithPrintWriter {

	/**
	 * 使用例
	 */
	def main(args: Array[String]) {

		val file = new File("example.txt")

		// 新しい制御構造の呼び出し
		withPrintWriter(file) { out =>
			out.println("Hello, world!")
		}

	}

	/**
	 * 新しい制御構造の定義
	 */
	def withPrintWriter(file: File)(op: PrintWriter => Unit) {
		// Writer を開いて閉じる、という Java でおなじみの構造
		val out = new PrintWriter(file)
		try {
			op(out)
		} finally {
			out.close()
		}
	}

}
