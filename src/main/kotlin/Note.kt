data class Note(
    val id: Int = 0,
    val date: Int = 0,
    val title: String,
    val text: String,
    val comments: MutableList<Comment> = mutableListOf()
)

