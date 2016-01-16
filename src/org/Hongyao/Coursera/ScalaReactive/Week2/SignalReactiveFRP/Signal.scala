package org.Hongyao.Coursera.ScalaReactive.Week2.SignalReactiveFRP


import scala.util.DynamicVariable


class Signal[T](expr: => T){
  private var myExpr: () => T = _
  private var myValue:T = _
  private var observers :Set[Signal[_]] = Set()
  private var observed: List[Signal[_]]=Nil
  update(expr)

  protected def computeValue():Unit = {
    for(sig<- observed){
      sig.observers -=this
    }
    observed = Nil
    val newValue = Signal.caller.withValue(this)(myExpr())
    myValue = newValue
    val obs = observers
    observers = Set()
    obs.foreach(x=>x.computeValue())
  }

  protected def update(expr: =>T):Unit={
    myExpr = () => expr
    computeValue()
  }

  def apply() = {
    observers += Signal.caller.value
    assert(!Signal.caller.value.observers.contains(this),"cyclic signal defination")
    Signal.caller.value.observed ::= this
    myValue
  }

}

object Signal {
  val caller = new DynamicVariable[Signal[_]](NoSignal)
  def apply[T](expr: => T) = new Signal(expr)
}

object NoSignal extends Signal[Nothing](???){
  override def computeValue() = {}
}

class Var[T](expr: =>T) extends Signal[T](expr){
  override def update(expr: =>T):Unit={
    super.update(expr)
  }
}

object Var {
  def apply[T](expr: => T) = new Var(expr)
}

