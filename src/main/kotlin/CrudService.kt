interface CrudService<E> {
    fun create(e: E): E
    fun delete(e: E): Boolean
    fun edit(e: E): E
    fun getById(id: Int): E?
}