package org.Hongyao.AkkaTutorial

import akka.actor.Actor.Receive
import akka.actor._
import akka.routing.RoundRobinRouter
import scala.concurrent.duration._

/**
  * Created by hone on 1/12/2016.
  */

sealed trait PiMessage
case object Calculate extends PiMessage
case class Work(start:Int, nrOfElements: Int) extends PiMessage
case class Result(value:Double) extends PiMessage
case class PiApproximation(pi:Double, duration:Duration)


class Worker extends Actor{
  override def receive = {
    case Work(start, nrOfElements)=>{
      sender ! Result(calculatePiFor(start, nrOfElements))
    }
  }

  def calculatePiFor(start:Int, nrOfElements:Int):Double= {
    var acc = 0.0
    for (i <- start until (start + nrOfElements)) {
      acc += 4.0 * (1 - (i % 2) * 2)
    }
    return acc
  }
}

class Master(nrOfWorkers:Int, nrOfMessages:Int, nrOfElements:Int, listener:ActorRef) extends Actor{
  var pi:Double = _
  var nrOfResults: Int = _
  val start:Long = System.currentTimeMillis

  val workerRouter = context.actorOf(
    Props[Worker].withRouter(RoundRobinRouter(nrOfWorkers)), name="workerRouter"
  )

  override def receive = {
    case Calculate=>{
      for(i<- 0 until nrOfMessages){
        workerRouter ! Work(i*nrOfElements, nrOfElements)
      }
    }
    case Result(value)=>{
      pi+=value
      nrOfResults +=1
      if(nrOfResults==nrOfMessages){
        listener ! PiApproximation(pi,duration = (System.currentTimeMillis-start).millis)
        context.stop(self)
      }
    }
  }
}

class Pi {

}
