package ru.netology


fun getrightTextMinut(seconds:Int) : String{
    var res = "";
    var minuts = seconds / 60
    when(minuts) {
        1 , 21 , 31 , 41 , 51 -> res = "был(а) ${minuts} минуту назад"
        2 , 22 , 32 , 42 , 52,3,4 -> res = "был(а) ${minuts} минуты назад"
        5 , 25 , 35 , 45 , 55 , in 6..9 -> res = "был(а) ${minuts} минут назад"
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
fun getCommission (transition:Int,card:String="Мир",transitionAgo:Int=0) {
    when (card) {
        "Mastercard" ->
            if (transition + transitionAgo <= 75000) {
                if (transition <= 150000 && transition + transitionAgo <= 600000) {
                    println(masercardCommision(transition - 75000))
                } else {
                    println("перевод заблокирован")
                }
            } else {
                if (transition <= 150000 && transition + transitionAgo <= 600000) {
                    println(transition - (transition - masercardCommision(transition - 75000)))
                } else {
                    println("перевод заблокирован")
                }
            }
        "Visa" ->
            if (transition <= 150000 && transition + transitionAgo <= 600000 && transition > 35) {
                println((transition * 0.0075).toInt())
            } else {
                println("перевод заблокирован")
            }
        "Мир" -> if (transition <= 150000 && transition + transitionAgo <= 600000) {
            println(0)
        } else {
            println("перевод заблокирован")
        }
    }
}


fun main() {
    println("Hello World!")
    agoToText(4800)

    // task 2
    getCommission(160000)
    getCommission(150000,"Mastercard")
    getCommission(150000,"Visa")
    getCommission(30000)

}
