object S10 extends App {

	abstract class Element {
		def contents: Array[String]
	}
	object Element {
	}

	class ArrayElement(
		val contents: Array[String]
	) extends Element {
	}

	class LineElement(
		s: String
	) extends ArrayElement(Array(s)) {
		override def toString = s
	}

	val vs = List[AnyRef](3: java.lang.Integer, new java.lang.Integer(4))
	println(vs(0).getClass)

	class Version(val major: Int, val minor: Int) extends Ordered[Version] {
		def compare(that: Version) = {
			val m = major - that.major
			if (m != 0) m else minor - that.minor
		}
	}
}
