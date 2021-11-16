import java.util.HashSet;
import java.util.Set;

/* VM args: -XX:PermSize=6M -XX:MaxPermSize=6M */
public class RuntimeConstPoolOOM {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        short i = 0;
        while (true){
            set.add(String.valueOf(i++).intern());
        }
    }
}
