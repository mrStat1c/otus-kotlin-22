package hw03

import hw02.protogonist
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertTrue

class ProtogonistWrapperTest {


    @Test
    fun sequenceTest() {
        val sequence = (1..10).asSequence()
            .map {
                protogonist {
                    name = "Hero $it"
                    level = 20 * it
                    damage = 110 * it
                    hp = 65 * it
                }
            }
        val wrapper = ProgonistsWrapper()
        wrapper.addOnlyBest(sequence)
        assertTrue(wrapper.size() == 3)
    }

    @Suppress("EXPERIMENTAL_API_USAGE")
    @Test
    fun flowTest() = runTest {
        val flow = flow {
            emit(protogonist {
                name = "Hero 1"
                characterClass = "Archer"
            })
            emit(protogonist {
                name = "Hero 2"
                characterClass = "Mage"
            })
            emit(protogonist {
                name = "Hero 3"
                characterClass = "Bggg"
            })
        }
        val wrapper = ProgonistsWrapper()
        wrapper.addExceptArchers(flow)
        assertTrue(wrapper.size() == 2)
    }
}