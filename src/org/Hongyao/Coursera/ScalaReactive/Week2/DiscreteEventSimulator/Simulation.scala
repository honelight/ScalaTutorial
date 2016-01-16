package org.Hongyao.Coursera.ScalaReactive.Week2.DiscreteEventSimulator

/**
  * Created by hone on 1/15/2016.
  */
trait Simulation {
  type Action =()=>Unit
  case class Event(time:Int, action:Action)
  private type Agenda = List[Event]
  var agenda:Agenda = List()

  private var currTime = 0
  def getCurrTime:Int={
    return this.currTime
  }

  def afterDelay(delay:Int)(block: =>Unit):Unit={
    val item = Event(this.currTime+delay, ()=>block)
//    println("current time: "+item.time)
    agenda=insert(agenda,item)
  }

  private def insert(ag:Agenda, item: Event):Agenda = ag match{
    case first::rest if (first.time <= item.time) =>{
      return first::insert(rest,item)
    }
    case _ =>{
      return item::ag
    }
  }

  private def loop():Unit = agenda match{
    case first::rest=>{
      agenda = rest
      currTime = first.time
      first.action()
      loop()
    }
    case Nil=>{}
  }

  def run():Unit={
    afterDelay(0) {
      println("*** simulation started time = " + currTime + "***")
    }
    loop()
  }
}
