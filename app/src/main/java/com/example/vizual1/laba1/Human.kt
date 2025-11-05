import kotlin.random.Random
import kotlin.math.*

class Human
{
    var name: String = ""
    var surname: String = ""
    var second_name: String = ""
    var age: Int = 0
    var currentSpeed: Int = 0
    var group_number: Int = -1
    var x: Int = 0
    var y: Int = 0
    constructor(_name: String, _surname: String, _second: String, _age: Int, _speed: Int, _gn: Int){
        name = _name
        surname = _surname
        second_name = _second
        age = _age
        currentSpeed = _speed
        group_number = _gn
    }

    fun getFullName(): String {
        return "$surname $name $second_name"
    }

    fun move()
    {
        val angle = Random.nextDouble(0.0, 2 * PI)
        val distance = Random.nextInt(0, currentSpeed + 1)

        x += (distance * cos(angle)).toInt()
        y += (distance * sin(angle)).toInt()
    }

    fun moveTo(_toX: Int, _toY: Int)
    {
        x = _toX
        y = _toY
    }
}

fun main(){
    val people = arrayOf(
        Human("Петя", "Иванов", "Петрович", 20, 5, 444),
        Human("Анна", "Петрова", "Игоревна", 22, 4, 442),
        Human("Виктор", "Сидоров", "Алексеевич", 21, 6, 443),
        Human("Ольга", "Васильева", "Сергеевна", 19, 3, 441)
    )
    val simulationTime = 10
    for (second in 1..simulationTime) {
        println("\nСекунда $second:")
        for (person in people) {
            person.move()
            println("${person.name} переместился в (${person.x}, ${person.y})")
        }
        Thread.sleep(1000)
    }
    println("\nФинальные позиции:")
    for (person in people) {
        println("${person.getFullName()}: (${person.x}, ${person.y})")
    }
}