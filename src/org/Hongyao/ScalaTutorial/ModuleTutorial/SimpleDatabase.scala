package org.Hongyao.ScalaTutorial.ModuleTutorial

import com.sun.xml.internal.ws.db.glassfish.BridgeWrapper

/**
  * Created by hone on 12/27/2015.
  */
object SimpleDatabase extends Database with SimpleFoods with SimpleRecipes{
  //override def allFoods: List[Food] = List(Apple, Orange, Cream, Sugar)

  //private var categories = List(FoodCategory("fruits", List(Apple, Orange)), FoodCategory("misc", List(Cream,Sugar)))
  //override def allCategories: List[SimpleDatabase.FoodCategory] = categories

  //override def allRecipes: List[Recipe] = List(FruitSalad)
}

object SimpleBrowser extends Browser
{
  override val database: Database = SimpleDatabase
}
