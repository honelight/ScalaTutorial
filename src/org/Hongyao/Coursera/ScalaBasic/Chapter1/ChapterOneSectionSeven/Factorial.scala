package org.Hongyao.Coursera.ScalaBasic.Chapter1.ChapterOneSectionSeven

/**
  * Created by hone on 12/30/2015.
  */
class Factorial {
  private var output = 1
  def factorial(input:Int):Int={
    require(input>=0)
    if(input==0)
      output
    else{
      output*=input
      factorial(input-1)
    }
  }
}

object TestFactorial{
  def main(args:Array[String]): Unit ={
    val testObject = new Factorial
    println(testObject.factorial(4))
  }
}
