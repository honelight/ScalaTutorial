package org.Hongyao.ScalaTutorial.ModuleTutorial

/**
  * Created by hone on 12/27/2015.
  */
trait FoodCategories {
  case class FoodCategory(name:String, foods:List[Food])
  def allCategories:List[FoodCategory]
}
