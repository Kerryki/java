import org.w3c.dom.Node;
/**
 * Name(s) and ID(s): Kigham Kerry Kinyuy 40207088 and Armaan Waels 40196241
 * COMP249 Assignment #3
 * Due Date: 3 Dec 2023
 * **/
import java.util.NoSuchElementException;

/**
 * The {@code CellList} class represents a linked list of {@code CellPhone} objects.
 * It provides methods to manipulate the linked list, such as adding to the start
 * or end, replacing and inserting at specific indexes, deleting from specific indexes,
 * finding objects based on serial numbers, checking if a serial number exists, and
 * displaying the contents of the list.
 */
public class CellList {

    /**
     * Represents a node in the linked list.
     */
    private Cellnode head;
    /**
     * Represents the number of nodes in the linked list.
     */
    private int count;
    /**
     * Constructs an empty {@code CellList} with no nodes.
     */
    public CellList(){
    this.head=null;
    this.count=0;
    }
    /**
     * Adds a new {@link CellPhone} to the beginning of the linked list.
     *
     * @param phone The {@code CellPhone} to be added.
     */
    public void AddToStart(CellPhone phone){
        if(head==null){
            Cellnode newnode= new Cellnode(phone, null);
            head=newnode;
        }else {
            Cellnode newnode= new Cellnode(phone, head);
            head = newnode;
            count++;
        }
    }
    /**
     * Adds a new {@link CellPhone} to the end of the linked list.
     *
     * @param phone The {@code CellPhone} to be added.
     */
    public void AddToEnd(CellPhone phone){

        Cellnode newnode= new Cellnode(phone, null);
        if(head==null){
            head=newnode;
            count++;
        }else {
            Cellnode position = head;
            while (position.getNext() != null) {
                position = position.getNext();
            }

            position.setNext(newnode);
            count++;

        }

    }
    /**
     * Replaces the {@link CellPhone} at the specified index with a new one.
     *
     * @param phone The new {@code CellPhone} to replace the existing one.
     * @param i The index at which the replacement should occur.
     */
    public void replaceAtIndex(CellPhone phone, int i ){
        if(head==null){
            head=new Cellnode(phone, null);
        }
        Cellnode position= head;
        Cellnode newnode= new Cellnode(phone, position.getNext().getNext());
        int index=0;

        while(position.getNext()!=null){
            position=position.getNext();
            index++;
            if(index==i-1){
                break;
            }

            while(position.getNext()!=null){

                position.setNext(newnode);
            }


        }
        if(position.getNext()==null){
            AddToEnd(phone);
        }
    }

    /**
     * Inserts a new {@link CellPhone} at the specified index in the linked list.
     *
     * @param phone The {@code CellPhone} to be inserted.
     * @param i The index at which the insertion should occur.
     * @throws NoSuchElementException if the index is out of bounds.
     */

    public void insertAtIndex(CellPhone phone, int i){
        if(i<0 || i>count){
            throw new NoSuchElementException();
        }
        if(i==1){
            AddToStart(phone);
            count++;

        }

        Cellnode position=head;
        int index=0;

        while(position.getNext()!=null) {
            position=position.getNext();
            index++;
            if(index==i-1){
                break;
            }
        }

        if(position.getNext()!=null && index==i-1){
            Cellnode newnode= new Cellnode(phone, position.getNext());
            position.setNext(newnode);
            count++;

        }

        if(index==count-1){
        AddToEnd(phone);
            count++;

        }

    }
    /**
     * Deletes the {@link CellPhone} at the specified index from the linked list.
     *
     * @param i The index of the {@code CellPhone} to be deleted.
     * @throws NoSuchElementException if the index is out of bounds.
     */
    public void deleteFromIndex(int i){

        if(i<0 || i>count){
            throw new NoSuchElementException();
        }
        if(i==1){
            head=head.getNext();
            count--;
        }
        Cellnode position=head;
        int index=0;
        while(position.getNext()!=null){
            position=position.getNext();
            if(index==i-1){
                break;
            }

        }
        if(position.getNext()!=null) {
            position.setNext(position.getNext().getNext());
            count--;

        }


    }

    /**
     * Deletes the first {@link CellPhone} from the linked list.
     */
    public void deleteFromStart(){
        if(head.getNext()!=null){
            head=head.getNext();
            count--;

        }
    }

    /**
     * WARNING: Potential Privacy Leak
     *
     * This method exposes internal details by returning a reference to a Cellnode.
     * External code may gain access to the internal structure of the linked list,
     * violating encapsulation. Any changes to the internal representation of the
     * linked list may impact external code relying on this exposed reference.
     *
     *
     *
     *
     * @param serialnumber The serial number to search for in the linked list.
     * @return A reference to the Cellnode where the object is found or null if not found.
     */
        public Cellnode find(long serialnumber){
        if(head==null){
            System.out.println("Empty list");
        }

        int index =0;
        Cellnode position= head;
        while(position!=null){
            if(position.getA().getSerialNum()==serialnumber){
                System.out.println("Object number" + (index+1) + " contains serial number" + serialnumber);
                return position;
            }
            position=position.getNext();
            index++;
        }

        return null;
        }

