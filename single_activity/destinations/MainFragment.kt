class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        button_calls.setOnClickListener {
            findNavController().navigate(R.id.main_to_calls)
        }
        button_contacts.setOnClickListener {
            findNavController().navigate(R.id.main_to_contacts)
        }
        button_about.setOnClickListener {
            findNavController().navigate(R.id.main_to_about)
        }
    }
}