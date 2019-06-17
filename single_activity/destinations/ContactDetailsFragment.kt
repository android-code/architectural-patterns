class ContactDetailsFragment : Fragment() {

    private val viewModel: PhoneViewModel by lazy {
        ViewModelProviders.of(activity!!).get(PhoneViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_contact_details, container, false)
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
            text_view_name.text = name
            text_view_phone_number.text = phoneNumber
            button_call.setOnClickListener {
                //in real app make some call, but for simplify just add info about call
                viewModel.addCall(name)
            }
            button_edit.setOnClickListener {
                val args = Bundle().apply { putSerializable("CONTACT", this@run) }
                findNavController().navigate(R.id.contactDetails_to_editContact, args)
            }
        }
    }
}