package org.Hongyao.ScalaTutorial.CircuitSimulation

/**
  * Created by hone on 12/21/2015.
  */
object MySImulation extends CircuitSimulation{
  override def InverterDelay = 1
  override def AndGateDelay = 3
  override def OrGateDelay = 5
  def main(args:Array[String]): Unit ={
    val input1, input2, sum, carry = new Wire
    probe("sum", sum)
    probe("carry", carry)
    halfAdder(input1, input2, sum, carry)
    input1.setSignal(true)
    run()
    input2.setSignal(true)
    run()

  }
}
