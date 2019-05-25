val discounts = arrayListOf<Discounts>(
        Discounts.Discount1,
        Discounts.Discount2,
        Discounts.Discount3,
        Discounts.Discount4,
        Discounts.Discount5)

val taxes = arrayListOf<Taxes>(
        Taxes.Tax1,
        Taxes.Tax2,
        Taxes.Tax3,
        Taxes.Tax4,
        Taxes.Tax5
)

fun generateFinalPrice(products: ArrayList<Product>, taxName: String): Double {
    val totalWithoutTaxes = products.sumByDouble { product -> product.getTotalPrice() }
    val totalDiscounts = generateTotalDiscounts(totalWithoutTaxes)
    val tax = taxes.find { taxes -> taxes.state.equals(taxName) }?.tax
    val priceWithDiscount = totalWithoutTaxes - (totalWithoutTaxes * totalDiscounts)
    val finalPrice = priceWithDiscount + (priceWithDiscount * tax!!)
    print(products,totalWithoutTaxes,totalDiscounts,tax,finalPrice)
    return finalPrice
}

fun generateTotalDiscounts(totalPrice: Double): Double {
    discounts.sortByDescending { discount -> discount.range }
    var totalPriceTmp = totalPrice
    var result = 0.0
    var index = 0
    while (index in discounts.indices) {
        if (totalPriceTmp >= discounts[index].range) {
            result += discounts[index].discount
            totalPriceTmp -= discounts[index].range
        } else {
            index++
        }
    }
    return result
}

fun print(products: ArrayList<Product>, totalPriceWithoutTaxes: Double, totalDiscounts: Double, totalTaxes:Double, totalPriceTaxes: Double){
    var recipe = "label     quantity     unit price     total price\n"
    products.forEach { product -> recipe+= " ${product.label}          ${product.quantity}          ${product.unitPrice}           ${product.getTotalPrice()}\n" }
    recipe += "     ----------------------------------------\n"
    recipe +=" Total without taxes          ${totalPriceWithoutTaxes}\n"
    recipe+=" Discounts                    -${totalDiscounts*100}%\n"
    recipe+=" Tax                          +${totalTaxes}\n"
    recipe += "     ----------------------------------------\n"
    recipe+=" Total price                  ${totalPriceTaxes}"
    println(recipe)
}
