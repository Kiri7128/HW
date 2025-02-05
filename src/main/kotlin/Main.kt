package ru.netology


fun getrightTextMinut(seconds:Int) : String{
    var res = "";
    var minuts = seconds / 60
    when {
        minuts % 10 == 1 && minuts % 100 != 11 -> res = "был(а) ${minuts} минуту назад"
        (minuts % 10 == 2 || minuts % 10 == 3 || minuts % 10 == 4) && 
        (minuts % 100 !in 12..14) -> res = "был(а) ${minuts} минуты назад"
        else -> res = "был(а) ${minuts} минут назад"
    }
    return res
}
fun getrightTextHours(seconds:Int) : String{
    var res = "";
    var hours = seconds / (60 * 60)
    when(hours) {
        1 , 21 -> res = "был(а) ${hours} час назад"
        2 ,3,4, 22 , 23 , 24 -> res = "был(а) ${hours} часа назад"
        else -> res = "был(а) ${hours} часов назад"
    }
    return res
}

fun agoToText(seconds:Int)  {
    when(seconds) {
        in 1..60 -> println("был(а) только что")
        in 61..60*60-> println(getrightTextMinut(seconds))
        in 60 * 60 + 1..24 * 60 * 60 -> println(getrightTextHours(seconds))
        in 24 * 60 * 60+1..24 * 60 * 60*2 -> println("был(а) вчера")
        in 24 * 60 * 60*2 + 1..24 * 60 * 60*3 -> println("был(а) позавчера")
        else -> println("был(а) давно")
    }
}

// task 2
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

