package coursework.matrix;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GlobalMatrix {
    private final double[] di; // Диагональные элементы
    private final double[] ggl; // Нижний треугольник
    private final double[] ggu; // Верхний треугольник
    private final int[] ig; // Массив индексов строк
    private final int[] jg; // Массив индексов столбцов
}
