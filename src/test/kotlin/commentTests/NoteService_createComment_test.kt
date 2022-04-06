package commentTests
import Comment
import Note
import NoteService
import org.junit.Test
import org.junit.Assert.*
import customExceptions.*

class NoteService_createComment_test {
    @Test
    fun addComment() {
        val service = NoteService()
        service.add(Note(title = "title", text = "text"))

        val expectedComment = Comment(noteId = 1,commentId = 1, message = "new comment")
        val actualComment = service.addComment(Comment(noteId = 1, message = "new comment"))

        assertEquals(expectedComment, actualComment)
    }
    @Test(expected = NoteNotExistException::class)
    fun addComment_throw_exception() {
        val service = NoteService()
        val note = service.add(Note(title = "title", text = "text"))

        service.addComment(Comment(noteId = 9999, message = "new comment"))

    }
}