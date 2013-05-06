package de.hsrm.sem2.progtech.test.uebung01;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import de.hsrm.sem2.progtech.test.uebung01.testcases.CharIterableTest;
import de.hsrm.sem2.progtech.test.uebung01.testcases.DiagonalIterableTest;
import de.hsrm.sem2.progtech.test.uebung01.testcases.LinesTest;
import de.hsrm.sem2.progtech.test.uebung01.testcases.PairIterableTest;
import de.hsrm.sem2.progtech.test.uebung01.testcases.ReaderIterableTest;


@RunWith(Suite.class)
@SuiteClasses({ CharIterableTest.class, DiagonalIterableTest.class,
		LinesTest.class, PairIterableTest.class, ReaderIterableTest.class })
public class Uebung01Tests {

}
