class Humans
{
    var name: String = ""
    var surname: String = ""
    var second_name: String = ""

    var group_number: Int = -1
    var x = 0
    var y = 0

    constructor(_name: String, _surname: String, _second: String, _gn: Int){
        name = _name
        surname = _surname
        second_name = _second
        group_number = _gn
        println("We created the Human object with name: $name")
    }

    fun move()
    {
        println("Human is moved")
    }

    fun moveTo(_toX: Int, _toY: Int)
    {
        x = _toX
        y = _toY
        println("Human is moved TO: $x,$y")
    }
}

fun main(){
    val petya: Humans = Humans("Petya","Ivanov","Petrovich",444)
    petya.move()
    petya.moveTo(10,100)
    println("${petya.x}")

    var counter: Int = 10
    val name: String = ""
    println(name)
    println("Hello World!")
}