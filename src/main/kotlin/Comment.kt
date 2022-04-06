 data class Comment(
     val noteId:Int,
     val commentId:Int = 0,
     val replyTo:Int = 0,
     val message: String,
     var isDeleted: Boolean = false
)