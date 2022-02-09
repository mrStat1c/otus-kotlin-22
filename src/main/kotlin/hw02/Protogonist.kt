package hw02

data class Protogonist(
    val name: String,
    val characterClass: String,
    var level: Int,
    var damage: Int,
    var hp: Int
)

class ProtogonistBuilder {
    var name: String = "Ptotogonist"
    var characterClass: String = "Archer"
    var level: Int = 1
    var damage: Int = 10
    var hp: Int = 200

    fun build(): Protogonist = Protogonist(name, characterClass, level, damage, hp)
}

fun protogonist(block: ProtogonistBuilder.() -> Unit) = ProtogonistBuilder().apply(block).build()

//lambda
val toDamage: (protogonist: Protogonist, targetHp: Int) -> Int = { protogonist, targetHp ->
    val hp = targetHp - (protogonist.damage - 10..protogonist.damage + 10).random()
    println("target hp = $hp")
    hp
}

//infix function
infix fun Protogonist.levelUp(levelCount: Int) {
    (1..levelCount).forEach { lvl ->
        this.level++
        this.damage += 5
        this.hp += 25
    }
}

//operator overloading
operator fun Protogonist.plus(levelCount: Int) {
    this levelUp levelCount
}