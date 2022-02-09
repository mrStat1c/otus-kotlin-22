package hw02

import org.junit.Assert.assertTrue
import org.junit.Test
import ru.otus.kotlin22.first.hw02.GameClient
import ru.otus.kotlin22.first.hw02.gameClientGreeting
import ru.otus.kotlin22.first.hw02.steam
import kotlin.test.assertEquals


class DslTest {

    @Test
    fun gameClientTest() {
        var steamClient: GameClient = steam {
            name = "Steam"
            gameCount = 894321

            game {
                name = "Dark Souls 3"
                price = 3000
            }
            game {
                name = "TABS"
                price = 600
            }
        }

        val steamGreeting: String =  gameClientGreeting(steamClient)

        assertEquals("Steam", steamClient.name)
        assertEquals(894321, steamClient.gameCount)
        assertEquals(2, steamClient.weekFreeGames.size)
        assertTrue("Incorrect game name!",
            steamClient.weekFreeGames.first().name.equals("Dark Souls 3")
        )
        assertTrue("Incorrect game price!",
            steamClient.weekFreeGames.first().price == 3000
        )
        assertEquals("Hello, I'm Steam, and you?", steamGreeting)
    }


    @Test
    fun protogonistTest() {
        var protogonist: Protogonist = protogonist {
            name = "Static"
            characterClass = "Knight"
            level = 10
            damage = 70
            hp = 650
        }
        protogonist levelUp 1
        protogonist + 3

        val targetHp = toDamage(protogonist, 200)

        assertEquals("Static", protogonist.name)
        assertEquals("Knight", protogonist.characterClass)
        assertEquals(14, protogonist.level)
        assertEquals(90, protogonist.damage)
        assertEquals(750, protogonist.hp)
        assertTrue (targetHp in 100..120)
    }
}