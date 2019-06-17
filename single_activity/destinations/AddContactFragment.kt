class AddContactFragment : Fragment() {

    private lateinit var viewModel: PhoneViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(activity!!).get(PhoneViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_add_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_save.setOnClickListener {
            addContact()
            findNavController().navigate(R.id.addContact_to_contacts)
        }
    }

    private fun addContact() {
        //add to some database and make some validations, but for simplify add just to ViewModel
        val name = edit_name.text.toString()
        val phoneNumber = edit_phone_number.text.toString()
        viewModel.addContact(name, phoneNumber)
    }
}