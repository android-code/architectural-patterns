class FilmsAdapter : RecyclerView.Adapter<FilmsAdapter.ViewHolder>() {

    val items = mutableListOf<Film>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title : TextView = view.item_title
        val status : TextView = view.item_status
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.title.text = item.title
        holder.status.text = item.status
    }

    override fun getItemCount(): Int = items.size
}