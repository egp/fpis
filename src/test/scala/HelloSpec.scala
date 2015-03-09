package com.example

import org.scalatest._
import org.scalatest.Matchers
import com.example.Hello._

class HelloSpec extends FlatSpec with Matchers {
	val l4 = List(1,2,3,4)

	"isSorted" should "pass on a sorted Int Array" in {
		isSorted(Array(1,2,3,4,5),(a:Int,b:Int) => a < b) shouldEqual true
	}
	it should "fail on unsorted  Int Array1" in {
		isSorted(Array(5,4,3,2,1),(a:Int,b:Int) => a < b) shouldEqual false
	}
	it should "fail on unsorted  Int Array2" in {
		isSorted(Array(1,2,3,5,4),(a:Int,b:Int) => a < b) shouldEqual false
	}
	it should "pass on a sorted String Array" in {
		isSorted(Array("1","2","3","4","5"),(a:String,b:String) => a < b) shouldEqual true
	}
	it should "fail on unsorted  String Array1" in {
		isSorted(Array("1","2","3","5","4"),(a:String,b:String) => a < b) shouldEqual false
	}
	it should "fail on unsorted  String Array2" in {
		isSorted(Array("1","2","3","5","4"),(a:String,b:String) => a < b) shouldEqual false
	}

	"fib" should "calc fib(0)" in {
		fib(0) === (0)
	}
	it should "calc fib(1)" in {
		fib(1) === (1)
	}
	it should "calc fib(5)" in {
		fib(5) === (5)
	}

	"tail" should "handle Nil" in {
		tail(Nil) === (Nil)
	}
	it should "remove head" in {
		tail(l4) == (List(2,3,4))
 	}

 	"drop should" should "drop 0" in {
 		drop(l4, 0) === l4
 	}
 	it should "drop 1" in {
 		drop(l4, 1) === List(2,3,4)
 	}
 	it should "drop 5" in {
 		drop(l4,5) === Nil
 	}

 	"dropWhile" should "drop none" in {
 		dropWhile(l4, (i: Int) => false) === l4
 	}
 	it should "drop 2" in {
 		dropWhile(l4, (i: Int) => i < 3) === List(3,4)
 	}
 	it should "drop all" in {
 		dropWhile(l4, (i: Int) => true) === Nil
 	}
}
