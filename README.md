"# Intercation" 

动态数组的原理练习
//通过源码可知ArrayList的元素存储在Object[]  elementData成员数组中

public ArrayList(int initialCapacity) {
    if (initialCapacity > 0) {
        this.elementData = new Object[initialCapacity];
    } else if (initialCapacity == 0) {
        this.elementData = EMPTY_ELEMENTDATA;
    } else {
        throw new IllegalArgumentException("Illegal Capacity: "+
                                           initialCapacity);
    }
}

arraycopy方法
该方法用于从指定源数组中进行拷贝操作，可以指定开始位置，拷贝指定长度的元素到指定目标数组中。
该方法是一个本地方法，声明如下：
				第一个参数是要被复制的数组
				第二个参数是被复制的数组开始复制的下标
				第三个参数是目标数组，也就是要把数据放进来的数组
				第四个参数是从目标数据第几个下标开始放入数据
				第五个参数表示从被复制的数组中拿几个数值放到目标数组中
@HotSpotIntrinsicCandidate
public static native void arraycopy(Object src,  int  srcPos,
                                        Object dest, int destPos,
                                        int length);
关于@HotSpotIntrinsicCandidate
这个注解是 HotSpot VM 标准的注解，被它标记的方法表明它为 HotSpot VM 的固有方法，
 HotSpot VM 会对其做一些增强处理以提高它的执行性能，比如可能手工编写汇编或手工编写编译器中间语言来替换该方法的实现。
 虽然这里被声明为 native 方法，但是它跟 JDK 中其他的本地方法实现地方不同，固有方法会在 JVM 内部实现，
 而其他的会在 JDK 库中实现。在调用方面，由于直接调用 JVM 内部实现，不走常规 JNI lookup，所以也省了开销。
有兴趣的可以深入的了解一下，使用arrayCopy 是否是线程安全的
