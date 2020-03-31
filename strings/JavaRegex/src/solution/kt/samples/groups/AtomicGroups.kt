package solution.kt.samples.groups

import solution.kt.samples.printMatch

/**
 * https://www.regular-expressions.info/atomic.html
 *
 * O que sao Atomic Grpups ?
 *
 * Um atomic group eh um grupo que quando a mecanismo de regex sai dele automaticamente se desfaz
 * de todas as posicoes armazenadas por qualquer toque dentro do grupo para realizar backtracking (funcao essa
 * que pode ser realizada com a combinacao do group "()" e backreference "\1")
 *
 * Atomic group eh um grupo de "nao-captura - (?)", a sintaxe para esse tipo de grupo eh (?>A|B|C ...).
 *
 * Look around groups (https://www.regular-expressions.info/lookaround.html) sao grupos atomicos tbm
 *
 * */


fun testBehaviorBetweenCapturingAndNonCapturingGroup() {

    /**
     * Exemplo: O comportamento do mecanismo de RE com o grupo de captura
     * e como o ele armazena a posicao quando encontra uma correspondencia entre
     * o TOKEN e o caracter numa posicao da string e quando usamos um grupo de nao captura
     * (grupo atomico)
     *
     * Seja RE1 = a(bc|b)c a regex com grupo de captura e RE2 = a(?>bc|b) a regex de um grupo atomico, os padroes
     * usados para entender o comportamento do mecanismos de regex, vejamos como eles se comportam dado uma String S.
     *
     * Seja S1 = "abc" vejamos como o mecanismo RE se comporta com a RE1
     *
     * 1) RE1 acha correspondencia entre o TOKEN "a" e o caracter na primeira posicao da string "a"
     * 2) o mecanismo passa para o proximo TOKEN "bc" dentro do grupo de capura e para a proxima posicao
     * da String e encontra correspondencia com as posicoes na string que correspondem a substring "bc"
     * 3) O mecanismo falha ao encontrar o TOKEN "c" na regex, pois ja tinha avaliado o ultimo caracter da String S1
     * 4) O mecanismo falhou no ultimo passo, mas como usamos um grupo de captura e esse mesmo mecanismo utiliza
     * o recurso de backtracking para tentar achar correspondencia com o proximo TOKEN do grupo "b". O mecanismo
     * desiste da ultima correspondencia e tenta achar correspondencia com o novo token "b", e acha
     * 5) O mecanismo segue para o ultimo TOKEN, "c", e acha correspondencia com o ultimo caracter
     *
     * Se definirmos RE3 como "a(b|bc)c" e usarmos em S1, o mecanismo encontraria correspondencia sem realizar backtraking
     *
     * Vejamos como o mecanismo se comporta ao usarmos RE2 em S1
     *
     * 1) O token "a" da regex corresponde com o caracter na primeira posicao, a regex avanca para o proximo token
     * e proxima posicao
     * 2) na proxima posicao a regex aponta para o TOKEN "bc" e encontra correspondencia na substring "bc" em S1.
     * O comportamento do mecanismo eh de sair do "grupo atomico", e assim falhar. Ao sair do grupo, as posicoes
     * no grupo para realizar backtracking sao descartadas, assim nao eh possivel tentar uma correspondencia com o
     * proximo token dentro do grupo (ALTERNATION)
     *
     * Observacao:
     *
     * Podemos observar que "a(?>bc|b)c")" e "a(?>b|bc)c")" tem resultados diferentes quando testados
     * com a String "abc", a primeira falha e a segunda nao, exatamente pq o mecanismo sai do grupo e
     * nao armazena a posicao para realizar um backtraking e tentar uma nova combinacao de matching
     *
     * Um outro exemplo desse mesmo comportamento pode ser visto com essas REGEXS e String "abcc",
     * entretanto com essa String a primeira regex corresponde ao padrao e a segunda nao
     *
     * */

    val args = arrayOf(
        Regex("a(b|bc)c")       // capturing group
        , Regex("a(bc|b)c")       // capturing group
        , Regex("a(?>bc|b)c")   // atomic non-capturing group
        , Regex("a(?>b|bc)c")   // atomic non-capturing group
    )
    listOf("abc", "abcc").forEach { it printMatch args }
}

fun optimizationAtomicGroup() {
    /**
     * Exemplo abaixo mostra como o mecanismo da RE para captura de grupos
     * pode ser otimizado, quando sabemos o que estamos procurando
     * */

    // not matching
    "integers" printMatch "\\b(integer|insert|in)\\b".toRegex()
    // matching
    "integers" printMatch "\\b(?>integer|insert|in)\\b".toRegex()
    // matching
    "integers" printMatch "\\b(integer|insert|in)s\\b".toRegex()
    // matching
    "integers" printMatch "\\b(?>integer|insert|in)s\\b".toRegex()
    // ?
    "integers" printMatch "\\b(?>insert|integer|in)s\\b".toRegex()
    // ? matching
    "integers" printMatch "\\b(?>insert|integer)s\\b".toRegex()
    // matching - O mecanismo ao falhar por completo ao tentar corresponder o TOKEN com caracter(es) da string
    // tebta o proximo token do grupo
    "integers" printMatch "\\b(?>ins|integer)s\\b".toRegex()
    // ? not matching
    "integers" printMatch "\\b(?>in|integer)s\\b".toRegex()
    // ??
    "integers" printMatch "\\b(?>insert|in|integer)s\\b".toRegex()
    //
    "integers" printMatch "\\b(?>in|insert|integer)s\\b".toRegex()
    // matching
    "integers" printMatch "\\b(?>ins|insert|integer)s\\b".toRegex()
    // matching
    "insert" printMatch "\\b(?>integer|insert|in)\\b".toRegex()
    // not-matching porque o mecanismo encontra correspondencia na alternativa "in"
    // encerra a busca no grupo passa para p proximo TOKEN \\b e falha ao tentar
    "insert" printMatch "\\b(?>integer|in|insert)\\b".toRegex()
    // IDEM
    "insert" printMatch "\\b(?>in|insert)\\b".toRegex()
}

fun main() {
    optimizationAtomicGroup()
}