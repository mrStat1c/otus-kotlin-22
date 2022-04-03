package hw03

import hw02.Protogonist
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach


class ProgonistsWrapper {

    private val protogonists = mutableMapOf<String, Protogonist>()

    fun add(protogonist: Protogonist) {
        protogonists.put(protogonist.name, protogonist)
    }

    fun get(name: String): Protogonist? {
        return protogonists.get(name)
    }

    fun size(): Int {
        return protogonists.size
    }

    // метод с sequence
    fun addOnlyBest(men: Sequence<Protogonist>) {
        val bestMen =
            men.filter { it.level > 50 && it.damage > 500 }
                .sortedBy { it.damage }
                .take(3)
        bestMen.forEach {
            protogonists.put(it.name, it)
        }
    }

    // метод c flow и Thread.sleep
    suspend fun addExceptArchers(flow: Flow<Protogonist>) {
        flow.onEach { protogonist ->
            Thread.sleep(300)
            if (!protogonist.characterClass.equals("Archer")) {
                protogonists.put(protogonist.name, protogonist)
            }
        }
            .flowOn(Dispatchers.IO)
            .collect()
    }
}