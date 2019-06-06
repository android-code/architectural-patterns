class AddFilm (private val filmsRepository: FilmsRepository) {

    operator fun invoke(film: Film) = filmsRepository.putFilm(film)
}