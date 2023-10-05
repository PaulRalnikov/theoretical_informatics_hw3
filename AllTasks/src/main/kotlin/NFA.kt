import java.io.File

open class NFA(inputFile: File) {
    val n : Int
    val m : Int
    val start: Set<Int>
    val finish: Set<Int>
    val go : Array<Array<MutableSet<Int>>>

    init  {
        println(inputFile.absolutePath)
        inputFile.bufferedReader().use {reader ->
            n = reader.readLine().toInt()
            m = reader.readLine().toInt()

            start = reader.readLine().split(" ").map {it.toInt()}.toSet()
            finish = reader.readLine().split(" ").map {it.toInt()}.toSet()

            go = Array(n) {
                Array(m) {
                    emptySet<Int>().toMutableSet()
                }
            }

            while(true) {
                try {
                    val splitted: List<Int> = reader.readLine().split(" ").map {it.toInt()}
                    val from : Int = splitted[0]
                    val symbol : Int = splitted[1]
                    val to : Int = splitted[2]
                    go[from][symbol].add(to)
                } catch (e : Exception) {
                    break
                }
            }
        }
    }

    fun checkString(inputString : String) : Boolean {
        var states : Set<Int> = start
        for (symbol in inputString) {
            val realSymbol : Int = symbol - '0'

            val newStates = emptySet<Int>().toMutableSet()
            states.forEach {
                newStates.addAll(go[it][realSymbol])
            }
            states = newStates
        }

        return states.intersect(finish.toSet()).isNotEmpty()
    }
}