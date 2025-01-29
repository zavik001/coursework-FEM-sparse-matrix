package coursework.boundary;

public interface BoundaryConditions {
    void apply(double[] globalVector, double[][] globalMatrix);
}
