package org.Hongyao.Coursera.ScalaReactive.Week2.DiscreteEventSimulator

/**
  * Created by hone on 1/15/2016.
  */
class Wire extends Simulation{
  private var sigVal = false
  private var actions: List[Action] = List()
  def getSignal:Boolean = {
    return this.sigVal
  }
  def setSignal(inputSig:Boolean): Unit ={
    if(inputSig!=sigVal){
      this.sigVal = inputSig
      actions.foreach(x=>x())
    }
  }
  def addAction(a:Action):Unit={
    actions = a::actions
    a()
  }
}