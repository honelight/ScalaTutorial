package org.Hongyao.Coursera.ScalaReactive.Week2.Chapter1

/**
  * Created by hone on 1/14/2016.
  */
class BankAccount {
  private var balance =0
  def deposit(amount:Int):Unit={
    if(amount>0){
      balance+=amount
    }
  }
  def withdraw(amount:Int):Int={
    if(0<amount && amount<=balance){
      balance = balance-amount
      return balance
    }
    else{
      throw new Error("insufficient funds")
    }
  }

}
