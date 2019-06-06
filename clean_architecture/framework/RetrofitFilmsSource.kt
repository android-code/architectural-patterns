class RetrofitFilmsSource : FilmRemoteSource {

    //mock implementations of Retrofit framework
    private val items = mutableListOf<Film>()

    override fun downloadFilms(): List<Film> {
        return items
    }

    override fun uploadFilm(film: Film) {
        items.add(film)
    }
}