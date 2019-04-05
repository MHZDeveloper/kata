import org.junit.Assert
import org.junit.Test

class FooBarQixKtTest {

    //compute 1

    @Test
    fun should_return_number() {
        //given
        val x = 1

        //when
        val result = compute1(x)

        //then
        Assert.assertEquals("1", result)
    }

    @Test
    fun should_return_0() {
        //given
        val x = 0

        //when
        val result = compute1(x)

        //then
        Assert.assertEquals("0", result)
    }

    @Test
    fun should_return_FooFoo() {
        //given
        val x = 3

        //when
        val result = compute1(x)

        //then
        Assert.assertEquals("FooFoo", result)
    }

    @Test
    fun should_return_BarBar() {
        //given
        val x = 5

        //when
        val result = compute1(x)

        //then
        Assert.assertEquals("BarBar", result)
    }

    @Test
    fun should_return_QixQix() {
        //given
        val x = 7

        //when
        val result = compute1(x)

        //then
        Assert.assertEquals("QixQix", result)
    }

    @Test
    fun should_return_BarFoo() {
        //given
        val x = 53

        //when
        val result = compute1(x)

        //then
        Assert.assertEquals("BarFoo", result)
    }

    @Test
    fun should_return_FooFooFoo() {
        //given
        val x = 33

        //when
        val result = compute1(x)

        //then
        Assert.assertEquals("FooFooFoo", result)
    }

    @Test
    fun should_return_FooBarBar() {
        //given
        val x = 15

        //when
        val result = compute1(x)

        //then
        Assert.assertEquals("FooBarBar", result)
    }

    @Test
    fun should_return_FooBar() {
        //given
        val x = 51

        //when
        val result = compute1(x)

        //then
        Assert.assertEquals("FooBar", result)
    }

    //compute 2

    @Test
    fun should_return_star() {
        //given
        val x = 0

        //when
        val result = compute2(x)

        //then
        Assert.assertEquals("*", result)
    }

    @Test
    fun should_return_1Star1() {
        //given
        val x = 101

        //when
        val result = compute2(x)

        //then
        Assert.assertEquals("1*1", result)
    }

    @Test
    fun should_return_FooFooStarFoo() {
        //given
        val x = 303

        //when
        val result = compute2(x)

        //then
        Assert.assertEquals("FooFoo*Foo", result)
    }

    @Test
    fun should_return_FooBarQixStarBar() {
        //given
        val x = 105

        //when
        val result = compute2(x)

        //then
        Assert.assertEquals("FooBarQix*Bar", result)
    }

    @Test
    fun should_return_FooQixStarStar() {
        //given
        val x = 10101

        //when
        val result = compute2(x)

        //then
        Assert.assertEquals("FooQix**", result)
    }

}