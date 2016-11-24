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

    val checkoutTotal = itemsList.map(i => itemPriceCalculator(i.itemType).calculate(i)).reduce( (a, b) => a+ b )


    "£" + checkoutTotal/100.00
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

object BOGOCalculator extends ItemTotalCalculator{
  override def calculate(item: Item): Int = {
    val itemPrice = item.price
    item.qty match {
      case x if x < 2 => itemPrice
      case  _ =>  val qR = BigInt(item.qty) /% 2
        val total: BigInt = (qR._1 + qR._2) * itemPrice
        total.toInt
    }
  }
}

object ThreeFor2Calculator extends ItemTotalCalculator {
  override def calculate(item: Item): Int = {
    val itemPrice = item.price
    item.qty match {
      case x if x < 3 => x * itemPrice
      case  _ =>  val qR = BigInt(item.qty) /% 3
        val total: BigInt = ((qR._1 *  2) +  qR._2) * itemPrice
        total.toInt
    }
  }
}