import java.util.List;
import java.util.ArrayList;
import java.io.File;

/**
 * <p>ディレクトリ内でのファイル名検索を行うクラスです。
 *
 * <p>検索方法は後方一致、部分一致、正規表現の三つです。
 */
public class FileMatcher {
	private File[] filesHere = (new File(".")).listFiles();

	/** 後方一致検索 */
	public List<File> filesEnding(String query) {
		List<File> result = new ArrayList<File>();

		for (File file : filesHere) {
			if (file.getName().endsWith(query)) result.add(file);
		}
		return result;
	}

	/** 部分一致検索 */
	public List<File> filesContaining(String query) {
		List<File> result = new ArrayList<File>();

		for (File file : filesHere) {
			if (file.getName().contains(query)) result.add(file);
		}
		return result;
	}

	/** 正規表現 */
	public List<File> filesRegex(String query) {
		List<File> result = new ArrayList<File>();

		for (File file : filesHere) {
			if (file.getName().matches(query)) result.add(file);
		}
		return result;
	}
}
