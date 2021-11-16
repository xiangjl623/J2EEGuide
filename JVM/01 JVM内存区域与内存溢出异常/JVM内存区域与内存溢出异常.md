

# Java内存区域与内存溢出异常

## 1 运行时数据区域

![](images\01.jpg)

### 1.1 程序计数器（Program Counter Register）

**作用：**由于Java虚拟机的多线程是通过线程轮流切换、分配处理器执行时间的方式来实现的，在任何一个确定的时刻，一个处理器（对于多核来说是一个内核）都会执行一条线程中的指令，因此，为了线程切换后能恢复到正确的执行位置，每条线程都需要独立的程序计数器，各条线程之间计数器互不影响，独立存储，我们称这类雷村区域为“线程私有”的内存。

**存储内容：**当线程中执行的是一个Java方法时，程序计数器中记录的是正在执行的线程的虚拟机字节码指令的地址。 当线程中执行的是一个本地方法时，程序计数器中的值为空。

> 此内存区域时唯一一个在《Java虚拟机规范》中没有任何OutOfMemoryError情况的区域。

### 1.2 Java虚拟机栈（Java Virtual Machine Stack）

**作用：**与程序计数器一样，Java虚拟机栈也是线程私有的，它的生命周期与线程相同。虚拟机栈描述的是Java方法执行的线程内存模型：每个方法被执行的时候，Java虚拟机都会同步创建一个帧栈（Stack Frame)用于存储局部变量表、操作数栈、动态链接、方法出口等信息。每一个方法被调用直至执行完毕的过程，就对应着一个线帧在虚拟机栈汇总的从入栈到出栈的过程。

**存储内容：**局部变量表（编译期可知的各种基本数据类型、引用类型和指向一条字节码指令的returnAddress类型）、操作数栈、动态链接、方法出口等信息。 

> 在《Java虚拟机规范》中，对于这个内存区域规定了两类异常状况：
>
> 1）**StackOverflowError**：如果线程请求的栈深度大于虚拟机所允许的深度， 将抛出StackOverflowError异常，场景：方法中无限递归）
>
> 2）**OutOfMemoryError**：如果虚拟机栈可以动态扩展（当前大部分的Java虚拟机都可动态扩展， 只不过Java虚拟机规范中也允许固定长度的虚拟机栈）， 如果扩展时无法申请到足够的内存， 就会抛出OutOfMemoryError异常。

### 1.3 本地方法栈（Native Method Stacks)

本地方法栈与虚拟机栈所发挥的作用是非常相似的，其区别只是虚拟机为虚拟机执行Java方法（也就是字节码）服务，而本地方法栈则是为虚拟机使用到的本地（Native）方法服务。

> 1）与虚拟机栈一样，规定了StackOverflowError和OutOfMemoryError两类异常
>
> 2）有的虚拟机（如Hot-Spot)，将本地方法栈和虚拟机栈合二为一。

### 1.4 Java堆（Java Heap)

对于Java应用程序来说，java堆是虚拟机管理的内存最大的一块。Java堆是垃圾收集器管理的主要区域（GC堆），可细分为：新生代，老年代，按空间可细分为：Eden空间，From Survivor空间，To Survivor空间**

**作用：**所有线程共享一块内存区域，在虚拟机开启的时候创建；存储对象实例，更好地分配内存；垃圾回收（GC），堆是垃圾收集器管理的主要区域，更好地回收内存。

**存储内容：**存放对象实例，几乎所有的对象实例都在这里进行分配。堆可以处于物理上不连续的内存空间，只要逻辑上是连续的就可以。 值得注意的是：在JIT编译器等技术的发展下，所有对象都在堆上进行分配已变得不那么绝对。有些对象实例也可以分配在栈中

> 可能出现的异常：实现堆可以是固定大小的，也可以通过设置配置文件设置该为可扩展的。 如果堆上没有内存进行分配，并无法进行扩展时，将会抛出OutOfMemoryError异常

### 1.5 方法区（Method Area）

**作用 ：**用于存储运行时常量池、已被虚拟机加载的类信息、常量、静态变量、即时编译器编译后的代码等数据。对运行时常量池、常量、静态变量等数据做出了规定。

**存储内容 ：**运行时常量池（具有动态性）、已被虚拟机加载的类信息、常量、静态变量、即时编译器编译后的代码等数据。

