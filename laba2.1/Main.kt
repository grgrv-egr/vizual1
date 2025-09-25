import kotlin.concurrent.thread

fun main() {
    val people = listOf(
        Human("Петя", "Иванов", "Петрович", 20, 5),
        Human("Анна", "Петрова", "Игоревна", 22, 4),
        Human("Виктор", "Сидоров", "Алексеевич", 21, 6),
        Human("Ольга", "Васильева", "Сергеевна", 19, 3)
    )
    val driver = Driver("Егор", "Григорьев", "Васильевич", 19, 8)
    val movableObjects: List<Movable> = people + driver
    println("Начальные позиции:")
    movableObjects.forEach { 
        if (it is Human) println("${it.getFullName()}: ${it.getPosition()}") 
    }
    println()
    val threads = mutableListOf<Thread>()
    movableObjects.forEachIndexed { index, movable ->
        val thread = thread {
            repeat(5) { step ->
                Thread.sleep((index * 100).toLong())
                movable.move()
                Thread.sleep(200)
            }
        }
        threads.add(thread)
    }
    threads.forEach { it.join() }
    println("\nФинальные позиции:")
    movableObjects.forEach { 
        if (it is Human) println("${it.getFullName()}: ${it.getPosition()}") 
    }
}
