enum class Taxes(
        val state:String,
        val tax:Double) {

    Tax1("UT",0.0685),
    Tax2("NV",0.08),
    Tax3("TX",0.0625),
    Tax4("AL",0.04),
    Tax5("CA",0.0825);
}