> 可能出现的异常：当方法区无法满足内存分配需求时，将抛出OutOfMemoryError异常。

### 1.6 运行时常量池（Runtime Constant Pool）

运行时常量池是方法区的一部分，Class文件出了有类的版本、字段、方法、接口等描述信息外，还有一项信息是常量池表（Constant Pool Table），用于存放编译器生成的各种字面量与符号引用，这部分内容将在类加载后存放在方法区的运行时常量池。

运行时常量池对于Class文件常量池的另一个特征是具备**动态性**，在运行期间也可能将新的常量放入池中，例如String类的intern()方法。

> 同方法区，可能出现的异常：当方法区无法满足内存分配需求时，将抛出OutOfMemoryError异常。

### 1.7 直接内存（Direct Memory）

JDK1.4中新加入NIO类，引入一种基于通道与缓冲的IO方式，它可以使用Native函数库**直接分配堆外内存**，然后通过一个存储在Java堆中的DirectByteBuffeer对象作为这块内存的引用进行操作。（在一些场景中显著提高性能，因为避免了Java堆和Native堆中来回复制数据）

> 如果服务器管理员在配置虚拟机参数时，忽略了直接内存，就有可能导致动态扩展时，出现OutOfMemoryError异常。



## 2 HotSpot虚拟机对象

### 2.1 对象创建

虚拟机遇到一条new指令时，首先将去检查这个指令的参数是否能在常量池中定位到一个类的符号引用，并且检查这个符号引用代表的类是否已被加载、解析和初始化过。如果没有，那必须先执行相应的类加载过程，类加载检查通过后，接下来虚拟机将为新生对象分配内存。对象所需内存的大小在类加载完成后便可完全确定，为对象分配空间的任务等同于把一块确定大小的内存从Java堆中划分出来。

内存分配的2种方式：

- **指针碰撞**
  Java堆中内存是绝对规整的，所有用过的内存都放在一边，空闲的内存放在另一边，中间放着一个指针作为分界点的指示器，那所分配内存就仅仅是把那个指针向空闲空间那边挪动一段与对象大小相等的距离。

  ![04](images\04.jpg)

- **空闲列表**
  Java堆中的内存并不是规整的，已使用的内存和空闲的内存相互交错，那就没有办法简单地进行指针碰撞了，虚拟机就必须维护一个列表，记录上哪些内存块是可用的，在分配的时候从列表中找到一块足够大的空间划分给对象实例，并更新列表上的记录。

  ![05](images\05.jpg)

  ​

**选择哪种分配方式由Java堆是否规整决定，而Java堆是否规整又由所采用的垃圾收集器是否带有压缩整理功能决定。**

内存分配完成后，虚拟机需要将分配到的内存空间都初始化为零值（不包括对象头），这一步操作保证了对象的实例字段在Java代码中可以不赋初始值就直接使用，程序能访问到这些字段的数据类型所对应的零值。

### 2.2 对象的内存布局

> 在HotSpot虚拟机中，对象在内存中存储的布局可以分为3块区域：对象头（Header）、实例数据（Instance Data）和对齐填充（Padding）

HotSpot虚拟机的对象头包括两部分信息：

* Mark Word 
  第一部分用于存储对象自身的运行时数据，如哈希码（HashCode）、GC分代年龄、锁状态标志、线程持有的锁、偏向线程ID、偏向时间戳等，这部分数据的长度在32位和64位的虚拟机（未开启压缩指针）中分别为32bit和64bit。
* 类型指针 
  对象头的另外一部分是类型指针，即对象指向它的类元数据的指针，虚拟机通过这个指针来确定这个对象是哪个类的实例。并不是所有的虚拟机实现都必须在对象数据上保留类型指针，换句话说，查找对象的元数据信息并不一定要经过对象本身

### 2.3 对象的访问定位

> 建立对象是为了使用对象，我们的Java程序需要通过栈上的reference数据来操作堆上的具体对象

目前主流的访问方式有使用句柄和直接指针两种：

1）通过句柄池访问

![02](images\02.jpg)

2）通过直接指针访问对象

![03](images\03.jpg)

对比优势：

