package crazysoap;

import crazysoap.jdk7_80.ParseBooleanJDK7_80;
import crazysoap.optimized.ParseBooleanOptimizedImpl;
import crazysoap.simple.ParseBooleanSimpleImpl;
import crazysoap.stringswitch.ParseBooleanStringSwitch;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
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
@Warmup(iterations = 2, time=200, timeUnit=TimeUnit.MILLISECONDS)
@Measurement(iterations = 2, time=200, timeUnit=TimeUnit.MILLISECONDS)
@Fork(value = 1, warmups = 1)
@State(Scope.Thread)
public class ParseBooleanBenchmarkTest {

	@Param({"true","false","1","0","tru","fals"})
	public String valueParam;
	@Param({"jdk7_80","simple","optimized","switch"})
	public String implId;
	
	private ParseBoolean impl;
	private String value;
	
	@Setup(Level.Trial)
	public void setup() {
		impl = instanceOf(implId);
		value = newInstance(valueParam);
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

	private static ParseBoolean instanceOf(String id) {
		switch (id) {
			case "jdk7_80":return new ParseBooleanJDK7_80();
			case "simple":return new ParseBooleanSimpleImpl();
			case "optimized":return new ParseBooleanOptimizedImpl();
			case "switch":return new ParseBooleanStringSwitch();
		}
		throw new RuntimeException("unknown "+id);
	}
}
