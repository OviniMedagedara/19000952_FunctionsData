object Bank extends App {

    var bank : List[account] = List( new account("John" , 1 , -50000) , new account("Doe" , 2 , 100000) )

    val find = ( p : Int , q : List[account]) => q.filter( x => x.account_number.equals( p ))

    val overdraft_account = ( q : List[account] ) => q.filter( x => x.account_balance < 0)

    val account_balance = ( q : List[account] ) => q.map( x => (x,x.account_balance) ).reduce( (a , c) => ( c._1 , a._2 + c._2) )

    val interest = ( q : List[account] ) => q.map( x => {
        x.account_balance match {
            case a if a >= 0 => x deposit (x.account_balance * 0.05)
            case _ => x withdraw Math.abs(x.account_balance) * 0.01

        }
        x
    })


    println("bank " + bank )
    println()
    println("find " + find( 2 , bank) )
    println()
    println("overdraft " + overdraft_account( bank ) )
    println()
    println("account_balance " + account_balance( bank )._2 )
    println()
    bank = interest( bank )
    println("bank " + bank )
    println()
    println("account_balance " + account_balance( bank )._2 )
    println()
}
