import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import ru.netology.*

class MainKtTest {

@Test
 fun getCommission() {
    kotlin.test.assertEquals("470",getCommission(150000,"Mastercard"))
    kotlin.test.assertEquals("920",getCommission(150000,"Mastercard",200000))
    kotlin.test.assertEquals("перевод заблокирован",getCommission(200000))
    kotlin.test.assertEquals("перевод заблокирован",getCommission(50000,"Мир",600000))
    kotlin.test.assertEquals("500",getCommission(150000,"Mastercard"))
 }
}