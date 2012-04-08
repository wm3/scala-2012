object S2 {
	def main(args: Array[String]): Unit = {
		List(1,2,3).foreach(print)
		println()
		for (x <- List(4,5,6)) print(x)
		println()
	}
	
	def m2(): Unit = {
		val c = (i:Int) => { print(i) }
		var i = 0
		while (i < 10) { c(i); i+=1 }
		println()
	}

	def m1(): Unit = {
		def call(m : String) = println("hello" + m)
		val msg = "world"
		call(msg)
	}
}
