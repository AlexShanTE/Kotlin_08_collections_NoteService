package commentTests

import Comment
import Note
import NoteService
import org.junit.Test
import org.junit.Assert.*
import customExceptions.*

class NoteService_editComment_test {
    @Test
    fun editComment() {
        val service = NoteService()
        service.add(Note(title = "title", text = "text"))
        val comment = Comment(noteId = 1, message = "comment")
        service.addComment(comment)

        val expectedComment = Comment(noteId = 1, commentId = 1, message = "EditedComment")
        val actualComment = service.editComment(comment.copy(commentId = 1, message = "EditedComment"))

        assertEquals(expectedComment, actualComment)
    }

    @Test(expected = CommentNotExistException::class)
    fun editComment_expectedException() {
        val service = NoteService()
        service.add(Note(title = "title", text = "text"))
        val comment = Comment(noteId = 1, message = "comment")
        service.addComment(comment)


        service.editComment(comment.copy(commentId = 0, message = "EditedComment"))

    }
}