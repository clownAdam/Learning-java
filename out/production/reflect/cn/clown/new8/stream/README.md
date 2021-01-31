# Stream
    Stream是数据渠道,用于操作数据源(集合,数组等)所生成的元素序列.
    集合讲的是数据,Stream讲的是计算！
    
    1.Stream不会自己存储元素
    2.Stream不会改变源对象.相反,他们会返回一个持有结果的新Stream
    3.Stream操作是延迟执行的.这意味着他们会等到需要结果的时候才执行.
    
# Stream和Collection集合的区别:
    Collection是一种静态的内存数据结构,而Stream是有关计算的.
    Collection主要是面向内存,存储在内存中.
    Stream主要是面向CPU,通过CPU实现计算.
    
# Stream执行流程
    1.Stream的实例化
    2.一系列中间操作
    3.终止操作
    