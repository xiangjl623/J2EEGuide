
public class VMStackSOFTooManyAreaVarient {
    private int stackLength=1;
    //递归
    private void stackLeak()throws Exception{
        long number01, number02, number03, number04, number05, number06, number07, number08, number09, number10, number11, number12, number13, number14, number15,
                number16, number17, number18, number19, number20, number21, number22, number23, number24, number25, number26, number27, number28, number29, number30,
                number31, number32, number33, number34, number35, number36, number37, number38, number39, number40, number41, number42, number43, number44, number45,
                couber01, couber02, couber03, couber04, couber05, couber06, couber07, couber08, couber09, couber10, couber11, couber12, couber13, couber14, couber15,
                couber16, couber17, couber18, couber19, couber20, couber21, couber22, couber23, couber24, couber25, couber26, couber27, couber28, couber29, couber30,
                couber31, couber32, couber33, couber34, couber35, couber36, couber37, couber38, couber39, couber40, couber41, couber42, couber43, couber44, couber45,
                agrber01, agrber02, agrber03, agrber04, agrber05, agrber06, agrber07, agrber08, agrber09, agrber10, agrber11, agrber12, agrber13, agrber14, agrber15,
                agrber16, agrber17, agrber18, agrber19, agrber20, agrber21, agrber22, agrber23, agrber24, agrber25, agrber26, agrber27, agrber28, agrber29, agrber30,
                agrber31, agrber32, agrber33, agrber34, agrber35, agrber36, agrber37, agrber38, agrber39, agrber40, agrber41, agrber42, agrber43, agrber44, agrber45,
                dsaber01, dsaber02, dsaber03, dsaber04, dsaber05, dsaber06, dsaber07, dsaber08, dsaber09, dsaber10, dsaber11, dsaber12, dsaber13, dsaber14, dsaber15,
                dsaber16, dsaber17, dsaber18, dsaber19, dsaber20, dsaber21, dsaber22, dsaber23, dsaber24, dsaber25, dsaber26, dsaber27, dsaber28, dsaber29, dsaber30,
                dsaber31, dsaber32, dsaber33, dsaber34, dsaber35, dsaber36, dsaber37, dsaber38, dsaber39, dsaber40, dsaber41, dsaber42, dsaber43, dsaber44, dsaber45;
        stackLength++;
        stackLeak();
        number01=number02=number03=number04=number05=number06=number07=number08=number09=number10=number11=number12=number13=number14=number15=0;
        number16=number17=number18=number19=number20=number21=number22=number23=number24=number25=number26=number27=number28=number29=number30=0;
        number31=number32=number33=number34=number35=number36=number37=number38=number39=number40=number41=number42=number43=number44=number45=0;
        couber01=couber02=couber03=couber04=couber05=couber06=couber07=couber08=couber09=couber10=couber11=couber12=couber13=couber14=couber15=0;
        couber16=couber17=couber18=couber19=couber20=couber21=couber22=couber23=couber24=couber25=couber26=couber27=couber28=couber29=couber30=0;
        couber31=couber32=couber33=couber34=couber35=couber36=couber37=couber38=couber39=couber40=couber41=couber42=couber43=couber44=couber45=0;
        agrber01=agrber02=agrber03=agrber04=agrber05=agrber06=agrber07=agrber08=agrber09=agrber10=agrber11=agrber12=agrber13=agrber14=agrber15=0;
        agrber16=agrber17=agrber18=agrber19=agrber20=agrber21=agrber22=agrber23=agrber24=agrber25=agrber26=agrber27=agrber28=agrber29=agrber30=0;
        agrber31=agrber32=agrber33=agrber34=agrber35=agrber36=agrber37=agrber38=agrber39=agrber40=agrber41=agrber42=agrber43=agrber44=agrber45=0;
        dsaber01=dsaber02=dsaber03=dsaber04=dsaber05=dsaber06=dsaber07=dsaber08=dsaber09=dsaber10=dsaber11=dsaber12=dsaber13=dsaber14=dsaber15=0;
        dsaber16=dsaber17=dsaber18=dsaber19=dsaber20=dsaber21=dsaber22=dsaber23=dsaber24=dsaber25=dsaber26=dsaber27=dsaber28=dsaber29=dsaber30=0;
        dsaber31=dsaber32=dsaber33=dsaber34=dsaber35=dsaber36=dsaber37=dsaber38=dsaber39=dsaber40=dsaber41=dsaber42=dsaber43=dsaber44=dsaber45=0;
    }

    public static void main(String[] args) throws Exception {
        VMStackSOFTooManyAreaVarient stackOOM = new VMStackSOFTooManyAreaVarient();
        try {
            stackOOM.stackLeak();
        } catch (Exception e) {
            System.out.println("stack length:"+stackOOM.stackLength);
            throw e;
        }
    }
}