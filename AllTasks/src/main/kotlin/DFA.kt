import java.io.File

class DFA(nfa : NFA) {
    val n : Int
    val m : Int
    val start: Int
    val finish: Set<Int>
    val go : Array<Array<Int>>

    init {
        n = (1 shl nfa.n)
        m = nfa.m
        start = nfa.start.sumOf { 1 shl it }
        val tempFinish = mutableListOf<Int>()
        val minimalFinishDFA : Int = nfa.finish.sumOf { 1 shl it }
        for (mask in 0 until n) {
            if ((mask and minimalFinishDFA).countOneBits() > 0)
                tempFinish.add(mask)
        }
        finish = tempFinish.toSet()
        go = Array(n) { Array(nfa.m) { 0 } }
        for (mask in 0 until n) {
            for (c in 0 until m) {
                var resMask = 0

                for (i in 0 until n) {
                    if (((mask shr i) and 1)== 1) {
                        nfa.go[i][c].forEach { resMask = resMask or (1 shl it) }
                        if (mask == 3 && c == 0) {
                            println("bit $i")
                        }
                    }
                }
                go[mask][c] = resMask
            }
        }
    }

    fun printToFile(outputFile : File) {
        if (!outputFile.exists()) outputFile.createNewFile()
        outputFile.printWriter().use {
            it.println(n)
            it.println(m)
            it.println(start)
            it.println(finish.toSortedSet().joinToString(" "))
            for (i in 0 until n) {
                for (c in 0 until m) {
                    it.println("$i $c ${go[i][c]}")
                }
            }
        }
    }
}