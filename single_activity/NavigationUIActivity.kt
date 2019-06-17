class NavigatioUIActivity : AppCompatActivity(), NavController.OnDestinationChangedListener {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_ui)
        initNavController()
        initNavUI()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //delegate menu items to NavController if connected
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

    private fun initNavController() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        navController.addOnDestinationChangedListener(this)
    }

    private fun initNavUI() {
        //setup app bar with default up navigate button and home destinations
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.callsFragment, R.id.contactsFragment))
        
        //connect Toolbar with NavController
        setSupportActionBar(toolbar)
        toolbar.setupWithNavController(navController, appBarConfiguration)
        
        //connect BottomNavigationView with NavController
        bottom_navigation_view.setupWithNavController(navController)
    }

    override fun onDestinationChanged(controller: NavController, destination: NavDestination, arguments: Bundle?) {
        //hide or show bottom navigation and menu items based on current destinations
        if(destination.id == R.id.callsFragment || destination.id == R.id.contactsFragment) {
            bottom_navigation_view.visibility = View.VISIBLE
            toolbar.menu?.findItem(R.id.aboutFragment)?.isVisible = true
        }
        else {
            bottom_navigation_view.visibility = View.GONE
            toolbar.menu?.findItem(R.id.aboutFragment)?.isVisible = false
        }
    }
}