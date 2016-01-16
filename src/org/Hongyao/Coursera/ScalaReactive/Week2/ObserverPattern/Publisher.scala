package org.Hongyao.Coursera.ScalaReactive.Week2.ObserverPattern

import scala.collection.mutable

/**
  * Created by hone on 1/15/2016.
  */
trait Publisher {
  private var subscribers: Set[Subscriber] = Set()

  def subscribe(subscriber:Subscriber):Unit={
    subscribers+=subscriber
  }

  def unsubscribe(subscriber:Subscriber): Unit ={
    subscribers-=subscriber
  }

  def publish():Unit={
    subscribers.foreach(x=>x.handler(this))
  }
}
