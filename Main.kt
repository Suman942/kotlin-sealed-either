fun main(args: Array<String>) {
    val result1 = Either.Success("Ok")
    val result2 = Either.Fail(IllegalArgumentException("Error"))
    val either : Either<Exception,String> = Either.Success("done")
    val eS = either.successOrNull()
    val eF = either.failOrNull()
    println(result1) //Success Ok
    println(eS) // done
    println(result2) // Failure java.lang.IllegalArgumentException: Error
    println(eF) //null
}
