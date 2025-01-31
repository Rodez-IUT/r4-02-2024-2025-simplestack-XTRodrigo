package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test behaviour of a SimpleStack")
class SimpleStackTest {

    private Stack stack;
    private Item item;

    private Item item2;

    @BeforeEach
    @DisplayName("Declaration of a stack and a two items")
    public void setUp() {
        stack = new SimpleStack();
        item = new SimpleItem();
        item2 = new SimpleItem();
    }
    @Test
    @DisplayName("Test the state of a newly created slack")
    public void testCreateEmptyStack() { // Test case

        // Then… (oracle)
        assertTrue(stack.isEmpty(), "A new stack must be empty");
        assertEquals( 0, stack.getSize(), "A new stack has no element");
    }

    @Test
    @DisplayName("Test the push of items")
    public void testPush() throws EmptyStackException {

        // When the item is pushed in the stack
        stack.push(item);

        // Then…
        assertFalse(stack.isEmpty(), "The stack must not be empty");
        assertEquals(1, stack.getSize(),"The stack must constain 1 item");
        assertSame( item, stack.peek(),"The pushed item must be is on top of the stack");

        // When we add the new item
        stack.push(item2);

        // then...
        assertFalse(stack.isEmpty(), "The stack must be not empty");
        assertEquals(2, stack.getSize(),"The stack must constain 2 items");
        assertSame( item2, stack.peek(),"The pushed item must be on top of the stack");
    }

    @Test
    @DisplayName("Test limit when trying to pop an empty stack")
    public void testPopOnEmptyStack()  {

        // When we "pop" the stack, should throws an EmptyStackException.
        //assertThrows(EmptyStackException.class, ()->stack.pop(), "EmptyStackException not thrown");
        assertThrows(EmptyStackException.class, stack::pop, "EmptyStackException not thrown");
    }

    @Test
    @DisplayName("Test pop an non empty stack")
    public void testPopOnNonEmptyStack() throws EmptyStackException {
        stack.push(item);

        // When we "pop" the stack
        Item poppedItem = stack.pop();

        // Then: the returned element must be the one added, and the stack must be empty
        assertEquals(item, poppedItem);
        assertTrue(stack.isEmpty());
    }

    @Test
    @DisplayName("Test peek an empty stack")
    public void testPeekOnEmptyStack() throws EmptyStackException {

        // When we "peek" the stack, should throws an EmptyStackException.
        //assertThrows(EmptyStackException.class, ()->stack.pop(), "EmptyStackException not thrown");
        assertThrows(EmptyStackException.class, stack::peek, "EmptyStackException not thrown");
    }
}
