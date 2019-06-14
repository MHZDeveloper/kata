import org.junit.Assert
import org.junit.Test
import kotlin.system.measureTimeMillis


class FiboTest {

    @Test
    fun fiboIterationTest() {
        //given
        val n = 16
        var result = 0

        //when
        val time = measureTimeMillis {
            result = fiboIteration(n)
        }

        //then
        Assert.assertEquals(987, result)
        println("execution time : " + time)
    }

    @Test
    fun fiboRecursionTest() {
        //given
        val n = 16
        var result = 0

        //when
        val time = measureTimeMillis {
            result = fiboRecursion(n)
        }

        //then
        Assert.assertEquals(987, result)
        println("execution time : " + time)
    }

    @Test
    fun fiboIteration2Test() {
        //given
        val n = 16
        var result = 0

        //when
        val time = measureTimeMillis {
            result = fiboIteration2(n)
        }

        //then
        Assert.assertEquals(987, result)
        println("execution time : " + time)
    }

    @Test
    fun fibonacciTest(){
        //given
        val n = 16

        //when
        val result = fibonacci().take(n+1).toList().last()

        //then
        Assert.assertEquals(987,result)
    }

}