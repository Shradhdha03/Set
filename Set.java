/*
Program Name: Set.java
      Author: Shradhdha Parsana
 Description: unordered and unique set 
*/
public class Set
{

	private int count = 0;
	private Object items[];

	public Set()
	{
		this.items = new Object[10];
	}

	public Set(int size)
	{
		this.items = new Object[size];
	}

	public boolean isEmpty()
	{

		return this.count == 0;
	}

	public void add(Object item)
	{
		if (contains(item))
		{
			return;
		}
		if (count >= this.items.length)
		{
			growSet();
		}
		this.items[this.count] = item;
		this.count++;
		// if adding a item creates an ordered Set then revert back
		if (isOrdered())
		{
			this.count--;
			this.items[this.count] = null;
		}

	}

	private void growSet()
	{
		Object newItems[] = new Object[this.items.length + 1];
		for (int i = 0; i < this.items.length; i++)
		{
			newItems[i] = this.items[i];
		}
		this.items = newItems;
	}

	private boolean isOrdered()
	{
		// if Set have two elements, it will always be ordered in either Asc or Desc
		// so avoiding first two elements check
		if (this.count <= 2)
		{
			return false;
		}

		boolean flag = true;
		// if state of flag will remain always true (Asc) or always false (Desc) for
		// ordered Set
		for (int i = 0; i < this.count - 1; i++)
		{
			if ((int) this.items[i] > (int) this.items[i + 1])
			{
				if (i == 0)
				{
					flag = false;
				}
				if (flag)
				{
					return false;
				}
			} else
			{
				if (!flag)
				{
					return false;
				}
			}

		}
		return true;
	}

	public int getCount()
	{

		return this.count;
	}

	public int getIndex(Object item)
	{
		for (int j = 0; j < this.count; j++)
		{
			if (this.items[j] == item)
			{
				return j;
			}
		}

		return -1;
	}

	public boolean contains(Object item)
	{
		return getIndex(item) != -1;
	}

	public void remove(Object item)
	{
		if (!contains(item))
		{
			return;
		}
		this.items[getIndex(item)] = this.items[count - 1];
		this.items[count - 1] = null;
		this.count--;
	}

	public int getSizeOfSet()
	{
		return this.items.length;
	}

}
