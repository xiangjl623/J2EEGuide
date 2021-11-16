import java.util.ArrayList;
import java.util.List;

/**
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */

public class HeapOOM {
    static class OOMOBject{

    }
    public static void main(String[] args) {
        List<OOMOBject> oomoBjects = new ArrayList<>();
        while (true){
            oomoBjects.add(new OOMOBject());
        }
    }
}
