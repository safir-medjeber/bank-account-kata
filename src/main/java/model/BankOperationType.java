package model;

public enum BankOperationType {
    DEPOSIT("deposit"),
    WITHDRAWAL("withdrawal");

   private final String value;

    BankOperationType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
