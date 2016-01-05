package org.Hongyao.ScalaTutorial.ModuleTutorial

/**
  * Created by hone on 12/27/2015.
  */
abstract class Browser {
  val database:Database

  def recipesUsing(food:Food)={
    database.allRecipes.filter(recipe=>recipe.ingredients.contains((food)))
  }

  def displayCategory(category: database.FoodCategory)={
    println(category)
  }
}
