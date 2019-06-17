class MainActivity : AppCompatActivity() {

    //only inflate layout with NavHostFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //get instance of NavHostFragment and NavController
        val navHostFragment: NavHostFragment = 
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController: NavController = 
            navHostFragment.navController //or just use findNavController
    }
	
    //optionaly provide some manage of navigation views like BottomNavigationView
}