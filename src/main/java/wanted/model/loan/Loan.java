package wanted.model.loan;

import static wanted.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import wanted.commons.util.ToStringBuilder;
import wanted.model.tag.Tag;

/**
 * Represents a Loan in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Loan {
    // Identity fields
    private final Name name;
    private final Amount amount;
    private final LoanDate loanDate;
    // Data fields
    private final Set<Tag> tags = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Loan(Name name, Amount amount, LoanDate date, Set<Tag> tags) {
        //requireAllNonNull(name, phone, email, address, amount, date, tags);
        requireAllNonNull(name, amount, date, tags);
        this.name = name;
        //this.phone = phone;
        //this.email = email;
        //this.address = address;
        this.amount = amount;
        this.loanDate = date;
        this.tags.addAll(tags);
    }

    public Name getName() {
        return name;
    }

    public Amount getAmount() {
        return amount;
    }
    public LoanDate getLoanDate() {
        return loanDate;
    }
    /*
    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }
    */
    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both persons have the same name.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Loan otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null
                && otherPerson.getName().equals(getName());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Loan)) {
            return false;
        }

        Loan otherPerson = (Loan) other;
        return name.equals(otherPerson.name)
                //&& phone.equals(otherPerson.phone)
                //&& email.equals(otherPerson.email)
                //&& address.equals(otherPerson.address)
                && amount.equals(otherPerson.amount)
                && loanDate.equals(otherPerson.loanDate)
                && tags.equals(otherPerson.tags);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        //return Objects.hash(name, phone, email, address, amount, loanDate, tags);
        return Objects.hash(name, amount, loanDate, tags);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", name)
                .add("amount", amount)
                .add("date", loanDate)
                .add("tags", tags)
                .toString();
    }

}
