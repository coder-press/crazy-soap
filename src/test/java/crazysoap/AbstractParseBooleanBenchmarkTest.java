package crazysoap;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
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
@Warmup(iterations = 2)
@Measurement(iterations = 2)
@Fork(value = 1, warmups = 1)
@State(Scope.Thread)
public abstract class AbstractParseBooleanBenchmarkTest {


	private static boolean parse(ParseBoolean impl, String value) {
		return impl.parse(value);
	}

	private ParseBoolean impl;
	private String TRUE = newInstance("true");
	private String FALSE = newInstance("false");
	private String ONE = newInstance("1");
	private String ZERO = newInstance("0");
	private String FALSE_TRUE = newInstance("tru");
	private String FALSE_FALSE = newInstance("fals");

	@Setup
	public void setup() {
		impl = instance();
	}

	private String newInstance(String src) {
		String ret = new StringBuilder().append(src).toString();
		assert (src != ret);
		return ret;
	}

	protected abstract ParseBoolean instance();

	@Benchmark
	public boolean parse_true() {
		return parse(impl, TRUE);
	}

	@Benchmark
	public boolean parse_one() {
		return parse(impl, ONE);
	}

	@Benchmark
	public boolean parse_false() {
		return parse(impl, FALSE);
	}

	@Benchmark
	public boolean parse_zero() {
		return parse(impl, ZERO);
	}

	@Benchmark
	public boolean parse_falseTypo() {
		return parse(impl, FALSE_FALSE);
	}

	@Benchmark
	public boolean parse_trueTypo() {
		return parse(impl, FALSE_TRUE);
	}

}
