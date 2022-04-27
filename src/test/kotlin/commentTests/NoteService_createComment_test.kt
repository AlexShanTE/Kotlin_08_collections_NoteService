package commentTests

import Comment
import CommentService
import Note
import NoteService
import org.junit.Test
import org.junit.Assert.*
import customExceptions.*

class NoteService_createComment_test {
    @Test
    fun createComment() {
        val notes = mutableListOf<Note>()
        val noteService = NoteService(notes)
        val commentService = CommentService(notes)

        noteService.create(Note(title = "title", text = "text"))

        val expectedComment = Comment(noteId = 1, commentId = 1, message = "new comment")
        val actualComment = commentService.create(Comment(noteId = 1, message = "new comment"))

        assertEquals(expectedComment, actualComment)
    }

    @Test(expected = NoteNotExistException::class)
    fun createComment_throw_exception() {
        val notes = mutableListOf<Note>()
        val noteService = NoteService(notes)
        val commentService = CommentService(notes)

        noteService.create(Note(title = "title", text = "text"))

        commentService.create(Comment(noteId = 9999, message = "new comment"))

    }
}