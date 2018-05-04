import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSet
{

	Set empty, one, many;

	@Before
	public void setUp() throws Exception
	{
		empty = new Set();
		one = new Set();
		one.add(1);
		many = new Set();
		many.add(1);
		many.add(2);
	}

	@Test
	public void isEmpty()
	{
		assertTrue(empty.isEmpty());
		assertFalse(one.isEmpty());
	}

	@Test
	public void size()
	{
		assertEquals(empty.getCount(), 0);
		assertEquals(one.getCount(), 1);
	}

	@Test
	public void add()
	{
		assertEquals(empty.getCount(), 0);
		// duplicate one
		one.add(1);
		assertEquals(one.getCount(), 1);
		// sorted many
		many.add(3);
		assertEquals(many.getCount(), 2);
		// unsorted many
		many.add(0);
		assertEquals(many.getCount(), 3);
		// unsorted many
		many.add(3);
		assertEquals(many.getCount(), 4);

	}

	@Test
	public void contains()
	{
		assertFalse(empty.contains(1));
		assertTrue(one.contains(1));
		assertFalse(one.contains(2));
	}

	//
	@Test
	public void remove()
	{
		one.remove(1);
		assertFalse(one.contains(1));

		// 1,2
		many.remove(2);
		assertFalse(many.contains(2));

		// 1
		many.remove(3);
		assertFalse(many.contains(3));

		many.add(3);
		many.add(0);

		// 1, 3 ,0
		many.remove(0);
		assertFalse(many.contains(0));

	}

	@Test
	public void grow()
	{
		Set set = new Set(2);
		set.add(1);
		set.add(3);
		set.add(2);
		assertEquals(set.getSizeOfSet(), 3);
		set.add(0);
		set.add(4);
		assertEquals(set.getSizeOfSet(), 5);
	}

	// @Test
	// public void shrink()
	// {
	// }
}
