package org.Hongyao.Coursera.ScalaReactive.Week2.ObserverPattern

/**
  * Created by hone on 1/15/2016.
  */
trait Subscriber {
  def handler(pub:Publisher)
}
