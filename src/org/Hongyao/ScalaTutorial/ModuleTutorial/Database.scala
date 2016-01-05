package org.Hongyao.ScalaTutorial.ModuleTutorial

/**
  * Created by hone on 12/27/2015.
  */
abstract class Database extends FoodCategories{
  def allFoods: List[Food]
  def allRecipes: List[Recipe]
  def foodNamed(name:String)={
    allFoods.find(food=>food.name==name)
  }
}
