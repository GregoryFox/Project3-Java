/**
 * localeListMan.java
 * Gregory Fox
 *
 */

public class localeListMan {

    private localeClass head = null;
    private localeClass last = null;


    public localeClass getHead() {
        return head;
    }
    public void setHead(localeClass head) {
        this.head = head;
    }

    public void add(localeClass location) {

        if (this.head == null) {

            this.head = location;
            this.last = location;
        } else {

            this.last.setNext(location);
            this.last = location;


        }
    }
}