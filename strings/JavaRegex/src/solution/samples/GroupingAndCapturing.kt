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
     * POdemos otimizar a nossa regex para o motor de regex ser mais eficiente
     * caso nao precisemos do padrao capturado pelo grupo usando a sintaxe
     * "?:" apos o primeiro parenteses chamado de non-grouping capture
     *
     * O operador ?: nao tem relacao com ? no final de uma regex ou parte
     * dela. Um indica que o grupo nao sera utilizado para captura na correspondencia
     * de um padrao e o outro um quantificador (0 ou 1 ocorrencia de um padrao = {0.1})
     * */

    val imageExtensions = Regex("\\w+\\.(?:png|jpg|jpeg|bmp)")
    arrayOf("teste.png", "teste.pig","teste.bmp", "teste123.jpeg").forEach {
        it.printMatch(imageExtensions)
    }
}

fun testGroupingAndCapturing2() {
    val regex1 = Regex("Set(?:Value)?")
    arrayOf("SetValue", "Set") exec { it.printMatch(regex1) }

    println()
    // \s = [ \t\n\r\f\v]
    val regex2= Regex("express(?:ão|ões)\\sregular(?:es)?")
    arrayOf("expressão regular"
        , "expressões regulares"
        , "expressão\nregular"
        , "expressões\nregulares"
        ,  "expressões\tregulares").exec {
       it.printMatch(regex2)
    }

    println()
    val regex3 = Regex("color=(?:red|green|blue)")
    arrayOf("color=red", "color=yellow", "color=blue", "color=purple") exec { it.printMatch(regex3) }
}

fun main() {
    testGroupingAndCapturing2()
}