import kotlin.test.Test
import kotlin.test.assertEquals

internal class TestTask1 {


    private val sample = Task1()
    private val firstTestPath = "src/test/data/task1_test1.txt"
    private val secondTestPath = "src/test/data/task1_test2.txt"

    //NFA tests
    @Test
    fun test_NFA_1() {
        val expected = true
        val result : Boolean = sample.testString(
            firstTestPath,
            "00111111100"
        )
        assertEquals(result, expected)
    }

    @Test
    fun test_NFA_2() {
        val expected = true
        val result : Boolean = sample.testString(
            firstTestPath,
            "111111111100"
        )
        assertEquals(result, expected)
    }
    @Test
    fun test_NFA_3() {
        val expected = false
        val result : Boolean = sample.testString(
            firstTestPath,
            "111111111"
        )
        assertEquals(result, expected)
    }

    @Test
    fun test_NFA_4() {
        val expected = false
        val result : Boolean = sample.testString(
            firstTestPath,
            "00"
        )
        assertEquals(result, expected)
    }

    @Test
    fun test_NFA_5() {
        val expected = true
        val result : Boolean = sample.testString(
            firstTestPath,
            "000"
        )
        assertEquals(result, expected)
    }

    //DFA tests
    @Test
    fun test_DFA_1() {
        val expected = true
        val result : Boolean = sample.testString(
            secondTestPath,
            "022220"
        )
        assertEquals(result, expected)
    }

    @Test
    fun test_DFA_2() {
        val expected = true
        val result : Boolean = sample.testString(
            secondTestPath,
            "2111111220"
        )
        assertEquals(result, expected)
    }

    @Test
    fun test_DFA_3() {
        val expected = false
        val result : Boolean = sample.testString(
            secondTestPath,
            "002222222211111111"
        )
        assertEquals(result, expected)
    }

    @Test
    fun test_DFA_4() {
        val expected = false
        val result : Boolean = sample.testString(
            secondTestPath,
            "20111111122222222222222"
        )
        assertEquals(result, expected)
    }
}