interface FilmLocalSource {

    fun getLocalFilms() : List<Film>
    fun saveFilm(film: Film)
    fun merge(films: List<Film>)
}
