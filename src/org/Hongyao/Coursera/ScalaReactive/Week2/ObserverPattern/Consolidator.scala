package org.Hongyao.Coursera.ScalaReactive.Week2.ObserverPattern

/**
  * Created by hone on 1/16/2016.
  */
class Consolidator(observed: List[BankAccount]) extends Subscriber {
  observed.foreach(x=>x.subscribe(this))

  private var total:Int = _
  compute()

  private def compute():Unit={
    total = observed.map(x=>x.getBalance()).sum
  }

  def totalBalance = total

  override def handler(pub: Publisher): Unit ={
    compute()
  }
}
