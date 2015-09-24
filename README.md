# Crazy Soap 

There is some funny code in javax.xml.bind.DatatypeConverterImpl.parseBoolean(String). Here you will find
performance tests and a test which shows the funny side of the jdk implementation.

Or just have a look at this [Slideshow](https://docs.google.com/presentation/d/1Y9NbTeAaftvAY00eJlU14RDbZTbqHmJJia_OX88etAM/edit?usp=sharing)

## Perf Tests (with jmh)

```
Benchmark                         (implId)  (valueParam)   Mode  Cnt          Score           Error  Units
ParseBooleanBenchmarkTest.parse    jdk7_80          true  thrpt    4   60285349,555 ±  65325908,698  ops/s
ParseBooleanBenchmarkTest.parse    jdk7_80         false  thrpt    4   52706956,521 ±  26966684,617  ops/s
ParseBooleanBenchmarkTest.parse    jdk7_80             1  thrpt    4   99705655,466 ±  85285336,117  ops/s
ParseBooleanBenchmarkTest.parse    jdk7_80             0  thrpt    4   89344275,275 ±  48606064,281  ops/s
ParseBooleanBenchmarkTest.parse    jdk7_80           tru  thrpt    4   68424151,623 ±  82223704,776  ops/s
ParseBooleanBenchmarkTest.parse    jdk7_80          fals  thrpt    4   89249107,885 ±  25243661,207  ops/s
ParseBooleanBenchmarkTest.parse    jdk7_80        true    thrpt    4   51603980,539 ±   4852101,815  ops/s
ParseBooleanBenchmarkTest.parse    jdk7_80           1    thrpt    4   73358647,104 ±   9462276,459  ops/s
ParseBooleanBenchmarkTest.parse    jdk7_80       false    thrpt    4   48850618,823 ±  11597475,396  ops/s
ParseBooleanBenchmarkTest.parse    jdk6_27          true  thrpt    4  237560647,968 ±  65579987,160  ops/s
ParseBooleanBenchmarkTest.parse    jdk6_27         false  thrpt    4  160203103,228 ± 537654380,533  ops/s
ParseBooleanBenchmarkTest.parse    jdk6_27             1  thrpt    4  220091226,991 ±  46177982,333  ops/s
ParseBooleanBenchmarkTest.parse    jdk6_27             0  thrpt    4  202196491,377 ±  49814236,739  ops/s
ParseBooleanBenchmarkTest.parse    jdk6_27           tru  thrpt    4  203671051,817 ± 194380088,383  ops/s
ParseBooleanBenchmarkTest.parse    jdk6_27          fals  thrpt    4  217633358,316 ±  58331926,324  ops/s
ParseBooleanBenchmarkTest.parse    jdk6_27        true    thrpt    4  136988808,260 ±   9950536,346  ops/s
ParseBooleanBenchmarkTest.parse    jdk6_27           1    thrpt    4  127049248,240 ±   8821005,832  ops/s
ParseBooleanBenchmarkTest.parse    jdk6_27       false    thrpt    4  127396284,553 ±   5525441,991  ops/s
ParseBooleanBenchmarkTest.parse     simple          true  thrpt    4   88320339,080 ±  45107699,173  ops/s
ParseBooleanBenchmarkTest.parse     simple         false  thrpt    4  147883260,092 ±   3662528,825  ops/s
ParseBooleanBenchmarkTest.parse     simple             1  thrpt    4  120661954,593 ±  80556178,516  ops/s
ParseBooleanBenchmarkTest.parse     simple             0  thrpt    4  116764629,037 ±   6919198,847  ops/s
ParseBooleanBenchmarkTest.parse     simple           tru  thrpt    4  139951218,748 ±  50940317,893  ops/s
ParseBooleanBenchmarkTest.parse     simple          fals  thrpt    4  105665039,834 ±   5284590,847  ops/s
ParseBooleanBenchmarkTest.parse     simple        true    thrpt    4   29333915,799 ±  40324206,871  ops/s
ParseBooleanBenchmarkTest.parse     simple           1    thrpt    4   34417054,862 ±  31824070,023  ops/s
ParseBooleanBenchmarkTest.parse     simple       false    thrpt    4   23880691,528 ±  43534768,009  ops/s
ParseBooleanBenchmarkTest.parse  optimized          true  thrpt    4   85592648,015 ±  53083444,220  ops/s
ParseBooleanBenchmarkTest.parse  optimized         false  thrpt    4  153670856,737 ± 115112793,570  ops/s
ParseBooleanBenchmarkTest.parse  optimized             1  thrpt    4  173054123,361 ± 150001256,555  ops/s
ParseBooleanBenchmarkTest.parse  optimized             0  thrpt    4  160961675,932 ±  90129367,137  ops/s
ParseBooleanBenchmarkTest.parse  optimized           tru  thrpt    4  160184309,862 ±  56959952,223  ops/s
ParseBooleanBenchmarkTest.parse  optimized          fals  thrpt    4   97111825,392 ±  64109764,445  ops/s
ParseBooleanBenchmarkTest.parse  optimized        true    thrpt    4   27694727,394 ±  57301482,442  ops/s
ParseBooleanBenchmarkTest.parse  optimized           1    thrpt    4   36088231,987 ±  27215797,440  ops/s
ParseBooleanBenchmarkTest.parse  optimized       false    thrpt    4   34533322,242 ±  72163986,540  ops/s
ParseBooleanBenchmarkTest.parse     switch          true  thrpt    4   84212024,236 ±  13692155,165  ops/s
ParseBooleanBenchmarkTest.parse     switch         false  thrpt    4  141307585,100 ±  62814541,458  ops/s
ParseBooleanBenchmarkTest.parse     switch             1  thrpt    4  109323034,934 ±   1416267,886  ops/s
ParseBooleanBenchmarkTest.parse     switch             0  thrpt    4  154735816,673 ±  19580444,092  ops/s
ParseBooleanBenchmarkTest.parse     switch           tru  thrpt    4  145973999,516 ±  13767931,453  ops/s
ParseBooleanBenchmarkTest.parse     switch          fals  thrpt    4  147384939,998 ±  13101870,915  ops/s
ParseBooleanBenchmarkTest.parse     switch        true    thrpt    4   25009079,221 ±  30847955,955  ops/s
ParseBooleanBenchmarkTest.parse     switch           1    thrpt    4   29134680,169 ±  30911055,488  ops/s
ParseBooleanBenchmarkTest.parse     switch       false    thrpt    4   28182935,826 ±  38778782,331  ops/s
```

![Charts](perf-tests.png)
