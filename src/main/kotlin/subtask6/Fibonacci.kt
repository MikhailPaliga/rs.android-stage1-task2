package subtask6

class Fibonacci {


    fun productFibonacciSequenceFor(n: Int): IntArray {
        var fibonacciOne = 0
        var fibonacciTwo = 1
        var variable: Int
        var final = 0
        while (fibonacciOne * fibonacciTwo < n) {
            variable = fibonacciOne + fibonacciTwo
            fibonacciOne = fibonacciTwo
            fibonacciTwo = variable
            if (fibonacciOne * fibonacciTwo == n) {
                final = 1
                break
            }
        }
        return arrayOf(fibonacciOne, fibonacciTwo, final).toIntArray()
    }
}
