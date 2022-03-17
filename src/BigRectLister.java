import java.awt.*;
import java.util.ArrayList;

public class BigRectLister
{
    private static ArrayList<Rectangle> rectListArray = new ArrayList<Rectangle>();

    private static Filter MyBigRectangleFilter = new BigRectangleFilter();

    public static ArrayList<Rectangle> collectAll()
    {
        ArrayList<Rectangle> rectArrayBigPerimeter = new ArrayList<>();

        for(Rectangle BigPerimeterRectangle : rectListArray)
        {
            boolean bAccepted = MyBigRectangleFilter.accept(BigPerimeterRectangle);

            if(bAccepted) rectArrayBigPerimeter.add(BigPerimeterRectangle);
        }

        return  rectArrayBigPerimeter;
    }

    public static void main(String[] args) {
        rectListArray.add(new Rectangle(5, 7));
        rectListArray.add(new Rectangle(2, 2));
        rectListArray.add(new Rectangle(1, 2));
        rectListArray.add(new Rectangle(4, 8));
        rectListArray.add(new Rectangle(3, 1));
        rectListArray.add(new Rectangle(3, 3));
        rectListArray.add(new Rectangle(7, 8));
        rectListArray.add(new Rectangle(2, 1));
        rectListArray.add(new Rectangle(1, 1));
        rectListArray.add(new Rectangle(6, 4));
        rectListArray.add(new Rectangle(2, 3));

        System.out.println("Original Input Rectangles are:");

        for(Rectangle InputRectangle : rectListArray)
        {
            String RectangleDisplay = "";

            RectangleDisplay += "Rectangle:- Width: " + InputRectangle.width + "; ";
            RectangleDisplay += "Height: " + InputRectangle.height + "; ";
            RectangleDisplay += "Perimeter: " + (2 * (InputRectangle.width + InputRectangle.height));

            System.out.println(RectangleDisplay);
        }

        ArrayList<Rectangle> BigPerimeterRectangles = collectAll();

        System.out.println("\nRectangles having Perimeter more than 10:");

        for(Rectangle BigPeriRectangle : BigPerimeterRectangles)
        {
            String RectangleDisplay = "";

            RectangleDisplay += "Rectangle:- Width: " + BigPeriRectangle.width + "; ";
            RectangleDisplay += "Height: " + BigPeriRectangle.height + "; ";
            RectangleDisplay += "Perimeter: " + (2 * (BigPeriRectangle.width + BigPeriRectangle.height));

            System.out.println(RectangleDisplay);
        }
    }
}
