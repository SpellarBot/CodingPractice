package tddbe;

/**
 * Created by sykim on 2015. 12. 13..
 */
public class Sum implements Expression {

    public Money augend;
    public Money addend;

    public Sum(Money argend, Money addend) {
        this.augend = argend;
        this.addend = addend;
    }

    public Money reduce(String to) {
        int amount = augend.amount + addend.amount;
        return new Money(amount, to);
    }

}
