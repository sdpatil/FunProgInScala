package scalacourse.week2

import scala.annotation.tailrec

/**
  * Created by sunilpatil on 1/24/17.
  */
object SumInts {

  def main(argv: Array[String]): Unit = {
    println("sumIntsTail(1,5) " + sumIntsTailGeneric(id,1, 5))


    println("sumInts(1,5) " + sumInts(1, 5))
    println("sumCubes(1,5) " + sumCubes(1, 5))
    println("sumFactorials(1,5) " + sumFactorials(1, 5))

    println("sum(id,1,5) " + sumIntsTailGeneric(id, 1, 5))
    println("sum(cube,1,5) " + sumIntsTailGeneric({
      def f(x: Int) = x * x * x; f
    }, 1, 5))
    println("sum(factorial,1,5) " + sumIntsTailGeneric(factorial, 1, 5))

  }

  def sumIntsc = sumC(x => x)
  def sumCubesc = sumC(x => x*x*x)
  def sumFactsc = sumC(factorial)

  def sumC(f:Int =>Int):(Int,Int) => Int ={
    def sumF(a:Int, b:Int):Int =
      if(a >b)
        0
      else
          f(a) + sumF(a+1,b)
    sumF
  }

  def sumC1(f:Int => Int)(a:Int, b:Int):Int ={
    if(a>b)
      0
    else
      f(a) + sumC1(f)(a+1,b)
  }

  def sumIntsTail(a: Int, b: Int): Int = {
    @tailrec
    def go(c: Int, acc: Int): Int = {
      if (c > b)
        acc
      else
        go(c + 1, acc + c)
    }

    go(a, 0)
  }

  def sumIntsTailGeneric(f: Int =>Int, a: Int, b: Int): Int = {
    @tailrec
    def go(c: Int, acc: Int): Int = {
      if (c > b)
        acc
      else
        go(c + 1, acc + f(c))
    }

    go(a, 0)
  }

  def sum(f: Int => Int, a: Int, b: Int): Int = {
    if (a > b)
      0
    else
      f(a) + sum(f, a + 1, b)
  }

  def sumInts(a: Int, b: Int): Int = {
    if (a > b)
      0
    else
      a + sumInts(a + 1, b)
  }

  def sumCubes(a: Int, b: Int): Int = {
    if (a > b)
      0
    else
      cube(a) + sumCubes(a + 1, b)
  }

  def sumFactorials(a: Int, b: Int): Int = {
    if (a > b)
      0
    else
      factorial(a) + sumFactorials(a + 1, b)
  }

  def id(x: Int): Int = x

  def cube(x: Int): Int = x * x * x

  def factorial(x: Int): Int = {
    if (x < 1)
      1
    else
      x * factorial(x - 1)
  }
}
