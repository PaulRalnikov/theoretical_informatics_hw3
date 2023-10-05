import java.io.File

class Task2 {
    //принимает 2 пути от папки с проектом,
    // считывает из первого NFA,
    // переводит в DFA и печатает во второй
    fun make_dfa_from_nfa (inputPath : String, outputPath : String) {
        val dfa = DFA(NFA(File(inputPath)))
        val outputFile = File(outputPath)
        if (outputFile.exists()) outputFile.createNewFile()
        dfa.printToFile(outputFile)
    }
}

fun main() {
    println("enter relative path (from directory with project) to file with input data:")
    val inputPath = readlnOrNull().toString()
    println("enter relative path (from directory with project) to output file")
    val outputPath = readlnOrNull().toString()
    Task2().make_dfa_from_nfa(inputPath, outputPath)
}