import org.junit.Assert
import org.junit.Test

/**
 * Created by mhz on 25/05/19.
 */
class ProductTest{

    @Test
    fun should_return_correct_Total_Price(){
        Assert.assertEquals(800.0,Product("label",8,100.0).getTotalPrice(),0.0)
    }
}