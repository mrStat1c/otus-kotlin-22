package hw01

import org.junit.Test
import ru.otus.kotlin22.first.hw01.GameClient
import kotlin.test.assertEquals


class GameClientTest {

    @Test
    fun steamTest() {
        val steam: GameClient.Steam = GameClient.Steam(25000, "Gabe", "some text")
        steam.startSales("15 may", "3 june")
    }

    @Test
    fun egsTest() {
        val egs: GameClient.Egs = GameClient.Egs(3000, "John")
        assert(egs.getWeekFreeGames().size > 0)
    }

    @Test
    fun microsoftStoreTest() {
        val ms: GameClient.MicrosoftStore = GameClient.MicrosoftStore(1000, "Unknown")
        assertEquals("42", ms.getAnswer("What is this all for?"))
    }
}