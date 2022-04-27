package commentTests
import Comment
import CommentService
import Note
import NoteService
import org.junit.Test
import org.junit.Assert.*
import customExceptions.*

class NoteService_deleteComment_test {
    @Test
    fun deleteComment_assertTrue() {

        val notes = mutableListOf<Note>()
        val noteService = NoteService(notes)
        val commentService = CommentService(notes)

        noteService.create(Note(title = "title", text = "text"))

        val comment = Comment(noteId = 1, message = "comment")
        commentService.create(comment)

        val expectedValue = true
        val actualValue = commentService.delete(comment.copy(commentId = 1))

        assertEquals(expectedValue, actualValue)
    }
    @Test
    fun deleteComment_assertFalse() {
        val notes = mutableListOf<Note>()
        val noteService = NoteService(notes)
        val commentService = CommentService(notes)

        noteService.create(Note(title = "title", text = "text"))
        val comment = Comment(noteId = 1, message = "comment")
        commentService.create(comment)

        val expectedValue = false
        val actualValue = commentService.delete(comment.copy(commentId = 0))

        assertEquals(expectedValue, actualValue)
    }
}