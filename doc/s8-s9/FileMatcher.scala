package lib

import java.io.File

/**
 * <p>ディレクトリ内でのファイル名検索を行うクラスです。
 *
 * <p>検索方法は後方一致、部分一致、正規表現の三つです。
 */
object FileMatcher {
	private def filesHere = (new File(".")).listFiles

	private def filesMatching(matcher: String => Boolean) =
		for (file <- filesHere; if matcher(file.getName))
			yield file

	/** 後方一致検索 */
	def filesEnding(query: String) = filesMatching(_.endsWith(query))

	/** 部分一致検索 */
	def filesContaining(query: String) = filesMatching(_.contains(query))

	/** 正規表現 */
	def filesRegex(query: String) = filesMatching(_.matches(query))
}
