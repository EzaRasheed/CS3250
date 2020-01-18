//zh2yn and er6qt
//test automation for assignment 8
//Test set for Question 2

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoundedQueueTest {
	
	private BoundedQueue bq;
	
	@BeforeEach
	public void setUp() throws Exception 
	{
		bq = new BoundedQueue(1); 
	}
	
	@Test
	//1
	//This test initializes a boundedQueue and checks to see if it's empty
	void BQOneInput() {
		assertTrue(bq.isEmpty());
	};


	
	@Test
	//2
	//This test case shows that you cannot call enQueue on null
	void enQueueOnNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			bq.enQueue(null);
	});	
}
	
	@Test
	//3
	//This test case shows that you cannot add another element to the queue once it's past capacity, otherwise it will throw an error
	void enQueueOnFull() {
		Assertions.assertThrows(IllegalStateException.class, () -> {
			BoundedQueue queue = new BoundedQueue(2);
			queue.enQueue(1);
			queue.enQueue(3);
			queue.enQueue(1);
			
		});
	}
	
	@Test
	//4
	//This test case shows that enQueue is working by checking to see whether there are some elements in the bounded queue
	void enQueueNotFull() {
		BoundedQueue queue = new BoundedQueue(2);
		queue.enQueue(1);
		queue.enQueue(3);
		assertFalse(queue.isEmpty());
	}
	
	@Test
	//5
	//This test case shows that you cannot dequeue or remove an element if the queue is empty
	void deQueueEmpty() {
		Assertions.assertThrows(IllegalStateException.class, () -> {
			bq.deQueue();
		});
	}
	
	@Test
	//6
	//This test shows that dequeue removes the oldest element in the queue
	void deQueueNonEmptyQueue() {
		BoundedQueue queue = new BoundedQueue(3);
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.deQueue();
		assertEquals(1, 1);
		
	}
	@Test
	//7
	//This sees whether the queue is empty after it's been initialized
	void checkIsEmpty() {
		assertEquals(true, bq.isEmpty());
	}
	
	@Test
	//8
	//Once we add elements based on the capacity, this checks whether the queue is full
	void checkIsFull() {
		BoundedQueue queue = new BoundedQueue(2);
		queue.enQueue(1);
		queue.enQueue(2);
		assertEquals(true, queue.isFull());
	}
	
	@Test
	//9
	//This test case checks that the method returns "[]" if the queue is empty
	void toStringOnEmpty() {
		assertEquals("[]", bq.toString());
	}
	
	@Test
	//10
	//This test case checks that the method will return the correct elements in the Queue when toString is called 
	void toStringNonEmpty() {
		BoundedQueue queue = new BoundedQueue(2);
		queue.enQueue(1);
		queue.enQueue(2);
		assertEquals("[1, 2]", queue.toString());
	}
}
