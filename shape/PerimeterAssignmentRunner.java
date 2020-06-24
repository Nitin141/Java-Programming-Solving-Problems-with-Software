import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    /*public void testPerimeterMultipleFiles() {
        // Put code here
        double Largestper = getLargestPerimeterMultipleFiles();
        System.out.println(Largestper);
    }
    public double getLargestPerimeterMultipleFiles() {
        double max=0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s= new Shape(fr);
            double per = getPerimeter(s);
            if(max<per);
                {
                    max=per;
                }
            }      
        return max;
    }*/

    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int num=0;
        for(Point p: s.getPoints()){
            num++;
        }
        return num;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double total = getPerimeter(s);
        double num = getNumPoints(s);
        double avg = total/num;
        return avg;
    }

    public double getLargestSide(Shape s) {
        double totalPerim = 0.0; 
        double maxlen = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            if(currDist> maxlen){
                maxlen = currDist;
            }
        }
        return maxlen;
    }
    
    public double getLargestX(Shape s) {
        int maxx=0;
        for (Point p : s.getPoints()) {
            if(p.getX()>maxx)
            {
               maxx=p.getX();
            };
        }
        return maxx;
    }

    public double getLargestPerimeterMultipleFiles() {
        double max=0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s= new Shape(fr);
            double per = getPerimeter(s);
            if(max<per)
                {
                    max=per;
                }
            }      
        return max;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;
        double max=0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s= new Shape(fr);
            double per = getPerimeter(s);
            if(max<per);
                {
                    max=per;
                    temp = f;
                }
            }      
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        int numofpoint= getNumPoints(s);
        System.out.println(numofpoint);
        double average = getAverageLength(s);
        System.out.println(average);
        double large = getLargestSide(s);
        System.out.println(large);
        double maxx = getLargestX(s);
        System.out.println(maxx);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double Largestper = getLargestPerimeterMultipleFiles();
        System.out.println(Largestper);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String name = getFileWithLargestPerimeter();
        System.out.println(name);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        //pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        //testFileWithLargestPerimeter();
        
    }
}
