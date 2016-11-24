package shoppingcart

object ShoppingCartApp extends App{

  print("Shopping cart...........")
  def checkout(shoppingCart: List[String], itemPriceCalculator: Map[String, ItemTotalCalculator]) : String = {
    val itemPrices: Map[String, Int] = Map( "Apple" -> 60, "Orange" -> 25)
    val applesCount: Int = shoppingCart.count(i => i.equals("Apple"))

    val orangesCount: Int = shoppingCart.count(i => i.equals("Orange"))


    val appleItem = new Item("Apple", itemPrices("Apple"), applesCount)

    val orangeItem = new Item("Orange", itemPrices("Orange"), orangesCount)

    val itemsList = List(new Item("Apple", itemPrices("Apple"), applesCount), new Item("Orange", itemPrices("Orange"), orangesCount))

    val checkoutTotal = itemsList.map(i => calculateTotalItemPrice(i, itemPriceCalculator(i.itemType))).reduce( (a, b) => a+ b )

//    val checkoutTotal = calculateTotalItemPrice(appleItem, itemPriceCalculator("Apple")) + calculateTotalItemPrice(orangeItem, itemPriceCalculator("Orange"))

    "£" + checkoutTotal/100.00
  }

  def calculateTotalItemPrice(item: Item, calculator: ItemTotalCalculator): Int = {

    val calculate: Int = calculator.calculate(item)
    print(item.itemType + "===" + calculate)
    return calculate
  }

}


class Item(val itemType: String, val price: Int, val qty:Int){

}

trait ItemTotalCalculator {
  def calculate(item: Item) : Int
}

object Calculator extends ItemTotalCalculator {
  override def calculate(item: Item): Int = {
    item.qty * item.price
  }
}