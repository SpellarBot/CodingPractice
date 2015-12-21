package tddbe;

public class Sum implements Expression {

    public Expression augend;
    public Expression addend;

    public Sum(Expression argend, Expression addend) {
        this.augend = argend;
        this.addend = addend;
    }

    public Money reduce(Bank bank, String to) {
        int amount = augend.reduce(bank, to).amount + addend.reduce(bank, to).amount;
        return new Money(amount, to);
    }

    public Expression plus(Expression addend) {
        return null;
    }

}
