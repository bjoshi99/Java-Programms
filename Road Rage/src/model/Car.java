/*
 * TCSS 305 - Road Rage.
 */
package model;

import java.util.Map;
/**
 * A Car class with two implemented methods.
 * @author Bhavesh Joshi
 * @version Autumn 2020.
 */
public class Car extends AbstractVehicle implements Vehicle {
    
    /**
     * A instance field for car death time.
     * CAr should revive in 15 moves. 
     */
    private static final int MY_CAR_DEATH_TIME = 15;
    
    /**
     * A public constructor for All Terrain vehicles.
     * @param theX the x coordinate of ATV on map
     * @param theY the y coordinate of ATV on map
     * @param theDir type of direction this Atv gets to move on map.
     */   
    public Car(final int theX, final int theY, final Direction theDir) {
        super(theDir, MY_CAR_DEATH_TIME, theX, theY);
    }

    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        // TODO Auto-generated method stub
        boolean pass = false;
//      
        if (theTerrain == Terrain.STREET || theTerrain == Terrain.CROSSWALK 
                      || theTerrain == Terrain.LIGHT) {
                     
            if (theTerrain == Terrain.LIGHT
                              && (theLight == Light.RED)) {
                pass = false;
            }  else if (theTerrain == Terrain.CROSSWALK 
                          && (theLight == Light.RED || theLight == Light.YELLOW)) {
                pass = false;
            } else {
                pass = true;
            }
        }
        return pass;
    }

    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        // TODO Auto-generated method stub
        Direction pass = super.getDirection();
        //System.out.println("My Direction:" + super.getDirection());
        
        
//        if (theNeighbors.get(super.getDirection()) != Terrain.STREET 
//                        && theNeighbors.get(super.getDirection()) != Terrain.CROSSWALK
//                        && theNeighbors.get(super.getDirection()) != Terrain.LIGHT) {
//            
//            for (Terrain t : Terrain.values()) {
//                System.out.println(t);
 //           Direction d = Direction.random();

//            while (true) {
//                System.out.println("Random direction "+d);
//                System.out.println("Reverse direction "+super.getDirection().reverse());
//                    
//                 if (d == super.getDirection().reverse()) {
//                    d = Direction.random();
//                    continue;
//                }
                //System.out.println("Rendom direction before second if statement "+d);

        if (theNeighbors.get(pass) == Terrain.STREET 
                                    || theNeighbors.get(pass) == Terrain.CROSSWALK
                                    || theNeighbors.get(pass) == Terrain.LIGHT) {

            pass = getDirection();
                    //System.out.println("Pass assigned to Normal:" + pass);

        } else if (theNeighbors.get(getDirection().left()) == Terrain.STREET
                       || theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK
                       || theNeighbors.get(getDirection().left()) == Terrain.LIGHT) {
                    //System.out.println("Before Pass assigned to:" +pass);
            pass = pass.left();
                   // System.out.println("Pass assigned to L:" + pass);

        } else if (theNeighbors.get(getDirection().right()) == Terrain.STREET
                       || theNeighbors.get(getDirection().right()) == Terrain.CROSSWALK
                       || theNeighbors.get(getDirection().right()) == Terrain.LIGHT) {
                    //System.out.println("Before Pass assigned to R:" +pass);
            pass = pass.right();
                    //System.out.println("Pass assigned to:" + pass);

        } else {
            pass = super.getDirection().reverse();
                   // System.out.println("Pass assigned to:" + pass);


        }
        
        
//        if (theNeighbors.get(super.getDirection()) != myTerrainForCar 
//                        && theNeighbors.get(super.getDirection()) != Terrain.CROSSWALK
//                        && theNeighbors.get(super.getDirection()) != Terrain.LIGHT) {
//            
//            while (true) {
//                
//                if (random == super.getDirection().reverse()) {
//                    random = Direction.random();
//                    continue;
//                }
//                else {
//                    break;
//                }
//            }
//            if (theNeighbors.get(getDirection().left()) == myTerrainForCar
//                            || theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK
//                            || theNeighbors.get(getDirection().left()) == Terrain.LIGHT) {
//                myCurrentDirection = random;
//            }
//            else if (theNeighbors.get(getDirection().right()) == myTerrainForCar
//                            || theNeighbors.get(getDirection().right()) == Terrain.CROSSWALK
//                            || theNeighbors.get(getDirection().right()) == Terrain.LIGHT) {
//                myCurrentDirection = random;
//            }
//            else {
//                myCurrentDirection = super.getDirection().reverse();
//            }
//            
//        }
        
        //System.out.println("Above return statement : "+ pass);
        return pass;
    }

}
//End of the class Car.
