import java.lang.IllegalArgumentException

sealed class Either<out E,out S> {

    data class Success<out S>(val value:S):Either<Nothing,S>(){
        override fun toString(): String {
            return "Success $value"
        }
    }

    data class Fail<out E>(val message:E):Either<E,Nothing>(){
        override fun toString(): String {
            return "Failure ${IllegalArgumentException("Error")}"
        }
    }

    fun successOrNull():S?=when(this){
        is Success -> value
       is Fail -> null
    }

    fun failOrNull():E? = when(this){
        is Success -> null
        is Fail -> message
    }
}
