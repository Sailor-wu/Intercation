"# Intercation" 

��̬�����ԭ����ϰ
//ͨ��Դ���֪ArrayList��Ԫ�ش洢��Object[]  elementData��Ա������

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

arraycopy����
�÷������ڴ�ָ��Դ�����н��п�������������ָ����ʼλ�ã�����ָ�����ȵ�Ԫ�ص�ָ��Ŀ�������С�
�÷�����һ�����ط������������£�
				��һ��������Ҫ�����Ƶ�����
				�ڶ��������Ǳ����Ƶ����鿪ʼ���Ƶ��±�
				������������Ŀ�����飬Ҳ����Ҫ�����ݷŽ���������
				���ĸ������Ǵ�Ŀ�����ݵڼ����±꿪ʼ��������
				�����������ʾ�ӱ����Ƶ��������ü�����ֵ�ŵ�Ŀ��������
@HotSpotIntrinsicCandidate
public static native void arraycopy(Object src,  int  srcPos,
                                        Object dest, int destPos,
                                        int length);
����@HotSpotIntrinsicCandidate
���ע���� HotSpot VM ��׼��ע�⣬������ǵķ���������Ϊ HotSpot VM �Ĺ��з�����
 HotSpot VM �������һЩ��ǿ�������������ִ�����ܣ���������ֹ���д�����ֹ���д�������м��������滻�÷�����ʵ�֡�
 ��Ȼ���ﱻ����Ϊ native �������������� JDK �������ı��ط���ʵ�ֵط���ͬ�����з������� JVM �ڲ�ʵ�֣�
 �������Ļ��� JDK ����ʵ�֡��ڵ��÷��棬����ֱ�ӵ��� JVM �ڲ�ʵ�֣����߳��� JNI lookup������Ҳʡ�˿�����
����Ȥ�Ŀ���������˽�һ�£�ʹ��arrayCopy �Ƿ����̰߳�ȫ��
