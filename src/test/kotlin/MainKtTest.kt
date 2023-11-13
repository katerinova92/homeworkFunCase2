import org.junit.Assert.*
import org.junit.Test

class MainKtTest {

    @Test
    fun feeCalculationForVisa() {
        val result = feeCalculation(cardType = "Visa", previouslyTransferredAmount = 0, amount = 5000)
        assertEquals(37, result)
    }

    @Test
    fun feeCalculationForVisaWithMinFee() {
        val result = feeCalculation(cardType = "Visa", previouslyTransferredAmount = 0, amount = 1000)
        assertEquals(35, result)
    }

    @Test
    fun feeCalculationForVisaWithExtraSum() {
        val result = feeCalculation(cardType = "Visa", previouslyTransferredAmount = 601_000, amount = 152_000)
        assertEquals(-666, result)
    }

    @Test
    fun feeCalculationForMir() {
        val result = feeCalculation(cardType = "Mir", previouslyTransferredAmount = 0, amount = 5000)
        assertEquals(37, result)
    }

    @Test
    fun feeCalculationForMirWithMinFee() {
        val result = feeCalculation(cardType = "Mir", previouslyTransferredAmount = 0, amount = 1000)
        assertEquals(35, result)
    }

    @Test
    fun feeCalculationForMirWithExtraSum() {
        val result = feeCalculation(cardType = "Mir", previouslyTransferredAmount = 620_000, amount = 180_000)
        assertEquals(-666, result)
    }

    @Test
    fun feeCalculationForMaestro() {
        val result = feeCalculation(cardType = "Maestro", previouslyTransferredAmount = 0, amount = 76_000)
        assertEquals(476, result)
    }

    @Test
    fun feeCalculationForMaestroWithZeroFee() {
        val result = feeCalculation(cardType = "Maestro", previouslyTransferredAmount = 0, amount = 1000)
        assertEquals(0, result)
    }

    @Test
    fun feeCalculationForMaestroWithExtraSum() {
        val result = feeCalculation(cardType = "Maestro", previouslyTransferredAmount = 610_000, amount = 195_000)
        assertEquals(-666, result)
    }

    @Test
    fun feeCalculationForMastercard() {
        val result = feeCalculation(cardType = "Mastercard", previouslyTransferredAmount = 0, amount = 76_000)
        assertEquals(476, result)
    }

    @Test
    fun feeCalculationForMastercardWithZeroFee() {
        val result = feeCalculation(cardType = "Mastercard", previouslyTransferredAmount = 0, amount = 1000)
        assertEquals(0, result)
    }

    @Test
    fun feeCalculationForMastercardWithExtraSum() {
        val result = feeCalculation(cardType = "Mastercard", previouslyTransferredAmount = 987_000, amount = 200_000)
        assertEquals(-666, result)
    }

    @Test
    fun feeCalculationForVKPay() {
        val result = feeCalculation(cardType = "VK Pay", previouslyTransferredAmount = 30_000, amount = 8000)
        assertEquals(550, result)
    }

    @Test
    fun feeCalculationForVKPayWithExtraSum() {
        val result = feeCalculation(cardType = "VK Pay", previouslyTransferredAmount = 45_000, amount = 16_000)
        assertEquals(-666, result)
    }
}