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
 *
 * Estudo de regex para capturar pattern Ipv4 e Ipv6
 * https://riptutorial.com/regex/example/14146/match-an-ip-address
 * */

fun testRegex2CharSequential() {
    val re2SequentialChars = Regex("[0-9]{2}")
    println("02".matches(re2SequentialChars))
}

fun testRegexIntervalNumbersFrom0to255() {
    // 0-9, 10-99, 100-199, 200-249, 250-255
    val regex = Regex("^[0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5]$")
    (0..256).forEach { value ->
        println("$value -> ${value.toString().matches(regex)}")
    }
}

fun testRegexMatchIpV4Address() {
    val regex = Regex("^(([01]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5])\\.){3}([01]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5])$")

    arrayOf("333.123.123.123"
        , "....", "123.123.123.123", "0.0.0.0", "200.200.200.200", "000.000.000.000"
        ,"000.12.234.23.23","666.666.23.23",".213.123.23.32","23.45.22.32.", "200.200.200.256"
        ,"0.19.19.19"
    ).forEach {
        println("$it -> ${it.matches(regex)}")
    }
}

fun testCharSet() {
    arrayOf(
        "012", "000",
        "111", "222", "0", "1", "2", "00", "01"
    ).forEach {
        println(it.matches(Regex("[0-2]{1,3}")))
    }
}

fun main() {
    testRegexMatchIpV4Address()
}