package solution

/**
 * https://www.regular-expressions.info/numericranges.html
 *
 * RE lida com textos nao com numeros, assim criar uma RE que capture
 * um padrao de texto que represente um especifico intervalo de numeros
 * nao eh uma tarefa trivial.
 *
 * Nao da para simples usar o recurso de "character set" [0-255]
 * para capturar um texto 0, 1, 2 ... 255. O "charset" [0-255] = [0125]
 *
 * A RE [0-9] captura um unico caracter [0-9]{2} captura 2 caracteres sequenciais
 * O motor de RE trata o '0' como um caracter unico e '255' como 3 caracteres
 * para fazer uma regex que capture um intervalo de numeros entre 0-255 por exemplo
 * precisamos de uma regex que capture de 1 a 3 caracteres
 * */

fun testRegex2CharSequential() {
    val re2SequentialChars = Regex("[0-9]{2}")
    println("02".matches(re2SequentialChars))
}

fun testRegexIntervalNumbersFrom0to255() {
    // 0-9, 10-99, 100-199, 200-249, 250-255
    val regex = Regex("([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])")
    (0..256).forEach { value ->
        println("$value -> ${value.toString().matches(regex)}")
    }
}

/**
 *
 * */
fun testRegexRangeNumber(start: Int, end: Int) {
    val regex = Regex("")
}

fun main() {
    testRegexIntervalNumbersFrom0to255()
}