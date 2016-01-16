package org.Hongyao.Coursera.ScalaReactive.Week2.ObserverPattern

/**
  * Created by hone on 1/14/2016.
  */
class BankAccount extends Publisher{
  private var balance =0
  def getBalance():Int={
    return this.balance
  }
  def deposit(amount:Int):Unit={
    if(amount>0){
      balance+=amount
      publish()
    }
  }
  def withdraw(amount:Int):Unit={
    if(0<amount && amount<=balance){
      balance = balance-amount
      publish()
    }
    else{
      throw new Error("insufficient funds")
    }
  }

}
