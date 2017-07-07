package demo.Pathfinding;

import core.Entity;
import core.Environment;

import java.util.ArrayList;

/**
 * Created by anthony on 20.12.2016.
 */
public class Population extends Entity
{
    public int popSize = 90;
    private Guy[] guys = new Guy[popSize];
    private ArrayList<Guy> parentPool = new ArrayList<>() ;

    public Population(Environment env)
    {
        super(env);
        for(int i = 0; i < this.popSize; i++)
            this.guys[i] = new Guy(this.env);
    }

    /**
     *
     */
    public void evaluate()
    {
        double maxFit = 0 ;
        /*
            Calc the Fitness
         */
        for(int i = 0; i < this.popSize; i++)
        {
            this.guys[i].calcFitness();
            if(this.guys[i].fitness > maxFit)
            {
                maxFit = this.guys[i].fitness;
            }
        }


        /*
            Normalize
         */
        for(int i = 0; i < this.popSize; i++)
        {
            this.guys[i].fitness /= maxFit ;
        }

        this.parentPool.clear();

        /*
            Fill the parentPool based on the fitness
         */
        for(int i = 0; i < this.popSize; i++)
        {
            double n = this.guys[i].fitness * 100;
            for(int j = 0 ; j<n; j++)
            {
                this.parentPool.add(this.guys[i]);
            }
        }

    }


    /**
     *
     */
    public void selection()
    {
        Guy[] newGuys = new Guy[popSize] ;

        for(int i=0; i<this.guys.length ; i++)
        {
            int index = random(0, this.parentPool.size()-1);
            DNA father = this.parentPool.get(index).getDna();

            index = random(0, this.parentPool.size()-1);
            DNA mother = this.parentPool.get(index).getDna();

            DNA child = father.crossover(mother);
            child.mutate();
            newGuys[i]  = new Guy(this.env) ;
            newGuys[i].setDna(child);
        }

        this.guys = newGuys ;
    }

    /**
     *
     */
    public void run()
    {
        for(int i = 0; i < this.popSize; i++)
        {
            this.guys[i].update();
            this.guys[i].show();
        }

    }

    /**
     *
     */
    @Override
    public void show()
    {

    }

    /**
     *
     */
    @Override
    public void update()
    {

    }
}
