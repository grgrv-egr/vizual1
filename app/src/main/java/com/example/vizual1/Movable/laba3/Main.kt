import kotlin.concurrent.thread

fun main(){
    val people = arrayOf(
        Human("Петя", "Иванов", "Петрович", 20, 5),
        Human("Анна", "Петрова", "Игоревна", 22, 4),
        Human("Виктор", "Сидоров", "Алексеевич", 21, 6),
        Human("Ольга", "Васильева", "Сергеевна", 19, 3)
    )

    val driver = Driver("Егор", "Григорьев", "Васильевич", 19, 8)
    val simulationTime = 5
    val threads = mutableListOf<Thread>()

    for (person in people) {
        val thread = thread {
            repeat(simulationTime) {
                person.move()
                Thread.sleep(1000)
            }
        }
        threads.add(thread)
    }

    val driverThread = thread {
        repeat(simulationTime) {
            driver.move()
            Thread.sleep(1000)
        }
    }
    threads.add(driverThread)

    threads.forEach { it.join() }

    println("\nФинальные позиции:")
    for (person in people) {
        println("${person.getFullName()}: (${person.x}, ${person.y})")
    }
    println("${driver.getFullName()}: (${driver.x}, ${driver.y})")
}