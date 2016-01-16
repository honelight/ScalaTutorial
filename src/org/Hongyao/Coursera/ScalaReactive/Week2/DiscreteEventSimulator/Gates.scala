package org.Hongyao.Coursera.ScalaReactive.Week2.DiscreteEventSimulator

/**
  * Created by hone on 1/15/2016.
  */
abstract class Gates extends Simulation{

  val InverterDelay:Int
  val AndGateDelay:Int
  val OrGateDelay:Int

  def inverter(input:Wire, output:Wire):Unit={
    def invertAction():Unit={
      val inputSig = input.getSignal
      afterDelay(InverterDelay){
        output.setSignal(!inputSig)
      }
    }
    input.addAction(invertAction)
  }

  def andGate(in1:Wire, in2:Wire, output:Wire):Unit={
    def andAction():Unit={
      val in1Sig = in1.getSignal
      val in2Sig = in2.getSignal
      afterDelay(AndGateDelay) {
        output.setSignal(in1Sig & in2Sig)
      }

    }
    in1.addAction(andAction)
    in2.addAction(andAction)
  }

  def orGate(in1:Wire, in2:Wire, output:Wire):Unit={
    def orAction():Unit={
      val in1Sig = in1.getSignal
      val in2Sig = in2.getSignal
      afterDelay(OrGateDelay) {
        output.setSignal(in1Sig | in2Sig)
      }
    }
    in1.addAction(orAction)
    in2.addAction(orAction)
  }

  def probe(name:String, wire:Wire):Unit={
    def probeAction():Unit={
      println(name+ " "+ getCurrTime+" value="+wire.getSignal)
    }
    wire.addAction(probeAction)
  }
}
