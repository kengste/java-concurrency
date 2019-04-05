###ThreadLocal

ThreadLocal variables can only be read and written by the thread itself and not accessible by other threads. This means the set() and get() methods executed in different threads are independent.