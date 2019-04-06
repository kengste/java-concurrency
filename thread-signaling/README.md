###Thread Signalling

For thread signalling to work, all threads must have a reference to a shared signal instance object i.e. `CustomSignal` / `WaitNotify`.

`BusyWaitExample` is a simple illustration of signalling, where the waiting thread is kept busy until it receives a signal.However, busy waiting is not an efficient utilization of the CPU in the computer running the thread.

`WaitNotifyExample`, on the other hand, makes use of native Java methods `wait()`, `notify()` and `notifyAll()` to facilitate a more efficient wait mechanism. Threads are basically inactive while waiting for signals.

** Do not use global objects or string constants for `wait()` / `notify()` mechanisms. Use an object that is unique to the construct using it. 