import kotlin.random.Random
import kotlin.math.*

open class Human : Movable {
    var name: String = ""
    var surname: String = ""
    var second_name: String = ""
    var age: Int = 0
    override var x: Int = 0
    override var y: Int = 0
    override var currentSpeed: Int = 0
    constructor(_name: String, _surname: String, _second: String, _age: Int, _speed: Int){
        name = _name
        surname = _surname
        second_name = _second
        age = _age
        currentSpeed = _speed
    }

    open fun getFullName(): String {
        return "$surname $name $second_name"
    }

    override fun move() {
        val angle = Random.nextDouble(0.0, 2 * PI)
        val distance = Random.nextInt(0, currentSpeed + 1)
        x += (distance * cos(angle)).toInt()
        y += (distance * sin(angle)).toInt(
        println("${name} переместился в (${x}, ${y})")
    }

    override fun getPosition(): String {
        return "($x, $y)"
    }
}
