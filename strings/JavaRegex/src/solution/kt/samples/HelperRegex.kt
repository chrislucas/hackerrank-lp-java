package solution.kt.samples

/**
 * https://kotlinlang.org/docs/reference/functions.html#infix-notation
 * Regras para infix notation
 *  - funcoes infix devem ser member functions ou extension function
 *  - devem conter um unico parametro
 *  - o parametro dessa funcao nao deve ser um 'variable number of args' (varargs)
 * */

// nota as funcoes abaixo nao precisariam ser infix, mas eu fiz para testar uma ideia e pq eu quis :)

infix fun String.match(regex: Regex) = this.matches(regex)

infix fun String.printMatch(regex: Regex) =
    println(String.format("%s %s with: %s"
        , this
        , if (this match regex) "matches" else "not matches"
        , regex.toString()))

infix fun String.printMatch(regex: Array<Regex>) = regex.forEach { this.printMatch(it) }


inline infix fun <T> Array<T>.exec(fn: (value: T) -> Unit) = this.forEach { fn(it) }