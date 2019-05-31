import org.junit.Assert
import org.junit.Test


class StringCalculatorTest{


    @Test
    fun should_return_zero_if_number_is_empty(){
        Assert.assertEquals("0",add(""))
    }

    @Test
    fun should_return_zero_if_length_more_than_3(){
        Assert.assertEquals("0",add("0785"))
    }

    @Test
    fun should_return_zero_if_dots_more_than_1(){
        Assert.assertEquals("0",add("0..8"))
        Assert.assertEquals("0",add("...."))
    }

    @Test
    fun should_return_th_sum(){
        Assert.assertEquals("8",add("0.8"))
        Assert.assertEquals("10",add("1.9"))
    }

    @Test
    fun should_return_right_answer_for_multiple_args(){
        addMultipleArgs("0.8","1.9")
    }
}