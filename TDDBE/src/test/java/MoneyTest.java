import static org.junit.Assert.*;

import tddbe.Money;
import tddbe.Dollar;
import tddbe.Franc;

import org.junit.Test;

// < To do list >
//
// $5 + 10CHF = $10 (환율 2:1)
// (V) $5 * 2 = $10
// (V) Dollar side effect -> FP in Scala
// (V) equality
// (V) 5CHF X 2 = 10CHF
// (V) Franc과 Dollar 비교하기
// amount 필드를 private
// Money 반올림?
// hashCode()
// Equal null
// Equal object -> 달러가 아닌게 들어오면?
// Dollar/Franc 중복
// 공용 equals
// 공용 times
// 통화?

// 1.red
// 2.green
// 3.refactoring (중복 제거 + 의미를 드러내기)

public class MoneyTest {

	@Test
	public void testSample() {
//		assertEquals(Dollar(5), Dollar(5) + Franc(10));
	}

	@Test
	public void testMultiplication() {
		Dollar five = new Dollar(5);
		assertEquals(new Dollar(10), five.times(2));
		assertEquals(new Dollar(15), five.times(3));
	}

	@Test
	public void testEquality() {
		
		assertTrue(new Dollar(5).equals(new Dollar(5)));
		assertFalse(new Dollar(5).equals(new Dollar(6)));

		Franc franc = new Franc(5);
		assertTrue(new Franc(5).equals(franc));
		assertFalse(new Franc(6).equals(franc));

		assertFalse(new Franc(5).equals(new Dollar(5)));

	}
	
	@Test
	public void testFrancMultiplication() {
		Franc five = new Franc(5);
		assertEquals(new Franc(10), five.times(2));
		assertEquals(new Franc(15), five.times(3));
	}

}
