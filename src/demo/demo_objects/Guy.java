package demo.demo_objects;

import core.Entity;
import core.Environment;
import demo.Pathfinding;
import geom.Vector2D;
import stdio.Stdio;

import java.lang.annotation.Target;

/**
 * Created by anthony on 19.12.2016.
 */
public class Guy extends Entity
{
    private DNA dna;
    private Vector2D pos;  // Position
    private Vector2D acc;  // Beschleunigung
    private Vector2D vel;  // Geschwindigkeit
    public double fitness;
    public boolean completed = false;
    public boolean crashed = false;


    public Guy(Environment env)
    {
        super(env);
        this.pos = new Vector2D(width() / 2, height() - 50);
        this.vel = new Vector2D();
        this.acc = new Vector2D();
        this.dna = new DNA();
    }

    /**
     *
     */
    public void calcFitness()
    {
        //Vector2D diff = new Vector2D(Math.abs(Pathfinding.TARGET.x - this.pos.x), Math.abs(Pathfinding.TARGET.y - this.pos.y));
        //this.fitness = 1 / diff.length();
        double distance = this.pos.dist(Pathfinding.TARGET);
        this.fitness = map(distance, 0, width(), width(), 0);

        if(completed)
        {
            this.fitness *= 15;
        }

        if(crashed)
            this.fitness /= 10;
    }

    /**
     * @return
     */
    public DNA getDna()
    {
        return this.dna;
    }

    /**
     * @param dna
     */
    public void setDna(DNA dna)
    {
        this.dna = dna;
    }


    /**
     * @param force
     */
    public void applyForce(Vector2D force)
    {
        this.acc.add(force);
    }

    /**
     *
     */
    @Override
    public void show()
    {
        fill(255);

        origin((int) this.pos.x, (int) this.pos.y);
        circle(0, 0);
    }

    /**
     *
     */
    @Override
    public void update()
    {
        double distance = this.pos.dist(Pathfinding.TARGET);

        if(distance < 12)
        {
            if(!this.completed)
                Pathfinding.GOAL_REACHED ++ ;

            this.completed = true;
            this.pos.x = Pathfinding.TARGET.x;
            this.pos.y = Pathfinding.TARGET.y;
        }


        if(this.pos.x > Pathfinding.OBSTACLE_X+5 && this.pos.x < (Pathfinding.OBSTACLE_X + Pathfinding.OBSTACLE_W)
                && this.pos.y > Pathfinding.OBSTACLE_Y && this.pos.y < (Pathfinding.OBSTACLE_Y + Pathfinding.OBSTACLE_H)
                )
        {
            this.crashed = true;
        }

        if(this.pos.x > width()-15 || this.pos.x < 0 || this.pos.y > height()-15 || this.pos.y < 0)
        {
            this.crashed = true;
        }

        this.applyForce(this.dna.getGenes()[Pathfinding.AGE]);

        if(!completed && !crashed)
        {
            this.vel.add(this.acc);
            this.pos.add(this.vel);
            this.acc.mult(0);
        }

    }

}
