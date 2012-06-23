object S3 {
	def main(args:Array[String]):Unit = m6

	def m6() = {
		def source() = scala.io.Source.fromFile("src/main/scala/S3.scala")
		var last = ""
		for (l <- source.getLines()) {
			last = l
		}
		println(last)
		println(source.getLines.length)
	}

	def m5() = {
		val s1 = Set(1,3,5)
		var s2 = Set(1,3,5)
		val s3 = scala.collection.mutable.Set(1,3,5)
		"add val " :: s1 + 4 :::x
		"add var " :: s2 + 4 :::x
		"add mut " :: s3 + 4 :::x
		//"push val " :: (s1 += 4, s1) :::x
		"push var " :: (s2 += 4, s2) :::x
		"push mut " :: (s3 += 4, s3) :::x

		val m = Map(3 -> 4)
		"map " :: m :::x
	}

	def m4() = {
		val t2 = ("a","b")
		"tuple1" :: t2._1 :::x
		"tuple2" :: t2._2 :::x

		//val tx = (1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3)
		val tx = (1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2)
		"tuplex" :: tx :::x
	}

	def m3() = {
		"Nil" :: (Nil)           :::x
		":: " :: (1 :: 2 :: Nil) :::x

		val nums = 0 to 10
		"count    " :: nums.count(n => n % 2 == 0) :::x
		"drop     " :: nums.drop(3)                :::x
		"dropRight" :: nums.dropRight(3)           :::x
		"exists   " :: nums.exists(n => n == 10)   :::x
		"filter   " :: nums.filter(n => ! (2 to n - 1).exists(i => n % i == 0)) :::x
		"forall   " :: nums.forall(n => n * n < 101) :::x
		"foreach  " :: nums.foreach(n => true) :::x
		"head     " :: nums.head                     :::x
		"tail     " :: nums.tail                     :::x
		"last     " :: nums.last                     :::x
		"init     " :: nums.init                     :::x
		"reverse  " :: nums.reverse                  :::x
		"isEmpty  " :: nums.isEmpty                  :::x
		"length   " :: nums.length                   :::x
		"mkString " :: nums.mkString("-")            :::x

		def calc(n:Int) = n % 3 + n % 2
		"map      " :: nums.map(calc)  :::x
		//"remove   " :: nums.remove(n => ! (2 to n - 1).exists(i => n % i == 0)) :::x
		//"sort     " :: nums.sort((n,m) => calc(n) < calc(m)) :::x
		//"sort     " :: nums.map(n=>n).sort((n,m) => calc(n) < calc(m)) :::x
	}

	def m2() = {
		val x = List(1,2,3)
		val y = List(4,5,6)
		println(x:::y)
		println(x::y)
	}

	def m1() = {
		val v = 0 to 3
		println(v)
	}

	object x {
		def :::(expr:Any) = new expr(expr)
		//def :::(expr:Object) = new expr(expr)
	}

	class expr(expr : Any) {
		def ::(name:String) = println(name + " ... " + expr)
	}
}
