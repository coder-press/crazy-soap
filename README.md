# crazy-soap

Soap Code Black Magic

see https://docs.google.com/presentation/d/1Y9NbTeAaftvAY00eJlU14RDbZTbqHmJJia_OX88etAM/edit?usp=sharing

## Perf Tests (with jmh)

Benchmark                                      Mode  Cnt          Score   Error  Units
ParseBooleanTestJDK7_80.parse_false           thrpt    2   74271494,768          ops/s
ParseBooleanTestJDK7_80.parse_falseTypo       thrpt    2   88613773,515          ops/s
ParseBooleanTestJDK7_80.parse_one             thrpt    2  235221874,212          ops/s
ParseBooleanTestJDK7_80.parse_true            thrpt    2   83088666,959          ops/s
ParseBooleanTestJDK7_80.parse_trueTypo        thrpt    2  103322299,029          ops/s
ParseBooleanTestJDK7_80.parse_zero            thrpt    2  237836064,936          ops/s
ParseBooleanTestOptimized.parse_false         thrpt    2  348077881,909          ops/s
ParseBooleanTestOptimized.parse_falseTypo     thrpt    2  157571850,225          ops/s
ParseBooleanTestOptimized.parse_one           thrpt    2  354950016,060          ops/s
ParseBooleanTestOptimized.parse_true          thrpt    2  358176311,850          ops/s
ParseBooleanTestOptimized.parse_trueTypo      thrpt    2  356378159,948          ops/s
ParseBooleanTestOptimized.parse_zero          thrpt    2  158518278,193          ops/s
ParseBooleanTestSimple.parse_false            thrpt    2  349467425,988          ops/s
ParseBooleanTestSimple.parse_falseTypo        thrpt    2  158294950,269          ops/s
ParseBooleanTestSimple.parse_one              thrpt    2  352871323,999          ops/s
ParseBooleanTestSimple.parse_true             thrpt    2  358939277,007          ops/s
ParseBooleanTestSimple.parse_trueTypo         thrpt    2  356479390,649          ops/s
ParseBooleanTestSimple.parse_zero             thrpt    2  142741744,097          ops/s
ParseBooleanTestStringSwitch.parse_false      thrpt    2  309793794,462          ops/s
ParseBooleanTestStringSwitch.parse_falseTypo  thrpt    2  178568181,685          ops/s
ParseBooleanTestStringSwitch.parse_one        thrpt    2  245220847,121          ops/s
ParseBooleanTestStringSwitch.parse_true       thrpt    2  255473142,341          ops/s
ParseBooleanTestStringSwitch.parse_trueTypo   thrpt    2  313052598,324          ops/s
ParseBooleanTestStringSwitch.parse_zero       thrpt    2  190722888,758          ops/s

