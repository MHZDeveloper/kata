
 class Product(val label : String,
               val quantity : Int,
               val unitPrice:Double) {

     fun getTotalPrice():Double{
         return quantity*unitPrice
     }
}