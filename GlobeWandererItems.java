/**
 * GlobeWanderItems.java
 * Gregory Fox
 *
 */

//PUBLIC

public class globeWandererItems {

    public globeWandererItems(int theId) {
        id = theId;
    }
    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getLocale() {
        return locale;
    }

    public void setLocale(int locale) {
        this.locale = locale;
    }

    public globeWandererItems getNext() {
        return next;
    }

    public void setNext(globeWandererItems next) {
        this.next = next;
    }

    public String toString() {
        return "[item: id= " + this.id + " name= " + this.itemName + " desc= " + this.desc + "]";
    }

//PRIVATE

    private int    id;
    private String itemName;
    private String desc;
    private int    locale;
    private globeWandererItems next = null;
}