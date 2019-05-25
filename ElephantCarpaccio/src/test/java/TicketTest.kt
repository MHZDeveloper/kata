import org.junit.Assert
import org.junit.Test

/**
 * Created by mhz on 22/05/19.
 */
class TicketTest {

    val taxes = arrayListOf<Taxes>(
            Taxes.Tax1,
            Taxes.Tax2,
            Taxes.Tax3,
            Taxes.Tax4,
            Taxes.Tax5
    )

    @Test
    fun generate_right_discounts(){
        //given
        val discounts = arrayListOf<Discounts>(
                Discounts.Discount1,
                Discounts.Discount2,
                Discounts.Discount3,
                Discounts.Discount4,
                Discounts.Discount5)
        val totalPrice = 51000.0

        //when
        val result = generateTotalDiscounts(totalPrice)

        //then
        Assert.assertEquals(0.18,result,0.0)
    }

    @Test
    fun generate_final_price_test_without_discounts(){

        //given
        val products = arrayListOf<Product>(Product("A",2,200.0),
                                            Product("B",1,400.0))
        val taxName = "AL"

        //when
        val result = generateFinalPrice(products,taxName)

        //then
        Assert.assertEquals(832.0,result,0.01)
    }

    @Test
    fun generate_final_price_test_with_discounts(){

        //given
        val products = arrayListOf<Product>(Product("A",4,200.0),
                Product("B",1,400.0))
        val taxName = "AL"

        //when
        val result = generateFinalPrice(products,taxName)

        //then
        Assert.assertEquals(1210.56,result,0.01)
    }

    @Test
    fun printTest(){
        //given
        val products = arrayListOf<Product>(Product("A",4,200.0),
                Product("B",1,400.0))
        val totalPriceWithoutTaxes = 800.0
        val totalDiscounts = 0.15
        val totalTaxes = 43.2
        val totalPrice = 653.2

        //when
        print(products,totalPriceWithoutTaxes,totalDiscounts,totalTaxes,totalPrice)
    }
}