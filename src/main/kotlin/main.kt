fun main() {
    val amount = 5000
    val previouslyTransferredAmount = 0
    val cardType = "Visa"
    val feePerOperation = feeCalculation(cardType, previouslyTransferredAmount, amount)

    println("Комиссия за перевод стоставит: $feePerOperation руб.")
}

fun feeCalculation(cardType: String, previouslyTransferredAmount: Int, amount: Int): Int {
    val feeForVisa = 0.0075
    val minFeeAmountForVisa = 35
    val feeForMaestro = 0.006

    if (cardType == "VK Pay" && (amount > 15_000 || previouslyTransferredAmount > 40_000)) return -666
    if ((cardType == "Maestro" || cardType == "Mastercard" || cardType == "Visa" || cardType == "Mir") &&
        (amount > 150_000 || previouslyTransferredAmount > 600_000)
    ) return -666

    var fee = when (cardType) {
        "Maestro", "Mastercard" -> if (amount < 75_000) 0 else amount * feeForMaestro + 20
        "Visa", "Mir" -> if ((amount * feeForVisa) > minFeeAmountForVisa) amount * feeForVisa else minFeeAmountForVisa
        else -> 0
    }
    return fee.toInt()
}