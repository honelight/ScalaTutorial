package org.Hongyao.Coursera.ScalaBasic.Chapter3

/**
  * Created by hone on 1/1/2016.
  */
trait List[T] {
  val head:T
  val tail:List[T]
  def isEmpty:Boolean
}

class Cons[T](inputhead:T, inputtail:List[T])extends List[T]{
  def isEmpty=false
  val head = inputhead
  val tail:List[T] = inputtail
}

class Nil[T] extends List[T]{
  override val head: Nothing = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override val tail: Nothing = throw new NoSuchElementException
}

trait TestTrait[X]{
  def method(elem:X):X
}


