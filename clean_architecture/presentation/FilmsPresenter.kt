class FilmsPresenter (private val view: FilmsView, private val getFilms: GetFilms, private val addFilm: AddFilm) {

    fun init() {
        view.showProgress(true)
        val films = getFilms.invoke()
        view.renderFilms(films.map (DomainFilm::toPresentation) )
        view.showProgress(false)
    }

    fun uninit() {

    }

    fun addFilmClicked(title: String, vote: Int?) {
        view.showProgress(true)
        val film = Film(title, vote)
        addFilm.invoke(film)
        view.renderNewFilm(film.toPresentation())
        view.showProgress(false)
    }
}