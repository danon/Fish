import Direction.South
import Direction.North
import kotlin.test.Test
import kotlin.test.assertEquals

internal class RiverForThreeFishTest {
    @Test
    fun shouldAllFriendsFishLive() {
        // given
        val nemo = Fish(4, South)
        val dory = Fish(3, South)
        val marlin = Fish(2, South)
        // then
        assertAllFishLive(listOf(nemo, dory, marlin))
    }

    @Test
    fun sharkShouldEatAllFish_Right() {
        // given
        val shark = Fish(4, North)
        val nemo = Fish(2, South)
        val dory = Fish(3, South)
        // then
        assertEquals(listOf(shark), River(listOf(shark, nemo, dory)).survivors())
    }

    @Test
    fun sharkShouldEatAllFish_Left() {
        // given
        val nemo = Fish(2, North)
        val dory = Fish(3, North)
        val shark = Fish(4, South)
        // then
        assertEquals(listOf(shark), River(listOf(nemo, dory, shark)).survivors())
    }

    @Test
    fun shouldEatingFishBeEaten() {
        // given
        val nemo = Fish(0, South)
        val shark1 = Fish(4, North)
        val dory = Fish(3, South)
        val shark2 = Fish(5, South)
        val merlin = Fish(2, South)
        val fish = listOf(nemo, shark1, dory, shark2, merlin)
        // then
        assertEquals(listOf(nemo, shark2, merlin), River(fish).survivors())
    }

    private fun assertAllFishLive(fish: List<Fish>) {
        assertEquals(fish, River(fish).survivors())
    }
}
