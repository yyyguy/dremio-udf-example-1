package com.BCI;

/*
 * Indicates the algorithm failed to converge in the allotted number of iterations.
 *
 * @author FredBlue
 */
public class NonConvergenceException extends IllegalArgumentException {

    private final double initialGuess;
    private final long iterations;

    public NonConvergenceException(double guess, long iterations) {
        super("Newton-Raphson failed to converge within " + iterations
                + " iterations.");
        this.initialGuess = guess;
        this.iterations = iterations;
    }

    /*
     * Get the initial guess used for the algorithm.
     *
     * @return the initial guess used for the algorithm
     */
    public double getInitialGuess() {
        return initialGuess;
    }

    /*
     * Get the number of iterations applied.
     *
     * @return the number of iterations applied
     */
    public long getIterations() {
        return iterations;
    }

}
