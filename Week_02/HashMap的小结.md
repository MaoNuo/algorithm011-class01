#关于HashMap的小结

##1.一些参数
* Capacity ： 容量，必须为2的幂，默认为16(1 << 4),最大为 1 << 30
* LoadFactor : 加载因子，当数组内元素数量达到这个数量的时候进行扩容处理，默认为0.75，
               可以通过构造函数自行设置
* Threshold : 一些阈值，如下表

|-------------名称-------------|-----涵义-----|-----值-----|
|:---|:---|---:|
|TREEIFY_THRESHOLD|链表转换为树|8|
|UNTREEIFY_THRESHOLD|树转换为链表|6|
|MIN_TREEIFY_CAPACITY|为树的最小容量|64|
>MIN_TREEIFY_CAPACITY是指只有当数组容量大于等于该数时才会将链表转换为数。
>也就是说链表转换为树有两个条件：1.数组总容量；2.该处数据数量

##2.两个内置静态类
* Node ： 用于链表，继承于Map中的Entry<>。
* TreeNode ： 用于红黑树，继承于LinkedHashMap中的Entry<>。

##3.构造函数
* HashMap() : 无参，指定扩容因子为默认值
* HashMap(int initialCapacity) : 将调用含有两个参数的构造函数，指定默认容量，扩容因子设定为默认值
* HashMap(int initialCapacity, float loadFactor) : 指定容量和扩容因子
* HashMap(Map<? extends K, ? extends V> m) : 传入一个已存在的HashMap。将扩容因子设定为默认值，
                                             调用putMapEntries传入所有元素

##4.关于容量的调整方法
* 使用tableSizeFor()方法
```$xslt
static final int tableSizeFor(int cap) {
	int n = cap - 1;
	n |= n >>> 1;
	n |= n >>> 2;
	n |= n >>> 4;
	n |= n >>> 8;
	n |= n >>> 16;
	return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
}
```
* 此函数将传入的数值转化为大于该值的最小的2的幂
* 原理 : 2的幂的特点为，只有第n + 1位为1，其余位为0，2^n-1则是最后n位全为1。
        第一次逻辑右移和或运算执行完之后，原数最高处的1与后面1位变为1.
        第二次则将原数最高处的1为起点的4位都变为1.
        由于int最高只有32位，所以计算5次则可以实现
        
##5.put(K key, V value)方法
* 调用putVal函数
* 首先计算HashMap的大小
>* 如果原HashMap为空，则会调用resize()进行扩容
* 此时将键值对添加进HashMap，计算下标
>* 1.该处为空，则新建节点直接插入
```
if ((p = tab[i = (n - 1) & hash]) == null)
	tab[i] = newNode(hash, key, value, null);
```
>* 2.该处已有元素，发生碰撞
>>* 该处节点的hash值与欲添加的hash相等，并且两处节点的key相等，则准备覆盖工作
>>* 该处节点为红黑树结构，则直接加入树结构中
>>* 该处节点为链表结构，进行尾插
>>>* 如果在遍历到尾部时发现同样的key，则进行覆盖操作
>* 3.覆盖操作
>>* 此时存在两种qingk
>>>* 1.发生碰撞，则修改旧节点为新值
>>>* 2.该处为插入到链表或者红黑树中的新节点

##6.hash()函数
```
static final int hash(Object key) {
	int h;
	return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
}
```
* 1.使用hashCode()来进行计算key的hashCode值
* 2.将该值逻辑右移16位，并与原值作异或计算
>* 如此计算会将原hashCode值的高位16位和低位16位进行混合，保证了高位16位的特征，
   以此减少碰撞的概率
>* 为什么不用和运算或者或运算
>>* 因为这两种运算得到的结果中，0和1的比例均为1:3，而异或的结果中比例为1:1，较
    为平衡，所以比起这两者而言，异或更为适合

##7.get()方法
* 同put()方法，先调用getNode()方法
```
public V get(Object key) {
	Node<K,V> e;
	return (e = getNode(hash(key), key)) == null ? null : e.value;
}
```
>* 查找该key所在的键值对，如果为空返回为null，否则返回值
* 利用同样的hash来计算table数组中的下标
>* 如果该下标中的元素和key值相等，则查找成功，返回即可
>* 如果该处为树结构，则调用getTreeNode()方法
>* 如果为链表，则逐个查找，直到链表末尾

##8.总结
* 1.HashMap的底层数据结构为一个数组
* 2.对于hash的算法使得该HashMap尽可能的少的出现哈希碰撞
* 3.put方法和get方法实际上也是一系列的查找，对比，然后得出结论是否插入或替换
* 4.基础原理其实很简单，只是实现上存在着很多的高级算法，使得该数据结构变得完整以及拥
    有强大且实用的功能


