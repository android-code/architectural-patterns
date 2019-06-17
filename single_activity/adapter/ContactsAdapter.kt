class ContactsAdapter : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    private val items = mutableListOf<Contact>()
    private var onClickListener: OnClickListener? = null

    interface OnClickListener {
        fun contactClick(contact: Contact)
    }

    fun setOnClickListener(listener: OnClickListener) {
        onClickListener = listener
    }

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val name: TextView = view.contact_name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_contact, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.name.text = item.name
        holder.view.setOnClickListener { onClickListener?.contactClick(item) }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addItems(newItems : List<Contact>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    fun addItem(contact: Contact) {
        items.add(contact)
        notifyDataSetChanged()
    }
}