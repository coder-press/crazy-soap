# crazy-soap

Soap Code Black Magic

see https://docs.google.com/presentation/d/1Y9NbTeAaftvAY00eJlU14RDbZTbqHmJJia_OX88etAM/edit?usp=sharing

## Perf Tests (with jmh)

```
Benchmark                         (implId)  (valueParam)   Mode  Cnt          Score          Error  Units
ParseBooleanBenchmarkTest.parse    jdk7_80          true  thrpt    4   84719839,361 ± 10027251,036  ops/s
ParseBooleanBenchmarkTest.parse    jdk7_80         false  thrpt    4   73403162,008 ± 22642775,811  ops/s
ParseBooleanBenchmarkTest.parse    jdk7_80             1  thrpt    4  180025131,193 ± 16352509,045  ops/s
ParseBooleanBenchmarkTest.parse    jdk7_80             0  thrpt    4  167937993,528 ±  9984928,741  ops/s
ParseBooleanBenchmarkTest.parse    jdk7_80           tru  thrpt    4  105980015,559 ± 19840245,954  ops/s
ParseBooleanBenchmarkTest.parse    jdk7_80          fals  thrpt    4   91456525,828 ± 32330785,564  ops/s
ParseBooleanBenchmarkTest.parse     simple          true  thrpt    4  102604504,085 ±  7463952,145  ops/s
ParseBooleanBenchmarkTest.parse     simple         false  thrpt    4  174869520,517 ± 16753896,650  ops/s
ParseBooleanBenchmarkTest.parse     simple             1  thrpt    4  137312173,634 ± 44534835,274  ops/s
ParseBooleanBenchmarkTest.parse     simple             0  thrpt    4  132433676,462 ± 16238424,776  ops/s
ParseBooleanBenchmarkTest.parse     simple           tru  thrpt    4  170909714,696 ± 46615839,094  ops/s
ParseBooleanBenchmarkTest.parse     simple          fals  thrpt    4  116565356,007 ± 86759239,452  ops/s
ParseBooleanBenchmarkTest.parse  optimized          true  thrpt    4  159598865,985 ±  5528370,262  ops/s
ParseBooleanBenchmarkTest.parse  optimized         false  thrpt    4  277048045,327 ± 14638444,645  ops/s
ParseBooleanBenchmarkTest.parse  optimized             1  thrpt    4  250331655,814 ± 48007610,341  ops/s
ParseBooleanBenchmarkTest.parse  optimized             0  thrpt    4  253897870,031 ±  8955186,318  ops/s
ParseBooleanBenchmarkTest.parse  optimized           tru  thrpt    4  275489111,221 ± 24918386,943  ops/s
ParseBooleanBenchmarkTest.parse  optimized          fals  thrpt    4  216237759,941 ± 92689399,945  ops/s
ParseBooleanBenchmarkTest.parse     switch          true  thrpt    4   92768261,646 ± 33988023,571  ops/s
ParseBooleanBenchmarkTest.parse     switch         false  thrpt    4  180210311,411 ± 77442740,067  ops/s
ParseBooleanBenchmarkTest.parse     switch             1  thrpt    4  127860856,316 ±  7575470,046  ops/s
ParseBooleanBenchmarkTest.parse     switch             0  thrpt    4  198510628,038 ±  7876639,792  ops/s
ParseBooleanBenchmarkTest.parse     switch           tru  thrpt    4  187543383,273 ± 17958779,824  ops/s
ParseBooleanBenchmarkTest.parse     switch          fals  thrpt    4  185629959,788 ± 17287948,825  ops/s

```

![Charts](perf-tests.png)
