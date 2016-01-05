package org.Hongyao.Coursera.Chapter6.Section6

/**
  * Created by hone on 1/4/2016.
  */
object Polynomials {
  class Poly(term0:Map[Int, Double]){
    val terms = term0.withDefaultValue(0.0)
    def + (other:Poly):Poly={
      new Poly(terms ++ (other.terms.map(adjust)))
    }
    def adjust(term:(Int, Double)):(Int, Double)={
      val exp = term._1
      val coeff= term._2
      terms.get(exp) match{
        case Some(coeff1) => exp->(coeff+coeff1)
        case None => exp->coeff
      }
    }

    override def toString:String = {
      val result =  ((for((exp, coeff)<- terms.toList.sorted.reverse) yield coeff+"x^"+exp).mkString(" + "))
      return result
    }
  }

  val p1 = new Poly(Map(1->2.0, 3->4.0, 5->6.2))
  val p2 = new Poly(Map(0->3.0, 3->7.0))
  p1+p2

}
