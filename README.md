# crazy-soap

Soap Code Black Magic

see https://docs.google.com/presentation/d/1Y9NbTeAaftvAY00eJlU14RDbZTbqHmJJia_OX88etAM/edit?usp=sharing

## Perf Tests (with jmh)

Benchmark                                      Mode  Cnt          Score   Error  Units
ParseBooleanTestJDK7_80.parse_false           thrpt    2   73615488,070          ops/s
ParseBooleanTestJDK7_80.parse_falseTypo       thrpt    2   87833831,319          ops/s
ParseBooleanTestJDK7_80.parse_one             thrpt    2  235619597,920          ops/s
ParseBooleanTestJDK7_80.parse_true            thrpt    2   78245704,628          ops/s
ParseBooleanTestJDK7_80.parse_trueTypo        thrpt    2  104196343,482          ops/s
ParseBooleanTestJDK7_80.parse_zero            thrpt    2  255039227,316          ops/s
ParseBooleanTestOptimized.parse_false         thrpt    2  347752757,480          ops/s
ParseBooleanTestOptimized.parse_falseTypo     thrpt    2  317447946,441          ops/s
ParseBooleanTestOptimized.parse_one           thrpt    2  314173124,756          ops/s
ParseBooleanTestOptimized.parse_true          thrpt    2  213803902,742          ops/s
ParseBooleanTestOptimized.parse_trueTypo      thrpt    2  317602111,402          ops/s
ParseBooleanTestOptimized.parse_zero          thrpt    2  310810066,584          ops/s
ParseBooleanTestSimple.parse_false            thrpt    2  351375495,602          ops/s
ParseBooleanTestSimple.parse_falseTypo        thrpt    2  157787340,861          ops/s
ParseBooleanTestSimple.parse_one              thrpt    2  351966159,873          ops/s
ParseBooleanTestSimple.parse_true             thrpt    2  356103784,238          ops/s
ParseBooleanTestSimple.parse_trueTypo         thrpt    2  352498113,624          ops/s
ParseBooleanTestSimple.parse_zero             thrpt    2  141908460,615          ops/s
ParseBooleanTestStringSwitch.parse_false      thrpt    2  313750722,228          ops/s
ParseBooleanTestStringSwitch.parse_falseTypo  thrpt    2  179949450,197          ops/s
ParseBooleanTestStringSwitch.parse_one        thrpt    2  283024062,516          ops/s
ParseBooleanTestStringSwitch.parse_true       thrpt    2  260904588,300          ops/s
ParseBooleanTestStringSwitch.parse_trueTypo   thrpt    2  315527415,172          ops/s
ParseBooleanTestStringSwitch.parse_zero       thrpt    2  189417193,535          ops/s

