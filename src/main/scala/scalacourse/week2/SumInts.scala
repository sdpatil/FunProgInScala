package scalacourse.week2

/**
  * Created by sunilpatil on 1/24/17.
  */
object SumInts {

  def main(argv:Array[String]): Unit ={
    println(sumInts(1,5))
  }

  def sumInts(a:Int, b:Int): Int ={
    if(a>b)
      0
    else
      a + sumInts(a+1,b)
  }
}
