# crazy-soap

Soap Code Black Magic

see https://docs.google.com/presentation/d/1Y9NbTeAaftvAY00eJlU14RDbZTbqHmJJia_OX88etAM/edit?usp=sharing

## Perf Tests (with jmh)

```
Benchmark                         (implId)  (valueParam)   Mode  Cnt          Score   Error  Units
ParseBooleanBenchmarkTest.parse    jdk7_80          true  thrpt    2   88286554,673          ops/s
ParseBooleanBenchmarkTest.parse    jdk7_80         false  thrpt    2   81958880,100          ops/s
ParseBooleanBenchmarkTest.parse    jdk7_80             1  thrpt    2  179850532,449          ops/s
ParseBooleanBenchmarkTest.parse    jdk7_80             0  thrpt    2  168561150,787          ops/s
ParseBooleanBenchmarkTest.parse    jdk7_80           tru  thrpt    2  111981557,955          ops/s
ParseBooleanBenchmarkTest.parse    jdk7_80          fals  thrpt    2   95582005,066          ops/s
ParseBooleanBenchmarkTest.parse     simple          true  thrpt    2  105099519,366          ops/s
ParseBooleanBenchmarkTest.parse     simple         false  thrpt    2  178360325,342          ops/s
ParseBooleanBenchmarkTest.parse     simple             1  thrpt    2  138880101,386          ops/s
ParseBooleanBenchmarkTest.parse     simple             0  thrpt    2  129855236,345          ops/s
ParseBooleanBenchmarkTest.parse     simple           tru  thrpt    2  141304540,890          ops/s
ParseBooleanBenchmarkTest.parse     simple          fals  thrpt    2  130052568,193          ops/s
ParseBooleanBenchmarkTest.parse  optimized          true  thrpt    2  166844513,233          ops/s
ParseBooleanBenchmarkTest.parse  optimized         false  thrpt    2  277005676,641          ops/s
ParseBooleanBenchmarkTest.parse  optimized             1  thrpt    2  253305116,940          ops/s
ParseBooleanBenchmarkTest.parse  optimized             0  thrpt    2  246455751,113          ops/s
ParseBooleanBenchmarkTest.parse  optimized           tru  thrpt    2  282007379,623          ops/s
ParseBooleanBenchmarkTest.parse  optimized          fals  thrpt    2  235474997,384          ops/s
ParseBooleanBenchmarkTest.parse     switch          true  thrpt    2  106829422,329          ops/s
ParseBooleanBenchmarkTest.parse     switch         false  thrpt    2  181020506,890          ops/s
ParseBooleanBenchmarkTest.parse     switch             1  thrpt    2  122955213,234          ops/s
ParseBooleanBenchmarkTest.parse     switch             0  thrpt    2  164185226,487          ops/s
ParseBooleanBenchmarkTest.parse     switch           tru  thrpt    2  187863131,113          ops/s
ParseBooleanBenchmarkTest.parse     switch          fals  thrpt    2  179959008,966          ops/s
```

![Charts](perf-tests.png)
