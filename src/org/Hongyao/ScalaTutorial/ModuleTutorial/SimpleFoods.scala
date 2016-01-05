package org.Hongyao.ScalaTutorial.ModuleTutorial

/**
  * Created by hone on 12/27/2015.
  */
trait SimpleFoods {
  object Pear extends Food("Pear")
  def allFoods = List(Apple, Pear)
  def allCategories= Nil
}
