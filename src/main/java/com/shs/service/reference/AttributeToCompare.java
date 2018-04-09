package com.shs.service.reference;

/**
 * Attributes for sorting collections.
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
public enum AttributeToCompare {
    PRICE("Price"),
    PRICEDESC("Price DESC"),
    NAME("Name"),
    STATUS("Status");

    private final String displayName;

    AttributeToCompare(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
