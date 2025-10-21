/**
 * Enum class representing Korean postpositions (Josa).
 * Each pair follows the format "consonantForm_vowelForm"
 */
enum class Josa(val pair: String) {
    은는("은_는"),
    이가("이_가"),
    을를("을_를"),
    와과("과_와"),
    으로("으로_로");
}

/**
 * Extension function for automatically appending the correct Korean postposition (Josa)
 * depending on whether the last syllable has a final consonant (batchim).
 *
 * Example:
 * ```
 * "사과".josa(Josa.은는)   // "사과는"
 * "밥".josa(Josa.은는)     // "밥은"
 * "길".josa(Josa.으로)     // "길로"
 * "산".josa(Josa.으로)     // "산으로"
 * ```
 */
fun String.josa(josa: Josa): String {
    if (this.isEmpty()) return this

    val parts = josa.pair.split("_")
    if (parts.size != 2) return this + josa.pair

    val (consonantForm, vowelForm) = parts
    val lastChar = this.last()
    val code = lastChar.code

    // 한글 유니코드 범위: AC00 (가) ~ D7A3 (힣)
    if (code !in 0xAC00..0xD7A3) return this + vowelForm

    val jong = (code - 0xAC00) % 28
    val hasBatchim = jong != 0

    return when (josa) {
        Josa.으로 -> {
            // 특이 규칙: 받침이 ㄹ(jong == 8)이면 '로' 사용
            if (hasBatchim && jong != 8) this + consonantForm else this + vowelForm
        }
        else -> {
            if (hasBatchim) this + consonantForm else this + vowelForm
        }
    }
}

fun main(){
    println("사과".josa(Josa.은는))
}