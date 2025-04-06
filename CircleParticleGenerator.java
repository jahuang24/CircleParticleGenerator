import java.util.Scanner;
import java.text.DecimalFormat;
import java.math.RoundingMode;

public class CircleParticleGenerator
{
    public static void main(String args[])
    {
        CircleParticleGenerator gen = new CircleParticleGenerator();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input particle (Ex: flame, cloud, etc): ");
        String particle = scanner.nextLine();
        System.out.print("Input circle radius (Decimals accepted): ");
        double radius = scanner.nextDouble();
        System.out.println("Generated Commands:");
        gen.BuildACircle(particle, radius);
        scanner.close();
    }

    private void BuildACircle(String particle, double radius)
    {
        //For rounding to two decimal places
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);

        double xVal = radius;
        double yVal = 0;
        double decrement = xVal * 0.1; //Decrements the x coordinate
        System.out.println("particle minecraft:" + particle + " ~" + yVal + " ~ ~" + xVal + " 0 0 0 0 0");
        System.out.println("particle minecraft:" + particle + " ~" + yVal + " ~ ~" + (xVal * -1) + " 0 0 0 0 0");
        while(xVal > radius * -1) 
        {
            xVal = xVal - decrement;
            yVal = Math.sqrt(Math.pow(radius,2) - Math.pow(xVal,2)); //Calculates y coordinate
            if(Math.pow(radius,2) - Math.pow(xVal,2) < 0) //Ensures y is not NaaN
                continue;

            //Prints out minecraft particle commands
            System.out.println("particle minecraft:" + particle + " ~" + df.format(yVal) + " ~ ~" + df.format(xVal) + " 0 0 0 0 0");
            System.out.println("particle minecraft:" + particle + " ~" + df.format(yVal * -1) + " ~ ~" + df.format(xVal) + " 0 0 0 0 0");
        }
        yVal = radius;
        xVal = 0;
        decrement = yVal * 0.1; //Decrements the y coordinate
        while(yVal > radius * -1) 
        {
            yVal = yVal - decrement;
            xVal = Math.sqrt(Math.pow(radius,2) - Math.pow(yVal,2)); //Calculates x coordinate
            if(Math.pow(radius,2) - Math.pow(yVal,2) < 0) //Ensures x is not NaaN
                continue;
            //Prints out minecraft particle commands
            System.out.println("particle minecraft:" + particle + " ~" + df.format(yVal) + " ~ ~" + df.format(xVal) + " 0 0 0 0 0");
            System.out.println("particle minecraft:" + particle + " ~" + df.format(yVal) + " ~ ~" + df.format(xVal * -1) + " 0 0 0 0 0");
        }
    }
}