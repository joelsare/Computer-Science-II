package exam3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import uno.collections.queues.UnboundedQueue;

public class Exam3
{
	private String fileName;
	private UnboundedQueue<Double> q;
	
	public Exam3(String fileNameIn)
	{
		fileName = fileNameIn;
		q = new UnboundedQueue<Double>();
	}
	
	public void processFile() throws FileNotFoundException
	{
		Scanner in = new Scanner(new File (fileName));
		
		while (in.hasNextLine())
		{
			String line = in.nextLine();
			Scanner a = new Scanner(line);
			while (a.hasNext())
			{
				String command = a.next();
				if (!isValid(command))
				{
					System.out.println("Invalid Command");
					break;
				}
				else
				{
					try
					{
						switch (command)
						{
							case "enqueue":
								ArrayList<Double> arr = new ArrayList<Double>();
								while (a.hasNext())
								{
									try
									{
										arr.add(a.nextDouble());
									}
									catch (InputMismatchException ime)
									{
										System.out.println("Invalid Argument");
										a.next();
									}
								}
								for (int i = 0; i < arr.size(); i++)
								{
									q.enqueue(arr.get(i));
								} 
								break;
							case "dequeue":						
								while (a.hasNext())
								{	
									try
									{
										int num = a.nextInt();
										for (int i = 0; i < num; i++)
										{
											System.out.println(q.dequeue());
										}
									}
									catch (InputMismatchException ime)
									{
										System.out.println("Invalid Argument");
										a.next();
									}
									catch (IllegalStateException ise)
									{
										System.out.println("Illegal State");
									}
								}
								break;
							case "peek":
								System.out.println(q.peek());
								break;
							case "size":
								System.out.println(q.size());
								break;
							case "print":
								printStructure();
								break;
						}
					}
					catch (IllegalStateException ise)
					{
						System.out.println("Illegal State");
					}
				}
			}
			a.close();
		}
		in.close();
	}
	
	public void printStructure()
	{
		for (int i = 0; i < q.size(); i++)
		{
			System.out.println(q.dequeue());
		}
	}
	
	private boolean isValid(String cmd)
	{
		return cmd.equals("enqueue") || cmd.equals("dequeue") || cmd.equals("peek") || cmd.equals("size") || cmd.equals("print");
	}
}
