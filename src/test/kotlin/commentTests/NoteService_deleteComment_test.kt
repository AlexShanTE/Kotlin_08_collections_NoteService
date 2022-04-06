package commentTests
import Comment
import Note
import NoteService
import org.junit.Test
import org.junit.Assert.*
import customExceptions.*

class NoteService_deleteComment_test {
    @Test
    fun deleteComment_assertTrue() {
        val service = NoteService()
        service.add(Note(title = "title", text = "text"))
        val comment = Comment(noteId = 1, message = "comment")
        service.addComment(comment)

        val expectedValue = true
        val actualValue = service.deleteComment(comment.copy(commentId = 1))

        assertEquals(expectedValue, actualValue)
    }
    @Test
    fun deleteComment_assertFalse() {
        val service = NoteService()
        service.add(Note(title = "title", text = "text"))
        val comment = Comment(noteId = 1, message = "comment")
        service.addComment(comment)

        val expectedValue = false
        val actualValue = service.deleteComment(comment.copy(commentId = 0))

        assertEquals(expectedValue, actualValue)
    }
}