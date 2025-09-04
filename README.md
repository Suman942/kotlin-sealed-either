# kotlin-sealed-either
A simple Kotlin demo showing how to implement Either&lt;Error, Success> using sealed classes


# Either in Kotlin 🚀

When writing code, functions often have **two possible outcomes**:
1. They succeed and return a result.
2. They fail and return an error.

How do we represent this safely? 🤔

Instead of:
- Returning `null`
- Throwing exceptions everywhere
- Or using multiple values

We can use a **sealed class** called `Either`.


---

## 🔧 Implementation

```kotlin

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
