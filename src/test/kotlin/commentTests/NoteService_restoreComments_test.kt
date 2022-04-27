package commentTests

import Comment
import CommentService
import Note
import NoteService
import org.junit.Test
import org.junit.Assert.*
import customExceptions.*

class NoteService_restoreComments_test {
    @Test
    fun restoreComments() {

        val notes = mutableListOf<Note>()
        val noteService = NoteService(notes)
        val commentService = CommentService(notes)

        val note = Note(title = "title", text = "text")
        noteService.create(note)
        val comment = Comment(noteId = 1, message = "comment")
        commentService.create(comment)
        commentService.delete(comment.copy(commentId = 1))


        val expected = comment.copy(commentId = 1, isDeleted = false)

        val actual = commentService.restore(comment.copy(commentId = 1))

        assertEquals(expected, actual)
    }

    @Test(expected = CommentNotExistException::class)
    fun restoreComments_throwException() {
        val notes = mutableListOf<Note>()
        val noteService = NoteService(notes)
        val commentService = CommentService(notes)

        val note = Note(title = "title", text = "text")
        noteService.create(note)
        val comment = Comment(noteId = 1, message = "comment")
        commentService.create(comment)
        commentService.delete(comment.copy(commentId = 1))

        commentService.restore(comment.copy(commentId = 0))
    }
}