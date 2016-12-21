package demo.demo_objects;

import demo.Pathfinding;
import geom.Vector2D;
import stdio.Stdio;

/**
 * Belongs to the Pathfinding demo.
 * Created by anthony on 19.12.2016.
 */
public class DNA
{

    private Vector2D[] genes;


    /**
     *
     */
    public DNA()
    {
        this.genes = new Vector2D[Pathfinding.LIFE_TIME];

        for(int i = 0; i < Pathfinding.LIFE_TIME; i++)
        {
            this.genes[i] = Vector2D.random();// new Vector2D();
            this.genes[i].mult(Pathfinding.MAX_FORCE);
        }
    }


    /**
     * @return
     */
    public Vector2D[] getGenes()
    {
        return this.genes;
    }


    /**
     * @param partner
     */
    public DNA crossover(DNA partner)
    {
        DNA childGenes = new DNA();

        int mid = this.genes.length / Stdio.randomInt(1, this.genes.length - 1) ;

        for(int i = 0; i < this.genes.length; i++)
            if(i > mid)
                childGenes.genes[i] = partner.genes[i];
            else
                childGenes.genes[i] = this.genes[i] ;

        return childGenes ;

    }


    /**
     *
     */
    public void mutate()
    {
        for(int i = 0; i < this.genes.length; i++)
            if(Math.random() < 0.005)
            {
                this.genes[i] = Vector2D.random();
                this.genes[i].mult(Pathfinding.MAX_FORCE);
            }
    }
}