* 使用句柄来访问的最大好处就是reference中存储的是稳定的句柄地址，在对象被移动（垃圾收集时移动对象是非常普遍的行为）时只会改变句柄中的实例数据指针，而reference本身不需要修改。
* 使用直接指针访问方式的最大好处就是速度更快，它节省了一次指针定位的时间开销，由于对象的访问在Java中非常频繁，因此这类开销积少成多后也是一项非常可观的执行成本。Sun HotSpot虚拟机是使用第二种方式进行对象虚拟机访问的。

## 3 实战：OutOfMemoryError异常

在《Java虚拟机规范》的规定里，除了程序计数器外，虚拟机内存的其他几个运行时区域都有发生OutOfMemoryError（下文称OOM）异常的可能，本篇将通过若干实例来验证异常实际发生的代码场景，并且将初步介绍若干最基本的与自动内存管理子系统相关的HotSpot虚拟机参数。

本篇实战的目的有两个：第一，通过代码验证《Java虚拟机规范》中描述的各个运行时区域储存的内容；第二，希望读者在工作中遇到实际的内存溢出异常时，能根据异常的提示信息迅速得知是哪个区域的内存溢出，知道怎样的代码可能会导致这些区域内存溢出，以及出现这些异常后该如何处理。

### 3.1 Java堆溢出

Java堆用于储存对象实例，我们只要不断地创建对象，并且保证GC Roots到对象之间有可达路径来避免垃圾回收机制清除这些对象，那么随着对象数量的增加，总容量触及最大堆的容量限制后就会产生内存溢出异常。

```java
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
```

运行结果

	java.lang.OutOfMemoryError: Java heap space
	Dumping heap to java_pid14700.hprof ...
	Heap dump file created [28285616 bytes in 0.073 secs]
	Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at java.util.Arrays.copyOf(Arrays.java:3210)
	at java.util.Arrays.copyOf(Arrays.java:3181)
	at java.util.ArrayList.grow(ArrayList.java:265)
	at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:239)
	at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:231)
	at java.util.ArrayList.add(ArrayList.java:462)
	at HeapOOM.main(HeapOOM.java:15)
Java堆内存的OutOfMemoryError异常是实际应用中最常见的内存溢出异常情况。出现Java堆内存溢出时，异常堆栈信息“java.lang.OutOfMemoryError”会跟随进一步提示“Java heapspace”。

要解决这个内存区域的异常，常规的处理方法是首先通过内存映像分析工具（如**Eclipse Memory Analyzer**或者idea的**JProfiler**）对Dump出来的堆转储快照进行分析。第一步首先应确认内存中导致OOM的对象是否是必要的，也就是要先分清楚到底是出现了内存泄漏（Memory Leak）还是内存溢出（Memory Overflow）。

    内存泄漏：可进一步通过工具查看泄漏对象到GC Roots的引用链，找到泄漏对象是通过怎样的引用路径、与哪些GC Roots相关联，才导致垃圾收集器无法回收它们，根据泄漏对象的类型信息以及它到GC Roots引用链的信息，一般可以比较准确地定位到这些对象创建的位置，进而找出产生内存泄漏的代码的具体位置。
    不是内存泄漏，换句话说就是内存中的对象确实都是必须存活的，那就应当检查Java虚拟机的堆参数（-Xmx与-Xms）设置，与机器的内存对比，看看是否还有向上调整的空间。再从代码上检查是否存在某些对象生命周期过长、持有状态时间过长、存储结构设计不合理等情况，尽量减少程序运行期的内存消耗。
以上是处理Java堆内存问题的简略思路，处理这些问题所需要的知识、工具与经验后面会逐步学习，后面我们将会针对具体的虚拟机实现、具体的垃圾收集器和具体的案例来进行分析，这里就先暂不展开。

### 3.2 虚拟机栈和本地方法栈溢出

由于HotSpot虚拟机中并不区分虚拟机栈和本地方法栈，因此对于HotSpot来说，-Xoss参数（设置本地方法栈大小）虽然存在，但实际上是没有任何效果的，栈容量只能由-Xss参数来设定。关于虚拟机栈和本地方法栈，在《Java虚拟机规范》中描述了两种异常：

    如果线程请求的栈深度大于虚拟机所允许的最大深度，将抛出StackOverflowError异常。
    如果虚拟机的栈内存允许动态扩展，当扩展栈容量无法申请到足够的内存时，将抛出OutOfMemoryError异常。
