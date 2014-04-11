/**
 * ListMan.java
 * Gregory Fox
 *
 */

public class listMan {

    //
    // Public
    //

    // Constructor
    public listMan() {
    }

    // Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

    public globeWandererItems getHead() {
        return head;
    }
    public void setHead(globeWandererItems head) {
        this.head = head;
    }
    
    
    public void add(gameItems item) {
    	
    	if (this.head == null) {
    		
    		this.head = item;
    		this.last = item;
    		
    	} else {
    		
    		this.last.setNext(item);
    		this.last = item;
    	}
    	}
    }

    // Other methods
    @Override
    public String toString() {
        String retVal;
        retVal = super.toString() + " name=" + this.name + " desc=" + this.desc + "\n";
        globeWandererItems currentItem = this.head;
        while (currentItem != null) {
            retVal = retVal + "   " + currentItem.toString() + "\n";
            currentItem = currentItem.getNext();
        }
        return retVal;
    }


    //
    // Private
    //
    private String name;
    private String desc;
    private globeWandererItems head = null;
	private globeWandererItems last = null;
}