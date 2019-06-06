class MainActivity : AppCompatActivity(), FilmsView {

    private val filmsAdapter = FilmsAdapter()
    private val presenter: FilmsPresenter

    init {
        //mostly use dependency injection instead of manual creating
        val room = RoomFilmsSource()
        val retrofit = RetrofitFilmsSource()
        val repository = FilmsRepository(room, retrofit)

        presenter = FilmsPresenter(this, GetFilms(repository), AddFilm(repository))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.apply {
            adapter = filmsAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        button.setOnClickListener { 
        	//this is mock implementation
        	//show some add dialog or activity/fragment instead of
        	presenter.addFilmClicked("Film", (0..10).random()) 
        }

        presenter.init()
    }

    override fun onDestroy() {
        presenter.uninit()
        super.onDestroy()
    }

    override fun renderFilms(films: List<Film>) {
        filmsAdapter.items.clear()
        filmsAdapter.items.addAll(films)
        filmsAdapter.notifyDataSetChanged()
    }

    override fun renderNewFilm(film: Film) {
        filmsAdapter.items.add(film)
        filmsAdapter.notifyDataSetChanged()
    }

    override fun showProgress(enable: Boolean) {
        //show or hide some progress
    }
}