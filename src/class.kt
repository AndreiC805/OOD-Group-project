class Tiket {
    data class Destination(
        val name: String,
        val singlePrice: Double,
        val returnPrice: Double,
        var totalTakings: Double = 0.0
    )

    class TicketMachine(private val originStation: String) {
        private val destinations = mutableListOf(
            Destination("London", 45.0, 60.0),
            Destination("Cardiff", 15.0, 25.0),
            Destination("Weston Super Mare", 20.0, 35.0),
            Destination("Swansea", 35.0, 55.0)
        )

        private var insertedMoney: Double = 0.0