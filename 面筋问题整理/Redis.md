# 从千万的key中返回某一个前缀的key

## KEYS PATTERN
一次性返回所有匹配的key

缺点：
当数据量非常大时会造成卡顿严重


## SCAN cursor PATTERN COUNT

SCAN 命令每次被调用之后， 都会向用户返回一个新的游标， 用户在下次迭代时需要使用这个新游标作为 SCAN 命令的游标参数， 以此来延续之前的迭代过程。


例子：
scan 0 k1* 10

这样会返回10个以k1为前缀的key

缺点：
不能保证每次都返回count个数据，只能确保大概为count个


# Redis实现分布式锁

## 实现方法1
   
1. SETNX key value
如果key存在，则设置key的值为value

如果设置成功，则会返回1，否则返回0

2. 在获取锁，也就是设置成功之后，为锁设置一个过程时间

EXPIRE KEY seconds

缺点，原子性不能保证，如果在set成功之后，设置过期时间之前挂掉，会导致锁一直不能被释放

## 实现方法2

1. SET Key value [EX seconds] [PX milliseconds] [NX|XX]

[EX seconds]:过期时间/秒

[PX milliseconds]：过期时间/毫秒

[NX] 如果不存在该key

[XX] 如果存在该key

保证了原子性

详细：
https://www.jianshu.com/p/47fd7f86c848



# 跳表

1 16
1 8 16
1 4 8 11 16
1 3 4 5 8 9 11 13 16