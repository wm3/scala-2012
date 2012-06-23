object S9 extends App {

	println(zipWith((0 to 3), (1 to 4), (_:Int) + (_:Int)))
	logx("param") { x => println("  " + x + x) }
	logx2("param") { x => println("  " + x + x) }
	log("param") { println("  xxx") }
	println((1 to 5).fold(1) { (x, y) => x * y })

	def zipWith[X, Y, Z](x: Iterable[X], y: Iterable[Y], z: (X, Y) => Z) =
		for (xy <- x.zip(y)) yield(z(xy._1, xy._2))

	def log(name: String)(op: => Unit) = logx(name)((x: String) => op)
	def logx(name: String)(op: String => Unit) {
		println("start: " + name)
		op(name)
		println("end: " + name)
	}
	def logx2(name: String) = { op:(String => Unit) => 
		println("start: " + name)
		op(name)
		println("end: " + name)
	}
}
