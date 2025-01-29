package coursework.boundary;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DirichletCondition implements BoundaryConditions {
    private final int nodeIndex;
    private final double value;

    @Override
    public void apply(double[] globalVector, double[][] globalMatrix) {
        if (nodeIndex >= globalVector.length || nodeIndex >= globalMatrix.length) {
            throw new IllegalArgumentException("Node index is out of bounds.");
        }

        globalVector[nodeIndex] = value;
        for (int i = 0; i < globalMatrix.length; i++) {
            globalMatrix[nodeIndex][i] = 0;
            if (i < globalMatrix[nodeIndex].length) {
                globalMatrix[i][nodeIndex] = 0;
            }
        }
        globalMatrix[nodeIndex][nodeIndex] = 1;
    }
}
