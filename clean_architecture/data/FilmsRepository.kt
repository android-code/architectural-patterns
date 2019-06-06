class FilmsRepository (private val localSource: FilmLocalSource, private val remoteSource: FilmRemoteSource) {

    fun getFilms() : List<Film> {
        val remotes = remoteSource.downloadFilms()
        if(remotes.isNotEmpty()) {
            localSource.merge(remotes)
            return remotes
        }
        else {
            return localSource.getLocalFilms()
        }
    }

    fun putFilm(film: Film) {
        localSource.saveFilm(film)
        remoteSource.uploadFilm(film)
    }
}