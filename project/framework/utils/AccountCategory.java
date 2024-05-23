package framework.utils;

public enum AccountCategory {
    CHECKING("CHECKING_ACCOUNT"),
    SAVINGS("SAVINGS_ACCOUNT")
    ;

    private String category;

    AccountCategory(String category) {
        this.category = category;
    }
}
