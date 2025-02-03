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
fun getCommission (transition:Int,card:String="Мир",transitionAgo:Int=0) {
    if (transition > 150000 || transition + transitionAgo > 600000) {
        println("перевод заблокирован")
        return
    }
    
    when (card) {
        "Mastercard" -> {
            when {
                transitionAgo >= 75000 -> println(masercardCommision(transition))
                transition + transitionAgo > 75000 -> println(masercardCommision(transition + transitionAgo - 75000))
                else -> println(0)
            }
        }
        "Visa" ->
            if (transition > 35) {
                println((transition * 0.0075).toInt())
            } else {
                println("перевод заблокирован")
            }
        "Мир" -> println(0)
    }
}


fun main() {
    println("Hello World!")
    agoToText(4800)
    agoToText(3800)
    

    // task 2
    getCommission(160000)
    getCommission(50000,"Mastercard",150000)
    getCommission(150000,"Mastercard",150000)
    getCommission(150000,"Visa")
    getCommission(30000)

}

