/**
 * VM Args: -Xss128k
 */
public class VMStackSOF {
    private int stackLength=1;
    //递归
    private void stackLeak()throws Exception{
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Exception {
        VMStackSOF stackOOM = new VMStackSOF();
        try {
            stackOOM.stackLeak();
        } catch (Exception e) {
            System.out.println("stack length:"+stackOOM.stackLength);
            throw e;
        }
    }
}