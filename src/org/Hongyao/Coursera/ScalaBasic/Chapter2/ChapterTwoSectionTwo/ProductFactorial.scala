package org.Hongyao.Coursera.ScalaBasic.Chapter2.ChapterTwoSectionTwo

/**
  * Created by hone on 12/31/2015.
  */
class ProductFactorial {
  def calculate(f:Int=>Int)(a:Int,b:Int, zero:Int)(g:(Int,Int)=>Int):Int={
    if(a>b)
      return zero
    else
      return g(f(a),calculate(f)(a+1,b, zero)(g))
  }
}

object ProductTest{
  def main(args:Array[String]): Unit ={
    val input = new ProductFactorial
    println(input.calculate(x=>x)(1,5,1)((x,y)=>x*y))
  }
}
