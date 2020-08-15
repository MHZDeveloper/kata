import org.junit.Assert
import org.junit.Test

class MainTest{

    @Test
    fun should_correct_list_of_integer() {
        //given
        val x = 54231

        //when
        val result = x.toList()

        //then
        Assert.assertEquals(5,result.get(0))
        Assert.assertEquals(4,result.get(1))
        Assert.assertEquals(2,result.get(2))
        Assert.assertEquals(3,result.get(3))
        Assert.assertEquals(1,result.get(4))
    }

    @Test
    fun should_return_correct_value_using_naive_multiplication() {
        Assert.assertEquals(10,naiveMultiplication(5,2))
        Assert.assertEquals(300,naiveMultiplication(50,6))
    }

    @Test
    fun should_return_correct_value_using_karatsuba_multiplication() {
        Assert.assertEquals(10,karatsubaMultiplication(5,2))
        Assert.assertEquals(300,karatsubaMultiplication(50,6))
        Assert.assertEquals(5332114,karatsubaMultiplication(1234,4321))
    }
}