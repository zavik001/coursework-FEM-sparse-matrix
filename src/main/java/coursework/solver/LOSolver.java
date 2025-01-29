package coursework.solver;

public class LOSolver implements Solver {
    @Override
    public double[] solve(double[][] matrix, double[] vector) {
        int n = vector.length;
        double[] x = new double[n]; // Начальное приближение
        double[] r = new double[n]; // Вектор невязки
        double[] p = new double[n]; // Направление
        double[] Ap = new double[n]; // Вектор для хранения A * p

        for (int i = 0; i < n; i++) {
            r[i] = vector[i];
            p[i] = r[i];
        }

        // Итерации
        for (int k = 0; k < 1000; k++) { // Максимум 1000 итераций
            double alpha = 0, beta = 0, rr = 0;

            // Вычисление A * p
            for (int i = 0; i < n; i++) {
                Ap[i] = 0;
                for (int j = 0; j < n; j++) {
                    Ap[i] += matrix[i][j] * p[j];
                }
            }

            // Вычисление alpha
            double pAp = 0, rrNew = 0;
            for (int i = 0; i < n; i++) {
                pAp += p[i] * Ap[i];
                rrNew += r[i] * r[i];
            }

            if (Math.abs(pAp) < 1e-10) {
                System.out.println("Знаменатель pAp слишком мал, метод прерывается.");
                break;
            }

            alpha = rrNew / pAp;

            // Обновление x и r
            for (int i = 0; i < n; i++) {
                x[i] += alpha * p[i];
                r[i] -= alpha * Ap[i];
            }

            // Проверка на сходимость
            if (Math.sqrt(rrNew) < 1e-6) {
                System.out.println("Метод сошелся за " + (k + 1) + " итераций.");
                break;
            }

            // Вычисление beta
            beta = rrNew / rr;
            rr = rrNew;

            // Обновление p
            for (int i = 0; i < n; i++) {
                p[i] = r[i] + beta * p[i];
            }
        }

        return x;
    }
}
