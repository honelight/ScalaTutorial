package org.Hongyao.ScalaTutorial.ModuleTutorial

/**
  * Created by hone on 12/27/2015.
  */
object StudentDatabase extends Database{
  override def allFoods: List[Food] = List(FrozenFood)

  override def allCategories: List[StudentDatabase.FoodCategory] = List(FoodCategory("edible", List(FrozenFood)))

  override def allRecipes: List[Recipe] = List(HeatUp)
}

object FrozenFood extends Food("FronzenFood")
object HeatUp extends Recipe("Heat it up", List(FrozenFood), "Microwave the food for 10 minutes")

object StudentBrowser extends Browser{
  override val database: Database = StudentDatabase
}
