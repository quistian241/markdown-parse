CLASSPATH = lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:.

MarkdownParse.class: MarkdownParse.java 
	javac -g MarkdownParse.java 

MarkdownParseTest.class: MarkdownParse.class MarkdownParseTest.java 
	javac -g -cp $(CLASSPATH) MarkdownParseTest.java

test: MarkdownParse.class MarkdownParseTest.class
	java -cp $(CLASSPATH) org.junit.runner.JUnitCore MarkdownParseTest

debug: MarkdownParseTest.class
	jdb -classpath $(CLASSPATH) org.junit.runner.JUnitCore MarkdownParseTest

snip1: MarkdownParse.class
	jdb MarkdownParse snippet-1.md

snip2: MarkdownParse.class
	jdb MarkdownParse snippet-2.md

snip3: MarkdownParse.class
	jdb MarkdownParse snippet-3.md
