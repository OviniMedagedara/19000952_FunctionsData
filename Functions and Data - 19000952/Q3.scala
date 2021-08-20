class Account ( nic:String , accnt_num: Int , accnt_bal: Double){

    val NIC_No : String = nic
    val account_number : Int = accnt_num
    var account_balance : Double = accnt_bal

    def debit ( transfer_amount : Double ) = this.account_balance -= transfer_amount

    def credit ( transfer_amount : Double ) = this.account_balance += transfer_amount

    def transfer( transfer_amount : Double , that : Account ): Unit = {
        this.account_balance =  this.account_balance - transfer_amount
        that.account_balance = that.account_balance + transfer_amount
    }

    override def toString() : String = "NIC Number : " + this.NIC_No + "\n Account Number : " + this.account_number + "\n Current Balance : " + this.account_balance

}
