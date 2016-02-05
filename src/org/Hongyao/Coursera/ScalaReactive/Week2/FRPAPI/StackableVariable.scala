package org.Hongyao.Coursera.ScalaReactive.Week2.FRPAPI

/**
  * Created by hone on 1/16/2016.
  */
class StackableVariable[T](init: T) {
  private var values: List[T] = List(init)
  def value :T = values.head
  def withValue[R](newValue:T)(op: =>R):R = {
    values = newValue::values
    try{
      return op
    }
    finally{
      values = values.tail
    }
  }

}
