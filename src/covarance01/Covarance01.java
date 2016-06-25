/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covarance01;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

/**
 *
 * @author Luke Chang
 */
public class Covarance01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double[][] data = {
            {90d, 60d, 90d},
            {90d, 90d, 30d},
            {60d, 60d, 60d},
            {60d, 60d, 90d},
            {30d, 30d, 30d}
        };
        // copy date to matrix, must use double
        RealMatrix mData = MatrixUtils.createRealMatrix(data);
        
        // create identity matrix
        double[][] d1 = new double[5][5];
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                d1[y][x] = 1;
            }
        }
        RealMatrix m1 = MatrixUtils.createRealMatrix(d1);
        
        // get column means 11'A(1/n)
        RealMatrix mMean = (m1.multiply(mData)).scalarMultiply(1d/5d);
        
        // covarance matrix
        RealMatrix mA = mData.subtract(mMean);
        // cov = A'*A./5
        RealMatrix mCov = mA.transpose().multiply(mA).scalarMultiply(1d/5d);
        
        System.out.print(mCov.toString());
    }

}
