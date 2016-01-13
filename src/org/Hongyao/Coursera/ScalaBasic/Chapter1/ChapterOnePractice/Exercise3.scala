package org.Hongyao.Coursera.ScalaBasic.Chapter1.ChapterOnePractice

/**
  * Created by hone on 12/30/2015.
  */
class Exercise3 {
  def countChange(money: Int, coins: List[Int]): Int={
    var count=0
    def countMoney(money:Int, coins: List[Int]):Unit={
      if(money==0) {
        count+=1
        return
      }
      else if(money<0){
        return
      }
      else{
        countMoney(money-coins.head, coins.tail)
      }
    }
    countMoney(money, coins)
    return count
  }
}

object ChangeTest{
  def main(args:Array[String]): Unit ={
    val inputTest = new Exercise3
    println(inputTest.countChange(5,List(1,1,1,1,1,2,2,2,2,2,3,3,3,3,3)))
  }
}
