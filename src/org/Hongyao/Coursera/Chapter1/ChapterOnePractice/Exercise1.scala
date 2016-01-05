package org.Hongyao.Coursera.Chapter1.ChapterOnePractice

/**
  * Created by hone on 12/30/2015.
  */
class Exercise1 {
  def pascal(c: Int, r: Int): Int={
    if(c==0 || r<2 || c==r)
      return 1
    else
      return pascal(c-1, r-1)+pascal(c, r-1)
  }

  def printPascal(level:Int): Unit ={
    for(i <- 0 to level){
      print(" "*(level-i))
      for(j<- 0 to i){
        print(pascal(j,i)+" ")
      }
      println()
    }
  }
}

object PascalTest{
  def main(args:Array[String]): Unit ={
    val test= new Exercise1
    test.printPascal(3)
  }
}
