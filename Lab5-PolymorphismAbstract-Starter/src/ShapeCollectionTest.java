// COURSE: CSCI1620
// TERM: Spring 2019
// 
// NAME: Joel Sare
// RESOURCES: Lab 5 slides

import shapes.Shape;

import collections.ShapeCollection;

/**
 * Test class for ShapeCollectionTests.
 * @author Joel Sare
 */
public class ShapeCollectionTest
{
	/**
	 * Main method of test class. Creates an instance of ShapeCollection class and tests public methods.
	 * @param args Not used.
	 */
	public static void main(String[] args)
	{
		ShapeCollection shapes = new ShapeCollection();
		
		//Add some Shapes
		addShapesToCollection(shapes);
		
		//Print the current five Shapes
		System.out.println("***Printing Current Shapes***");
		printShapeArray(shapes.getAllShapes());
		
		//Add some more Shapes
		addShapesToCollection(shapes);
		
		//Print the current ten Shapes
		System.out.println("\n***Printing Current Shapes***");
		printShapeArray(shapes.getAllShapes());
		
		//Print only the Circles
		System.out.println("\n***Printing Circles***");
		printShapeArray(shapes.getCircles());
		
		//Print only the Rectangles
		System.out.println("\n***Printing Rectangles***");
		printShapeArray(shapes.getRectangles());
		
		//Print only the Spheres
		System.out.println("\n***Printing Triangles***");
		printShapeArray(shapes.getTriangles());
		
		//Try to add 6th Shape
		System.out.println("\n***Attempt to add too many Shapes***");
		addShapesToCollection(shapes);
		
		//Test Area of Shapes
		System.out.printf("\nSum of areas of Shapes: %.2f", shapes.totalAreaOfShapes());
	}
	
	/**
	 * Adds predefined Shapes to the given ShapeCollection for testing purposes.
	 * Uses the boolean return of the add methods and reports if the Shape was not added due to size restrictions.
	 * Use of Magic numbers for predefined Shapes for testing purposes.
	 * @param shapes ShapeCollection to which the Shapes will be added.
	 */
	public static void addShapesToCollection(ShapeCollection shapes)
	{
		if (!shapes.addNewCircle(5.7))
		{
			System.out.println("New Circle not added!");
		}
		
		if (!shapes.addNewRectangle(new double[] {7.1, 3.7}))
		{
			System.out.println("New Rectangle not added!");
		}
		
		if (!shapes.addNewTriangle(new double[] {4.6, 9.1}))
		{
			System.out.println("New Triangle not added!");
		}
		
	}
	
	/**
	 * Utility method to output all of the Shapes in an array of Shapes.
	 * @param out Array of Shapes to be printed.
	 */
	private static void printShapeArray(Shape[] out)
	{
		for (int i = 0; i < out.length; i++)
		{
			if (out[i] == null)
			{
				break;
			}
			System.out.println(out[i]);
		}
	}
}

