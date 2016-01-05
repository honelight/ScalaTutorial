package org.Hongyao.ScalaTutorial.Rational

/**
  * Created by hone on 12/29/2015.
  */
class Rational(n:Int, d:Int) {
  require(d!=0)

  private val g = gcd(n.abs,d.abs)
  val numer = if(d<0){-n / g}; else{n / g}
  val denom = d.abs/g

  private def gcd(a:Int, b:Int):Int={
    if(b==0)
      a
    else
      gcd(b,a%b)
  }
  override def equals(other:Any):Boolean= other match{
    case that:Rational=>{
      return  super.equals(that)&&that.canEqual(this)&&that.denom==this.denom&&that.numer==this.numer
    }
    case _ =>{return false}
  }

  override def hashCode: Int={
    return 41+(41+numer)+denom
  }

  override def toString:String = {
    if(denom==1)
      return numer.toString
    else
      return numer+"/"+denom
  }

  def canEqual(other:Any):Boolean = {
    other.isInstanceOf[Rational]
  }
}
