### Slipped Conditions

Slipped condition arises when a thread has checked a certain condition until it acts upon it, the condition has been changed by another thread so that it is errorneous for the first thread to act.

In the example, both threads test the condition and exit the synchronized block, thereby allowing other threads to test the condition. This means the condition has slipped from the time the condition was checked until the threads change it for subsequent threads.

To avoid slipped conditions, the testing and setting of conditions must be done atomically by the thread, meaning no other threads can check the condition in between the testing and setting of the condition by the first thread.

** If you were to run the example, you would not be able to see the slipped condition arising as the threads are not actually started at the same time.