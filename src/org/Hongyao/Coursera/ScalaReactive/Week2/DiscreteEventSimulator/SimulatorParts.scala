package org.Hongyao.Coursera.ScalaReactive.Week2.DiscreteEventSimulator



/**
  * Created by hone on 1/15/2016.
  */


object test{
  def main(args:Array[String]):Unit = {
    println("Welcome to the scala worksheet")
    object sim extends Circuits with Parameters
    val in1, in2, sum, carry = new Wire

    sim.halfAdder(in1, in2, sum, carry)
    sim.probe("sum", sum)
    sim.probe("carry", carry)


    println()
    in1.setSignal(true)

    sim.run()
    println()
    in2.setSignal(true)
    sim.run()
    println()
    in1.setSignal(false)
    sim.run()


  }
}

