package org.Hongyao.Coursera.ScalaReactive.Week2.ObserverPattern

/**
  * Created by hone on 1/16/2016.
  */
object Observers {
  def main(args:Array[String]): Unit ={
    println("Welcome to the Scala worksheet")
    val a = new BankAccount
    val b = new BankAccount
    val c = new Consolidator(List(a,b))

    println(c.totalBalance)

    a.deposit(20)
    println(c.totalBalance)

    b.deposit(30)

    println(c.totalBalance)
  }

}
