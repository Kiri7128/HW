//package ru.netology

fun masercardCommision (transition:Int) : Int {
    val a = transition * 0.006 + 20
    return a.toInt()
}
fun getCommission (transition:Int,card:String="Мир",transitionAgo:Int=0) : String{
    if (transition > 150000 || transition + transitionAgo > 600000) {
        return "перевод заблокирован"
    }
    
    when (card) {
        "Mastercard" -> {
            when {
                transitionAgo >= 75000 -> return (masercardCommision(transition)).toString()
                transition + transitionAgo > 75000 -> return (masercardCommision(transition + transitionAgo - 75000)).toString()
                else -> return "0"
            }
        }
        "Visa" ->
            if (transition > 35) {
                return ((transition * 0.0075).toInt()).toString()
            } else {
                return  "0"
            }
        "Мир" -> return "0"
    }
    return " "
}


fun main() {
    println(getCommission(150000,"Mastercard",200000))
    println(getCommission(700000))
}

