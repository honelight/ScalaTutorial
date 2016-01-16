package org.Hongyao.Coursera.ScalaReactive.Week2.SignalReactiveFRP

/**
  * Created by hone on 1/14/2016.
  */
class BankAccount{
  val balance = Var(0)
  def getBalance():Int={
    return this.balance()
  }
  def deposit(amount:Int):Unit={
    if(amount>0){
      val b = balance()
      balance() = b+amount
    }
  }
  def withdraw(amount:Int):Unit={
    if(0<amount && amount<=balance()){
      val b = balance()
      balance() = b -amount
    }
    else{
      throw new Error("insufficient funds")
    }
  }

}
