package src.com.bci;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/*
 * Represents a transaction for the purposes of computing the internal rate of return.
 *
 * Note: Negative amounts represent deposits into the investment (i.e. withdrawals from your cash).
 * Positive amounts represent withdrawals from the investment (i.e. deposits into cash).
 * Zero amounts are allowed in case your investment is now worthless.
 * @see XIRR
 */
public class Transaction {

    final double amount;
    final LocalDate when;

    /*
     * Construct a Transaction instance with the given amount at the given day.
     * @param amount the amount transferred
     * @param when the day the transaction took place
     */
    public Transaction(double amount, LocalDate when) {
        this.amount = amount;
        this.when = when;
    }

    /*
     * Construct a Transaction instance with the given amount at the given day.
     * @param amount the amount transferred
     * @param when the day the transaction took place
     */
    public Transaction(double amount, Date when) {
        this.amount = amount;
        this.when = LocalDate.from(when.toInstant().atZone(ZoneId.systemDefault()));
    }

    /*
     * Construct a Transaction instance with the given amount at the given day.
     * @param amount the amount transferred
     * @param when the day the transaction took place, see
     *             {@link LocalDate#parse(java.lang.CharSequence) }
     *             for the format
     */
    public Transaction(double amount, String when) {
        this.amount = amount;
        this.when = LocalDate.parse(when);
    }

    /*
     * The amount transferred in this transaction.
     * @return amount transferred in this transaction
     */
    public double getAmount() {
        return amount;
    }

    /*
     * The day the transaction took place.
     * @return day the transaction took place
     */
    public LocalDate getWhen() {
        return when;
    }
}
