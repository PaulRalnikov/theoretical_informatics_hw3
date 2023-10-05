import java.io.File

class Task1 {

    //принимает 2 аргумета: путь до файла с описанием DFA и строку, которую нужно проверить
    //считается, что строка состоит только из символов 0..9
    fun testString (path : String, inputString : String) :Boolean = NFA(File(path)).checkString(inputString)
}

fun main() {
    println("enter relative path (from directory with project) to file with input data:")
    val path = readlnOrNull().toString()
    println("enter string you want to check:")
    val inputString = readlnOrNull().toString()
    val task1 = Task1()
    if (task1.testString(path, inputString))
        println("Correct")
    else
        println("Incorrect")

}
