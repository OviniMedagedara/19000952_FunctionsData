class Rational_number( x:Int , y:Int ) {

    require(y>0 , "positive denominator should be there")

    private def gcd( p:Int , q:Int ):Int = {
        if ( q == 0 ) p
        else if ( q > p ) gcd( q , p )
        else gcd( q, p%q )
    }


    private val val_gcd = gcd( Math.abs(x) , y )

    val val_numerator = x/val_gcd

    val val_denominator = y/val_gcd

    def this( x : Int ) = this( x , 1 )

    def +( that : Rational_number) Rational_number= new Rational_number( this.val_numerator * that.val_denominator + that.val_numerator * this.val_denominator  , this.val_denominator * that.val_denominator )

    def neg : Rational_number= new Rational_number( -this.val_numerator , this.val_denominator )

    def -( that : Rational_number) : Rational_number= this + that.neg

    def *( that : Rational_number) : Rational_number= new Rational_number( this.val_numerator * that.val_numerator , this.val_denominator * that.val_denominator )

    def /( that : Rational_number) : Rational_number= new Rational_number( this.val_numerator * that.val_denominator , this.val_denominator * that.val_numerator )

    override def toString() : String = {

        val_denominator match {

            case x if x==1 => val_numerator.toString

            case _ => val_numerator + "/" + val_denominator

        }

    }
}
