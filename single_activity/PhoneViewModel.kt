class PhoneViewModel : ViewModel() {

    private var contacts = MutableLiveData<MutableList<Contact>>()
    private var calls = MutableLiveData<MutableList<Call>>()

    init {
        initContacts()
        initCalls()
    }

    fun getContacts(): LiveData<MutableList<Contact>> {
        return contacts
    }

    fun getCalls(): LiveData<MutableList<Call>> {
        return calls
    }

    //in real world operations should be run on some local database also
    //for simplify it is just mock and manage data only in ViewModel

    fun addContact(name: String, phoneNumber: String) {
        contacts.value?.add(Contact(name, phoneNumber))
        contacts.value = contacts.value
    }

    fun editContact(old: Contact, new: Contact) {
        //in real world use some id to change data instead of searching by all fields
        contacts.value?.run {
            for(contact in this) {
                if(contact.name == old.name && contact.phoneNumber == old.phoneNumber) {
                    contact.name = new.name
                    contact.phoneNumber = old.phoneNumber
                    break
                }
            }
        }
    }

    fun addCall(phoneNumber: String) {
        calls.value?.add(Call(phoneNumber, System.currentTimeMillis()))
        calls.value = calls.value
    }

    private fun initContacts() {
        val list = arrayListOf<Contact>().apply {
            add(Contact("Johnnie", "111 222 333"))
            add(Contact("William", "444 555 666"))
            add(Contact("Jack", "777 888 999"))
        }
        contacts.value = list
    }

    private fun initCalls() {
        val list = arrayListOf<Call>().apply {
            add(Call("Johnnie", 1560500000))
            add(Call("William", 1560400000))
            add(Call("Jack", 1560300000))
            add(Call("123 456 789", 1560200000))
        }
        calls.value = list
    }
}