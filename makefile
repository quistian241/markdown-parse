CLASSPATH = lib/*:.

MarkdownParse.class: MarkdownParse.java 
	javac -g MarkdownParse.java 

MarkdownParseTest.class: MarkdownParse.class MarkdownParseTest.java 
	javac -g -cp lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:. MarkdownParseTest.java

test: MarkdownParse.class MarkdownParseTest.class
	java -cp $(CLASSPATH) org.junit.runner.JUnitCore MarkdownParseTest

debug: MarkdownParseTest.class
	jdb -classpath $(CLASSPATH) org.junit.runner.JUnitCore MarkdownParseTest

TryCommonMark.class: TryCommonMark.java
	javac -g -cp $(CLASSPATH) TryCommonMark.java
