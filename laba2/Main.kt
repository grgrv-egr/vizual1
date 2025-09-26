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
    for ((index, person) in people.withIndex()) {
        val thread = thread {
            println("Запущен поток для ${person.name}")
            repeat(simulationTime) {
                person.move()
                Thread.sleep(2000)
            }
            println("Поток для ${person.name} завершен")
        }
        threads.add(thread)
    }

    val driverThread = thread {
        println("Запущен поток для водителя ${driver.name}")
        repeat(simulationTime) {
            driver.move()
            Thread.sleep(1000)
        }
        println("Поток для водителя завершен")
    }
    threads.add(driverThread)
    println("\nОжидание завершения потоков...")
    threads.forEach { it.join() }
    println("\nФинальные позиции:")
    for (person in people) {
        println("${person.getFullName()}: (${person.x}, ${person.y})")
    }
    println("${driver.getFullName()}: (${driver.x}, ${driver.y})")
}
