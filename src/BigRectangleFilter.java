import java.awt.*;

public class BigRectangleFilter implements Filter
{
    @Override
    public boolean accept(Object x) {
        try
        {
            Rectangle rect = (Rectangle) x;

            if(2 * (rect.height + rect.width) > 10) return true;
        }
        catch (ClassCastException ccex)
        {
            System.out.println("Object is Not Rectangle Object");
            ccex.printStackTrace();
        }

        return false;
    }
}
