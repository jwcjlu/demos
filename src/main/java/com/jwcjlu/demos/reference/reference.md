
级别 |什么时候被垃圾回收 |用途 |  生存时间   
---|---|---|---
强引用|  从来不会|对象的一般状态|JVM停止运行时终止
软引用|在内存不足时|对象简单？缓存|内存不足时终止
弱引用|在垃圾回收时|对象缓存|gc运行后终止
虚引用|Unknown|Unknown|Unknown
 
   