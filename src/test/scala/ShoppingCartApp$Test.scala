package test.scala

import org.scalatest.FunSuite
import shoppingcart._

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

  test("buy one get one free offer applied on apples") {
    val shoppingCart = List[String]("Apple", "Apple", "Orange", "Orange")
    val itemPriceCalculator: Map[String, ItemTotalCalculator] = Map("Apple" -> BOGOCalculator, "Orange" -> Calculator)
    assert(ShoppingCartApp.checkout(shoppingCart, itemPriceCalculator) == "£1.1")
  }

  test("three for 2 offer applied on oranges") {
    val shoppingCart = List[String]("Apple", "Apple", "Orange", "Orange", "Orange")
    val itemPriceCalculator: Map[String, ItemTotalCalculator] = Map("Apple" -> Calculator, "Orange" -> ThreeFor2Calculator)
    assert(ShoppingCartApp.checkout(shoppingCart, itemPriceCalculator) == "£1.7")
  }

  test("buy one get one free offer applied on apples and three for 2 offer applied on oranges") {
    val shoppingCart = List[String]("Apple", "Apple", "Orange", "Orange", "Orange")
    val itemPriceCalculator: Map[String, ItemTotalCalculator] = Map("Apple" -> BOGOCalculator, "Orange" -> ThreeFor2Calculator)
    assert(ShoppingCartApp.checkout(shoppingCart, itemPriceCalculator) == "£1.1")
  }
}