《Java虚拟机规范》明确允许Java虚拟机实现自行选择是否支持栈的动态扩展，而HotSpot虚拟机的选择是不支持扩展，所以除非在创建线程申请内存时就因无法获得足够内存而出现OutOfMemoryError异常，否则在线程运行时是不会因为扩展而导致内存溢出的，只会因为栈容量无法容纳新的栈帧而导致StackOverflowError异常。

为了验证这点，我们可以做两个实验，先将实验范围限制在单线程中操作，尝试下面两种行为是否能让HotSpot虚拟机产生OutOfMemoryError异常：

使用-Xss参数减少栈内存容量。结果：抛出StackOverflowError异常，异常出现时输出的堆栈深度相应缩小。

定义了大量的本地变量，增大此方法帧中本地变量表的长度。结果：抛出StackOverflowError异常，异常出现时输出的堆栈深度相应缩小。

第一种StackOverflowError

```java
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
```

运行结果

	Exception in thread "main" java.lang.StackOverflowError
	at VMStackSOF.stackLeak(VMStackSOF.java:6)
	at VMStackSOF.stackLeak(VMStackSOF.java:6)

### 第二种：StackOverflowError

局部变量定义过多超出局部变量表空间大小

```java
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
```

无论是由于栈帧太大还是虚拟机栈容量太小，当新的栈帧内存无法分配的时候，HotSpot虚拟机抛出的都是StackOverflowError异常。可是如果在允许动态扩展栈容量大小的虚拟机上，相同代码则会导致不一样的情况。

每个线程的栈分配的内存越大，反而越容易产生内存溢出异常。每个线程分配到的栈内存越大，可以建立的线程数量自然就越少，建立线程时就越容易把剩下的内存耗尽。

### 3.3 方法区和运行时常量池溢出

由于运行时常量池是方法区的一部分，所以这两个区域的溢出测试可以放到一起进行。前面提到HotSpot从JDK7开始逐步“去永久化”的计划，并在JDK 8中完全使用元空间来代替永久代的背景故事，在此我们就以测试代码来观察一下，使用“永久代”还是“元空间”来实现方法区，对程序有什么实际的影响。

String::intern()是一个本地方法，它的作用是如果字符串常量池中已经包含一个等于此String对象的字符串，则返回代表池中这个字符串的String对象的引用；否则，会将此String对象包含的字符串添加到常量池中，并且返回此String对象的引用。在JDK 6或更早之前的HotSpot虚拟机中，常量池都是分配在永久代中，我们可以通过-XX：PermSize和-XX：MaxPermSize限制永久代的大小，即可间接限制其中常量池的容量。代码如下：

```java
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
```

> 在Java8以后，永久代已经完全退出了历史舞台，元空间作为替代者登场。
>
> Java HotSpot(TM) 64-Bit Server VM warning: ignoring option PermSize=6M; support was removed in 8.0
> Java HotSpot(TM) 64-Bit Server VM warning: ignoring option MaxPermSize=6M; support was removed in 8.0

### 3.4 本机直接内存溢出

直接内存（Direct Memory）的容量大小可通过-XX：MaxDirectMemorySize参数来指定，如果不去指定，则默认与Java堆最大值（由-Xmx指定）一致，如下代码越过了DirectByteBuffer类直接通过反射获取Unsafe实例进行内存分配（Unsafe类的getUnsafe()方法指定只有引导类加载器才会返回实例，体现了设计者希望只有虚拟机标准类库里面的类才能使用Unsafe的功能，在JDK 10时才将Unsafe的部分功能通过VarHandle开放给外部使用），因为虽然使用DirectByteBuffer分配内存也会抛出内存溢出异常，但它抛出异常时并没有真正向操作系统申请分配内存，而是通过计算得知内存无法分配就会在代码里手动抛出溢出异常，真正申请分配内存的方法是Unsafe::allocateMemory()。

```java
/*-Xmx20M -XX:MaxDirectMemorySize=10M*/

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class DirectMemoryOOM {
    private static final int _1MB=1024*1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true){
            unsafe.allocateMemory(_1MB);
        }
    }
}
```

运行结果：

	Exception in thread "main" java.lang.OutOfMemoryError
	at sun.misc.Unsafe.allocateMemory(Native Method)
	at DirectMemoryOOM.main(DirectMemoryOOM.java:15)