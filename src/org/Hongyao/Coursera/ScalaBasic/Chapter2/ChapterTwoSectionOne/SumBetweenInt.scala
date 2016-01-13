package org.Hongyao.Coursera.ScalaBasic.Chapter2.ChapterTwoSectionOne

/**
  * Created by hone on 12/31/2015.
  */
class SumBetweenInt {
  def sum(f:Int=>Int)(a:Int, b:Int):Int={
    def loop(a:Int, acc:Int):Int={
      if(a>b)
        return acc
      else
        return loop(a+1, acc+f(a))
    }
    return loop(a,0)
  }
}
