package org.lld.examples.locker.exception;

public class SlotNotFoundException extends RuntimeException {
    public SlotNotFoundException(String message) {
        super(message);
    }
}
