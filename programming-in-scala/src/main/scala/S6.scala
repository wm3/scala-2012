object S6 extends App {

	implicit def intToRational(n: Int) = new Rational(n, 1)

	val x = r(1, 2)
	println(x)
	println(x * r(2, 3))
	println(x + r(1, 3))
	println(x max r(1, 3))
	println(x max r(2, 3))
	println(x max r(2, 3))
	println(x `の逆!`)
	println(1 + x)

	def r(n: Int, d: Int) = new Rational(n, d)

	class Rational(n: Int, d: Int) {
		require(d != 0)

		private val g = gcd(n, d)
		val number = n / g
		val denum = d / g

		def this(n: Int) = this(n, 1)

		override def toString = number + "/" + denum
		def +(x: Rational) = r(number * x.denum + denum * x.number, denum * x.denum)
		def *(x: Rational) = r(number * x.number, denum * x.denum)
		def <(x: Rational) = number * x.denum < denum * x.number
		def max(x: Rational) = if (this < x ) x else this
		def `の逆!` = r(denum, number)

		private def gcd(x: Int, y: Int):Int = if (y == 0) x else gcd(y, x % y)
	}
}
