package org.Hongyao.Coursera.ScalaReactive.Week2.FRPAPI


import scala.util.DynamicVariable

/**
  * Created by hone on 1/16/2016.
  */
class Signal[T](expr: =>T) {
  import Signal._
  private var myExpr: ()=>T = _
  private var myValue: T= _
  private var observers:Set[Signal[_]]=Set()
  update(expr)

  def apply():T = {
    observers+=caller.value
    assert(!caller.value.observers.contains(this),"cyclic signal definition")
    return myValue
  }
  protected def update(expr: =>T):Unit={
    myExpr = ()=>expr
    computeValue()
  }

  protected def computeValue(): Unit={
//    myValue = caller.withValue(this)(myExpr())
    val newValue = caller.withValue(this)(myExpr())
    if(myValue!=newValue){
      myValue = newValue
      val obs = observers
      observers = Set()
      obs.foreach(x=>x.computeValue())
    }
  }
}

object Signal{
//  private val caller = new StackableVariable[Signal[_]](NoSignal)
  private val caller = new DynamicVariable[Signal[_]](NoSignal)
  def apply[T](expr: => T) = new Signal(expr)
}

object NoSignal extends Signal[Nothing](???){}

class Var[T](expr: =>T) extends Signal[T](expr){
  override def update(expr: =>T):Unit = super.update(expr)
}

object Var{
  def apply[T](expr: => T) = new Var(expr)
}
