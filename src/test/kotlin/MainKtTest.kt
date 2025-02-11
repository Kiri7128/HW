import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test
import ru.netology.*

class MainKtTest {
    @Test
    fun testGetCommission1() {
        assertEquals("920", getCommission(150000,"Mastercard",200000))
    }
    @Test
    fun testGetCommission2() {
        assertEquals("920",getCommission(150000,"Mastercard",200000))
    }
    @Test
    fun testGetCommissionBlock() {
        assertEquals("перевод заблокирован",getCommission(160000))
        assertEquals("перевод заблокирован",getCommission(50000,"Мир",600000))
    }


}