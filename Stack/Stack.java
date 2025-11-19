package Stack;


class MyEmptyStackException extends RuntimeException
{
	MyEmptyStackException()
	{
		super();
	}
}

class MyStack<E>{

	E [] arr;
	static final int INITIAL_CAPACITY=10;
	int indx;

	public MyStack()
	{
		super();
		arr=(E [] ) new Object[INITIAL_CAPACITY];
	}

	public int getCapacity(int oldCapacity)
	{
		return oldCapacity*2;
	}

	public int size()
	{
		return indx;
	}

	public boolean isEmpty()//1
	{
		return (size()==0) ? true : false;
	}

	public String toString()
	{
		String data="[";
		if(indx==0)return "[]";
		else{
			for(int i=0;i<size()-1;i++)
			{
				data+=arr[i]+", ";
			}
			data+=arr[size()-1];
		}
		return data+"]";
	}

	public E push(E ele)//2
	{
		if(size()==arr.length)
		{
			E[] newArr=(E[]) new Object[getCapacity(arr.length)];
			for(int i=0;i<arr.length;i++)
			{
				newArr[i]=arr[i];
			}
			arr=newArr;

		}
		arr[indx++]=ele;
		return ele;
	}

	public E pop()//3
	{
		if(size()==0)
		{
			throw new MyEmptyStackException(); 
		}
		E temp=arr[size()-1];
		arr[size()-1]=null;
		indx--;
        return temp;
	}

	public E peek()//4
	{
		if(size()==0)
		{
			throw new MyEmptyStackException(); 
		}
		return arr[size()-1];
	}

	public int search(E ele)
	{
		if(size()==0)
		{
			throw new MyEmptyStackException(); 
		}
		else{
			for(int i=size()-1,offset=0;i>=0;i--,offset++)
			{
				if(arr[i].equals(ele))
				{
					return offset;
				}

			}
		}
		return -1;
	}

}
class StackDriver{
	public static void main(String[] args) {
		MyStack<Integer> stack=new MyStack<>();
		System.out.println("isEmpty() : "+stack.isEmpty());

		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.push(60);
		stack.push(70);
		stack.push(80);
		stack.push(90);
		stack.push(100);
		stack.push(110);
		stack.push(120);
		System.out.println(stack);

		stack.pop();
		stack.pop();

		System.out.println(stack);

		System.out.println("peek() : "+stack.peek());

		System.out.println("isEmpty() : "+stack.isEmpty());

		System.out.println("search() : "+stack.search(30));

	}
	
}