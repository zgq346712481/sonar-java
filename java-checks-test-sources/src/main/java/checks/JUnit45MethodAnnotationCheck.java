package checks;

class JUnit45MethodAnnotationCheck_JUnit4_compliant1 {
  protected Object step() { return null; } // unrelated
  protected Object teaDown() { return null; } // typo from tearDown, but could be unrelated
  @org.junit.Test void test() { }
  @org.junit.Before public void setUp() { }
  @org.junit.After public void tearDown() { }
}

class JUnit45MethodAnnotationCheck_JUnit4 {
  @org.junit.Test void test() { }

  public void setUp() { } // Noncompliant [[sc=15;ec=20]] {{Annotate this method with JUnit4 '@org.junit.Before' or rename it to avoid confusion.}}
  public void tearDown() { }  // Noncompliant {{Annotate this method with JUnit4 '@org.junit.After' or rename it to avoid confusion.}}
}

class JUnit45MethodAnnotationCheck_JUnit4_compliant {
  protected Object step() { return null; } // unrelated
  protected Object teaDown() { return null; } // typo from tearDown, but could be unrelated
  @org.junit.Test void test() { }
  @org.junit.Before public void setUp() { }
  @org.junit.After public void tearDown() { }
}

class JUnit45MethodAnnotationCheck_JUnit4_compliant2 {
  @org.junit.Test void test() { }
  @org.junit.BeforeClass public void setUp() { }
  @org.junit.AfterClass public void tearDown() { }
}

abstract class AbstractJUnit45MethodAnnotationCheck_JUnit4 {
  @org.junit.Before public void setUp() { }
}

class JUnit45MethodAnnotationCheck_JUnit4_compliant3 extends AbstractJUnit45MethodAnnotationCheck_JUnit4 {
  @org.junit.Test void test() { }

  @Override
  public void setUp() { } // Compliant
}

class JUnit45MethodAnnotationCheck_JUnit5 {
  @org.junit.jupiter.api.Test void test() { }

  public void setUp() { } // Noncompliant {{Annotate this method with JUnit5 '@org.junit.jupiter.api.BeforeEach' or rename it to avoid confusion.}}
  public void tearDown() { }  // Noncompliant {{Annotate this method with JUnit5 '@org.junit.jupiter.api.AfterEach' or rename it to avoid confusion.}}
}

class JUnit45MethodAnnotationCheck_JUnit5_compliant {
  @org.junit.jupiter.api.Test void test() { }
  @org.junit.jupiter.api.BeforeEach public void setUp() { }
  @org.junit.jupiter.api.AfterEach public void tearDown() { }
}

class JUnit45MethodAnnotationCheck_JUnit5_compliant2 {
  @org.junit.jupiter.api.Test void test() { }
  @org.junit.jupiter.api.BeforeAll public void setUp() { }
  @org.junit.jupiter.api.AfterAll public void tearDown() { }
}

class JUnit45MethodAnnotationCheck_JUnit4_5_mixed {
  @org.junit.Test void junit4() { }
  @org.junit.jupiter.api.Test void junit5() { }

  // use JUnit 4 annotations
  @org.junit.Before public void setUp() { } // Noncompliant {{Annotate this method with JUnit5 '@org.junit.jupiter.api.BeforeEach' instead of JUnit4 '@Before'.}}
  @org.junit.After public void tearDown() { } // Noncompliant {{Annotate this method with JUnit5 '@org.junit.jupiter.api.AfterEach' instead of JUnit4 '@After'.}}

  @org.junit.Before public void before() { } // Noncompliant {{Annotate this method with JUnit5 '@org.junit.jupiter.api.BeforeEach' instead of JUnit4 '@Before'.}}
  @org.junit.After public void after() { } // Noncompliant {{Annotate this method with JUnit5 '@org.junit.jupiter.api.AfterEach' instead of JUnit4 '@After'.}}
}

class JUnit45MethodAnnotationCheck_JUnit4_5_mixed2 {
  @org.junit.Test void junit4() { }
  @org.junit.jupiter.api.Test void junit5() { }

  // use JUnit 4 annotations
  @org.junit.BeforeClass public void setUp() { } // Noncompliant {{Annotate this method with JUnit5 '@org.junit.jupiter.api.BeforeAll' instead of JUnit4 '@BeforeClass'.}}
  @org.junit.AfterClass public void tearDown() { } // Noncompliant {{Annotate this method with JUnit5 '@org.junit.jupiter.api.AfterAll' instead of JUnit4 '@AfterClass'.}}
}
