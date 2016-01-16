package org.Hongyao.Coursera.ScalaReactive.Week2.Chapter1

/**
  * Created by hone on 1/14/2016.
  */
object Account {
  def main(args:Array[String]): Unit ={
    println("Welcom to the scala worksheet")
    val acct = new BankAccount

    val input = List(1,2,3,4,5)
    input.foreach(x=>x+1)
    println(input)
  }
}
