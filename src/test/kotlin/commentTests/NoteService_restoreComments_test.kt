package commentTests
import Comment
import Note
import NoteService
import org.junit.Test
import org.junit.Assert.*
import customExceptions.*

class NoteService_restoreComments_test {
    @Test
    fun restoreComments() {
        val service = NoteService()
        val note = Note(title = "title", text = "text")
        service.add(note)
        val comment = Comment(noteId = 1, message = "comment")
        service.addComment(comment)
        service.deleteComment(comment.copy(commentId = 1))


        val expected = comment.copy(commentId = 1, isDeleted = false)

        val actual = service.restoreComment(comment.copy(commentId = 1))

        assertEquals(expected, actual)
    }
    @Test(expected = CommentNotExistException::class)
    fun restoreComments_throwException() {
        val service = NoteService()
        val note = Note(title = "title", text = "text")
        service.add(note)
        val comment = Comment(noteId = 1, message = "comment")
        service.addComment(comment)
        service.deleteComment(comment.copy(commentId = 1))

        service.restoreComment(comment.copy(commentId = 0))
    }
}