import org.junit.Assert
import org.junit.Test

/**
 * Created by mhz on 18/05/19.
 */

class FizzBuzzTest {

    @Test
    fun fizzTest() {
        //given
        val x = 3
        val y = 13
        val z = 5


        //when
        val resultForX = fizz(x)
        val resultForY = fizz(y)
        val resultForZ = fizz(z)

        //then
        Assert.assertEquals(true, resultForX)
        Assert.assertEquals(true, resultForY)
        Assert.assertEquals(false, resultForZ)
    }

    @Test
    fun buzzTest() {
        //given
        val x = 5
        val y = 51
        val z = 3

        //when
        val resultForX = buzz(x)
        val resultForY = buzz(y)
        val resultForZ = buzz(z)

        //then
        Assert.assertEquals(true, resultForX)
        Assert.assertEquals(true, resultForY)
        Assert.assertEquals(false, resultForZ)
    }

    @Test
    fun fizzbuzzTest(){

        //given
        val x = 15
        val y = 3
        val z = 5
        val w = 1


        //then
        Assert.assertEquals("fizzbuzz", fizzbuzz(x))
        Assert.assertEquals("fizz", fizzbuzz(y))
        Assert.assertEquals("buzz", fizzbuzz(z))
        Assert.assertEquals("1", fizzbuzz(w))
    }
}