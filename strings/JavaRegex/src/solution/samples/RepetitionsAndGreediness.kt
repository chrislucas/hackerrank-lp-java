package solution.samples

/**
 * https://www.regular-expressions.info/repeat.html
 *
 * Quantificadores e suas caracteristicas
 * https://www.regular-expressions.info/refrepeat.html
 * https://www.rexegg.com/regex-quantifiers.html#greedytrap
 *
 * */

fun testGreedinessOperator() {
    /**
     * Resumo e conclusoes retiradas da leitura sobre o operador + ser `guloso|ganancioso`
     * no link (https://www.regular-expressions.info/repeat.html) secao "Watch Out for The Greediness"
     *
     * Um exemplo pratico eh escrever uma regex que capture uma tag html valida. Seja uma string S
     * um conjunto de caracteres que represente um documento HTML formado somente por TAGS validas
     * (H1, html, head, title), poderiamos escrever uma RE que captura-se uma tag valida dessa forma
     * <.+>. Entretanto se esperamos que essa regex capture somente tags html estamos errados,
     * <.+> captura tbm <tag valida>texto qualquer</tag valida> e o texto que esta entre <>
     *     nem precisa ser o mesmo (mas partimos do principio que estamos avaliando um texto html valido)
     *
     * Isso ocorre pq o operador + eh "greedy", ele faz com que o motor de RE repita a correspondencia ao
     * TOKEN  (.+) quantas vezes for possível até o motor falhar (nao encontrar mais correspondencia conforme
     * avanca sua analise pela String HTML). Somente se a regex falhar completamente
     * o motor de regex executara um backtracking voiltando para o (.+) e prosseguindo avancado com a regex
     * procurando por correspondecia.
     *
     * Os quantificadores +, * e {} sao "greedy"
     *
     * */
    arrayOf("<em></em>"
        , "<em>teste</em>"
        , "<em>"
        , "</em>"
        , "<em>teste</teste>"
        , "um teste<b>teste</b>maroto"
    , "<b>"
    , "<h1>"
    , "</h1>"
    ,"</b>") exec {
        it printMatch Regex("<.+>") // greediness
        it printMatch Regex("<.+?>") // laziness
        it printMatch Regex("<[^>]+>") // negate >
        it printMatch Regex("</?[a-zA-Z]+[0-9]?>")
    }
}

fun main() {
    testGreedinessOperator()
}