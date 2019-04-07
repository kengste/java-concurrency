### Nested Monitor Lockout

Nested monitor lockout, simply put, could be as follows:-
Thread 1 is holding a lock A, and waits for a signal from Thread 2. Thread 2 needs the lock A to send the signal to Thread 1.

** Note that in a deadlock, two threads are waiting for each other to release locks.

###### Example 1
The call to `monitorObject.wait()` only releases the synchronization monitor on the `monitorObject` member, and not the synchronization monitor associated with `this`. In other words, the thread that was just parked waiting is still holding the synchronization lock on `this`.

When the thread that locked the `Lock` tries to unlock it by calling `unlock()` it will be blocked trying to enter the `synchronized(this)` block in the `unlock()` method. It will remain blocked until the thread waiting in `lock()` leaves the `synchronized(this)` block. But the thread waiting in the `lock()` method will not leave that block until `isLocked` is set to false, and a `monitorObject.notify()` is executed, as it happens in `unlock()`.

Simply put, the thread waiting in `lock()` needs an `unlock()` call to execute successfully for it to exit `lock()` and the synchronized blocks inside it. But, no thread can actually execute `unlock()` until the thread waiting in `lock()` leaves the outer synchronized block.

###### Example 2
This example illustrates a naive implementation of fairness in a Lock i.e. enabling each thread to call `wait()` on its own queue object so the threads can be notified one at a time. Again, a situation arises whereby a thread is holding onto the shared object's lock and is waiting for a signal from another thread. However, the other thread needs the shared object's lock to execute `unlock()` and send signal.
