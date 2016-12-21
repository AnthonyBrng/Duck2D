package demo;

import core.Environment;
import demo.demo_objects.Guy;
import demo.demo_objects.Population;
import geom.Vector2D;
import stdio.Stdio;


/**
 * Created by anthony on 19.12.2016.
 */
public class Pathfinding extends Environment
{

    public static int AGE = 0;
    public static int LIFE_TIME = 500;
    public static Vector2D TARGET;
    public static double MAX_FORCE = 0.15 ;

    public static int OBSTACLE_X;
    public static int OBSTACLE_Y;
    public static int OBSTACLE_W;
    public static int OBSTACLE_H;

    private Population population;
    private int genCounter = 1 ;
    public static int GOAL_REACHED = 0 ;


    /**
     * This Method is used to apply core-settings to the window or canvas.
     */
    @Override
    public void settings()
    {
        size(500, 500);
        shapeOrigin(ShapeOrigin.CENTER);

        this.population = new Population(this);
        TARGET = new Vector2D(width() / 2, 50);
        OBSTACLE_X = width()/2-200;
        OBSTACLE_Y = height()/2;
        OBSTACLE_W = 300;
        OBSTACLE_H = 20;
    }

    /**
     * This method is called frequently and is used to draw things on the canvas.
     */
    @Override
    public void draw()
    {
        background(0);

        origin(0, 0);
        textColor(255);
        text("Alter: " + AGE, 20, 20);
        text("Generation: #" + this.genCounter, 20, 40);
        text("Populationsgröße: " + this.population.popSize, 20, 60);


        fill(200, 20, 20);
        circle(TARGET.x, TARGET.y, 10);

        fill(20,200,20);
        shapeOrigin(ShapeOrigin.TOP_LEFT);
        rect(OBSTACLE_X, OBSTACLE_Y, OBSTACLE_W, OBSTACLE_H);


        this.population.run();

        AGE++;
        if(AGE >= LIFE_TIME)
        {
            Stdio.print(String.format("Generation #%d hat %d mal das Ziel erreicht\t%f Prozent", this.genCounter, GOAL_REACHED, (1.0*GOAL_REACHED/this.population.popSize)*100));
            this.population.evaluate();
            this.population.selection();
            this.genCounter ++ ;
            GOAL_REACHED = 0 ;
            AGE = 0;
        }
    }


    /**
     * @param args
     */
    public static void main(String[] args)
    {
        new Pathfinding().show();
    }
}
