/*
 * Copyright (C) 2020 Dalton Redman <dalton.redman@mavs.uta.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 *
 * @author Dalton Redman <dalton.redman@mavs.uta.com>
 */
public class VehicleTest {
    public static void main(String[] args) {
        
        //Array of Vehicle objects
        Vehicle vehicle[] = new Vehicle[2];
        vehicle[0] = new Car(42);           //Car object
        vehicle[1] = new Bicycle();         //Bicycle object
        
        for(int i = 0; i < vehicle.length; i++){
            if(i == 0){
                System.out.printf("Cars Carbon footprint: %d\n", vehicle[i].GetCarbonFootprint());
            }
            else if(i == 1){
                System.out.printf("Bicycle Carbon Footprint: %d\n", vehicle[i].GetCarbonFootprint());
            }
            else{
                System.out.println("Error has occured");
            }
        }
    }
}
