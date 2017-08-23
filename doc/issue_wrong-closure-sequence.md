# Wrong order issue in closure

In spark RDD transformation phase, the code execution order may not as expected.

### problem description

the issue comes from a scenario when some data want to be inserted to HBase during transformation. The code lookes 
like follow.

```
val rdd2 = rdd1.mapPartitions { case part =>
    val htable = new HTable()
    htable.setAutoFlushTo(false)    // step 1
    val p2 = part.map { case p =>
        //do some transformation 
        //and create a hbase put
        val p = new Put(...)
        htable.put(p)               // step 2
        ...
    }

    htable.flushCommits()           // step 3
    p2
}
```

> Normally, the execution order of the code snippet is quite clear: *step1* -> *step2* -> *step3*
> But as a closure running in rdd's mapPartitions function, the execution order becomes to *step1* -> **step3** -> *step2*
> It looks like the return variable `p2` has been signed as `lazy` in mapPartitions

### investigation

the behavior is quite strange. the code snippet inside `mapPartitions` has been proved without issue during the UT. So 
it may casued by spark rdd's execute behavior.

Run the closure in `foreachPartitions` again. We get the correct execution order. As we know, `mapPartitions` is a 
transformation function but not action. It means the closure inside `mapPartitions` will not be processed immediately. 

> So the return variable `p2` may be signed as **lazy** in `mapPartitions` because it need not an immediate return

### TODO:

Inside mapPartions function, spark will clean `call sc.clean(f)` the closure for deattach the non-seriablizable object 
inside closure, it may be the place to lazy the outer
