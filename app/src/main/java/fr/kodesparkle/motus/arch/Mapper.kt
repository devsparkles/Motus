package fr.kodesparkle.motus.arch

sealed interface Mapper<T, R> {
    interface Suspending<T, R> : Mapper<T, R> {
        suspend fun map(param: T): R
    }

    interface Blocking<T, R> : Mapper<T, R> {
        fun map(param: T): R
    }
}
