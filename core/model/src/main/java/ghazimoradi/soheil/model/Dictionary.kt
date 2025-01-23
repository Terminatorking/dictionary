package ghazimoradi.soheil.model

data class Dictionary(
    val id: Long = 0,
    val enWord: String,
    val faWord: String,
    val isBookMarked: Boolean
)