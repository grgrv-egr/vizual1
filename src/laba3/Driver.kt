class Driver : Human {
    constructor(_name: String, _surname: String, _second: String, _age: Int, _speed: Int)
            : super(_name, _surname, _second, _age, _speed)

    override fun move() {
        x += currentSpeed
        println("Водитель $name едет прямо: (${x}, ${y})")
    }
}