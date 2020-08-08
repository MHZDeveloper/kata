import org.junit.Assert
import org.junit.Test

class LeapYearsTest{

    @Test
    fun should_return_false_when_year_is_not_divisible_by_4(){
        //when & then
        Assert.assertEquals(false,isLeapYear(2017))
        Assert.assertEquals(false,isLeapYear(2018))
        Assert.assertEquals(false,isLeapYear(2019))
    }

    @Test
    fun should_return_true_when_year_is_divisible_by_400(){
        //when & then
        Assert.assertEquals(true,isLeapYear(2000))
    }

    @Test
    fun should_return_false_when_year_is_divisible_by_100_and_not_by_400(){
        //when & then
        Assert.assertEquals(false,isLeapYear(1700))
        Assert.assertEquals(false,isLeapYear(1800))
        Assert.assertEquals(false,isLeapYear(1900))
        Assert.assertEquals(false,isLeapYear(2100))
    }

    @Test
    fun should_return_true_when_year_is_divisible_by_4_and_not_by_100(){
        //when & then
        Assert.assertEquals(true,isLeapYear(2008))
        Assert.assertEquals(true,isLeapYear(2012))
        Assert.assertEquals(true,isLeapYear(2016))
    }

}