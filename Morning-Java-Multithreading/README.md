<h2> Blocking Queue </h2>

1. A blocking queue is a queue that blocks when you try to dequeue from it and the queue is empty, or if you try to enqueue items to it and the queue is already full.
2. A thread trying to dequeue from an empty queue is blocked until some other thread inserts an item into the queue.
3. A thread trying to enqueue an item in a full queue is blocked until some other thread makes space in the queue, either by dequeuing one or more items or clearing the queue completely.
4. There should be Multiple thread who are producing, and the number of consuming threads will vary on situation and it should be configurable
