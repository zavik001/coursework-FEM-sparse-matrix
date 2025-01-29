package coursework.boundary;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RobinCondition implements BoundaryConditions {
    private final int nodeIndex;
    private final double alpha;
    private final double beta;

    @Override
    public void apply(double[] globalVector, double[][] globalMatrix) {
        globalMatrix[nodeIndex][nodeIndex] += alpha;
        globalVector[nodeIndex] += beta;
    }
}
