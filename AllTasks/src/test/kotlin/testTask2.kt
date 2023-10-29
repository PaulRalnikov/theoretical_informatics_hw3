import java.io.File
import kotlin.test.Test

internal class TestTask2 {

    private fun isEqual(firstFile: File, secondFile: File): Boolean {
        return firstFile.readLines() == secondFile.readLines()
    }

    private val sample = Task2()

    private val firstTestPath = "src/test/data/task2_test1.txt"
    private val secondTestPath = "src/test/data/task2_test2.txt"

    private val firstTestExpectedPath = "src/test/data/task2_test1_expected.txt"
    private val secondTestExpectedPath = "src/test/data/task2_test2_expected.txt"


    //NFA tests
    @Test
    fun test_1() {
        val tempPath = kotlin.io.path.createTempFile().toString()
        sample.make_dfa_from_nfa(firstTestPath, tempPath)
        val result = isEqual(File(firstTestExpectedPath), File(tempPath))
        assert (result)
    }

    @Test
    fun test_2() {
//        val tempPath = kotlin.io.path.createTempFile().toString()
        val tempPath = "src/test/data/temp.txt"
        sample.make_dfa_from_nfa(secondTestPath, tempPath)
        val result = isEqual(File(secondTestExpectedPath), File(tempPath))
        assert (result)
    }
}