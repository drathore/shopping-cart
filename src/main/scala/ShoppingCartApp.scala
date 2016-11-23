package shoppingcart

object ShoppingCartApp extends App{
  print("Shopping cart...........")
  def checkout(shoppingCart: List[String]) : String = {

    val total = shoppingCart.size * 60
    "£" + total/100.00
  }

}
