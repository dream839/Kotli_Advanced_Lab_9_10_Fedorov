package gameCharacter

fun main() {
    val character = GameCharacter("xc8pt")

    character.changeState(CharacterState.Running)
    printState(character.currentState)

    character.changeState(CharacterState.Attack(25))
    printState(character.currentState)

    character.changeState(CharacterState.Death("упал в пропасть"))
    printState(character.currentState)
}

fun printState(state: CharacterState) {
    when (state) {
        CharacterState.Idle -> println("Персонаж бездействует")
        CharacterState.Running -> println("Персонаж бежит")
        is CharacterState.Attack -> println("Персонаж атакует с уроном ${state.damage}")
        is CharacterState.Death -> println("Персонаж погиб: ${state.reason}")
    }
}