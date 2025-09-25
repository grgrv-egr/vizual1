class Driver(
    name: String,
    surname: String,
    second_name: String,
    age: Int,
    currentSpeed: Int
) : Human(name, surname, second_name, age, currentSpeed) {

    override fun move() {
        x += currentSpeed
        println("Водитель $name едет прямо: (${x}, ${y})")
    }
}
