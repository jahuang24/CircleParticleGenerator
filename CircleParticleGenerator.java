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
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);

        double xVal = radius;
        double yVal = 0;
        double decrement = xVal * 0.1;
        System.out.println("particle minecraft:" + particle + " ~" + yVal + " ~ ~" + xVal + " 0 0 0 0 0");
        System.out.println("particle minecraft:" + particle + " ~" + yVal + " ~ ~" + (xVal * -1) + " 0 0 0 0 0");
        while(xVal > radius * -1) 
        {
            xVal = xVal - decrement;
            yVal = Math.sqrt(Math.pow(radius,2) - Math.pow(xVal,2));
            if(Math.pow(radius,2) - Math.pow(xVal,2) < 0)
                return;
            System.out.println("particle minecraft:" + particle + " ~" + df.format(yVal) + " ~ ~" + df.format(xVal) + " 0 0 0 0 0");
            System.out.println("particle minecraft:" + particle + " ~" + df.format(yVal * -1) + " ~ ~" + df.format(xVal) + " 0 0 0 0 0");
        }
    }
}