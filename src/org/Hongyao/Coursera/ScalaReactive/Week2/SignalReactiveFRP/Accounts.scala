package org.Hongyao.Coursera.ScalaReactive.Week2.SignalReactiveFRP

/**
  * Created by hone on 1/16/2016.
  */
object Accounts {
  def consolidated(accts:List[BankAccount]):Signal[Int] = {
    Signal(accts.map(x=>x.balance()).sum)
  }

  def main(args:Array[String]):Unit={
    val a = new BankAccount()
    val b = new BankAccount()
    val c = consolidated(List(a,b))

    println(c())
    a.deposit(20)
    println(c())


  }
}
