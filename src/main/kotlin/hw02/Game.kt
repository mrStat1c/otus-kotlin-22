package hw02

class Game(val name: String, val price: Int)

class GameBuilder {
    var name: String = ""
    var price: Int = 0

    fun build(): Game{
        return Game(name, price)
    }
}