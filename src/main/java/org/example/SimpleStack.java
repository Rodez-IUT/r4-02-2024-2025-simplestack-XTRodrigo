    package org.example;

    import java.util.List;
    import java.util.ArrayList;

    public class SimpleStack implements Stack {

        //Déclaration de la liste qui va stocker les items
        private List<Item> stackListe;

        //Constructeur qui initialise la liste
        public SimpleStack(){
            this.stackListe = new ArrayList<>();
        }

        /**
         * Tests if this stack is empty
         */
        @Override
        public boolean isEmpty() {
            return stackListe.isEmpty();
        }

        /**
         * Returns the number of items in this stack.
         */
        @Override
        public int getSize() {
            return stackListe.size();
        }

        /**
         * Pushes an item onto the top of this stack.
         * null item is allowed.
         *
         * @param item an item of the stack
         */
        @Override
        public void push(Item item) {
            stackListe.add(item);
        }

        /**
         * Looks at the object at the top of this stack without removing it from the stack.
         */
        @Override
        public Item peek() throws EmptyStackException {
            if(isEmpty()){
                throw new EmptyStackException();
            }
            return stackListe.get(stackListe.size()-1);
        }

        /**
         * Removes the object at the top of this stack and returns
         * that object as the value of this function.
         *
         * @throws EmptyStackException if this stack is empty.
         */
        @Override
        public Item pop() throws EmptyStackException {
            if(isEmpty()){
                throw new EmptyStackException();
            }
            return stackListe.remove(stackListe.size()-1);
        }
    }
