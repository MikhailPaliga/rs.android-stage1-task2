package subtask2

class TimeConverter {
    @Suppress("UNREACHABLE_CODE")

    fun toTextFormat(hours: String, minutes: String): String {
        val hoursArray = arrayOf("zero","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve")
        val minutesArray = arrayOf("one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine", "thirty")
        return when (minutes.toInt()) {
            0 -> "${hoursArray[hours.toInt()]} o' clock"
            15 -> "quarter past ${hoursArray[hours.toInt()]}"
            30 -> "half past ${hoursArray[hours.toInt()]}"
            45 -> "quarter to ${hoursArray[hours.toInt() + 1]}"
            1 -> "one minute past ${hoursArray[hours.toInt()]}"
            in 1..30 -> "${minutesArray[minutes.toInt() - 1]} minutes past ${hoursArray[hours.toInt()]}"
            in 31..60 -> "${minutesArray[60 - minutes.toInt() - 1]} minutes to ${hoursArray[hours.toInt() + 1]}"
            else -> ""
        }
    }
}