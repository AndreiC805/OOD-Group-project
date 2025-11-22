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

        fun start() {
            println("Welcome to the $originStation Ticket Machine!")
            println("-------------------------------------------")

            while (true) {
                println("\n1. Search Ticket")
                println("2. Insert Money")
                println("3. Buy Ticket")
                println("4. Exit")
                print("Choose an option: ")

                when (readLine()?.trim()) {
                    "1" -> searchTicket()
                    "2" -> insertMoney()
                    "3" -> buyTicket()
                    "4" -> {
                        println("Thank you for using the ticket machine!")
                        return
                    }

                    else -> println("Invalid option. Please try again.")
                }
            }
        }
        private fun searchTicket() {
            println("\nAvailable destinations:")
            destinations.forEach { println("- ${it.name}") }

            print("Enter destination: ")
            val destinationName = readLine()?.trim()?.capitalize()

            val destination = destinations.find { it.name.equals(destinationName, ignoreCase = true) }
            if (destination == null) {
                println("Destination not found.")
                return
            }

            print("Ticket type (single/return): ")
            val type = readLine()?.trim()?.lowercase()

            when (type) {
                "single" -> println("Price for single ticket: £${destination.singlePrice}")
                "return" -> println("Price for return ticket: £${destination.returnPrice}")
                else -> println("Invalid ticket type.")
            }
        }