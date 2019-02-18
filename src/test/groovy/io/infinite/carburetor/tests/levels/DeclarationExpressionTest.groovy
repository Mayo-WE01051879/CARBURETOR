package io.infinite.carburetor.tests.levels

import io.infinite.carburetor.CarburetorTransformation

class DeclarationExpressionTest extends GroovyTestCase {

    void test() {
        assertScript("""
import io.infinite.carburetor.TestCarburetor
import io.infinite.carburetor.CarburetorLevel


class Foo {

    @TestCarburetor(level = CarburetorLevel.EXPRESSION)
    void test(String bar) {
        def foo
    }

}

new Foo().test()
""")
        assert CarburetorTransformation.lastCode == expectedCode
    }

    String expectedCode = """
testEngine.methodStart(new io.infinite.supplies.ast.metadata.MetaDataMethodNode(8, 11, 5, 6, 'Foo', 'test'), ['bar': bar ])
try {
    testEngine.expressionStart(new io.infinite.supplies.ast.metadata.MetaDataExpression('DeclarationExpression', 'java.lang.Object foo ', 10, 10, 9, 16, 'test', 'Foo'))java.lang.Object foo testEngine.expressionEnd(new io.infinite.supplies.ast.metadata.MetaDataExpression('DeclarationExpression', 'java.lang.Object foo ', 10, 10, 9, 16, 'test', 'Foo'))
} 
catch (java.lang.Exception automaticException) {
    testEngine.methodException(new io.infinite.supplies.ast.metadata.MetaDataMethodNode(8, 11, 5, 6, 'Foo', 'test'), ['bar': bar ], automaticException)
    throw automaticException 
} 
finally { 
    testEngine.methodEnd(new io.infinite.supplies.ast.metadata.MetaDataMethodNode(8, 11, 5, 6, 'Foo', 'test'))} 
"""


}