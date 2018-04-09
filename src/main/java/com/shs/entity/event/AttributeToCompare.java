/**
 * @author Serg Shankunas <shserg2012@gmail.com>
 * Attributes for sorting collections
 */
package com.shs.entity.event;

public enum AttributeToCompare{
    PRICE("Price"),
    PRICEDESC("Price DESC"),
    NAME("Name"),
    STATUS("Status");

    private final String displayName;

    AttributeToCompare (String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
