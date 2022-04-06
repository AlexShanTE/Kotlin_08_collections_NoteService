package commentTests

import Comment
import Note
import NoteService
import org.junit.Test
import org.junit.Assert.*
import customExceptions.*

class NoteService_getComments_test {
    @Test
    fun getComments() {
        val service = NoteService()
        val note = Note(title = "title", text = "text")
        service.add(note)
        val comment1 = Comment(noteId = 1, message = "comment")
        val comment2 = Comment(noteId = 1, message = "comment")
        service.addComment(comment1)
        service.addComment(comment2)

        val expected = listOf(comment1.copy(commentId = 1), comment2.copy(commentId = 2))
        val actual = service.getComments(note.copy(id = 1))

        assertEquals(expected, actual)
    }
    @Test(expected = CommentNotExistException::class)
    fun getComments_throwException() {
        val service = NoteService()
        val note = Note(title = "title", text = "text")
        service.add(note)
        val comment1 = Comment(noteId = 1, message = "comment")
        val comment2 = Comment(noteId = 1, message = "comment")
        service.addComment(comment1)
        service.addComment(comment2)

        service.getComments(note.copy(id = 0))

    }
}
