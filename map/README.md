Map接口继承树
    -->SortedMap
        -->TreeMap
    -->Hashtable
        -->Properties
    -->HashMap
        -->LinkedHashMap
HashMap是作为Map的主要实现类,线程不安全，效率高,可以存储null的key和value
Hashtabel作为Map的古老实现类,线程安全,效率低。不能存储null的key和value
LinkedHashMap保证在遍历map元素时,可以按照添加的顺序实现遍历.
    原因： 在原有的hashmap底层结构基础上,添加了一对指针,指向了前一个和后一个元素.
            对于频繁的遍历操作,此类执行效率高于HashMap.
TreeMap:保证按照添加的key-value对进行排序,实现排序遍历.排序是按照key进行排序(自然和定制排序)的.
    底层使用的是红黑树

HashMap:jdk7之前底层使用数组+链表，jdk8底层使用数组+链表+红黑树
Properties:常用来处理配置文件.key和value都是String类型. 
1、HashMap的底层实现原理：
    1.7:HashMap map = new HashMap(),在实例化之后，底层创建了长度为16的一位数组Entry[] table;
        …………可能已经执行过多次put…………
        map.put(key1,value1):
        首先调用key1所在类的hashcode()方法计算key1的哈希值,此哈希值经过某种算法计算以后，得到在Entry数组中的存放位置.
        如果此位置上的数据为空,此时的key1-value1添加成功-->情况1
        如果此位置上的数据不为空(意味着此位置上存在一个或多个数据(以链表形式存在)),比较当前的key1和当前位置上已经存在的一个或多个数据的hash值
            如果key1的hash值与已经存在的数据的hash值都不相同,此时key1-value1添加成功-->-->情况2
                以链表方式进行存储
            如果key1的hash值和已经存在的某一个数据的hash值相同,继续比较：调用key1所在类的equals方法
                如果equals返回false,此时key1-value1添加成功-->情况3
                    以链表方式进行存储
                如果equals返回true:将使用value1替换相同key的value值
HashMap在不断的添加过程中,会涉及到扩容问题.默认的扩容方式：扩容为原来容量的2倍,并将原有的数据复制过来.
    1.8:相较于7在底层实现方面的不同。
        new HashMap():底层没有创建一个长度为16的数组
        底层数组是Node[],而非Entry[].
        首次调用put()方法时,底层创建长度为16的数组.
        jdk7底层结构是：数组+链表
        jdk8地层结构是：数组+链表+红黑树
        当数组的某一个索引的位置上的元素以链表形式存在的数据个数>8且当前数组的长度>64时,此时此索引位置上的所有数据改为使用红黑树存储.
        (原因：查找效率高)
2、HashMap和HashTable的异同：
~~CurrentHashMap和HashTable的异同~~
Map结构的理解： 
    Map中的key：无序的、不可重复的，使用set存储所有的key，key所在的类要重写equals和hashcode方法
    Map中的value:无序的，可重复的,使用collection存储所有的value,-->value所在的类要重写equals()
    一个键值对：key-value构成了entry对象
    Map中的Entry：无序的,不可重复的,使用set存储所有的entry
    

谈谈你对HashMap中put/get方法的认识,如果了解再谈谈HashMap的扩容机制,默认大小是多少？什么是负载因子（或填充比）？什么是吞吐临界值（或阈值，threshold）

LinkedHashMap:
    和hashmap一样，替换掉HashMap中的node,增加了before,after


Map存储数据的特点：双列数据，存储key-value对数据
key:set存储,无序，不可重复
value:无序，可重复collection存储
key-value:entry存储，无序，不可重复 set存储






