    /**
     * Checks if the linked list contains a {@code CellPhone} with the specified serial number.
     *
     * @param serialnumber The serial number to search for.
     * @return {@code true} if the list contains a matching serial number, {@code false} otherwise.
     */
        public boolean contains(long serialnumber){
            if(head==null){
               return false;
            }

            int index =0;
            Cellnode position= head;
            while(position!=null){
                if(position.getA().getSerialNum()==serialnumber){
                   return true;
                }
                position=position.getNext();
                index++;
            }

            return false;
        }
    /**
     * Displays the contents of the linked list, including the size and objects in the list.
     */
        public void showcontents(){

            if(head==null){
                System.out.println("Empty list");
            }else {

                System.out.println("The current size of the list is " + count + ". Here are the contents of the list");
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println("--------------------------------------------------------------------------------");
            }
            Cellnode position= head;
            int counter=0;

            while (position != null) {
                System.out.print(position.getA().toString());
                counter++;
                position = position.getNext();

                if (position != null) {
                    System.out.print("--->");
                } else {
                    System.out.println("---> X");
                }

                // Check if three objects have been printed
                if (counter % 3 == 0) {
                    System.out.println();  // Move to the next line
                }
            }


        }

    /**
     * Checks if the current {@code CellList} is equal to another {@code CellList} based on their contents.
     *
     * @param obj The object to compare with.
     * @return {@code true} if the two lists are equal, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {

        if(obj==null){
            return false;
        }

        if(getClass()!= obj.getClass()){
            return false;
        }else {
            CellList otherlist = (CellList) obj;
            Cellnode position= head;
            Cellnode position2=otherlist.head;
            if (head == null && otherlist.head == null) {
                return true;  // Both are empty, consider them equal
            }

            if (head == null || otherlist.head == null) {
                return false;  // One is empty, the other is not
            }

            while(position!=null && position2!=null){
                if(!position.getA().equals(position2.getA())){
                    return false;
                }
               position= position.getNext();
                position2=position2.getNext();
            }
        }
        return true;
    }

    /**
     * Creates a deep copy of the linked list from another {@code CellList}.
     *
     * @param originalList The {@code CellList} to copy from.
     */
    public void deepCopy(CellList originalList) {
        // Clear the current content of the list
        this.head = null;
        this.count = 0;

        if (originalList.head != null) {
            // Copy the first node separately to set the head
            this.head = new Cellnode(new CellPhone(
                    originalList.head.getA().getSerialNum(),
                    originalList.head.getA().getBrand(),originalList.head.getA().getPrice(),
                    originalList.head.getA().getYear()
            ), null);

            Cellnode originalNode = originalList.head;
            Cellnode newNode = this.head;

            // Iterate through the rest of the original list to copy each node
            while (originalNode.getNext() != null) {
                originalNode = originalNode.getNext();
                newNode.setNext(new Cellnode(new CellPhone(
                        originalNode.getA().getSerialNum(),
                        originalNode.getA().getBrand(), originalNode.getA().getPrice(),
                        originalNode.getA().getYear()
                ), null));
                newNode = newNode.getNext();
            }

            // Update the count
            this.count = originalList.count;
        }
    }

    /**
     * Represents a node in the linked list.
     */
    private class Cellnode implements Cloneable{ //node for linkedlist
        /**
         * The {@code CellPhone} object stored in this node.
         */
        private  CellPhone a;
        /**
         * The reference to the next node in the linked list.
         */
        private Cellnode next;
        /**
         * Constructs an empty node with null values.
         */
        public Cellnode(){
            this.a=null;
            this.next=null;
        }
        /**
         * Constructs a node with the specified {@code CellPhone} object and reference to the next node.
         *
         * @param cell The {@code CellPhone} object to be stored in the node.
         * @param next The reference to the next node in the linked list.
         */
        public Cellnode(CellPhone cell, Cellnode next){
            this.a=cell;
            this.next=next;
        }
        /**
         * Gets the {@code CellPhone} object stored in this node.
         *
         * @return The {@code CellPhone} object.
         */

        public CellPhone getA() {
            return a;
        }
        /**
         * Sets the {@code CellPhone} object to be stored in this node.
         *
         * @param a The {@code CellPhone} object to set.
         */
        public void setA(CellPhone a) {
            this.a = a;
        }
        /**
         * Gets the reference to the next node in the linked list.
         *
         * @return The reference to the next node.
         */
        public Cellnode getNext() {
            return next;
        }
        /**
         * Sets the reference to the next node in the linked list.
         *
         * @param next The reference to the next node.
         */
        public void setNext(Cellnode next) {
            this.next = next;
        }
        /**
         * Creates a deep copy of the current node and its subsequent nodes in the linked list.
         *
         * @param originalNode The node to start copying from.
         * @return The deep-copied node.
         */
        private Cellnode deepCopyNode(Cellnode originalNode) {
            if (originalNode == null) {
                return null;
            }

            // Copy the current node
            Cellnode newNode = new Cellnode(new CellPhone(
                    originalNode.getA().getSerialNum(),
                    originalNode.getA().getBrand(),  originalNode.getA().getPrice(),
                    originalNode.getA().getYear()
            ), null);

            // Recursively copy the rest of the linked list
            newNode.setNext(deepCopyNode(originalNode.getNext()));

            return newNode;
        }


        /**
         * Clones the current node.
         *
         * @return A cloned instance of the current node.
         * @throws CloneNotSupportedException If cloning is not supported.
         */
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }



    }


}




