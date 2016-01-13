package org.Hongyao.Coursera.ScalaBasic.Chapter1.ChapterOneSectionFive

/**
  * Created by hone on 12/30/2015.
  */
class FindSqrtRoot{
  private var maxValue = Double.MaxValue
  private var minValue = 0.0
  def sqrtIter(guess:Double, x: Double):Double={
    if(isGoodGuess(guess,x))
      return guess
    else
      return sqrtIter(improveGuess(guess, x),x)
  }

  private def isGoodGuess(guess:Double, x:Double):Boolean={
    return guess*guess<=x+x/1000 && guess*guess>=x-x/1000
  }

  private def improveGuess(guess:Double, x:Double):Double={
    if(guess*guess>x) {
      this.maxValue=guess
    }
    else
      {this.minValue=guess}
    return minValue+(maxValue-minValue)/2

  }
}

object TestSqrt{
  def main(args:Array[String]): Unit ={
    val input = new FindSqrtRoot
    println(input.sqrtIter(1.0, 1e60))
  }
}
