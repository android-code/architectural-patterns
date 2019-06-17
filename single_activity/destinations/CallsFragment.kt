class CallsFragment : Fragment() {

    private val viewModel: PhoneViewModel by lazy {
        ViewModelProviders.of(activity!!).get(PhoneViewModel::class.java)
    }
    private val adapter = CallsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getCalls().observe(this, Observer {
            adapter.addItems(it)
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_calls, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_view_calls.apply {
            adapter = this@CallsFragment.adapter
            layoutManager = LinearLayoutManager(activity)
        }

        button_call.setOnClickListener {
            //in real app make some call, but for simplify just add info about call
            viewModel.addCall(edit_phone_number.text.toString())
        }
    }
}