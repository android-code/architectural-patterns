interface FilmRemoteSource {

    fun downloadFilms() : List<Film>
    fun uploadFilm(film: Film)
}