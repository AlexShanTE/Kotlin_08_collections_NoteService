package commentTests

import Comment
import CommentService
import Note
import NoteService
import org.junit.Test
import org.junit.Assert.*
import customExceptions.*

class NoteService_editComment_test {
    @Test
    fun editComment() {
        val notes = mutableListOf<Note>()
        val noteService = NoteService(notes)
        val commentService = CommentService(notes)

        noteService.create(Note(title = "title", text = "text"))
        val comment = Comment(noteId = 1, message = "comment")
        commentService.create(comment)

        val expectedComment = Comment(noteId = 1, commentId = 1, message = "EditedComment")
        val actualComment = commentService.edit(comment.copy(commentId = 1, message = "EditedComment"))

        assertEquals(expectedComment, actualComment)
    }

    @Test(expected = CommentNotExistException::class)
    fun editComment_expectedException() {

        val notes = mutableListOf<Note>()
        val noteService = NoteService(notes)
        val commentService = CommentService(notes)

        noteService.create(Note(title = "title", text = "text"))
        val comment = Comment(noteId = 1, message = "comment")
        commentService.create(comment)


        commentService.edit(comment.copy(commentId = 0, message = "EditedComment"))

    }
}