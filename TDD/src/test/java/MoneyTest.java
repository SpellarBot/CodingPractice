import org.junit.Test;
import static org.junit.Assert.*;

// < To do list >
//
// $5 + 10CHF = $10 (환율 2:1)
// (V) $5 * 2 = $10
// (V) Dollar side effect -> FP in Scala
// (V) equality
// amount 필드를 private
// Money 반올림?
// hashCode()
// Equal null
// Equal object -> 달러가 아닌게 들어오면?

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
/*
		// 아래처럼 해도 테스트 가능
		Dollar dollar = new Dollar(5);
		assertTrue(new Dollar(5).equals(dollar));
		assertFalse(new Dollar(6).equals(dollar));
*/
	}

	@Test
	public void testFrancMultiplication() {
		Franc five = new Franc(5);
		assertEquals(new Franc(10), five.times(2));
		assertEquals(new Franc(15), five.times(3));
	}

}
