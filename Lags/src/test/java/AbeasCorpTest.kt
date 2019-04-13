import AbeasCorp.RentRequest
import org.junit.Assert.assertEquals
import org.junit.Test


class AbeasCorpTest {

    val abeasCrop = AbeasCorp()

    @Test
    fun should_return_price_for_1_company() {

        //given
        val rentRequests = arrayListOf<RentRequest>(
                RentRequest("customer1", 0, 5, 18.0)
        )

        //when
        val result = abeasCrop.calculateBestPrice(rentRequests)

        //then
        assertEquals(18.0, result, 0.0)
    }

    @Test
    fun should_return_price_for_2_successive_time_companies() {

        //given
        val rentRequests = arrayListOf<RentRequest>(
                RentRequest("customer1", 0, 5, 18.0),
                RentRequest("customer2", 5, 8, 20.0)
        )

        //when
        val result = abeasCrop.calculateBestPrice(rentRequests)

        //then
        assertEquals(38.0, result, 0.0)
    }

    @Test
    fun should_return_price_for_2_companies() {

        //given
        val rentRequests = arrayListOf<RentRequest>(
                RentRequest("customer1", 0, 5, 18.0),
                RentRequest("customer2", 2, 8, 20.0)
        )

        //when
        val result = abeasCrop.calculateBestPrice(rentRequests)

        //then
        assertEquals(20.0, result, 0.0)
    }

    @Test
    fun should_return_price_for_3_companies() {

        //given
        val rentRequests = arrayListOf<RentRequest>(
                RentRequest("customer1", 0, 5, 18.0),
                RentRequest("customer2", 2, 8, 15.0),
                RentRequest("customer3", 10, 5, 18.0)
        )

        //when
        val result = abeasCrop.calculateBestPrice(rentRequests)

        //then
        assertEquals(36.0, result, 0.0) // 1 -> 3
    }

    @Test
    fun should_return_price_for_4_companies() {

        //given
        val rentRequests = arrayListOf<RentRequest>(
                RentRequest("customer1", 0, 5, 10.0),
                RentRequest("customer2", 3, 7, 14.0),
                RentRequest("customer3", 5, 9, 7.0),
                RentRequest("customer4", 6, 9, 8.0)
        )

        //when
        val result = abeasCrop.calculateBestPrice(rentRequests)

        //then
        assertEquals(18.0, result, 0.0) // 1 -> 4
    }

    @Test
    fun should_return_price_for_8_companies() {

        //given
        val rentRequests = arrayListOf<RentRequest>(
                RentRequest("customer1", 0, 5, 10.0),
                RentRequest("customer2", 2, 1, 14.0),
                RentRequest("customer3", 1, 9, 11.0),
                RentRequest("customer4", 0, 7, 12.0),
                RentRequest("customer5", 6, 3, 8.0),
                RentRequest("customer6", 9, 3, 10.0),
                RentRequest("customer7", 8, 3, 8.0),
                RentRequest("customer8", 10, 6, 18.0)
        )

        //when
        val result = abeasCrop.calculateBestPrice(rentRequests)

        //then
        assertEquals(32.0, result, 0.0) // 2 -> 5 -> 6
    }
}