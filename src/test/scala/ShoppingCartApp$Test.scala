package test.scala

import org.scalatest.FunSuite
import shoppingcart.{ItemTotalCalculator, Calculator, ShoppingCartApp}

class ShoppingCartApp$Test extends FunSuite {

  test("shopping cart with only apples calculated correctly") {
    val shoppingCart = List[String]("Apple", "Apple")

    val itemPriceCalculator: Map[String, ItemTotalCalculator] = Map("Apple" -> Calculator, "Orange" -> Calculator)
    assert(ShoppingCartApp.checkout(shoppingCart, itemPriceCalculator) == "£1.2")
  }

  test("shopping cart with apples and oranges calculated correctly") {
    val shoppingCart = List[String]("Apple", "Apple", "Orange", "Apple")
    val itemPriceCalculator: Map[String, ItemTotalCalculator] = Map("Apple" -> Calculator, "Orange" -> Calculator)
    assert(ShoppingCartApp.checkout(shoppingCart, itemPriceCalculator) == "£2.05")
  }
}
