object S5 extends App {
	m2

	def m2 {
		"max " :: D(0 max 9)
		"min " :: D(0 min 9)
		"min " :: D(-8 abs)
		"capitalize " :: D("int" capitalize)
	}

	def m1 {
		println(x +--- 7)
	}

	object x {
		def +---(x: Int) = x + 3
	}

	object D {
		def apply(expr:Any) = new expr(expr)
		class expr(expr : Any) {
			def ::(name:String) = println(name + " ... " + expr)
		}
	}
}
