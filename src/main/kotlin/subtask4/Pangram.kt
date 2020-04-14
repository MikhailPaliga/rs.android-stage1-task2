package subtask4
import java.util.*
import kotlin.Comparator

class Pangram {

    fun getResult(inputString: String): String {
        var StringInput = inputString.trim().replace("\n","")
        StringInput = StringInput.replace("[\\s]+".toRegex(), " ")
        if (StringInput.isEmpty()) {
            return ""
        }
        if (PangramToo(StringInput)) {

            return pangramAlfa(StringInput.split(" "))
        } else {
            return pangramBetta(StringInput.split(" "))

        }
    }

    fun PangramToo
                (str: String): Boolean {
        val sign = BooleanArray(26)
        var index: Int
        loop@ for (i in str.indices) {

            index = when (str[i]) {
                in 'A'..'Z' -> str[i] - 'A'
                in 'a'..'z' -> str[i] - 'a'
                else -> continue@loop
            }
            sign[index] = true
        }
        for (i in 0..25) {
            if (!sign[i]) {
                return false
            }
        }
        return true
    }

    fun sortByFirstLetter(list: MutableList<String>): List<String> {
        Collections.sort(list, object : Comparator<String> {
            override fun compare(e1: String, e2: String): Int {
                return e1[0].compareTo(e2[0])
            }
        })
        return list
    }

    fun pangramAlfa(inputArray: List<String>): String {
        val newList = mutableListOf<String>()
        for (i in inputArray) {
            newList.add(pangrammGamma(i.toCharArray(), true))
        }
        return sortByFirstLetter(newList).joinToString(separator = " ")
    }

    fun pangramBetta(inputArray: List<String>): String {
        val newList = mutableListOf<String>()
        for (i in inputArray) {
            newList.add(pangrammGamma(i.toCharArray(), false))
        }
        return sortByFirstLetter(newList).joinToString(separator = " ")
    }

    fun pangrammGamma(str: CharArray, isVowelNeeded: Boolean): String {
        var count = 0
        for (i in str.indices) {
            if (str[i] == '\\') {
                return ""
            }
            if (open(str[i]) && isVowelNeeded) {
                str[i] = str[i].toUpperCase()
                count++
            }
            if (!open(str[i]) && !isVowelNeeded && str[i].isLetter()){
                str[i] = str[i].toUpperCase()
                count++
            }
        }
        return "${count}${str.joinToString(separator = "")}"
    }

    fun open(char: Char): Boolean {
        return char == 'a' || char == 'e' || char == 'i' || char == 'o' || char == 'u' || char == 'y'
                || char == 'A' || char == 'E' || char == 'I' || char == 'O' || char == 'U' || char == 'Y'
    }
}
