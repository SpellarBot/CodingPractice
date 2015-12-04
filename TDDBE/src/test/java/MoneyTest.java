import static org.junit.Assert.*;
import tddbe.Money;
import org.junit.Test;

// < To do list >
//
// $5 + 10CHF = $10 (환율 2:1)
// (V) $5 * 2 = $10
// (V) Dollar side effect -> FP in Scala
// (V) equality
// (V) 5CHF X 2 = 10CHF
// (V) Franc과 Dollar 비교하기
// (V) 공용 equals
// (V) 통화?
// amount 필드를 private
// Money 반올림?
// hashCode()
// Equal null
// Equal object -> 달러가 아닌게 들어오면?
// Dollar/Franc 중복
// 공용 times
// (V) testFrancMultiplication을 지워야 할까?

// 1.red
// 2.green
// 3.refactoring (중복 제거 + 의미를 드러내기)

public class MoneyTest {

	@Test
	public void testMultiplication() {
		Money five = Money.dollar(5);
		assertEquals(Money.dollar(10), five.times(2));
		assertEquals(Money.dollar(15), five.times(3));
	}

	@Test
	public void testEquality() {
		assertTrue(Money.dollar(5).equals(Money.dollar(5)));
		assertFalse(Money.dollar(5).equals(Money.dollar(6)));
		assertFalse(Money.franc(5).equals(Money.dollar(5)));
	}
	
	@Test
	public void testCurrency() {
		assertEquals("USD", Money.dollar(1).currency());
		assertEquals("CHF", Money.franc(1).currency());
	}

}
