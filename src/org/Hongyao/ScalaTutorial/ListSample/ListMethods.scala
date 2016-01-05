package org.Hongyao.ScalaTutorial.ListSample

/**
  * Created by hone on 12/20/2015.
  */
class ListMethods {
  def iSort(xs: List[Int]): List[Int] = xs match{
    case List()=>{List()}
    case x::xsl => insert(x, iSort(xsl))
  }

  def insert(x:Int, xs: List[Int]):List[Int] = xs match{
    case List()=>List(x)
    case y::ys=> {
      if(x>y){
        y::insert(x,ys)
      }
      else{
        x::xs
      }
    }
  }

  def append[T] (xs: List[T], ys: List[T]):List[T]= xs match{
    case List()=>ys
    case x::xsl => x::append(xsl, ys)
  }

  def rev[T] (xs:List[T]):List[T]=xs match{
    case List()=>List()
    case x::xsl=>{
      rev(xsl):::List(x)
    }
  }
}
