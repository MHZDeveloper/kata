

/*
 * Task #1. Find all the drivers who performed no trips.
 */
fun TaxiPark.findFakeDrivers(): Set<Driver> =
        this.allDrivers.filter { it !in this.trips.map { it.driver } }.toSet()

/*
 * Task #2. Find all the clients who completed at least the given number of trips.
 */
fun TaxiPark.findFaithfulPassengers(minTrips: Int): Set<Passenger> =
        this.allPassengers.filter { passenger ->
            this.trips.filter { trip ->
                trip.passengers.contains(passenger)
            }.count() >= minTrips
        }.toSet()

/*
 * Task #3. Find all the passengers, who were taken by a given driver more than once.
 */
fun TaxiPark.findFrequentPassengers(driver: Driver): Set<Passenger> =
        this.allPassengers.filter { passenger ->
            this.trips.filter {trip ->
                trip.passengers.contains(passenger)
                        &&
                trip.driver == driver
            }.count()>1
        }.toSet()

/*
 * Task #4. Find the passengers who had a discount for majority of their trips.
 */
fun TaxiPark.findSmartPassengers(): Set<Passenger> =
        this.allPassengers.filter { passenger ->
            val (tripWithDiscount,tripWithoutDiscount) =
                    this.trips.filter { trip ->
                        trip.passengers.contains(passenger)
                    }.partition {it.discount!=null && it.discount >0.0 }
            tripWithDiscount.size>tripWithoutDiscount.size
        }.toSet()

/*
 * Task #5. Find the most frequent trip duration among minute periods 0..9, 10..19, 20..29, and so on.
 * Return any period if many are the most frequent, return `null` if there're no trips.
 */
fun TaxiPark.findTheMostFrequentTripDurationPeriod(): IntRange? {
    return this.trips.map { it.duration }
            .groupBy { it/10 }
            .maxBy { (_,duration) -> duration.size }
            ?.key
            ?.let { it ->
                IntRange(it*10,(it*10)+9)
            }
}

/*
 * Task #6.
 * Check whether 20% of the drivers contribute 80% of the income.
 */
fun TaxiPark.checkParetoPrinciple(): Boolean {
    if (this.trips.isEmpty()) return false
    val twentyPercentBestDrivers = this.allDrivers.size/5
    val eightyPercentOfIncome = this.trips.sumByDouble { it.cost } * 0.8
    return this.trips.groupBy { it.driver }
            .mapValues { (_,trips) -> trips.sumByDouble { it.cost } }
            .entries
            .sortedByDescending { it.value }
            .take(twentyPercentBestDrivers)
            .sumByDouble { it.value } >=eightyPercentOfIncome

}