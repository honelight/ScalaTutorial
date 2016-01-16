package org.Hongyao.Coursera.ScalaReactive.Week2.DiscreteEventSimulator

/**
  * Created by hone on 1/15/2016.
  */
abstract class Circuits extends Gates{

  var d:Wire= new Wire
  var e:Wire= new Wire
  def halfAdder(a:Wire, b:Wire, s: Wire, c:Wire): Unit = {

    andGate(a,b,c)
    orGate(a,b,d)
    inverter(c,e)
    andGate(d,e,s)
  }

  def fullAdder(a:Wire, b:Wire, cIn:Wire, s:Wire, cOut:Wire): Unit ={
    val s = new Wire
    val c1 = new Wire
    val c2 = new Wire
    halfAdder(b,cIn, s, c1)
    halfAdder(a, s, c2, s)
    orGate(c2, c1, cOut)
  }
}
