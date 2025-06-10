fun main() {

    val above75 = false
    val knowsCoding = true

    // && AND operators
    val eligibleForInterView = above75 && knowsCoding
    println(eligibleForInterView)
    /* In && AND operators the output only comes true when the both
     condition is true else output will be false*/

    // || OR operator

    val callForInterView = above75 || knowsCoding
    println(callForInterView)

    /*   in OR operator the output will false only when the oth conditions are come false
         else the true  (if the single condition is true the output will be true)
    * */


    // ! NOT operator
    val learning = false
    val answer = !learning
    println(answer)

    /*   in ! NOT operator is   if the condition is true the output will be true
         and if the condition true the output will be false
     */

}