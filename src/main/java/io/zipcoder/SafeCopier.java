package io.zipcoder;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier {

    public SafeCopier(String toCopy) {
        super(toCopy);
    }

    @Override
    public void run() {
        try {
            while (stringIterator.hasNext()) {
                Thread.sleep(1000);
                if (stringIterator.hasNext()) {
                    sync();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
     void sync() {
        copied += this.stringIterator.next() + " ";
    }
//        try {
//            while (stringIterator.hasNext()) {
//                Thread.sleep(1000);
//                if (stringIterator.hasNext()) {
//                    StringBuilder sb = new StringBuilder();
//                    sb.append(this.stringIterator.next()).append(" ");
//                    copied += sb.toString();
//                }
//            }
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
