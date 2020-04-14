package subtask3

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        val
                variable = a.filter{b.contains(it,true)}
        //println(t)
        if (b.toUpperCase() == variable.toUpperCase()) {
            return( "YES")
        } else return("NO")}}
