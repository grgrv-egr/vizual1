import kotlin.random.Random
import kotlin.math.*

open class Human(
    var name: String,
    var surname: String,
    var second_name: String,
    var age: Int,
    override var currentSpeed: Int
) : Movable {
    
    override var x: Int = 0
    override var y: Int = 0

    open fun getFullName(): String {
        return "$surname $name $second_name"
    }

    override fun move() {
        val angle = Random.nextDouble(0.0, 2 * PI)
        val distance = Random.nextInt(0, currentSpeed + 1)

        x += (distance * cos(angle)).toInt()
        y += (distance * sin(angle)).toInt()
        println("${name} переместился в (${x}, ${y})")
    }

    override fun getPosition(): String {
        return "($x, $y)"
    }
}
