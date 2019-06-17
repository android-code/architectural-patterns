class CallsAdapter : RecyclerView.Adapter<CallsAdapter.ViewHolder>() {

    private val items = mutableListOf<Call>()

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val phone_number: TextView = view.call_phone_number
        val date: TextView = view.call_date
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_call, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.phone_number.text = item.phoneNumber
        holder.date.text = getDate(item.date)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addItems(newItems : List<Call>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    fun addItem(call: Call) {
        items.add(call)
        notifyDataSetChanged()
    }

    private fun getDate(timestamp: Long): String {
        val sdf = SimpleDateFormat("HH:mm dd-MM-yyyy")
        return sdf.format(timestamp)
    }
}