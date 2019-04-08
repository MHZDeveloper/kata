import java.util.function.Predicate

class Discounts{

    val bookPrice = 8.0
    var discounts = ArrayList<DiscountType>()

    fun calculateDiscountedPrice(numberOfBooks:Int, discount:Double): Double{
        return (numberOfBooks*bookPrice)-((numberOfBooks*bookPrice)*discount)
    }

    fun decrementBooks(numberOfBooks: Int, books: ArrayList<Int>){
        for (i in 0..numberOfBooks-1)
            books.set(i,books.get(i)-1)
        books.removeIf({x -> x==0})
    }

    fun estimateIteration(books: ArrayList<Int>):Int{
        return books.fold(0){sum,element -> sum+element}+5
    }

    fun smartShuffle(){
        discounts = arrayListOf<DiscountType>(
                DiscountType.Discount3,
                DiscountType.Discount4,
                DiscountType.Discount5)
        discounts.shuffle()
        discounts.add(DiscountType.Discount2)
        discounts.add(DiscountType.Discount1)
    }


    fun calculatePrice(books: ArrayList<Int>, price: Double): Double {
        val purchase = ArrayList<Int>(books)
        smartShuffle()
        var j = 0
        var temporaryPrice = 0.0
        while (j < discounts.size && temporaryPrice <= price) {
            if (purchase.size >= discounts.get(j).NumberOfBooks) {
                temporaryPrice += calculateDiscountedPrice(discounts.get(j).NumberOfBooks, discounts.get(j).discount)
                decrementBooks(discounts.get(j).NumberOfBooks, purchase)
                j = -1
            }
            j++
        }
        return temporaryPrice
    }

    fun calculateMinimumPrice(books:ArrayList<Int>) : Double{
        var price = 10000000.0
        var temporaryPrice : Double
        books.removeIf(Predicate { x -> x==0 })
        if(books.size>0){
            for (i in 0..estimateIteration(books)){
                temporaryPrice = calculatePrice(books, price)
                if(temporaryPrice<price) price=temporaryPrice
            }
            return price
        }
        else{
            return 0.0
        }
    }
}