object S8 extends App {

	println((0 until 3).map(_ * 2))
	def r(x: Int, y: Int) = x + y

	println((0 until 4).reduce(r))
}
