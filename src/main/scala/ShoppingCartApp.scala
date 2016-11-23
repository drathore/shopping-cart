package shoppingcart

object ShoppingCartApp extends App{
  print("Shopping cart...........")
  def checkout(shoppingCart: List[String]) : String = {

    var sum = 0
    for (item <- shoppingCart)  item match {
      case "Apple" => sum = sum + 60
      case "Orange" => sum = sum + 25
    }

    "£" + sum/100.00
  }

}
