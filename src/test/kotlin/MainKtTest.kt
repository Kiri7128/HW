import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test
//import ru.netology.*

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
    @Test
    fun testGetCommission_Mastercard_NoCommission() {
        assertEquals("0", getCommission(10000, "Mastercard", 20000))
    }

    @Test
    fun testGetCommission_Visa_MinCommission() {
        assertEquals("0", getCommission(35, "Visa"))
    }

    @Test
    fun testGetCommission_Visa_NormalCommission() {
        assertEquals("75", getCommission(10000, "Visa"))
    }

    @Test
    fun testGetCommission_Mir_NoCommission() {
        assertEquals("0", getCommission(50000, "Мир"))
    }

    @Test
    fun testGetCommission_DefaultCard_NoCommission() {
        assertEquals("0", getCommission(50000))
    }

    @Test
    fun testGetCommission_LimitExceeded() {
        assertEquals("перевод заблокирован", getCommission(160000))
        assertEquals("перевод заблокирован", getCommission(50000, "Мир", 600000))
    }


}