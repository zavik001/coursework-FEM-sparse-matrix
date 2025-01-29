package coursework.mesh;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Mesh {
    private final List<Node> nodes;
    private final List<Element> elements;
}
