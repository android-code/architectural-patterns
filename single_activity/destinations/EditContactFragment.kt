class EditContactFragment : Fragment() {

    private val viewModel: PhoneViewModel by lazy {
        ViewModelProviders.of(activity!!).get(PhoneViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_edit_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val contact = arguments?.run {
            if(containsKey("CONTACT")) {
                getSerializable("CONTACT") as Contact
            }
            else null
        }

        contact?.run {
            edit_name.setText(name)
            edit_phone_number.setText(phoneNumber)
            button_save.setOnClickListener {
                //in real app make some validation before
                editContact(this)
                findNavController().navigate(R.id.editContact_to_contacts)
            }
        }
    }

    private fun editContact(old: Contact) {
        val name = edit_name.text.toString()
        val phoneNumber = edit_phone_number.text.toString()
        viewModel.editContact(old, Contact(name, phoneNumber))
    }
}