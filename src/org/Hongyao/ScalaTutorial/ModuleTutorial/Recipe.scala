package org.Hongyao.ScalaTutorial.ModuleTutorial

/**
  * Created by hone on 12/27/2015.
  */
class Recipe (
  val name:String,
  val ingredients:List[Food],
  val instructions:String)
{
  override def toString = name
}
