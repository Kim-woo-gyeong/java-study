package prob5;

import java.util.Arrays;

public class MyStack<T> {
	private int top;
	private T[] buffer;
	private T[] newbuffer;
	
	public MyStack(int num) 
	{
		top = -1;
		buffer = (T[])new Object[num];
	}
	
	public void push(T string)
	{
		if(top == buffer.length-1)
		{
			resize();
			/*newbuffer = new String[top];
			for(int i = 0; i < buffer.length;i++)
			{
				newbuffer[i] = buffer[i];
			}
			buffer = new String[top+1];*/
		}
		
		buffer[++top] = string;		
		//this.top++;
	}
	
	public void resize()
	{
		T[] newbuffer = (T[])new Object[buffer.length*2];
		for(int i = 0; i < buffer.length;i++)
		{
			newbuffer[i] = buffer[i];
		}
		buffer = newbuffer;
	}
	
	public T pop() throws MyStackException
	{
		if(isEmpty())
		{
			throw new MyStackException();
		}
		T result = buffer[top];
		buffer[top--] = null;
		
		return result;
	}
	
	public boolean isEmpty()
	{
		return top == -1;
		/*if(top > 0)
		{
			return true;
		}
		else
			return false;*/
	}
}