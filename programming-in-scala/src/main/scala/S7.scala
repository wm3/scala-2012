object S7 extends App {

	for (x <- 0 until 10) print(x)
	println()
	println(for (x <- 0 until 10 if (x % 2) == 1) yield(x))
	println(for (x <- 0 until 3; y <- 0 until 3) yield x + "" + y)

	try {
		3 / 0
	} catch {
		case ex: ArithmeticException => println(ex)
	}

	println(3 match {
		case 4 => 'a'
		case _ => 4
	})
}
