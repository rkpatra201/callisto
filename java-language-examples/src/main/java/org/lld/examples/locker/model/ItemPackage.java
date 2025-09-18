package org.lld.examples.locker.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ItemPackage {
    private String orderId;
    private Size size;
    private String customerId;
    private String secondaryOwner;
}
