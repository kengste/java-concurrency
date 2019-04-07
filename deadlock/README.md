### Deadlock

Deadlock describes a situation where two or more threads are blocked forever, waiting for one another. Deadlocks occur when the `synchronized` keyword causes the executing thread to block while waiting to get the lock associated with the specified object. Since the lock may be held by another thread, the threads could end up waiting for other threads to release the lock. In such case, they end up waiting forever, resulting in a deadlock situation.
