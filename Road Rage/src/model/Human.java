/*
 * TCSS 305 - Road Rage.
 */
package model;

import java.util.Map;

/**
 * A Human class with two implemented and two protected helper method.
 * @author Bhavesh Joshi
 * @version Autumn 2020.
 */
public class Human extends AbstractVehicle implements Vehicle {

    /**
     * A cosntant for human death time.
     * Human should revive in 45 moves.  
     */
    private static final int MY_HUMAN_DEATH_TIME = 45;
    
    /**
     * A construct with 3 parameters.
     * @param theX for X coordinates.
     * @param theY for Y coordinates.
     * @param theDir The Initial direction.
     */
    public Human(final int theX, final int theY, final Direction theDir) {
        super(theDir, MY_HUMAN_DEATH_TIME, theX, theY);
    }
    
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        // TODO Auto-generated method stub
        boolean pass = false;
        
        if (theTerrain == Terrain.GRASS || theTerrain == Terrain.CROSSWALK) {
            
            if (theTerrain == Terrain.CROSSWALK && theLight == Light.GREEN) {
                pass = false;
            } else if (theTerrain == Terrain.CROSSWALK 
                            && (theLight == Light.RED || theLight == Light.YELLOW)) {
                pass = true;
            } else {
                pass = true;
            }
        }
        
        return pass;
    }

    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        // TODO Auto-generated method stub
        
        Direction randomdir = Direction.random();
        
        if (checkValidDir(theNeighbors)) {
            if (theNeighbors.get(getDirection()) == Terrain.CROSSWALK) {
                randomdir = getDirection();
            } else {
                while (theNeighbors.get(randomdir) != Terrain.GRASS
                                && theNeighbors.get(randomdir) != Terrain.CROSSWALK
                                || randomdir == getDirection().reverse()) {
                    randomdir = Direction.random();
                }
            }
        } else {
            randomdir = getDirection().reverse();
        }
        return randomdir;
//        if (theNeighbors.get(getDirection()) == Terrain.CROSSWALK) {
//            return pass;
//        } else { 
//            while (true) {
//                
//                if (randomdir == super.getDirection().reverse()) {
//                    randomdir = Direction.random();
//    //                System.out.println("In first reverse method :");
//                    continue;
//                    
//                } else if (theNeighbors.get(randomdir) == Terrain.CROSSWALK 
//                                || theNeighbors.get(getDirection().left()) 
//        == Terrain.CROSSWALK
//                                || theNeighbors.get(getDirection().right()) 
//                                    == Terrain.CROSSWALK) {
//                    pass = randomdir;
//                    break; 
//                    
//                } else if (theNeighbors.get(randomdir) == Terrain.GRASS 
//                                || theNeighbors.get(getDirection().left()) == Terrain.GRASS
//                                || theNeighbors.get(getDirection().right()) 
//        == Terrain.GRASS) {
//                    pass = randomdir;
//                    break;
//                    
//                }  else {
//    //                System.out.println("In last reverse method :");
//                    pass = randomdir.reverse();
//                    break;
//                }
//                    
//            }
//        }
    }
    
    /**
     * A helper method to check to whether direction is okay or not?
     * @param theNeighbors map contains key- direction and value- terrain
     * @return boolean depends on whether the neighbors valid.
     */
    private boolean checkValidDir(final Map<Direction, Terrain> theNeighbors) {
        boolean pass = false;
        
        if (isValidTerrain(theNeighbors.get(getDirection()))
                        || isValidTerrain(theNeighbors.get(getDirection().left()))
                        || isValidTerrain(theNeighbors.get(getDirection().right()))) {
            pass = true;
        }
        
        return pass; 
    }
    
    /**
     * A helper method to check if the Terrain is valid or not.
     * @param theTerrain the enum type.
     * @return boolean depends whether terrain is valid or not.
     */
    private boolean isValidTerrain(final Terrain theTerrain) {
        boolean result = false;
        if (theTerrain == Terrain.GRASS || theTerrain == Terrain.CROSSWALK) {
            result = true;
            
        }
        return result;
    }

} //End of the class human.
