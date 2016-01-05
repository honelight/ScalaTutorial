package org.Hongyao.ScalaTutorial.CircuitSimulation

import scala.collection.mutable.ListBuffer

/**
  * Created by hone on 12/20/2015.
  */
abstract class Simulation {
  type Action = () => Unit
  case class WorkItem(time:Int, action:Action)

  private var curTime = 0
  def currentTime:Int = curTime

  private var agenda: List[WorkItem] = List()

  private def insert(ag: List[WorkItem], item:WorkItem):List[WorkItem]={
    if(ag.isEmpty||item.time<ag.head.time) item::ag
    else{
      val output:ListBuffer[WorkItem] = ag.to[ListBuffer]
      output+=item
      output.toList
    }
  }

  def afterDelay(delay:Int)(block:()=>Unit)={
    val item=WorkItem(currentTime+delay, block)
    agenda=insert(agenda,item)
  }

  private def next(): Unit = agenda match{
    case item::rest=>{
      agenda=rest
      curTime=item.time
      item.action()
    }

  }

  def run(): Unit ={
    afterDelay(0)(()=>{
      println("*** simulation started, time = "+ currentTime+ " ***")
    })
    while(!agenda.isEmpty){next()}
  }
}
