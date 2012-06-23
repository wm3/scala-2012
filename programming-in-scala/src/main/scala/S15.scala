object S15 extends App {

	Sign(1) match {
		case Sign("+", x) => println("plus " + x)
		case Sign("-", x) => println("minus " + x)
	}

	-1 match {
		case x if (x > 0) => println("plus " + x)
		case x if (x < 0) => println("minus " + x)
	}

	case class Sign(sign: String, value: Int) {}
	object Sign {
		def apply(value: Int): Sign = {
			if (value > 0) return Sign("+", value)
			if (value < 0) return Sign("-", value)
			Sign("", value)
		}
	}
}
