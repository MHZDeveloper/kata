import java.util.*

class AbeasCorp {

    data class RentRequest(val customer: String,
                           val startTime: Int,
                           val duration: Int,
                           val price: Double)

    private class State(val finishTime: Int,
                        val totalPrice: Double)


    fun calculateBestPrice(rentRequests: ArrayList<RentRequest>): Double {
        rentRequests.sortBy({ x -> x.startTime })
        val states = arrayListOf(State(0, 0.0))
        rentRequests.forEach { rentRequest ->
            for (j in states.indices) {
                if (states[j].finishTime <= rentRequest.startTime) {
                    val finishTime = rentRequest.duration + rentRequest.startTime + states[j].finishTime
                    val price = rentRequest.price + states[j].totalPrice
                    states.add(AbeasCorp.State(finishTime, price))
                }
            }
        }
        return states.maxBy({ x -> x.totalPrice })!!.totalPrice
    }
}