package com.example

import annotation.tailrec

object Hello {

	def main(args: Array[String]): Unit = {
			println("Hello, world!")
	}

	def fib(n: Int): Int = n match {
		case 0 => 0
		case 1 => 1
		case _ => {
			@tailrec
			def go(m: Int, k: Int, l: Int): Int = m match {
				case 0 => k+l
				case _ => go(m-1, l, k+l)
			}
			go (n-2, 0, 1)
		}
	}

	def isSorted[A] (as: Array[A], ordered: (A,A) => Boolean):Boolean = as.length match {
	case 0 => true
	case 1 => true
	case _ =>     ordered(as(0),as(1)) && isSorted(as.tail, ordered)
	}

	def curry[A,B,C](f: (A,B) => C): A => (B => C) = { (a: A) => { (b: B) => f(a,b) } }
  
	def uncurry[A,B,C](f: A => B => C): (A, B) => C = { (a: A, b: B) => f(a)(b) }
  
	def compose[A,B,C](f: B => C, g: A => B): A => C = (a:A) => f(g(a))

	def tail[A](xs: List[A] ): List[A] = xs match {
		case Nil => Nil
		case h :: t => t
	}

	def setHead[A](newHead: A, xs: List[A]) : List[A] = xs match {
		case Nil => newHead :: Nil
		case h :: t => newHead :: t
	}

	def drop[A] (l: List[A], n: Int): List[A] = l match {
		case Nil => Nil
		case h :: t => {
			drop(t, n-1)
		}
	}

	def dropWhile[A] (l: List[A], p: A => Boolean): List[A] = l match {
		case Nil => Nil
		case h :: t => {
			if (p(h)) dropWhile(t, p) else t
		}
	}
}
