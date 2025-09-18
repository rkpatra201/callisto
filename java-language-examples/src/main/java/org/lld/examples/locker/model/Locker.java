package org.lld.examples.locker.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Locker {
    private String lockerId;
    private List<Slot> slots;
}
