package fr.kodesparkle.motus.di.coroutines

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class CoroutineDispatcherProvider : DispatcherProvider {
    override val main: CoroutineContext get() = Dispatchers.Main
    override val default: CoroutineContext get() = Dispatchers.Default
    override val io: CoroutineContext get() = Dispatchers.IO
    override val unconfined: CoroutineContext get() = Dispatchers.Unconfined
    override val limitedParallelism: CoroutineContext get() = Dispatchers.Default.limitedParallelism(1)
}
