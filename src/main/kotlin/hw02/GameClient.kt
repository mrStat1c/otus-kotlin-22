package ru.otus.kotlin22.first.hw02

import hw02.Game
import hw02.GameBuilder

sealed class GameClient(
    val name: String,
    val gameCount: Int,
    val weekFreeGames: List<Game>
) {
    class Steam(name: String, gameCount: Int, weekFreeGames: List<Game> = emptyList()) :
        GameClient(name, gameCount, weekFreeGames)

    class Egs(name: String, gameCount: Int, weekFreeGames: List<Game> = emptyList()) :
        GameClient(name, gameCount, weekFreeGames)

}


abstract class GameClientBuilder {
    var name: String = ""
    var gameCount: Int = 0
    var weekFreeGames: MutableList<Game> = mutableListOf()


    fun add(game: Game) {
        weekFreeGames.add(game)
    }

    fun add(gameBuilder: GameBuilder) {
        add(gameBuilder.build())
    }

    abstract fun build(): GameClient
}


class SteamBuilder : GameClientBuilder() {

    override fun build(): GameClient.Steam = GameClient.Steam(name, gameCount, weekFreeGames.toList())

    fun game(function: GameBuilder.() -> Unit) = add(GameBuilder().apply(function))
}


class EgsBuilder : GameClientBuilder() {

    override fun build(): GameClient.Egs = GameClient.Egs(name, gameCount, weekFreeGames.toList())

    fun game(function: GameBuilder.() -> Unit) = add(GameBuilder().apply(function))
}


fun steam(function: SteamBuilder.() -> Unit): GameClient.Steam = SteamBuilder().apply(function).build()

fun egs(function: EgsBuilder.() -> Unit): GameClient.Egs = EgsBuilder().apply(function).build()

//inline reified fun + generic
inline fun <reified T : GameClient> gameClientGreeting(gameClient: T): String = "Hello, I'm ${gameClient.name}, and you?"
