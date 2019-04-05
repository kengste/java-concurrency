### Race Conditions

This is a simple illustration of race condition in Java multi-threading. In this case, the shared resource is an instance of the `Counter` class. The instance variable is increased and decreased so every thread should leave the count at 0. However, if you were to run the program a few times, you might see the final count more than or less than 0. The series of non-atomic actions (READ, WRITE) to switch between contexts results in race condition related bugs when the threads are trying to change a shared resource.

The difference between the `Counter` and `SynchronizedCounter` classes is the use of keyword `synchronized` in the `SynchronizedCounter` class. This restricts resource access to only one thread at a time.

Meanwhile, the `AtomicCounter` class uses the `AtomicLong` class, which ensures READ and WRITE actions are performed atomically, hence eliminating the possibility of race condition related bugs.
