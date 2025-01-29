package coursework.boundary;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NeumannCondition implements BoundaryConditions {
    private final int nodeIndex;
    private final double value;

    @Override
    public void apply(double[] globalVector, double[][] globalMatrix) {
        globalVector[nodeIndex] += value;
    }
}
