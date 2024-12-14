
package Model_01;

import java.util.Date;

public class MembershipCard_01 {

    private String cardNumber;
    private Date expirationDate;

    public MembershipCard_01(String cardNumber, Date expirationDate) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Date getexpirationdate() {
        return expirationDate;
    }

    public String displayDetails() {
        return cardNumber + expirationDate;
    }
}
