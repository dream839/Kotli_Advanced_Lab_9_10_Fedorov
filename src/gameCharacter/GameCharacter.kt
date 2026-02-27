package gameCharacter

class GameCharacter(val name: String) {
    var currentState: CharacterState = CharacterState.Idle
        private set

    fun changeState(newState: CharacterState) {
        currentState = newState
    }
}