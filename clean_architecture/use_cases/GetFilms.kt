class GetFilms (private val filmsRepository: FilmsRepository) {

    operator fun invoke(): List<Film> = filmsRepository.getFilms()
}