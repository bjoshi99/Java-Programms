/*
 * TCSS 305 - Road Rage.
 */
package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Direction;
import model.Light;
import model.Terrain;
import model.Truck;
import org.junit.Test;

/**
 * A test class of Truck.
 * @author Bhavesh Joshi
 * @version Autumn 2020.
 */
public class TruckTest {

    /**
     * Test method for truck class constructor.
     */
    @Test
    public void testTruckConstructor() {
        final Truck tr = new Truck(20, 41, Direction.NORTH);
        assertEquals("Checking x coordinates: ", 20, tr.getX());
        assertEquals("Checking y coordinates: ", 41, tr.getY());
        assertEquals("Directoin fail: ", Direction.NORTH, tr.getDirection());
        assertEquals("Health is not equal: ", 0, tr.getDeathTime());
        assertTrue("Truck status is not true", tr.isAlive());
    }
    
    /**
     *  Test method for Truck class setters. 
     *  Including all setter from parent class. 
     * */
    @Test
    public void testTruckSetters() {
        final Truck tr = new Truck(10, 11, Direction.NORTH);
        
        tr.setX(22);
        assertEquals("Human setX failed!", 22, tr.getX());
        tr.setY(23);
        assertEquals("Human setY failed!", 23, tr.getY());
        tr.setDirection(Direction.EAST);
        assertEquals("Human setDirection failed!", Direction.EAST, tr.getDirection());
    }
    
    /**
     * A test method for canPasss method.
     */
    @Test
    public void testCanPass() {
        final List<Terrain> validTerrain = new ArrayList<>();
        validTerrain.add(Terrain.STREET);
        validTerrain.add(Terrain.LIGHT);
        validTerrain.add(Terrain.CROSSWALK);
        
                
        final Truck tr = new Truck(0, 0, Direction.NORTH);
        // test each terrain type as a destination
        for (final Terrain destinationTerrain : Terrain.values()) {
            
            // try the test under each light condition
            for (final Light currentLightCondition : Light.values()) {
                
                if (destinationTerrain == Terrain.STREET
                                || destinationTerrain == Terrain.LIGHT) {
                
                    // humans can pass GRASS under any light condition
                    assertTrue("Truck should be able to pass Street"
                               + ", with light condition " + currentLightCondition,
                               tr.canPass(destinationTerrain, currentLightCondition));
                    
                } else if (destinationTerrain == Terrain.CROSSWALK) {
                           // humans can pass CROSSWALK
                           // if the light is YELLOW or RED but not GREEN

                    if (currentLightCondition == Light.RED) {
                        assertFalse("Truck should NOT be able to pass " + destinationTerrain
                            + ", with light " + currentLightCondition,
                            tr.canPass(destinationTerrain,
                                          currentLightCondition));
                        
                    } else { // light is yellow or Green
                        assertTrue("Truck should be able to pass " + destinationTerrain
                            + ", with light " + currentLightCondition,
                            tr.canPass(destinationTerrain,
                                          currentLightCondition));
                    }
                } else if (!validTerrain.contains(destinationTerrain)) {
 
                    assertFalse("Truck should NOT be able to pass " + destinationTerrain
                        + ", with light " + currentLightCondition,
                        tr.canPass(destinationTerrain, currentLightCondition));
                }
            } 
        }
    }

    /**
     * A test method for reverse direction.
     */
    @Test
    public void testChooseDirectionforReverse() {
        for (final Terrain t : Terrain.values()) {
            if (t != Terrain.STREET && t != Terrain.CROSSWALK 
                            && t != Terrain.LIGHT) {
                
                final Map<Direction, Terrain> neighbors = new HashMap<Direction, Terrain>();
                neighbors.put(Direction.WEST, t);
                neighbors.put(Direction.NORTH, t);
                neighbors.put(Direction.EAST, t);
                neighbors.put(Direction.SOUTH, Terrain.STREET);
                
                final Truck tr = new Truck(0, 0, Direction.NORTH);
                
                // the Human must reverse and go SOUTH
                assertEquals("Truck chooseDirection() failed "
                                + "when reverse was the only valid choice!",
                             Direction.SOUTH, tr.chooseDirection(neighbors));
            }
                
        }
    }
    
    /**
     * A test method for truck when it is surrounded by all valid terrain.
     */
    @Test
    public void testChooseDirectionSurroundedByStraight() {
        final Truck tr = new Truck(0, 0, Direction.NORTH);
        
        final Map<Direction, Terrain> neighbors = new HashMap<Direction, Terrain>();
        neighbors.put(Direction.WEST, Terrain.STREET);
        neighbors.put(Direction.NORTH, Terrain.LIGHT);
        neighbors.put(Direction.EAST, Terrain.STREET);
        neighbors.put(Direction.SOUTH, Terrain.CROSSWALK);
        
        boolean seenWest = false;
        boolean seenNorth = false;
        boolean seenEast = false;
        boolean seenSouth = false;
        
        for (int count = 0; count < 50; count++) {
            final Direction d = tr.chooseDirection(neighbors);
            
            if (d == Direction.WEST) {
                seenWest = true;
            } else if (d == Direction.NORTH) {
                seenNorth = true;
            } else if (d == Direction.EAST) {
                seenEast = true;
            } else if (d == Direction.SOUTH) { // this should NOT be chosen
                seenSouth = true;
            }
        }
 
        assertTrue("Truck chooseDirection() fails to select randomly "
                   + "among all possible valid choices!",
                   seenWest && seenNorth && seenEast);
            
        assertFalse("Truck chooseDirection() reversed direction when not necessary!",
                    seenSouth);
    }

    /**
     * A test which for straight way. 
     */ 
    @Test 
    public void testChooseDirectionForStraightTruck() {
        for (final Terrain t : Terrain.values()) {
            if (t != Terrain.STREET && t != Terrain.CROSSWALK 
                            && t != Terrain.LIGHT) {
                
                final Map<Direction, Terrain> neighbors = new HashMap<Direction, Terrain>();
                neighbors.put(Direction.WEST, t);
                neighbors.put(Direction.NORTH, t);
                neighbors.put(Direction.EAST, t);
                neighbors.put(Direction.SOUTH, Terrain.STREET);
                
                final Truck tr = new Truck(0, 0, Direction.SOUTH);
                
                // the Human must reverse and go SOUTH
                assertEquals("Truck chooseDirection() failed "
                                + "when straight was the only valid choice!",
                             Direction.SOUTH, tr.chooseDirection(neighbors));
                
            } 
                
        }    }

    
} //End of the classs testTruck/
