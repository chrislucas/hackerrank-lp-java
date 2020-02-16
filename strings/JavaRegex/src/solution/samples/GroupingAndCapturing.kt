package solution.samples

/**
 * https://www.regular-expressions.info/brackets.html
 * ER - express(ão|ões) regular(es)?
 * () -> parenteses agrupam partes de um ER e tambem criam um
 * grupo de captura numerado. A parte da ER que esta entre parenteses
 * serve para capturar uma possivel parte da string que esta sendo avaliada
 * pela ER.
 *
 * Exemplo
 *
 * ER = "Set(Value)?"
 * String avaliada 1 = "Set"
 * a ER corresponde a string 1 e o grupo de captura (Value)? fica vazio porque a string nao
 * possui uma correspondencia para o que esta no grupo de captura
 *
 * String avaliada 2 = "SetValue"
 *
 * No segundo caso o grupo de captura
 *
 * */

fun testGroupingAndCapturing1() {

    /**
     * ?: non-grouping
     * O operador non-grouping eh util quando nao queremos que o(s) valor(es)
     * dentro do grupo sejam armazenados para uso posterior por exemplo quando
     * usamos backreference ()
     *
     * */

    val imageExtensions = Regex("\\w+\\.(?:png|jpg|jpeg|bmp)")
    arrayOf("teste.png", "teste.pig","teste.bmp", "teste123.jpeg").forEach {
        it.logMatch(imageExtensions)
    }
}


/**
 * https://kotlinlang.org/docs/reference/functions.html#infix-notation
 * Regras para infix notation
 *  - funcoes infix devem ser member functions ou extension function
 *  - devem conter um unico parametro
 *  - o parametro dessa funcao nao deve ser um 'variable number of args' (varargs)
 * */
infix fun String.match(regex: Regex) = this.matches(regex)

fun String.logMatch(regex: Regex) =
    println(String.format("%s %s with: %s"
        , this
        , if (this match regex) "matches" else "not matches"
        , regex.toString()))

fun testGroupingAndCapturing2() {
    val regex = Regex("Set(?:Value)?")
    arrayOf("SetValue", "Set").forEach {
       it.logMatch(regex)
    }
    println()
    // \s = [ \t\n\r\f\v]
    val regex1 = Regex("express(?:ão|ões)\\sregular(?:es)?")
    arrayOf("expressão regular"
        , "expressões regulares"
        , "expressão\nregular"
        , "expressões\nregulares"
        ,  "expressões\tregulares").forEach {
       it.logMatch(regex1)
    }

}

fun main() {
    testGroupingAndCapturing2()
}