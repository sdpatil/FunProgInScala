package chapter2

import scala.annotation.tailrec

/**
  * Created by sunilpatil on 1/24/17.
  * EXERCISE 1 (optional): Write a function to get the nth Fibonacci number. The
first two Fibonacci numbers are 0 and 1, and the next number is always the sum of
the previous two. Your definition should use a local tail-recursive function
  */
object Fibonacci {

  def main(argv:Array[String]): Unit ={
    println(fib(5))
  }

  def fib(n:Int):Int ={
    @tailrec
    def go(first: Int, second: Int, counter:Int):Int ={
      println(s"first -> $first, second -> $second, counter -> $counter")
      if(counter == n) first + second
      else go(second,first + second,counter+1)
    }

    go(0,1,1)
  }
}
