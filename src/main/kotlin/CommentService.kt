import customExceptions.CommentNotExistException
import customExceptions.NoteNotExistException

class CommentService(
    private val notes: MutableList<Note>
) : CrudService<Comment> {


    private var commentId = 1

    override fun create(e: Comment): Comment {
        for (note in notes) {
            if (note.id == e.noteId) {
                val newComment = e.copy(commentId = commentId)
                note.comments += newComment
                commentId++
                return newComment
            }
        }
        throw NoteNotExistException("Note is not exist")
    }

    override fun delete(e: Comment): Boolean {
        for (note in notes) {
            for ((index, el) in note.comments.withIndex()) {
                if (el.commentId == e.commentId) {
                    note.comments[index].isDeleted = true
                    return true
                }
            }
        }
        return false
    }

    override fun edit(e: Comment): Comment {
        for (note in notes) {
            for ((index, element) in note.comments.withIndex()) {
                if (element.commentId == e.commentId) {
                    note.comments[index] = e
                    return e
                }
            }
        }
        throw CommentNotExistException("Comment not exist")
    }

    override fun getById(id: Int): Comment {
        for (note in notes){
            for (comment in note.comments){
                if (comment.commentId == id) {
                    return comment
                }
            }
        }
        throw CommentNotExistException("Comment is not exist")
    }

    fun restore(e: Comment): Comment {
        for (note in notes) {
            for ((index, el) in note.comments.withIndex()) {
                if (el == e.copy(isDeleted = true)) {
                    note.comments[index].isDeleted = false
                    return el
                }
            }
        }
        throw CommentNotExistException("Comment not exist")
    }

    fun getComments(note: Note): List<Comment> {
        for (e in notes) {
            if (e.id == note.id) {
                return e.comments
            }
        }
        throw CommentNotExistException("This note has no comments")
    }

}



