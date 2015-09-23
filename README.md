# crazy-soap

Soap Code Black Magic

see https://docs.google.com/presentation/d/1Y9NbTeAaftvAY00eJlU14RDbZTbqHmJJia_OX88etAM/edit?usp=sharing

## Perf Tests (with jmh)

Benchmark                                            Mode  Cnt          Score   Error  Units
ImplementationBenchmarkTest.falseTypo_parseJDK7_80  thrpt    2   96770341,468          ops/s
ImplementationBenchmarkTest.falseTypo_parseSimple   thrpt    2  161896668,270          ops/s
ImplementationBenchmarkTest.false_parseJDK7_80      thrpt    2   77299399,587          ops/s
ImplementationBenchmarkTest.false_parseSimple       thrpt    2  310489101,183          ops/s
ImplementationBenchmarkTest.one_parseJDK7_80        thrpt    2  255728422,477          ops/s
ImplementationBenchmarkTest.one_parseSimple         thrpt    2  363750253,003          ops/s
ImplementationBenchmarkTest.trueTypo_parseJDK7_80   thrpt    2  105654719,026          ops/s
ImplementationBenchmarkTest.trueTypo_parseSimple    thrpt    2  359532509,591          ops/s
ImplementationBenchmarkTest.true_parseJDK7_80       thrpt    2   86939269,099          ops/s
ImplementationBenchmarkTest.true_parseSimple        thrpt    2  362469072,285          ops/s
ImplementationBenchmarkTest.zero_parseJDK7_80       thrpt    2  245926861,006          ops/s
ImplementationBenchmarkTest.zero_parseSimple        thrpt    2  159673698,088          ops/s

