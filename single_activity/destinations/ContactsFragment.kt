class ContactsFragment : Fragment(), ContactsAdapter.OnClickListener {

    private val viewModel: PhoneViewModel by lazy {
        ViewModelProviders.of(activity!!).get(PhoneViewModel::class.java)
    }
    private val adapter = ContactsAdapter().apply { setOnClickListener(this@ContactsFragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getContacts().observe(this, Observer {
            adapter.addItems(it)
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_contacts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_view_contacts.apply {
            adapter = this@ContactsFragment.adapter
            layoutManager = LinearLayoutManager(activity)
        }

        button_add_contact.setOnClickListener {
            findNavController().navigate(R.id.contacts_to_addContact)
        }
		
        //if needed provide some conditional navigation based on ViewModel state here
    }

    override fun contactClick(contact: Contact) {
        //pass small data between destinations by Bundle or Safe Args
        //in real example it could be only some id instead of full object
        val args = Bundle().apply { putSerializable("CONTACT", contact) }
        findNavController().navigate(R.id.contacts_to_contactDetails, args)
    }
}