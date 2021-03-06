import org.junit.Assert
import org.junit.Test


class StringCalculatorTest{


    @Test
    fun should_return_zero_if_number_is_empty(){
        Assert.assertEquals("0",add(""))
    }

    @Test
    fun should_return_number_if_no_dots(){
        Assert.assertEquals("123",add("123"))
    }

    @Test
    fun should_return_number_if_dots_are_in_the_beginning_or_the_end(){
        Assert.assertEquals("23",add(".23"))
        Assert.assertEquals("23",add("23."))
    }

    @Test
    fun should_return_error_if_number_contains_other_special_chars(){
        Assert.assertEquals("error",add(".?3"))
        Assert.assertEquals("error",add("2!."))
    }

    @Test
    fun should_return_zero_if_length_more_than_3(){
        Assert.assertEquals("0",add("7785"))
    }

    @Test
    fun should_return_zero_if_dots_more_than_1(){
        Assert.assertEquals("0",add("0..8"))
        Assert.assertEquals("0",add("...."))
    }

    @Test
    fun should_return_the_sum(){
        Assert.assertEquals("8",add("0.8"))
        Assert.assertEquals("10",add("1.9"))
    }

    @Test
    fun should_return_right_sum_for_multiple_arguments(){
        Assert.assertEquals("0",addMultipleArgs(""))
        Assert.assertEquals("1",addMultipleArgs("1"))
        Assert.assertEquals("11",addMultipleArgs("1.8.2"))
        Assert.assertEquals("11",addMultipleArgs(".8.3"))
        Assert.assertEquals("error",addMultipleArgs("0..2"))
    }

    @Test
    fun should_return_right_sum_for_multiple_arguments_with_newLine_as_separator(){
        Assert.assertEquals("0",addMultipleArgs(""))
        Assert.assertEquals("1",addMultipleArgs("1"))
        Assert.assertEquals("10",addMultipleArgs("0.8\n2"))
        Assert.assertEquals("11",addMultipleArgs("\n8.3"))
        Assert.assertEquals("error",addMultipleArgs("0.8\n"))
        Assert.assertEquals("error",addMultipleArgs("0.\n2"))
        Assert.assertEquals("error",addMultipleArgs("0\n.2"))
        Assert.assertEquals("error",addMultipleArgs("0,2\n"))
        Assert.assertEquals("error",addMultipleArgs("0\n2."))
    }

    @Test
    fun should_return_error_if_separator_at_the_end(){
        Assert.assertEquals("error",addMultipleArgs("0.8\n"))
        Assert.assertEquals("error",addMultipleArgs("0.2\n"))
        Assert.assertEquals("error",addMultipleArgs("0\n2."))
    }

    @Test
    fun should_return_right_sum_with_delimiter_as_char(){
        Assert.assertEquals("0",addMultipleArgsWithDelimiter(""))
        Assert.assertEquals("error",addMultipleArgsWithDelimiter("/L\nL8"))
        Assert.assertEquals("error",addMultipleArgsWithDelimiter("//L\nL"))
        Assert.assertEquals("error",addMultipleArgsWithDelimiter("//L\nLL8"))
        Assert.assertEquals("10",addMultipleArgsWithDelimiter("//|\n2|8"))
    }

}