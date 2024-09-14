package tools.important.russianroulette

import kotlin.random.Random


object Revolver {
    private var rotation: Int = 0
        set(newRotation) {
            field = newRotation % CHAMBER_SIZE
        }
    private const val CHAMBER_SIZE = 6
    private val bullets: MutableList<Boolean> = mutableListOf()

    fun load() {
        for (n in 1..CHAMBER_SIZE) {
            bullets.add(false)
        }
        bullets[Random.nextInt(CHAMBER_SIZE)] = true
    }

    fun spin() {
        rotation += Random.nextInt(12)
    }

    fun pull(): Boolean {
        val fired = bullets[rotation]
        rotation += 1
        return fired
    }
}