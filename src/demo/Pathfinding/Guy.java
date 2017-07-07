package demo.Pathfinding;

import core.Entity;
import core.Environment;
import geom.Vector2D;

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


    /**
     * Constructor
     *
     * @param env the environment this Guy lives in
     */
    public Guy(Environment env)
    {
        super(env);
        this.pos = new Vector2D(width() / 2, height() - 50);
        this.vel = new Vector2D();
        this.acc = new Vector2D();
        this.dna = new DNA();
    }

    /**
     * calculates the Fitness level of this guy.
     */
    public void calcFitness()
    {
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
     * Getter for the dna property
     *
     * @return dna property
     */
    public DNA getDna()
    {
        return this.dna;
    }

    /**
     * Setter for the dna property
     *
     * @param dna set a new DNA-Object
     */
    public void setDna(DNA dna)
    {
        this.dna = dna;
    }


    /**
     * Applies a force in form of a two dimensional Vector to the
     * current acceleration property
     *
     * @param force Force to be applied
     */
    public void applyForce(Vector2D force)
    {
        this.acc.add(force);
    }

    /**
     * Show-method of this guy.
     *
     * Draws a circle on the current position of this guy.
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

        /*
            If this guy is close to the goal
            set its position to the goal
         */
        if(distance < 12)
        {
            if(!this.completed)
                Pathfinding.GOAL_REACHED ++ ;

            this.completed = true;
            this.pos.x = Pathfinding.TARGET.x;
            this.pos.y = Pathfinding.TARGET.y;
        }


        /*
            If the guy crashed against an obstacle
         */
        if(this.pos.x > Pathfinding.OBSTACLE_X+5 && this.pos.x < (Pathfinding.OBSTACLE_X + Pathfinding.OBSTACLE_W)
                && this.pos.y > Pathfinding.OBSTACLE_Y && this.pos.y < (Pathfinding.OBSTACLE_Y + Pathfinding.OBSTACLE_H)
                )
        {
            this.crashed = true;
        }

        /*
            If the guy crashed against the boundings of the window or arena
         */
        if(this.pos.x > width()-15 || this.pos.x < 0 || this.pos.y > height()-15 || this.pos.y < 0)
        {
            this.crashed = true;
        }

        /*
            Apply next force
         */
        this.applyForce(this.dna.getGenes()[Pathfinding.AGE]);

        /*
            Update the position
         */
        if(!completed && !crashed)
        {
            this.vel.add(this.acc);
            this.pos.add(this.vel);
            this.acc.mult(0);
        }

    }

}
