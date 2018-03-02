/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roullete;

import java.util.Random;

/**
 *
 * @author nolasco
 */
public class spinner {
    final int singleVersion = 1; //Single-zero wheel
    final int doubleVersion = 2; //Double-zero wheel
    final int rouletteVersion = singleVersion;
    
    //Evaluates result of Spin
    public boolean evaluateSpin() {
        Random randomGenerator = new Random();
        int num = randomGenerator.nextInt(36 + rouletteVersion);
            if(num>0 && num%2==0) {
                return true;
            } else {
                return false;
            }
    }
}
