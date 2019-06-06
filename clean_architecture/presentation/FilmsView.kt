interface FilmsView {

    fun showProgress(enable: Boolean)
    fun renderFilms(films: List<Film>)
    fun renderNewFilm(film: Film)
}