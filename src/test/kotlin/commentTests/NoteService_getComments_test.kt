package commentTests

import Comment
import CommentService
import Note
import NoteService
import org.junit.Test
import org.junit.Assert.*
import customExceptions.*

class NoteService_getComments_test {
    @Test
    fun getComments() {

        val notes = mutableListOf<Note>()
        val noteService = NoteService(notes)
        val commentService = CommentService(notes)

        val note = Note(title = "title", text = "text")
        noteService.create(note)
        val comment1 = Comment(noteId = 1, message = "comment")
        val comment2 = Comment(noteId = 1, message = "comment")
        commentService.create(comment1)
        commentService.create(comment2)

        val expected = listOf(comment1.copy(commentId = 1), comment2.copy(commentId = 2))
        val actual = commentService.getComments(note.copy(id = 1))

        assertEquals(expected, actual)
    }

    @Test(expected = CommentNotExistException::class)
    fun getComments_throwException() {

        val notes = mutableListOf<Note>()
        val noteService = NoteService(notes)
        val commentService = CommentService(notes)

        val note = Note(title = "title", text = "text")
        noteService.create(note)
        val comment1 = Comment(noteId = 1, message = "comment")
        val comment2 = Comment(noteId = 1, message = "comment")
        commentService.create(comment1)
        commentService.create(comment2)

        commentService.getComments(note.copy(id = 0))

    }

    @Test
    fun getCommentById() {

        val notes = mutableListOf<Note>()
        val noteService = NoteService(notes)
        val commentService = CommentService(notes)

        val note = Note(title = "title", text = "text")
        noteService.create(note)
        val comment1 = Comment(noteId = 1, message = "comment")
        val comment2 = Comment(noteId = 1, message = "comment")
        commentService.create(comment1)
        commentService.create(comment2)

        val expected = comment1.copy(commentId = 2)
        val actual = commentService.getById(2)

        assertEquals(expected, actual)
    }

    @Test(expected = CommentNotExistException::class)
    fun getCommentById_throwException() {

        val notes = mutableListOf<Note>()
        val noteService = NoteService(notes)
        val commentService = CommentService(notes)

        val note = Note(title = "title", text = "text")
        noteService.create(note)
        val comment1 = Comment(noteId = 1, message = "comment")
        val comment2 = Comment(noteId = 1, message = "comment")

        commentService.getById(999)

    }
}
