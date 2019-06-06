class RoomFilmsSource : FilmLocalSource {

    //mock implementation of Room database
    private var items = mutableListOf<Film>()

    override fun getLocalFilms(): List<Film> {
        return items
    }

    override fun saveFilm(film: Film) {
        items.add(film)
    }

    override fun merge(films: List<Film>) {
        for(film in films) {
            if(!items.contains(film))
                items.add(film)
        }
    }
}