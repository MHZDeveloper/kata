import org.junit.Assert
import org.junit.Test

class DiscountsTest{

    val discounts = Discounts()

    @Test
    fun should_return_0(){
        //given
        val purchase = arrayListOf<Int>(0,0,0,0,0)
        //when
        val result = discounts.calculateMinimumPrice(purchase)
        //then
        Assert.assertEquals(0.0,result,0.0)
    }

    @Test
    fun should_return_price_of_one_book(){
        //given
        val purchase = arrayListOf<Int>(1,0,0,0,0)
        //when
        val result = discounts.calculateMinimumPrice(purchase)
        //then
        Assert.assertEquals(8.0,result,0.0)
    }

    @Test
    fun should_return_price_of_two_different_books(){
        //given
        val purchase = arrayListOf<Int>(0,0,0,1,1)
        //when
        val result = discounts.calculateMinimumPrice(purchase)
        //then
        Assert.assertEquals(15.2,result,0.0)
    }

    @Test
    fun should_return_price_of_three_different_books(){
        //given
        val purchase = arrayListOf<Int>(0,0,1,1,1)
        //when
        val result = discounts.calculateMinimumPrice(purchase)
        //then
        Assert.assertEquals(21.6,result,0.0)
    }

    @Test
    fun should_return_price_of_four_different_books(){
        //given
        val purchase = arrayListOf<Int>(0,1,1,1,1)
        //when
        val result = discounts.calculateMinimumPrice(purchase)
        //then
        Assert.assertEquals(25.6,result,0.0)
    }

    @Test
    fun should_return_price_of_five_different_books(){
        //given
        val purchase = arrayListOf<Int>(1,1,1,1,1)
        //when
        val result = discounts.calculateMinimumPrice(purchase)
        //then
        Assert.assertEquals(30.0,result,0.0)
    }

    @Test
    fun should_return_price_of_eight_books(){
        //given
        val purchase = arrayListOf<Int>(2,2,2,1,1)
        //when
        val result = discounts.calculateMinimumPrice(purchase)
        //then
        Assert.assertEquals(51.2,result,0.0)
    }

    @Test(timeout = 40)
    fun should_return_correct_price_less_than_40ms(){
        //given
        val purchase = arrayListOf<Int>(2,3,2,4,5)
        //when
        val result = discounts.calculateMinimumPrice(purchase)
        //then
        Assert.assertEquals(104.8,result,0.0)
    }
}