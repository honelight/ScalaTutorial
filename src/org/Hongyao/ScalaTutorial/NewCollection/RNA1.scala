package org.Hongyao.ScalaTutorial.NewCollection
import collection.IterableLike
import collection.mutable.{Builder,ArrayBuffer}
import collection.generic.CanBuildFrom

/**
  * Created by hone on 12/26/2015.
  */
final class RNA1 private(val groups: Array[Int], val length:Int) extends IndexedSeq[Base] {
  def apply(idx:Int): Base={
    if(idx<0 || length <= idx){
      throw new IndexOutOfBoundsException
    }
    Base.fromInt(groups(idx/RNA1.N)>>(idx%RNA1.N*RNA1.S)&RNA1.M)
  }
}

object RNA1{
  private val S=2
  private val N=32/S
  private val M=(1<<S)-1
  def fromSeq(buf:Seq[Base]):RNA1={
    val groups=new Array[Int]((buf.length+N-1)/N)
    for(i<-0 until buf.length){
      groups(i/N)|=Base.toInt(buf(i))<<(i%N*S)
    }
    new RNA1(groups, buf.length)
  }
  def apply(bases:Base*)=fromSeq(bases)
}
