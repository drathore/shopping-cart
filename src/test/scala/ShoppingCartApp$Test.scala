package test.scala

import org.scalatest.FunSuite
import shoppingcart.ShoppingCartApp

class ShoppingCartApp$Test extends FunSuite {

  test("shopping cart with only apples calculated") {
    val shoppingCart = List[String]("Apple", "Apple")
    assert(ShoppingCartApp.checkout(shoppingCart) == "£1.2")
  }
}
