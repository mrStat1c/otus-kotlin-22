package ru.otus.kotlin22.first.hw01

sealed class GameClient {

    class Steam(var gameCount: Int, var owner: String, var someFieldOnlyForSteam: String) : GameClient() {

        fun startSales(startDate: String, endDate: String) {
            println("Sales started! start date = $startDate, end date = $endDate...")
        }
    }

    class Egs(var gameCount: Int, var owner: String) : GameClient() {

        fun getWeekFreeGames(): List<String> {
            return listOf("Dark Souls 3", "God of War")
        }
    }

    class MicrosoftStore(var gameCount: Int, var owner: String) : GameClient() {

        fun getAnswer(question: String): String {
            return "42"
        }
    }
}