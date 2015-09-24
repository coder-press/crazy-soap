package crazysoap;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

/*
 * Copyright 2015 mosmann.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 *
 * @author mosmann
 */
@Warmup(iterations = 2, time=1,timeUnit=TimeUnit.SECONDS)
@Measurement(iterations = 2, time=3,timeUnit=TimeUnit.SECONDS)
@Fork(value = 1, warmups = 1)
//@Warmup(iterations = 1, time=100,timeUnit=TimeUnit.MICROSECONDS)
//@Measurement(iterations = 2, time=200,timeUnit=TimeUnit.MICROSECONDS)
//@Fork(value = 1, warmups = 1)
@State(Scope.Benchmark)
public class ParseBooleanBenchmarkTest {

//	@Param({"true","false","1","0","tru","fals","__true__","__1__","__false__"})
//	public String valueParam;
	@Param
	public Value valueParam;
	@Param//({"jdk7_80","jdk6_27", "jdk6_27opt", "simple","optimized","research","switch"})
	public Implementation implId;
	
	private ParseBoolean impl;
	private String value;
	
	@Setup(Level.Trial)
	public void setup() {
		impl = implId.getInstance();
		value = newInstance(valueParam.getValue());
	}

	@Benchmark
	public boolean parse() {
		return impl.parse(value);
	}

	private static String newInstance(String src) {
		String ret = new StringBuilder().append(src).toString();
		assert (src != ret);
		return ret;
	}

//	private static ParseBoolean instanceOf(String id) {
//		switch (id) {
//			case "jdk7_80":return new ParseBooleanJDK7_80();
//			case "jdk6_27":return new ParseBooleanJDK6_27();
//			case "jdk6_27opt":return new ParseBooleanJDK6_27Optimized();
//			case "simple":return new ParseBooleanSimpleImpl();
//			case "optimized":return new ParseBooleanOptimizedImpl();
//			case "research": return new ParseBooleanResearchImpl();
//			case "switch":return new ParseBooleanStringSwitch();
//		}
//		throw new RuntimeException("unknown "+id);
//	}
	
	public static ParseBooleanBenchmarkTest with(Implementation implId, Value valueParam) {
		ParseBooleanBenchmarkTest ret = new ParseBooleanBenchmarkTest();
		ret.implId=implId;
		ret.valueParam=valueParam;
		ret.setup();
		return ret;
	}
	
	@Test
	public void testAll() {
		for (Implementation impl : Implementation.values()) {
			for (Value value : Value.values()) {
				boolean result = with(impl,value).parse();
				if (!value.isUnstable()) {
					assertEquals(impl+":"+value, value.getExpectedBoolean(), result);
				}
			}
		}
	}
}
