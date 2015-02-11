abstract class Shape
{
    private String name;
    
    Shape(String name0)
    {
        name=name0;
    }
    
    abstract double area();
    abstract double perim();
    
    void put()
    {
        System.out.println(name + " with area " + area() + " and perimeter " + perim());
    }
}

class Rectangle extends Shape
{
    private double width, height;
    
    Rectangle(String s, double w, double h)
    {
        super(s);
        width=w;
        height=h;
    }
    
    double area()
    {
        return width*height;
    }   
    
    double perim()
    {
        return (width+height)*2;
    }
}

class Triangle extends Shape
{
    private double a,b,c;
    
    Triangle(String s, double a0, double b0, double c0)
    {
        super(s);
        a=a0;
        b=b0;
        c=c0;
    }
    
    double area()
    {   
        double s = (a+b+c)/2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }
    
    double perim()
    {
        return a+b+c;
    }   
}

class Shapes
{
    private static Shape biggest(Shape[] w)
    {
        Shape max=w[0];
        for(int i=1;i<w.length;i++)
        {
            if(w[i].area() > max.area())
                max=w[i];
        }
        
        return max;
    }
    

    public static void main(String[] args)
    {
        Rectangle[] rs= {new Rectangle("Rectangle",2,3), new Rectangle("Square",4,4)};
        biggest(rs).put();

        Shape[] figs={new Rectangle("Rectangle",2,3), new Triangle("Scalene",5,12,13), new Rectangle("Square",4,4)};
        biggest(figs).put();
    }
}       