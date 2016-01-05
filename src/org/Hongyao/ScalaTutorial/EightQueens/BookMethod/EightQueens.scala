package org.Hongyao.ScalaTutorial.EightQueens.BookMethod

/**
  * Created by hone on 12/24/2015.
  */
class EightQueens {
  type game = (String, String)
  case class Book(title:String, authors: String*)

  val time = List[game](("1","2"),("2","3"))
  val books = List[Book](Book("title","here we go"))

  def queens(n: Int) :List[List[(Int, Int)]]={
    def placeQueens(k:Int):List[List[(Int, Int)]]={
      if(k==0)
        List(List())
      else {
        for {queens <- placeQueens(k - 1)
             column <- 1 to n
             queen = (k, column)
             if isSafe(queen, queens)
        } yield queen :: queens
      }
    }
    def isSafe(queen:(Int, Int), queens:List[(Int,Int)]):Boolean={
      queens.forall(q => !inCheck(queen,q))
    }

    def inCheck(q1:(Int, Int), q2:(Int, Int))={
      q1._1==q2._1||q1._2==q2._2||(q1._1-q2._1).abs==(q1._2-q2._2).abs
    }
    placeQueens(n)
  }
}
