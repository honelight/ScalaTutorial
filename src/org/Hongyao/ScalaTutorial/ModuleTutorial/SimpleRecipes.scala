package org.Hongyao.ScalaTutorial.ModuleTutorial

/**
  * Created by hone on 12/27/2015.
  */
trait SimpleRecipes {
  this:SimpleFoods =>
  object FruitSalad extends Recipe("fruit salad", List(Apple, Pear), "Mix it all together"){

  }
  def allRecipes = List(FruitSalad)
}
